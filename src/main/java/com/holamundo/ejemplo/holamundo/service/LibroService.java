package com.holamundo.ejemplo.holamundo.service;

import com.holamundo.ejemplo.holamundo.model.Libro;
import com.holamundo.ejemplo.holamundo.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository; // Minúscula para la instancia

    public List<Libro> getLibros() {
        return libroRepository.obtenerLibro();
    }

    public Libro saveLibro(Libro libro) { // Recibe un Libro, no un Repository

        return libroRepository.guardar(libro);
    }

    public Libro getLibroId(int id){

        return libroRepository.buscarPorId(id);
    }

    public Libro updateLibro(Libro libro){
        return libroRepository.actualizar(libro);
    }

    public String deleteLibro(int id){
        libroRepository.eliminar(id);
        return "producto eliminado";
    }

}