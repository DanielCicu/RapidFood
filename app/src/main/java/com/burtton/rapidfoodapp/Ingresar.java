package com.burtton.rapidfoodapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Ingresar extends AppCompatActivity {

    EditText edtxEmailIngreso, edtxContraseñaIngreso;
    Button btnIngresoApp;

    private static final String DOCUMENTO_ADMIN = "admin@gmail.com";
    private static final String CONTRASENA_ADMIN = "asd1234-Admin";

    FirebaseAuth auth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar);

        edtxEmailIngreso = findViewById(R.id.edtxEmailIngreso);
        edtxContraseñaIngreso = findViewById(R.id.edtxContraseñaIngreso);
        btnIngresoApp = findViewById(R.id.btnIngresoApp);

        btnIngresoApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String usuario = edtxEmailIngreso.getText().toString();
                String contrasena = edtxContraseñaIngreso.getText().toString();

                if (edtxEmailIngreso.getText().toString().equals(DOCUMENTO_ADMIN) && edtxContraseñaIngreso.getText().toString().equals(CONTRASENA_ADMIN)) {

                    ingresarAdministrador(usuario, contrasena);

                } else {

                    ingresarClientes(usuario, contrasena);

                }

                limpiarCampos();
            }
        });
    }

    public void ingresarClientes(String usuario, String contrasena){

        auth.signInWithEmailAndPassword(usuario,contrasena).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){
                    Intent interfazMenuPrincipal = new Intent(getApplicationContext(), MenuPrincipal.class);
                    startActivity(interfazMenuPrincipal);

                } else{

                    Toast.makeText(Ingresar.this, "Datos incorrectos", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void ingresarAdministrador(String usuario, String contrasena){

        auth.signInWithEmailAndPassword(usuario,contrasena).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){
                    Intent interfazAdmintracionProductos = new Intent(getApplicationContext(), AdministracionProductos.class);
                    startActivity(interfazAdmintracionProductos);

                } else{

                    Toast.makeText(Ingresar.this, "Datos incorrectos", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void limpiarCampos() {
        edtxEmailIngreso.setText("");
        edtxContraseñaIngreso.setText("");
    }
}