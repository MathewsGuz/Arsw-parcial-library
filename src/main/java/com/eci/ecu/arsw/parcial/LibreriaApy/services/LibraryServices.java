/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eci.ecu.arsw.parcial.LibreriaApy.services;

import com.eci.ecu.arsw.parcial.LibreriaApy.entities.Book;
import com.eci.ecu.arsw.parcial.LibreriaApy.entities.Library;
import com.eci.ecu.arsw.parcial.LibreriaApy.persistance.librariesPersistence;
import com.eci.ecu.arsw.parcial.LibreriaApy.persistance.libraryPersistanceException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 2108263
 */
@Service
public class LibraryServices {
    
    @Autowired
    librariesPersistence lb;
    
    public List<Library> getAllLibraries() throws libraryPersistanceException{
        return lb.getLibraries();
    }
    
    public List<Book> getBookByLibraryId(int id) throws libraryPersistanceException{
        return lb.getBookByLibrary(id);
    }
    
    public void DeleteLibrary(int id)throws libraryPersistanceException{
        lb.deleteLibraryById(id);
    
    }
    
    public void addBookById(int id, Book libro)throws libraryPersistanceException{
        lb.addBookByLibrary(id, libro);
    }
    
}
