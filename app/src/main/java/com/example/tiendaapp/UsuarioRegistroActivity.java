package com.example.tiendaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class UsuarioRegistroActivity extends AppCompatActivity {

    EditText nombreusuario, telefonousuario, direccionusuario, ciudadusuario, correousuario, contraseña, confirmarcontraseña;
    CheckBox checkterminos;
    Button btnRegistrar, btnatras;

    private DatabaseReference mDatabase;
    private String fromActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nombreusuario = findViewById(R.id.nombreusuario);
        telefonousuario = findViewById(R.id.telefonousuario);
        direccionusuario = findViewById(R.id.direccionusuario);
        ciudadusuario = findViewById(R.id.ciudadusuario);
        correousuario = findViewById(R.id.correousuario);
        contraseña = findViewById(R.id.contraseña);
        confirmarcontraseña = findViewById(R.id.confirmarcontraseña);
        checkterminos = findViewById(R.id.checkterminos);
        btnRegistrar = findViewById(R.id.btnregistrar);
        btnatras = findViewById(R.id.btnatras);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        // Obtener el valor del parámetro extra "fromActivity"
        fromActivity = getIntent().getStringExtra("fromActivity");

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarUsuario();
            }
        });

        btnatras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Redirigir según la actividad de origen
                if ("ListadoUsuariosActivity".equals(fromActivity)) {
                    // Redirigir a ListadoUsuariosActivity
                    Intent intent = new Intent(UsuarioRegistroActivity.this, ListadoUsuariosActivity.class);
                    startActivity(intent);
                } else {
                    // Redirigir a MainActivity
                    Intent intent = new Intent(UsuarioRegistroActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                finish(); // Opcional: Cierra la actividad actual para que no esté en el historial de retroceso
            }
        });
    }

    private void registrarUsuario() {
        String uid = UUID.randomUUID().toString();
        String nombre = nombreusuario.getText().toString().trim();
        String telefono = telefonousuario.getText().toString().trim();
        String direccion = direccionusuario.getText().toString().trim();
        String ciudad = ciudadusuario.getText().toString().trim();
        String correo = correousuario.getText().toString().trim();
        String contrasena = contraseña.getText().toString().trim();
        String confirmarcontrasena = confirmarcontraseña.getText().toString().trim();
        boolean terminoscondiciones = checkterminos.isChecked();

        if (nombre.isEmpty() || telefono.isEmpty() || direccion.isEmpty() || ciudad.isEmpty() ||
                correo.isEmpty() || contrasena.isEmpty() || confirmarcontrasena.isEmpty()) {
            Toast.makeText(UsuarioRegistroActivity.this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!contrasena.equals(confirmarcontrasena)) {
            Toast.makeText(UsuarioRegistroActivity.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!terminoscondiciones) {
            Toast.makeText(UsuarioRegistroActivity.this, "Debe aceptar los términos y condiciones", Toast.LENGTH_SHORT).show();
            return;
        }

        // Crear objeto usuario
        usuario usuario = new usuario(uid, nombre, telefono, direccion, ciudad, correo, contrasena, confirmarcontrasena, terminoscondiciones);

        // Guardar usuario en la base de datos
        mDatabase.child("Usuario").child(uid).setValue(usuario);

        Toast.makeText(UsuarioRegistroActivity.this, "Usuario registrado correctamente", Toast.LENGTH_SHORT).show();

        // Redirigir según la actividad de origen
        if ("ListadoUsuariosActivity".equals(fromActivity)) {
            // Redirigir a ListadoUsuariosActivity
            Intent intent = new Intent(UsuarioRegistroActivity.this, ListadoUsuariosActivity.class);
            startActivity(intent);
        } else {
            // Redirigir a MainActivity
            Intent intent = new Intent(UsuarioRegistroActivity.this, MainActivity.class);
            startActivity(intent);
        }
        finish(); // Opcional: Cierra la actividad actual para que no esté en el historial de retroceso
    }
}
