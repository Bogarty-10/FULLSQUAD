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

public class PartidoActivity extends AppCompatActivity {
    private RecyclerView recyclerPartidos;
    private DBHelper dbHelper;
    private PartidoAdapter adapter;
    private ArrayList<Partido> listaPartidos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_partido);


            // Obtener RecyclerView
            recyclerPartidos = findViewById(R.id.recyclerPartidos);

            // Crear conexión SQLite
            dbHelper = new DBHelper(this);

            // Obtener partidos guardados
            listaPartidos = dbHelper.obtenerPartidos();

            // Crear adaptador
            adapter = new PartidoAdapter(listaPartidos);

            // Mostrar lista vertical
            recyclerPartidos.setLayoutManager(new LinearLayoutManager(this));

            // Asignar adaptador
            recyclerPartidos.setAdapter(adapter);

            // Insertar datos de prueba
            dbHelper.insertarPartidosPrueba();

            // Obtener partidos
            listaPartidos = dbHelper.obtenerPartidos();

            adapter = new PartidoAdapter(listaPartidos);

            recyclerPartidos.setLayoutManager(
                    new LinearLayoutManager(this)
            );

            recyclerPartidos.setAdapter(adapter);

        BottomNavigationView bottomNavigation = findViewById(R.id.bottomNavigation);

        bottomNavigation.setSelectedItemId(R.id.nav_games);

        bottomNavigation.setOnItemSelectedListener(item -> {

            if (item.getItemId() == R.id.nav_home) {

                startActivity(
                        new Intent(
                                PartidoActivity.this,
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
                                PartidoActivity.this,
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