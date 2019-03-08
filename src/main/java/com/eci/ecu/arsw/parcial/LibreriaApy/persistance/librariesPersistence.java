/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eci.ecu.arsw.parcial.LibreriaApy.persistance;

import com.eci.ecu.arsw.parcial.LibreriaApy.entities.Book;
import com.eci.ecu.arsw.parcial.LibreriaApy.entities.Library;
import java.util.List;

/**
 *
 * @author 2108263
 */
public interface librariesPersistence {
    
    public List<Library> getLibraries()throws libraryPersistanceException;
    
    public List<Book> getBookByLibrary(int Id)throws libraryPersistanceException;
    
    public void deleteLibraryById(int Id)throws libraryPersistanceException; 
    
    public void addBookByLibrary(int Id,Book libro)throws libraryPersistanceException; 
    
}
