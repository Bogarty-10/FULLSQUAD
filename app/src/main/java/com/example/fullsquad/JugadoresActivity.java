package com.example.fullsquad;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class JugadoresActivity extends AppCompatActivity {
    //declarar vistas
    private RecyclerView rvJugadores;

    //Acceso a Sqlite
    private DBHelper dbHelper;

    //Lista de datos
    private ArrayList<Jugador> listaJugadores;
    private JugadorAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_jugadores);

        //inincliar
        rvJugadores = findViewById(R.id.rvJugadores);

        //Crear conexion con SQLite
        dbHelper = new DBHelper(this);

        //Insertar datos de prueba
        dbHelper.insertarDatosPrueba();

        //Leer jugadores
        listaJugadores = dbHelper.obtenerJugadores();
        // Crear adaptador
        adapter = new JugadorAdapter(listaJugadores);

        // Mostrar lista vertical
        rvJugadores.setLayoutManager(
                new LinearLayoutManager(this)
        );

        // Asignar adaptador
        rvJugadores.setAdapter(adapter);

    }
}