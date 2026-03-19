package com.holamundo.ejemplo.holamundo.repository;

import com.holamundo.ejemplo.holamundo.model.Libro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LibroRepository{

    private List<Libro> listaLibros = new ArrayList<>();

    public List<Libro> obtenerTodos() {
        return listaLibros;
    }

    public Libro buscarPorId(int id) {
        for (Libro libro : listaLibros) {
            if (libro.getId() == id) {
                return libro;
            }
        }
        return null;
    }

    public Libro buscarPorIsbn(String isbn) {
        for (Libro libro : listaLibros) {
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }

    public Libro guardar(Libro libro) {
        listaLibros.add(libro);
        return libro;
    }

    public Libro actualizar(Libro libroActualizado) {
        for (int i = 0; i < listaLibros.size(); i++) {
            if (listaLibros.get(i).getId() == libroActualizado.getId()) {
                listaLibros.set(i, libroActualizado);
                return libroActualizado;
            }
        }
        return null;
    }
}