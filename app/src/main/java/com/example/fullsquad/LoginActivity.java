package com.example.fullsquad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        Button btnLogin = findViewById(R.id.buttonEntrar);

        EditText etUsuario = findViewById(R.id.eTNombre);
        EditText etPassword = findViewById(R.id.eTPass);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String correo = etUsuario.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                DBHelper dbHelper = new DBHelper(LoginActivity.this);

                boolean existe = dbHelper.comprobarUsuario(correo, password);

                if (existe) {
                    Toast.makeText(LoginActivity.this,
                            "Inicio de sesión correcto",
                            Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        TextView tvRegistro = findViewById(R.id.textVRegistro);

        tvRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =
                        new Intent(LoginActivity.this, RolActivity.class);

                startActivity(intent);

            }
        });
    }
}