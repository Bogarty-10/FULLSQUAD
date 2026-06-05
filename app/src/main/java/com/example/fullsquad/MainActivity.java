package com.example.fullsquad;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ImageButton btnMenu;

    private Button btnNewJugador;

    private Button btnNewEvento;

    private CardView cardJugadores;

    private CardView cardCalendar;

    private TextView tvNombreEquipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnMenu = findViewById(R.id.btnMenu);

        btnNewJugador = findViewById(R.id.btnAddJugador);

        btnNewEvento = findViewById(R.id.btnAddEvent);

        cardJugadores = findViewById(R.id.cardJugadores);

        cardCalendar = findViewById(R.id.cardCalendar);

        tvNombreEquipo = findViewById(R.id.txtEquipo);

        // Obtener datos guardados
        SharedPreferences prefs = getSharedPreferences("FULLSQUAD", MODE_PRIVATE);

        String nombreEquipo = prefs.getString("nombre_equipo", "FULLSQUAD");

        // Mostrar datos en el header
        tvNombreEquipo.setText(nombreEquipo);

        cardJugadores.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this, JugadoresActivity.class);
                startActivity(intent);
            }
        });

       cardCalendar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this, PartidoActivity.class);
               startActivity(intent);
           }
       });

        btnNewJugador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewplayerActivity.class);
                startActivity(intent);
            }
        });

        btnNewEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NeweventoActivity.class);
                startActivity(intent);
            }
        });

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, btnMenu);

                popupMenu.getMenu().add("Perfil");
                popupMenu.getMenu().add("Mi Equipo");
                popupMenu.getMenu().add("Estadísticas");
                popupMenu.getMenu().add("Configuración");
                popupMenu.getMenu().add("Cerrar sesión");

                popupMenu.setOnMenuItemClickListener(item -> {

                    if (item.getTitle().equals("Cerrar sesión")) {

                        Toast.makeText(MainActivity.this,
                                "Sesión cerrada correctamente",
                                Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);

                        finish();

                        return true;
                    }

                    return false;
                });

                popupMenu.show();


            }
        });
    }
}