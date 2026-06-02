package com.example.fullsquad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CoachActivity extends AppCompatActivity {
    Spinner spLocalidad;

    private Button btnFinalizar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_coach);

        btnFinalizar = findViewById(R.id.btnFinCoach);

        spLocalidad = findViewById(R.id.spinnerLocalidad);

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
                    Intent intent = new Intent(CoachActivity.this, MainActivity.class);

                    startActivity(intent);
                }
            });
    }
}