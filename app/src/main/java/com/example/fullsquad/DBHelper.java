package com.example.fullsquad;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

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
    public ArrayList<Jugador> obtenerJugadores() {

        ArrayList<Jugador> lista = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM jugadores", null);

        if (cursor.moveToFirst()) {
            do {
                String correo = cursor.getString(cursor.getColumnIndexOrThrow("correo"));
                String nombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre"));
                String fecha = cursor.getString(cursor.getColumnIndexOrThrow("fecha_nacimiento"));
                int dorsal = cursor.getInt(cursor.getColumnIndexOrThrow("dorsal"));
                String posicion = cursor.getString(cursor.getColumnIndexOrThrow("posicion"));

                Jugador jugador = new Jugador(correo, nombre, fecha, dorsal, posicion);
                lista.add(jugador);

            } while (cursor.moveToNext());
        }

        cursor.close();

        return lista;
    }

    public int contarJugadores() {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT COUNT(*) FROM jugadores", null);

        int cantidad = 0;

        if (cursor.moveToFirst()) {
            cantidad = cursor.getInt(0);
        }

        cursor.close();

        return cantidad;
    }

    public void insertarDatosPrueba() {

        if (contarJugadores() > 0) {
            return;
        }

        insertarJugador("juan@fullsquad.com", "Juan Pérez", "12/03/2000", 1, "Portero");
        insertarJugador("carlos@fullsquad.com", "Carlos Ruiz", "05/06/1999", 4, "Defensa");
        insertarJugador("pedro@fullsquad.com", "Pedro López", "20/01/2001", 5, "Defensa");
        insertarJugador("miguel@fullsquad.com", "Miguel Santos", "14/09/2000", 6, "Mediocentro");
        insertarJugador("david@fullsquad.com", "David Martín", "30/11/1998", 8, "Mediocentro");
        insertarJugador("alex@fullsquad.com", "Álex García", "17/02/2002", 10, "Delantero");
        insertarJugador("sergio@fullsquad.com", "Sergio Ramos", "22/04/2001", 9, "Delantero");
        insertarJugador("luis@fullsquad.com", "Luis Moreno", "11/12/1999", 7, "Mediocentro");
        insertarJugador("adrian@fullsquad.com", "Adrián Torres", "03/08/2000", 3, "Defensa");
        insertarJugador("marcos@fullsquad.com", "Marcos Díaz", "25/10/2002", 11, "Delantero");
        insertarJugador("ivan@fullsquad.com", "Iván Romero", "18/05/2001", 2, "Defensa");
        insertarJugador("daniel@fullsquad.com", "Daniel Vega", "09/07/2000", 12, "Portero");
    }

    // Leer partidos/eventos
    public ArrayList<Partido> obtenerPartidos() {

        ArrayList<Partido> lista = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM eventos", null);

        if (cursor.moveToFirst()) {
            do {
                String nombreEvent = cursor.getString(cursor.getColumnIndexOrThrow("nameEvent"));
                String fechEvent = cursor.getString(cursor.getColumnIndexOrThrow("fechEvent"));
                String localizacionEvent = cursor.getString(cursor.getColumnIndexOrThrow("localizacionEvent"));
                String horaEvent = cursor.getString(cursor.getColumnIndexOrThrow("horaEvent"));

                Partido partido = new Partido(
                        nombreEvent,
                        fechEvent,
                        localizacionEvent,
                        horaEvent
                );

                lista.add(partido);

            } while (cursor.moveToNext());
        }

        cursor.close();

        return lista;
    }
    // Insertar partidos de prueba
    public void insertarPartidosPrueba() {

        insertarEvento(
                "FULLSQUAD vs Los Leones",
                "12/06/2026",
                "Campo Vista Alegre",
                "11:00"
        );

        insertarEvento(
                "FULLSQUAD vs Atlético Sur",
                "19/06/2026",
                "Polideportivo Norte",
                "10:30"
        );

        insertarEvento(
                "FULLSQUAD vs Sporting Madrid",
                "26/06/2026",
                "Campo Municipal",
                "12:00"
        );

        insertarEvento(
                "FULLSQUAD vs Los Titanes",
                "03/07/2026",
                "Campo Central",
                "11:30"
        );

        insertarEvento(
                "FULLSQUAD vs Fénix FC",
                "10/07/2026",
                "Ciudad Deportiva",
                "10:00"
        );

        insertarEvento(
                "FULLSQUAD vs Unión Latina",
                "17/07/2026",
                "Campo Municipal",
                "12:30"
        );

        insertarEvento(
                "FULLSQUAD vs Real Vallecas",
                "24/07/2026",
                "Campo Vallecas",
                "11:00"
        );

        insertarEvento(
                "FULLSQUAD vs Estrellas FC",
                "31/07/2026",
                "Campo Norte",
                "09:30"
        );

        insertarEvento(
                "FULLSQUAD vs Deportivo Centro",
                "07/08/2026",
                "Polideportivo Sur",
                "10:30"
        );

        insertarEvento(
                "FULLSQUAD vs Majadahonda CF",
                "14/08/2026",
                "Campo Municipal Majadahonda",
                "12:00"
        );
    }
}
