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
    private RecyclerView recyclerJugadores;
    private DBHelper dbHelper;
    private JugadorAdapter adapter;
    private ArrayList<Jugador> listaJugadores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_jugadores);
        recyclerJugadores = findViewById(R.id.recyclerJugadores);

        dbHelper = new DBHelper(this);

        dbHelper.insertarDatosPrueba();

        listaJugadores = dbHelper.obtenerJugadores();

        adapter = new JugadorAdapter(listaJugadores);

        recyclerJugadores.setLayoutManager(new LinearLayoutManager(this));
        recyclerJugadores.setAdapter(adapter);
    }
}