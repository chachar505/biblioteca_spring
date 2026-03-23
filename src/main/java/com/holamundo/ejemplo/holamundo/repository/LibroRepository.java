package com.holamundo.ejemplo.holamundo.repository;
import com.holamundo.ejemplo.holamundo.model.Libro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class LibroRepository {


    private List<Libro> listaLibro = new ArrayList<>();


    public LibroRepository(){
        listaLibro.add(new Libro(1,  2018, "9789569646638", "Fuego y Sangre",                                    "Penguin Random House Grupo Editorial", "George R. R. Martin"));
        listaLibro.add(new Libro(2,  2014, "9789563494150", "Quique Hache: El Mall Embrujado y Otras Historias", "Sm Ediciones",                        "Sergio Gomez"));
        listaLibro.add(new Libro(3,  2020, "9781484256251", "Spring Boot Persistence Best Practices",            "Apress",                              "Anghel Leonard"));
        listaLibro.add(new Libro(4,  2024, "9789566075752", "Harry Potter y la piedra filosofal",                "Salamandra",                          "J. K. Rowling"));
        listaLibro.add(new Libro(5,  1999, "9780439139601", "Harry Potter y el prisionero Azkaban",              "Scholastic",                          "J. K. Rowling"));
        listaLibro.add(new Libro(6,  2000, "9780439136365", "Harry Potter y el cáliz de fuego",                 "Scholastic",                          "J. K. Rowling"));
        listaLibro.add(new Libro(7,  2008, "9780321127426", "Effective Java",                                    "Addison-Wesley",                      "Joshua Bloch"));
        listaLibro.add(new Libro(8,  2017, "9780134685991", "Clean Architecture",                               "Prentice Hall",                       "Robert C. Martin"));
        listaLibro.add(new Libro(9,  1994, "9780201633610", "Design Patterns",                                   "Addison-Wesley",                      "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides"));
        listaLibro.add(new Libro(10, 2008, "9780132350884", "Clean Code",                                        "Prentice Hall",                       "Robert C. Martin"));
    }
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