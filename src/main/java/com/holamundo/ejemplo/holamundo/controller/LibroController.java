package com.holamundo.ejemplo.holamundo.controller;

import com.holamundo.ejemplo.holamundo.model.Libro;
import com.holamundo.ejemplo.holamundo.repository.LibroRepository;
import com.holamundo.ejemplo.holamundo.service.libroService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("")

public class LibroController {

    @Autowired
    private libroService libroService;
    @Autowired
    private LibroRepository libroRepository;

    @GetMapping
    public List<Libro> listarLibro(){
        return libroService.getLibros();
    }

    @PostMapping
    public Libro agregarLibro(@RequestBody Libro libro){
        return libroService.saveLibro(libro);
    }

    @GetMapping("{id}")
    public Libro buscarLibro(@RequestBody Libro libro){
        return libroService.updateLibro();
    }

    public String deletelibro(int id){
        libroRepository.eliminar(id);
        return "producto eliminado";
    }

}
