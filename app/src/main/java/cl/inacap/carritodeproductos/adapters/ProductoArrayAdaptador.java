package cl.inacap.carritodeproductos.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.List;

import cl.inacap.carritodeproductos.R;
import cl.inacap.carritodeproductos.dto.Producto;

public class ProductoArrayAdaptador extends ArrayAdapter<Producto> {
    private Activity activity;
    private List<Producto> productos;

    public ProductoArrayAdaptador(@NonNull Activity context, int resource, @NonNull List<Producto> objects) {
        super(context, resource, objects);
        this.activity = context;
        this.productos = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = this.activity.getLayoutInflater();
        View fila = inflater.inflate(R.layout.productos_list, null, true);
        TextView nombreTv = fila.findViewById(R.id.nombreProductoTv);
        ImageView imagenIv = fila.findViewById(R.id.imagenProductoLv);
        Producto productoActual = productos.get(position);
        nombreTv.setText(productoActual.getNombre());
        Picasso.get().load(productoActual.getFoto()).resize(200, 200).centerCrop().into(imagenIv);

        return fila;
    }
}
