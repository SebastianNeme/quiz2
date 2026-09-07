
package co.edu.javeriana.onomatopeya.quiz2.controller;

import co.edu.javeriana.onomatopeya.quiz2.dto.request.ProductoRequestDto;
import co.edu.javeriana.onomatopeya.quiz2.dto.response.ProductoResponseDto;
import co.edu.javeriana.onomatopeya.quiz2.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation     
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/productos")
@RequiredArgsConstructor
  
public class ProductoController {

    private final ProductoService productoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductoResponseDto registrar(
       @RequestBody ProductoRequestDto request) {

        return productoService.registrar(request);
    }

    @GetMapping("/buscar/{categoriaa}")
    public List<ProductoResponseDto> buscarPorCategoria(
            @PathVariable("categoria") String categoria) {

        return productoService.buscarPorCategoria(categoria);
    }
}
