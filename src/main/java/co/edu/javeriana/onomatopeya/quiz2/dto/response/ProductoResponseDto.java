 package co.edu.javeriana.onomatopeya.quiz2.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class ProductoResponseDto {

    private Long id;
    private String nombre;
    private String categoria;
    private int precio;
    private Boolean activo;
}
