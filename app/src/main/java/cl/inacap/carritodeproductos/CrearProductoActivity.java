package cl.inacap.carritodeproductos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import cl.inacap.carritodeproductos.dao.ProductoDAO;
import cl.inacap.carritodeproductos.dao.ProductoDAOSQLite;
import cl.inacap.carritodeproductos.dto.Producto;

public class CrearProductoActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private EditText nombreProductoCrearEt;
    private EditText precioProductoCrearEt;
    private EditText fotoProductoCrearEt;
    private EditText descripcionProductoCrearEt;
    private Button crearBtn;
    private ProductoDAO daoProductos = new ProductoDAOSQLite(this);

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_producto);
        this.toolbar = findViewById(R.id.toolbar);
        this.setSupportActionBar(this.toolbar);
        this.getSupportActionBar().setDisplayShowHomeEnabled(true);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.nombreProductoCrearEt = findViewById(R.id.nombreProductoCrearEt);
        this.precioProductoCrearEt = findViewById(R.id.precioProductoCrearEt);
        this.fotoProductoCrearEt = findViewById(R.id.fotoProductoCrearEt);
        this.descripcionProductoCrearEt = findViewById(R.id.descripcionProductoCrearEt);
        this.crearBtn = findViewById(R.id.crearBtn);

        this.crearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //1. Crear el producto.
                Producto p = new Producto();
                p.setNombre(nombreProductoCrearEt.getText().toString());
                p.setDescripcion(descripcionProductoCrearEt.getText().toString());
                p.setFoto(fotoProductoCrearEt.getText().toString());
                p.setPrecio(Integer.parseInt(precioProductoCrearEt.getText().toString()));

                //2. Llamar al DAO y agregarlo.
                daoProductos.save(p);

                //3. Redirigir al MainActivity.
                startActivity(new Intent(CrearProductoActivity.this, MainActivity.class));
            }
        });

    }
}