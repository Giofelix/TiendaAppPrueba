package com.example.tiendaapp;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;

    private static final int REQUEST_CODE_LOCATION_PERMISSION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.username_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        Button loginButton = findViewById(R.id.login_button);
        TextView registerTextView = findViewById(R.id.register_text_view);
        Button ubicacionButton = findViewById(R.id.btnubicacion);
        Button adminButton = findViewById(R.id.btnadmin); // Agregar el botón btnadmin

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                    Toast.makeText(MainActivity.this, "Por favor, ingrese su nombre de usuario y contraseña", Toast.LENGTH_SHORT).show();
                } else {
                    // Inicia ProductListActivity al hacer clic en el botón de inicio de sesión
                    Intent intent = new Intent(MainActivity.this, ProductListActivity.class);
                    startActivity(intent);
                }
            }
        });

        registerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Inicia UsuarioRegistroActivity al hacer clic en el texto de registro
                Intent intent = new Intent(MainActivity.this, UsuarioRegistroActivity.class);
                startActivity(intent);
            }
        });

        ubicacionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Inicia UsuarioRegistroActivity al hacer clic en el texto de registro
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        });

        adminButton.setOnClickListener(new View.OnClickListener() { // Agregar OnClickListener al botón btnadmin
            @Override
            public void onClick(View view) {
                // Redirige a ListadoUsuariosActivity al hacer clic en el botón de administrador
                Intent intent = new Intent(MainActivity.this, ListadoUsuariosActivity.class);
                startActivity(intent);
            }
        });
    }

    private void obtenerUbicacion() {

        Toast.makeText(this, "Obteniendo ubicación...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE_LOCATION_PERMISSION && grantResults.length > 0) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                obtenerUbicacion();
            } else {
                Toast.makeText(this, "Permiso de ubicación denegado", Toast.LENGTH_SHORT).show();
            }
        }
    }
}