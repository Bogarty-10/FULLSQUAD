package com.example.fullsquad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

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

        BottomNavigationView bottomNavigation = findViewById(R.id.bottomNavigation);

        bottomNavigation.setSelectedItemId(R.id.nav_players);

        bottomNavigation.setOnItemSelectedListener(item -> {

            if (item.getItemId() == R.id.nav_home) {

                startActivity(
                        new Intent(
                                JugadoresActivity.this,
                                MainActivity.class
                        )
                );
                finish();
                return true;
            }

            if (item.getItemId() == R.id.nav_players) {
                return true;
            }

            if (item.getItemId() == R.id.nav_games) {

                startActivity(
                        new Intent(
                                JugadoresActivity.this,
                                PartidoActivity.class
                        )
                );
                finish();
                return true;
            }

            return false;
        });

    }
}