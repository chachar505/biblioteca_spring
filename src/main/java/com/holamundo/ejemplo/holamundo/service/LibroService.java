package com.holamundo.ejemplo.holamundo.service;

import com.holamundo.ejemplo.holamundo.model.Libro;
import com.holamundo.ejemplo.holamundo.repository.LibroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LibroService {

    @Autowired
    private LibroRepositorio libroRepositorio; // Nombre consistente con tu Repositorio

    public List<Libro> getLibros(){
        return libroRepositorio.obtenerLibros();
    }

    public Libro saveLibro(Libro libro){
        return libroRepositorio.guardar(libro);
    }

    public Libro getLibroId(int id){
        return libroRepositorio.buscarPorId(id);
    }

    public Libro updateLibro(Libro libro){
        return libroRepositorio.actualizar(libro);
    }

    public String deleteLibro(int id){
        libroRepositorio.eliminar(id);
        return "Libro eliminado";
    }

    public int totalLibros(){
        return libroRepositorio.totalLibros();
    }

    public Libro getLibroTitulo(String titulo){
        return libroRepositorio.buscarPorTitulo(titulo);
    }

    public Libro getLibroIsbn(String isbn){
        return libroRepositorio.buscarPorIsbn(isbn);
    }

    public Libro getLibroFechaPublicacion(int fechaPublicacion){
        return libroRepositorio.buscarPorFechaPublicacion(fechaPublicacion);
    }

    public Libro getLibroAutor(String autor){
        return libroRepositorio.buscarPorAutor(autor);
    }

    public Libro obtenerMasAntiguo(){
        return libroRepositorio.obtenerMasAntiguo();
    }

    public Libro obtenerMasNuevo(){
        return libroRepositorio.obtenerMasNuevo();
    }

    public List<Libro> listarLibrosOrdenados(){
        return libroRepositorio.obtenerLibrosOrdenados();
    }

    public String eliminart(String titulo) {
        libroRepositorio.eliminart(titulo);
        return "Libro Eliminado";
    }
}