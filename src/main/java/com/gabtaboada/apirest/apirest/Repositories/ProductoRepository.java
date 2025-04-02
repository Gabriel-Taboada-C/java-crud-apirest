package com.gabtaboada.apirest.apirest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gabtaboada.apirest.apirest.Entities.Producto;

public interface ProductoRepository extends JpaRepository <Producto, Long>{

}

/* El repositorio es una INTERFASE no una clase. 
 * Importamos la Entitie creada anteriormente y
 * la funcion JpaRepository importada con 2 datos entre <>
 * el tipo de entidad (Producto)
 * el tipo de identificador (en este caso Long, pero puede ser Int)
 */