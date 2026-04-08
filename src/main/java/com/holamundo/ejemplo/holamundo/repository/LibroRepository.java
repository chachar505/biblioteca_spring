package com.holamundo.ejemplo.holamundo.repository;
import com.holamundo.ejemplo.holamundo.model.Libro;
import com.holamundo.ejemplo.holamundo.repository.LibroRepositorio; // Nombre actualizado
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    @Autowired
    private LibroRepositorio libroRepositorio; // Cambiado a LibroRepositorio

    public List<Libro> getLibros() {
        return libroRepositorio.obtenerLibros();
    }

    public Libro getLibroId(int id) {
        return libroRepositorio.buscarPorId(id);
    }

    public Libro saveLibro(Libro libro) {
        // Validación: No permitir ISBN duplicado
        if (libroRepositorio.buscarPorIsbn(libro.getIsbn()) != null) {
            throw new RuntimeException("El ISBN ya existe.");
        }
        return libroRepositorio.guardar(libro);
    }

    public Libro updateLibro(Libro libro) {
        return libroRepositorio.actualizar(libro);
    }

    public String deleteLibro(int id) {
        libroRepositorio.eliminar(id);
        return "Libro con ID " + id + " eliminado con éxito.";
    }

    public String eliminart(String titulo) {
        libroRepositorio.eliminart(titulo);
        return "Libro '" + titulo + "' eliminado.";
    }

    public int totalLibros() {
        return libroRepositorio.totalLibros();
    }

    public Libro getLibroIsbn(String isbn) {
        return libroRepositorio.buscarPorIsbn(isbn);
    }

    public Libro getLibroFechaPublicacion(int fecha) {
        return libroRepositorio.buscarPorFechaPublicacion(fecha);
    }

    public Libro getLibroTitulo(String titulo) {
        return libroRepositorio.buscarPorTitulo(titulo);
    }

    public Libro getLibroAutor(String autor) {
        return libroRepositorio.buscarPorAutor(autor);
    }

    public Libro obtenerMasAntiguo() {
        return libroRepositorio.obtenerMasAntiguo();
    }

    public Libro obtenerMasNuevo() {
        return libroRepositorio.obtenerMasNuevo();
    }

    public List<Libro> listarLibrosOrdenados() {
        return libroRepositorio.obtenerLibrosOrdenados();
    }
}