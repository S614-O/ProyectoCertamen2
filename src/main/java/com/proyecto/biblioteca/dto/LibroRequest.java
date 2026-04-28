package com.proyecto.biblioteca.dto;
import java.math.BigDecimal;

import com.proyecto.biblioteca.model.Categoria;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class LibroRequest {
    @NotBlank(message = "El titulo no puede estar vacio")
    private String titulo;
    
    @NotBlank(message = "El ISBN no puede estar vacio")
    private String isbn;
    
    @NotNull(message = "El precio es obligatorio")
    @Positive(message = "El precio debe ser mayor a 0")
    private BigDecimal precio;

    @NotNull(message = "El categoriaId es obligatorio")
    private Categoria categoria;
}
