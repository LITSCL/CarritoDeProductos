package cl.inacap.carritodeproductos.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ProductoSQLiteHelper extends SQLiteOpenHelper {

    private final String sqlCreate = "CREATE TABLE producto" +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL" +
            ",nombre TEXT" +
            ",descripcion TEXT" +
            ",precio INTEGER" +
            ",foto TEXT)";

    public ProductoSQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(sqlCreate);
        sqLiteDatabase.execSQL("INSERT INTO producto(nombre,descripcion,precio,foto)" +
                " VALUES('Coca','Coca Cola Buenarda',1000,'https://jumbo.vteximg.com.br/arquivos/ids/336745/Principal-3942.jpg?v=637237316746070000')");
        sqLiteDatabase.execSQL("INSERT INTO producto(nombre,descripcion,precio,foto)" +
                " VALUES('Ramas','Ramitas Buenardas',1700,'https://s.cornershopapp.com/product-images/534341.jpg?versionId=u14Yl9eYhe1gPkVRxeavEmauxVTsyRo.')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS producto");
        sqLiteDatabase.execSQL(sqlCreate);
    }
}
