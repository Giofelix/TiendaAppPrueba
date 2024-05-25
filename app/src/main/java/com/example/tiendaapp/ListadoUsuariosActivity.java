package com.example.tiendaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ListadoUsuariosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_usuarios);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.icon_add) {
            // Redirige a UsuarioRegistroActivity
            Intent intent = new Intent(this, UsuarioRegistroActivity.class);
            startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.icon_save) {
            Toast.makeText(this, "Guardar", Toast.LENGTH_LONG).show();
            return true;
        } else if (item.getItemId() == R.id.icon_delete) {
            Toast.makeText(this, "Eliminar", Toast.LENGTH_LONG).show();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

}
