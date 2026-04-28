package com.proyecto.biblioteca.service;

import org.springframework.stereotype.Service;

import com.proyecto.biblioteca.dto.LibroResponse;
import com.proyecto.biblioteca.model.Libro;
import com.proyecto.biblioteca.repository.LibroRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@RequiredArgsConstructor
@Slf4j
@Transactional

public class LibroServiceImpl implements LibroService {


    private final LibroRepository libroRepository;



    




    
}
