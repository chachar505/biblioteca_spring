package com.holamundo.ejemplo.holamundo.controller;

import com.holamundo.ejemplo.holamundo.model.Libro;
import com.holamundo.ejemplo.holamundo.service.LibroService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/v1/libros")

public class LibroController {
    @Autowired
    private LibroService libroServicio;  // ← tipo con mayúscula, variable distinta

    @GetMapping
    public List<Libro> listarLibro() {
        return libroServicio.getLibros();  // ← usa el nuevo nombre
    }

    @PostMapping
    public Libro agregarLibro(@RequestBody Libro libro) {
        return libroServicio.saveLibro(libro);
    }

    @GetMapping("{id}")
    public Libro buscarLibro(@PathVariable int id) {
        return libroServicio.getLibroId(id);
    }

    @PutMapping("{id}")
    public Libro actualizarLibro(@PathVariable int id, @RequestBody Libro libro) {
        return libroServicio.updateLibro(libro);
    }

    @DeleteMapping("{id}")
    public String eliminarLibro(@PathVariable int id) {
        return libroServicio.deleteLibro(id);
    }

}