package com.example.tiendaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ListadoUsuariosActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_usuarios);

        ImageView adduser = findViewById(R.id.icon_add);
        ImageView updateuser = findViewById(R.id.icon_save);
        ImageView deleteuser = findViewById(R.id.icon_delete);

        adduser.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ListadoUsuariosActivity.this, UsuarioRegistroActivity.class);
                startActivity(intent);

            }

        });

        updateuser.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Toast.makeText(ListadoUsuariosActivity.this, "Actualizando registro", Toast.LENGTH_SHORT).show();

            }

        });

        deleteuser.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Toast.makeText(ListadoUsuariosActivity.this, "Usuario Eliminado", Toast.LENGTH_SHORT).show();

            }

        });
    }



}
