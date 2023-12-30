package cl.inacap.carritodeproductos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import cl.inacap.carritodeproductos.adapters.ProductoArrayAdaptador;
import cl.inacap.carritodeproductos.dao.ProductoDAO;
import cl.inacap.carritodeproductos.dao.ProductoDAOSQLite;
import cl.inacap.carritodeproductos.dto.Producto;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton agregarBtn;
    private ListView productosLv;
    private List<Producto> productos;
    private ProductoArrayAdaptador adaptador;
    private ProductoDAO daoProductos = new ProductoDAOSQLite(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        this.agregarBtn = findViewById(R.id.agregarBtn);
        this.agregarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CrearProductoActivity.class));
            }
        });
    }

    protected void onResume() {
        super.onResume();
        productos = daoProductos.getAll();
        adaptador = new ProductoArrayAdaptador(this,R.layout.productos_list,productos);
        productosLv = findViewById(R.id.productosLv);
        productosLv.setAdapter(adaptador);
        productosLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, VerProductoActivity.class);
                Producto productoActual = productos.get(i);
                intent.putExtra("producto", productoActual);
                startActivity(intent);
            }
        });
    }
}