package com.example.fullsquad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RolActivity extends AppCompatActivity {
    private CardView cardEntrenador;
    private CardView cardJugador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_rol);

        cardEntrenador = findViewById(R.id.cardEntrenador);
        cardJugador = findViewById(R.id.cardJugador);

        cardEntrenador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RolActivity.this, RegisterActivity.class);
                intent.putExtra("rol", "entrenador");
                startActivity(intent);
            }
        });
    }
}