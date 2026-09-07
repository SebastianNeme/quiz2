package co.edu.javeriana.onomatopeya.quiz2.service;

import co.edu.javeriana.onomatopeya.quiz2.dto.request.ProductoRequestDto;
import co.edu.javeriana.onomatopeya.quiz2.dto.response.ProductoResponseDto;
import co.edu.javeriana.onomatopeya.quiz2.entity.Producto;
import co.edu.javeriana.onomatopeya.quiz2.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoService {

@Transactional
  public ProductoResponseDto registrar(ProductoRequestDto request) {
        validar(request);

        Producto producto = new Producto();
        producto.setNombre(request.getNombre().trim());
        producto.setCategoria(request.getCategoria().trim());
        producto.setPrecio(request.getPrecio());
        producto.setActivo(request.getActivo());

        Producto guardado = productoRepository.save(producto);

        return convertirARespuesta(guardado);
    }

@Transactional(readOnly = true)
    public List<ProductoResponseDto> buscarPorCategoria(String categoria) {

        return productoRepository.buscarPorCategoria(categoria.trim())
                .stream()
                .map(this::convertirARespuesta)
                .toList();
    }

   

  private ProductoResponseDto convertirARespuesta(Producto producto) {
        return new ProductoResponseDto(
                producto.getId(),
                producto.getNombre(),
                producto.getCategoria(),
                producto.getPrecio(),
                producto.getActivo()
        );
    }
}
