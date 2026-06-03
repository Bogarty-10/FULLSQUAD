package com.example.fullsquad;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "fullsquad.db";
    private static final int DATABASE_VERSION = 1;
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE jugadores (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "correo TEXT," +
                        "nombre TEXT," +
                        "fecha_nacimiento TEXT," +
                        "dorsal INTEGER," +
                        "posicion TEXT)"
        );

        db.execSQL("CREATE TABLE eventos(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nameEvent TEXT, " +
                "fechEvent TEXT, " +
                "localizacionEvent TEXT, " +
                "horaEvent TEXT)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS jugadores");
        db.execSQL("DROP TABLE IF EXISTS eventos");
        onCreate(db);
    }
    public boolean insertarJugador(String correo,
                                   String nombre,
                                   String fech_nacimiento,
                                   int dorsal,
                                   String posicion) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("correo", correo);
        values.put("nombre", nombre);
        values.put("fecha_nacimiento", fech_nacimiento);
        values.put("dorsal", dorsal);
        values.put("posicion", posicion);

        long resultado = db.insert(
                "jugadores",
                null,
                values
        );

        return resultado != -1;
    }
    public boolean insertarEvento(String nameEvent,
                                  String fechEvent,
                                  String localizacionEvent,
                                  String horaEvent)
            {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("nameEvent", nameEvent);
        values.put("fechEvent", fechEvent);
        values.put("localizacionEvent", localizacionEvent);
        values.put("horaEvent", horaEvent);

        long resultado = db.insert(
                "eventos",
                null,
                values
        );

        return resultado != -1;
    }
}
