package cl.inacap.carritodeproductos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import cl.inacap.carritodeproductos.dto.Producto;

public class VerProductoActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView nombreProductoTv;
    private ImageView productoImagenIv;
    private TextView productoDescripcionTv;
    private TextView productoPrecioTv;
    private TextView tituloToolbarTv;

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_producto);
        this.tituloToolbarTv = findViewById(R.id.tituloToolbarTv);
        this.nombreProductoTv = findViewById(R.id.nombreProducto2Tv);
        this.productoImagenIv = findViewById(R.id.productoImagen2Iv);
        this.productoDescripcionTv = findViewById(R.id.productoDescripcionTv);
        this.productoPrecioTv = findViewById(R.id.productoPrecioTv);
        this.toolbar = findViewById(R.id.toolbar);
        this.setSupportActionBar(this.toolbar);
        this.getSupportActionBar().setDisplayShowHomeEnabled(true);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (getIntent() != null) {
            this.tituloToolbarTv.setText("PRODUCTO");
            Producto producto = (Producto)getIntent().getSerializableExtra("producto");
            this.nombreProductoTv.setText(producto.getNombre());
            Picasso.get().load(producto.getFoto()).resize(500, 500).centerCrop().into(this.productoImagenIv);
            this.productoDescripcionTv.setText(producto.getDescripcion());
            this.productoPrecioTv.setText("$" + producto.getPrecio());
        }
    }
}


















