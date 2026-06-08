package com.example.fullsquad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterActivity extends AppCompatActivity {
    private Button btnRegistrarse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        btnRegistrarse = findViewById(R.id.buttonRegister);

        EditText etUsuario = findViewById(R.id.editTUsuario);

        EditText etCorreo = findViewById(R.id.editTCorreo);

        EditText etPassword = findViewById(R.id.editTPass);

        EditText etConfirmPass = findViewById(R.id.editTConfirmPass);

        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = etUsuario.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                String confirmPass = etConfirmPass.getText().toString().trim();

                String correo = etCorreo.getText().toString().trim();

                if (usuario.isEmpty() || password.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Rellena todos los campos", Toast.LENGTH_SHORT).show();
                    return;
                }

                DBHelper dbHelper = new DBHelper(RegisterActivity.this);

                // Validar campos vacíos
                if (usuario.isEmpty() || correo.isEmpty()||
                        password.isEmpty() ||
                        confirmPass.isEmpty()) {

                    Toast.makeText(
                            RegisterActivity.this,
                            "Rellena todos los campos",
                            Toast.LENGTH_SHORT
                    ).show();

                    return;
                }

// Validar contraseñas
                if (!password.equals(confirmPass)) {

                    Toast.makeText(
                            RegisterActivity.this,
                            "Las contraseñas no coinciden",
                            Toast.LENGTH_SHORT
                    ).show();

                    return;
                }

                boolean insertado = dbHelper.insertarUsuario(usuario, password);

                if (insertado) {
                    Toast.makeText(RegisterActivity.this, "Usuario registrado correctamente", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(RegisterActivity.this, CoachActivity.class);
                    startActivity(intent);
                    finish();

                } else {
                    Toast.makeText(RegisterActivity.this, "Error al registrar usuario", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}