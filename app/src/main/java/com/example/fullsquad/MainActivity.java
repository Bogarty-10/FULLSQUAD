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

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ImageButton btnMenu;

    private Button btnNewJugador;

    private Button btnNewEvento;

    private CardView cardJugadores;

    private CardView cardCalendar;

    private TextView tvNombreEquipo;

    private TextView tvNombrePartido;
    private TextView tvFechaPartido;
    private TextView tvHoraPartido;
    private TextView tvLugarPartido;

    private DBHelper dbHelper;

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

        tvNombrePartido = findViewById(R.id.tvRivales);

        tvFechaPartido = findViewById(R.id.tvFechaPartidoMain);

        tvHoraPartido = findViewById(R.id.tvHoraPartidoMain);

        tvLugarPartido = findViewById(R.id.tvLugarPartidoMain);

        CardView cardProximoPartido = findViewById(R.id.cardNextMatch);

        cardProximoPartido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DetallePartidoActivity.class);
                startActivity(intent);
            }
        });


        dbHelper = new DBHelper(this);

        Partido ultimoPartido = dbHelper.obtenerUltimoPartido();

        if (ultimoPartido != null) {

            tvNombrePartido.setText(ultimoPartido.getNombreEvent());
            tvFechaPartido.setText("Fecha: " + ultimoPartido.getFechEvent());
            tvHoraPartido.setText("Hora: " + ultimoPartido.getHoraEvent());
            tvLugarPartido.setText("Lugar: " + ultimoPartido.getLocalizacionEvent());

        } else {

            tvNombrePartido.setText("No hay partidos creados");
        }

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
        BottomNavigationView bottomNavigation = findViewById(R.id.bottomNavigation);

        bottomNavigation.setSelectedItemId(R.id.nav_home);

        bottomNavigation.setOnItemSelectedListener(item -> {

            if (item.getItemId() == R.id.nav_home) {

                return true;
            }

            if (item.getItemId() == R.id.nav_players) {
                startActivity(
                        new Intent(
                                MainActivity.this,
                                JugadoresActivity.class
                        )
                );
                finish();
                return true;
            }

            if (item.getItemId() == R.id.nav_games) {

                startActivity(
                        new Intent(
                                MainActivity.this,
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