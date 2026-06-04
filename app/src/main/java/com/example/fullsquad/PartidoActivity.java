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
        }
    }