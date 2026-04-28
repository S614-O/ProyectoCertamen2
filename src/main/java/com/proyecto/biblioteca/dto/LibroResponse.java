package com.proyecto.biblioteca.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class LibroResponse {
    private Long id;
    private String titulo;
    private String isbn;
    private BigDecimal precio;

    // Solo el nombre de la categoria, no el objeto completo.
    // Se obtiene desde libro.getCategoria().getNombre() en mapToDTO.
    private String categoriaNombre;
}
