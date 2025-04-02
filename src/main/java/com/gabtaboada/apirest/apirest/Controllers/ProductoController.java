package com.gabtaboada.apirest.apirest.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gabtaboada.apirest.apirest.Entities.Producto;

import com.gabtaboada.apirest.apirest.Repositories.ProductoRepository;

@RestController //Uso este decorador, ya que vamos a hacer una ApiRest
@RequestMapping("/productos")
public class ProductoController {

    @Autowired //Automatiza rutas y procesos por nosotros
    private ProductoRepository productoRepository;

    @GetMapping //Get Grupal
    public List<Producto> obtenerProductos() {
        return productoRepository.findAll();
        // Gracias a Spreen con .findAll() busco todos los valores del repositorio
    }

    @GetMapping("/{id}") //Get Individual
    public Producto obteneProductoPorId(@PathVariable Long id){
        return productoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontro el producto con el ID: " + id));
    }

    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoRepository.save(producto); //Graba en la base de datos y devuelve el producto
    }

    @PutMapping("/{id}")
    public Producto actualizarProducto(@PathVariable Long id, @RequestBody Producto detallesProducto) {
        Producto producto = productoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontro el producto con el ID: " + id));

        producto.setNombre(detallesProducto.getNombre());
        producto.setPrecio(detallesProducto.getPrecio());

        return productoRepository.save(producto);
    }

    @DeleteMapping("/{id}")
    public String borrarProducto(@PathVariable Long id) {
        Producto producto = productoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontro el producto con el ID: " + id));

        productoRepository.delete(producto);
        return "El producto con el ID: " + id + " fue eliminado correctamente";
    }


}
