package cl.inacap.carritodeproductos.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import cl.inacap.carritodeproductos.dto.Producto;
import cl.inacap.carritodeproductos.helpers.ProductoSQLiteHelper;

public class ProductoDAOSQLite implements ProductoDAO {
    private ProductoSQLiteHelper productosHelper;

    public ProductoDAOSQLite(Context context) {
        this.productosHelper = new ProductoSQLiteHelper(context, "dbcarritodeproductos", null, 3);
    }

    @Override
    public List<Producto> getAll() {
        SQLiteDatabase reader = this.productosHelper.getReadableDatabase(); //Aca se hace la conexión a la DB (Conexión de solo lectura).
        List<Producto> productos = new ArrayList<>();
        try {
            if (reader != null) {
                Cursor c = reader.rawQuery("SELECT id,nombre,descripcion,precio,foto" + " FROM producto", null);
                if (c.moveToFirst()) {
                    do {
                        Producto p = new Producto();
                        p.setId(c.getInt(0));
                        p.setNombre(c.getString(1));
                        p.setDescripcion(c.getString(2));
                        p.setPrecio(c.getInt(3));
                        p.setFoto(c.getString(4));
                        productos.add(p);
                    } while (c.moveToNext());
                }
                reader.close();
            }
        } catch (Exception ex) {
            productos = null;
        }
        return productos;
    }

    @Override
    public Producto save(Producto p) {
        SQLiteDatabase writer = this.productosHelper.getWritableDatabase();
        String sql = String.format("INSERT INTO producto(nombre,descripcion,precio,foto)" +
            " VALUES ('%s','%s','%d','%s')", p.getNombre(), p.getDescripcion(), p.getPrecio(), p.getFoto());
        writer.execSQL(sql);
        writer.close();
        return p;
    }
}
