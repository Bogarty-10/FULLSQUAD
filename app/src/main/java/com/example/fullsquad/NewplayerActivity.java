package com.example.fullsquad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class NewplayerActivity extends AppCompatActivity {
    private EditText etCorreo;
    private EditText etNombre;
    private EditText etFechaNacimiento;

    private Spinner spDorsal;
    private Spinner spPosicion;

    private Button btnGuardar;

    private Button btnCancelarPlayer;


    private DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_newplayer);


        etCorreo = findViewById(R.id.editTMailPlayer);
        etNombre = findViewById(R.id.editTNombrePlayer);
        etFechaNacimiento = findViewById(R.id.editTFechPlayer);

        spDorsal = findViewById(R.id.spDorsal);
        spPosicion = findViewById(R.id.spPosicion);

        btnGuardar = findViewById(R.id.btnGuardarPlayer);

        spDorsal = findViewById(R.id.spDorsal);

        spPosicion = findViewById(R.id.spPosicion);

        dbHelper = new DBHelper(this);


        btnCancelarPlayer = findViewById(R.id.btnCancelarPlayer);

        btnCancelarPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (NewplayerActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String correo = etCorreo.getText().toString();
                String nombre = etNombre.getText().toString();
                String fecha = etFechaNacimiento.getText().toString();

                int dorsal = Integer.parseInt(
                        spDorsal.getSelectedItem().toString()
                );
                String posicion =
                        spPosicion.getSelectedItem().toString();

                boolean insertado =
                        dbHelper.insertarJugador(
                                correo,
                                nombre,
                                fecha,
                                dorsal,
                                posicion
                        );
            }
        });
        ArrayAdapter<CharSequence> adapterDorsal =
                ArrayAdapter.createFromResource(
                        this,
                        R.array.dorsales,
                        android.R.layout.simple_spinner_item
                );

        adapterDorsal.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        spDorsal.setAdapter(adapterDorsal);

        ArrayAdapter<CharSequence> adapterPosicion =
                ArrayAdapter.createFromResource(
                        this,
                        R.array.posiciones,
                        android.R.layout.simple_spinner_item
                );

        adapterPosicion.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        spPosicion.setAdapter(adapterPosicion);


    }
}