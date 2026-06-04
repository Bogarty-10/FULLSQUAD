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

        EditText editCorreo = findViewById(R.id.eTNombre);
        EditText editPassword = findViewById(R.id.eTPass);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String correo = editCorreo.getText().toString().trim();
                String password = editPassword.getText().toString().trim();

                DBHelper dbHelper = new DBHelper(LoginActivity.this);

                dbHelper.insertarUsuarioPrueba();

                if (correo.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Rellena todos los campos", Toast.LENGTH_SHORT).show();
                    return;
                }

                boolean existe = dbHelper.comprobarUsuario(correo, password);

                if (existe) {
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