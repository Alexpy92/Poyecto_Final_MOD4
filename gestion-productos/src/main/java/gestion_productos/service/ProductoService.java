package gestion_productos.service;

import gestion_productos.model.Producto;
import gestion_productos.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    // Obtener todos los productos
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    // Buscar un producto por su ID
    public Optional<Producto> getProductoById(Long id) {
        return productoRepository.findById(id);
    }

    // Validar y Agregar un nuevo producto
    public Producto guardarProducto(Producto producto) {
        if (producto.getPrecio() == null || producto.getPrecio() < 0) {
            throw new IllegalArgumentException("El precio del producto no puede ser nulo o negativo.");
        }

        if (producto.getCantidad() == null || producto.getCantidad() < 0) {
            throw new IllegalArgumentException("La cantidad del producto no puede ser nula o negativa.");
        }

        return productoRepository.save(producto);
    }

    // Obtener producto con mayor stock
    public Producto obtenerProductoConMayorStock() {
        List<Producto> productos = productoRepository.findAll();

        if (productos.isEmpty()) {
            return null;
        }

        Producto mayorStock = productos.get(0);

        for (Producto p : productos) {
            if (p.getCantidad() > mayorStock.getCantidad()) {
                mayorStock = p;
            }
        }

        return mayorStock;
    }
}