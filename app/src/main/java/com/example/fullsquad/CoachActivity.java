package com.example.fullsquad;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CoachActivity extends AppCompatActivity {
    Spinner spLocalidad;

    private Button btnFinalizar;

    private EditText etNameTeam;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_coach);

        btnFinalizar = findViewById(R.id.btnFinCoach);

        spLocalidad = findViewById(R.id.spinnerLocalidad);

        etNameTeam = findViewById(R.id.editTNameTeam);

            ArrayAdapter<CharSequence> adapter =
                    ArrayAdapter.createFromResource(
                            this,
                            R.array.localidades,
                            android.R.layout.simple_spinner_item
                    );

            adapter.setDropDownViewResource(
                    android.R.layout.simple_spinner_dropdown_item
            );

            spLocalidad.setAdapter(adapter);


            btnFinalizar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Obtener datos del formulario
                    String nombreEquipo = etNameTeam.getText().toString().trim();


                    // Validar campos
                    if (nombreEquipo.isEmpty()) {
                        Toast.makeText(CoachActivity.this, "Introduce el nombre del equipo", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    // Guardar datos del equipo
                    SharedPreferences prefs = getSharedPreferences("FULLSQUAD", MODE_PRIVATE);

                    prefs.edit()
                            .putString("nombre_equipo", nombreEquipo)
                            .apply();

                    // Ir al Main
                    Intent intent = new Intent(CoachActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            });

    }
}