package com.example.fullsquad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NeweventoActivity extends AppCompatActivity {
    private Button btnCancelarEvent;
    private EditText etNameEvent;
    private EditText etFechEvent;
    private EditText etLocalizacion;
    private EditText etHora;
    private Button btnGuardarEvent;

    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_newevento);
        etNameEvent = findViewById(R.id.editTNameEvent);

        etFechEvent = findViewById(R.id.editTFechEvent);

        etLocalizacion = findViewById(R.id.etLocalizacion);

        etHora = findViewById(R.id.etHora);

        btnGuardarEvent = findViewById(R.id.btnGuardarEvent);


        btnCancelarEvent = findViewById(R.id.btnCancelarEvent);

        dbHelper = new DBHelper(this);

        btnCancelarEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NeweventoActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnGuardarEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameEvent = etNameEvent.getText().toString();
                String fechEvent = etFechEvent.getText().toString();
                String localizacion = etLocalizacion.getText().toString();
                String hora = etHora.getText().toString();

                boolean insertado =
                        dbHelper.insertarEvento(
                                nameEvent,
                                fechEvent,
                                localizacion,
                                hora
                        );
            }
        });

    }
}