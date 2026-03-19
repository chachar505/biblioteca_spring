package com.holamundo.ejemplo.holamundo.service;

import com.holamundo.ejemplo.holamundo.model.Libro;
import com.holamundo.ejemplo.holamundo.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class libroService {

    @Autowired

    private LibroRepository LibroRepository;

    public List<libroService> getLibros(){
        return LibroRepository.obtenerLibros();

    }

    public LibroRepository saveLIbro(LibroRepository libro){
        return LibroRepository.guardar(libro);
    }

    public Libro updateLibro(Libro libro){
        return LibroRepository.actualizar(libro);
    }

    public Libro getLibroId(int id){
        return LibroRepository.actualizar(Libro);
    }



}
