package cl.inacap.carritodeproductos.dao;

import java.util.List;

import cl.inacap.carritodeproductos.dto.Producto;

public interface ProductoDAO {
    List<Producto> getAll();
    Producto save(Producto p);
}
