package com.proyecto.biblioteca.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.proyecto.biblioteca.dto.LibroRequest;
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

    
    private LibroResponse entidadADTO (Libro libro){
        return LibroResponse.builder()
        .id(libro.getId())
        .titulo(libro.getTitulo())
        .isbn(libro.getIsbn())
        .precio(libro.getPrecio())
        .categoria(libro.getCategoria())
        .build();
    }

    private Libro dtoAEntidad (LibroRequest dto){
        Libro libro = new Libro();
        libro.setTitulo(dto.getTitulo());
        libro.setIsbn(dto.getIsbn());
        libro.setPrecio(dto.getPrecio());
        libro.setCategoria(dto.getCategoria());
        return libro;
    }

    @Override
    public LibroResponse crearLibro(LibroRequest dto){
        log.info("Creando Libro: {}", dto.getTitulo());
        Libro libro = dtoAEntidad(dto);

        Libro lGuardado = libroRepository.save(libro);
        return entidadADTO(lGuardado);

    }

    @Override
    public LibroResponse buscarId(Long id){
        log.info("Buscando libro por Id: {}", id);
        Libro libro = libroRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("asd"));
        return entidadADTO(libro);
    }

  @Override
  public Page<LibroResponse> obtenerTodoLosLibros(Pageable pageable){
        Page<Libro> libroPage = libroRepository.findAll(pageable);
        return libroPage.map(this::entidadADTO);
  }



  @Override
  public void eliminarLibro (Long id){
    if(!libroRepository.existsById(id)){
        throw new RuntimeException("Usuario no encontrado");

    }
    libroRepository.deleteById(id);
    
  }
}
