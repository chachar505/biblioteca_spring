package com.holamundo.ejemplo.holamundo.service;

import com.holamundo.ejemplo.holamundo.model.Libro;
import com.holamundo.ejemplo.holamundo.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class libroService {

    @Autowired
    private LibroRepository libroRepository; // Minúscula para la instancia

    public List<Libro> getLibros() {
        return libroRepository.obtenerTodos();
    }

    public Libro saveLibro(Libro libro) { // Recibe un Libro, no un Repository
        return libroRepository.guardar(libro);
    }

    public Libro getLibroId(int id){
        return libroRepository.buscarPorId(id);
    }
    public abstract Libro updateLibro();

}