package com.holamundo.ejemplo.holamundo.repository;
import com.holamundo.ejemplo.holamundo.model.Libro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class LibroRepository {
    private List<Libro> listaLibro = new ArrayList<>();

    public List<Libro> obtenerLibro(){
        return listaLibro;
    }

    public Libro buscarPorId(int id){
        for (Libro libro : listaLibro){
            if (libro.getId() == id){
                return libro;
            }
        }
        return null;
    }

    public Libro buscarPorIsbn(String isbn){
        for (Libro libro: listaLibro){
            if (libro.getIsbn().equals(isbn)){
                return libro;
            }
        }
        return null;
    }
    public Libro guardar(Libro libro){
        int id=0, idPosicion=0;

        listaLibro.add(libro);
        return libro;

    }

    public Libro actualizar(Libro libro){
        int id=0, idPosicion=0;

        for (int i=0; i <  listaLibro.size(); i++) {
            if ((listaLibro.get(i).getId()) == libro.getId()){
                id = libro.getId();
                idPosicion = i;

            }
        }

        Libro libro1 = new Libro();
        libro1.setId(id);
        libro1.setTitulo(libro.getTitulo());
        libro1.setAutor(libro.getAutor());
        libro1.setFechaPublicacion(libro.getFechaPublicacion());

        return libro1;
    }

    public void eliminar( int id) {
        Libro libro = buscarPorId(id);
        if (libro != null) {
            listaLibro.remove(libro);
        }
    }
}