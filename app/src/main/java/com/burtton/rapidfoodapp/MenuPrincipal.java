package com.burtton.rapidfoodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MenuPrincipal extends AppCompatActivity {

    Button btnComprarProductos, btnPerfilCliente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        btnComprarProductos = findViewById(R.id.btnComprarProductos);
        btnPerfilCliente = findViewById(R.id.btnPerfilCliente);

        int posicionCliente = getIntent().getExtras().getInt("posicionCliente");

        btnComprarProductos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent interfazCompraProductos = new Intent(getApplicationContext(), CompraProductos.class);
                startActivity(interfazCompraProductos);
            }
        });

        btnPerfilCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent interfazPerfilCliente = new Intent(getApplicationContext(), PerfilCliente.class);
                interfazPerfilCliente.putExtra("posicionCliente", posicionCliente);
                startActivity(interfazPerfilCliente);
            }
        });
    }
}
