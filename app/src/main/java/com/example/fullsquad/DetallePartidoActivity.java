package com.example.fullsquad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetallePartidoActivity extends AppCompatActivity {
    private TextView tvNombrePartido;
    private TextView tvFecha;
    private TextView tvHora;
    private TextView tvCampo;

    private DBHelper dbHelper;

    private Button btnConfirmar;

    private Button btnNoAsistir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detalle_partido);

        tvNombrePartido = findViewById(R.id.tvNombrePartido);
        tvFecha = findViewById(R.id.tvFecha);
        tvHora = findViewById(R.id.tvHora);
        tvCampo = findViewById(R.id.tvCampo);

        btnConfirmar = findViewById(R.id.btnConfirmar);

        btnNoAsistir = findViewById(R.id.btnNoAsistir);

        dbHelper = new DBHelper(this);

// Obtener último partido creado
        Partido partido = dbHelper.obtenerUltimoPartido();

        if(partido != null){

            tvNombrePartido.setText(
                    partido.getNombreEvent()
            );

            tvFecha.setText(
                    "Fecha: " +
                            partido.getFechEvent()
            );

            tvHora.setText(
                    "Hora: " +
                            partido.getHoraEvent()
            );

            tvCampo.setText(
                    "Campo: " +
                            partido.getLocalizacionEvent()
            );
        }

        btnConfirmar.setOnClickListener(v -> {

            Toast.makeText(
                    this,
                    "Asistencia confirmada",
                    Toast.LENGTH_SHORT
            ).show();
            finish();
        });

        btnNoAsistir.setOnClickListener(v -> {

            Toast.makeText(
                    this,
                    "Asistencia rechazada",
                    Toast.LENGTH_SHORT
            ).show();
            finish();
        });

    }
}