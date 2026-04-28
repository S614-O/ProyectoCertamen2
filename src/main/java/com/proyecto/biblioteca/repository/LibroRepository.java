package com.proyecto.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.biblioteca.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {


    
}
