/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eci.ecu.arsw.parcial.LibreriaApy.persistance;

import com.eci.ecu.arsw.parcial.LibreriaApy.entities.Book;
import com.eci.ecu.arsw.parcial.LibreriaApy.entities.Library;
import java.util.*;
import org.springframework.stereotype.Service;

/**
 *
 * @author 2108263
 */
@Service
public class librariesMemory implements librariesPersistence{
    
    List<Library> bibliotecas = new ArrayList<>();

    public librariesMemory() {
        Book libro1 =new Book("alicia",1,"Manson","una niña perdida en un pais de maravillas",10);
        Book libro2 =new Book("Harrypotter",2,"Rowling","un niño que usa magia",10);
        Book libro3 =new Book("Harrypotter y caliz",3,"Rowling","un niño que usa magiay juega en un torneo",10);
        Book libro4 =new Book("El cartel de los sapos",4,"uribe","narracion de acuadores",20);
        Book libro5 =new Book("Caballo de troya",5,"Autor","viajes en el tiempo",20);
        Book libro6 =new Book("Quijote",6,"Miguel","las aventuras de un lancero",20);
        
        List<Book> libros10 = new ArrayList<>();
        libros10.add(libro1);
        libros10.add(libro2);
        libros10.add(libro3);
        
        List<Book> libros20 = new ArrayList<>();
        libros20.add(libro4);
        libros20.add(libro5);
        libros20.add(libro6);
        
        Library libreria1 = new Library("Lerner",10,"norte","3005467089",libros10);
        Library libreria2 = new Library("blowson",20,"norte","3004679076",libros20);
        Library libreriaVacia = new Library("blowson",30,"norte","3004679076",new ArrayList<>());
        
        
        bibliotecas.add(libreria1);
        bibliotecas.add(libreria2);
        bibliotecas.add(libreriaVacia);
    }

    @Override
    public List<Library> getLibraries() {
        return bibliotecas;
    }

    @Override
    public List<Book> getBookByLibrary(int Id) throws libraryPersistanceException  {
        boolean exists = false;
        List<Book>res =new ArrayList<>();
        for(Library i:bibliotecas){
            if(i.getId()==Id){
                exists=true;
                res=i.getLibros();
            }
        }
        if(exists){
            return res;
        }else{
            throw new libraryPersistanceException("No existe la libreria especificada");
        }
    }

    @Override
    public void deleteLibraryById(int Id) throws libraryPersistanceException{
        Library down = null;
        boolean books = false;
        for(Library i:bibliotecas){
            if(i.getId()==Id){
                books=i.getLibros().isEmpty();
                down=i;
            }
        }
        if(books){
            bibliotecas.remove(down);
        }else{
            throw new libraryPersistanceException("La biblioteca especificada no puede ser eliminada");
        }
        
    }

    @Override
    public void addBookByLibrary(int Id, Book libro) throws libraryPersistanceException {
        for(Library i:bibliotecas){
            if(i.getId()==Id){
                i.getLibros().add(libro);
            }
        }
    }
    
    
    
    
}
