/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eci.ecu.arsw.parcial.LibreriaApy.controllers;

import com.eci.ecu.arsw.parcial.LibreriaApy.persistance.libraryPersistanceException;
import com.eci.ecu.arsw.parcial.LibreriaApy.services.LibraryServices;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.server.PathParam;
import javax.xml.ws.http.HTTPException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 2108263
 */
@RestController
@RequestMapping(value = "/libraries")
@Service
public class LibraryAPI {
    
    @Autowired
    LibraryServices ls;
    
    @GetMapping()
    public ResponseEntity<?> getLibrarys()throws libraryPersistanceException{
        try {            
            return new ResponseEntity<>(ls.getAllLibraries(),HttpStatus.ACCEPTED);
        } catch (HTTPException ex) {
            Logger.getLogger(LibraryAPI.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.toString(),HttpStatus.valueOf(ex.getStatusCode()));
        }  
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getBookByLibreryId(@PathVariable int id)throws libraryPersistanceException{
        try {            
            return new ResponseEntity<>(ls.getBookByLibraryId(id),HttpStatus.ACCEPTED);
        } catch (HTTPException ex) {
            Logger.getLogger(LibraryAPI.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.toString(),HttpStatus.valueOf(ex.getStatusCode()));
        }
    }
    
    @DeleteMapping("/{id}")
    public  ResponseEntity<?> deleteLibraryById(@PathVariable int id)throws libraryPersistanceException{
        try {            
            ls.DeleteLibrary(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (HTTPException ex) {
            Logger.getLogger(LibraryAPI.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.toString(),HttpStatus.valueOf(ex.getStatusCode()));
        }
    }
    
    
    
}
