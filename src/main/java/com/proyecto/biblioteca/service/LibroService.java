package com.proyecto.biblioteca.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.proyecto.biblioteca.dto.LibroRequest;
import com.proyecto.biblioteca.dto.LibroResponse;

public interface LibroService {
    LibroResponse crearLibro(LibroRequest dto);
    
    LibroResponse buscarId(Long id);

    Page<LibroResponse> obtenerTodoLosLibros(Pageable pageable);

    void eliminarLibro (Long id);
}
