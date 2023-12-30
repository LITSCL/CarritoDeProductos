package cl.inacap.carritodeproductos.dao;

import java.util.ArrayList;
import java.util.List;

import cl.inacap.carritodeproductos.dto.Producto;

public class ProductoDAOLista implements ProductoDAO {
    private List<Producto> productos = new ArrayList<>();
    private static ProductoDAOLista instancia;

    private ProductoDAOLista() {
        Producto p = new Producto();
        p.setNombre("Coca cola Zero");
        p.setDescripcion("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse ac nulla fermentum, vulputate odio quis, sodales risus. Morbi nec fringilla leo, ut fringilla diam. Nam facilisis rutrum vehicula. Sed accumsan convallis neque.");
        p.setPrecio(1000);
        p.setFoto("https://jumbo.vteximg.com.br/arquivos/ids/336745/Principal-3942.jpg?v=637237316746070000");
        productos.add(p);

        p = new Producto();
        p.setNombre("Ramitas");
        p.setDescripcion("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse ac nulla fermentum, vulputate odio quis, sodales risus. Morbi nec fringilla leo, ut fringilla diam. Nam facilisis rutrum vehicula. Sed accumsan convallis neque.");
        p.setPrecio(1250);
        p.setFoto("https://s.cornershopapp.com/product-images/534341.jpg?versionId=u14Yl9eYhe1gPkVRxeavEmauxVTsyRo.");
        productos.add(p);

        p = new Producto();
        p.setNombre("Toblerone");
        p.setDescripcion("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse ac nulla fermentum, vulputate odio quis, sodales risus. Morbi nec fringilla leo, ut fringilla diam. Nam facilisis rutrum vehicula. Sed accumsan convallis neque.");
        p.setPrecio(2100);
        p.setFoto("https://www.larbos.cl/1492-large_default/toblerone-100-gr.jpg");
        productos.add(p);
    }

    public static ProductoDAOLista getInstance() {
        if (instancia == null) {
            instancia = new ProductoDAOLista();
        }
        return instancia;
    }
    @Override
    public List<Producto> getAll() {
        return productos;
    }

    @Override
    public Producto save(Producto p) {
        productos.add(p);
        return p;
    }
}
