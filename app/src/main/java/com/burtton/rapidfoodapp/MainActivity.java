package com.burtton.rapidfoodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnRegistrarse, btnIngresarPrincipal, btnUbicacionRestaurante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRegistrarse = findViewById(R.id.btnRegistrarse);
        btnIngresarPrincipal = findViewById(R.id.btnIngresarPrincipal);
        btnUbicacionRestaurante = findViewById(R.id.btnUbicacionRestaurante);

        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent interfazRegistrarse = new Intent(getApplicationContext(), Registrarse.class);
                startActivity(interfazRegistrarse);
            }
        });

        btnIngresarPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent interfazIngresar = new Intent(getApplicationContext(), Ingresar.class);
                startActivity(interfazIngresar);
            }
        });


        btnUbicacionRestaurante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent interfazUbicacion = new Intent(getApplicationContext(), UbicacionRestaurante.class);
                startActivity(interfazUbicacion);
            }
        });
    }
}