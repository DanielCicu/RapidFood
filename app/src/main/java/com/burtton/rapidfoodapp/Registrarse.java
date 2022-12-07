package com.burtton.rapidfoodapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.burtton.rapidfoodapp.Model.Cliente;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Registrarse extends AppCompatActivity {

    EditText edtxNumeroIdentidadRegistroCliente, edtxNombreCliente, edtxNumeroTelefonoCliente;
    EditText edtxEmailCliente, edtxDireccionCliente, edtxContrasenaRegistro;
    Button btnGuardarRegistro;

    FirebaseAuth auth = FirebaseAuth.getInstance();
    FirebaseFirestore firestore = FirebaseFirestore.getInstance();

    ArrayList<Cliente> datosCliente = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        edtxNumeroIdentidadRegistroCliente = findViewById(R.id.edtxNumeroIdentidadRegistroCliente);
        edtxNombreCliente = findViewById(R.id.edtxNombreCliente);
        edtxNumeroTelefonoCliente = findViewById(R.id.edtxNumeroTelefonoCliente);
        edtxEmailCliente = findViewById(R.id.edtxEmailCliente);
        edtxDireccionCliente = findViewById(R.id.edtxDireccionCliente);
        edtxContrasenaRegistro = findViewById(R.id.edtxContrasenaRegistro);

        btnGuardarRegistro = findViewById(R.id.btnGuardarRegistro);

        btnGuardarRegistro.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String documentoIdentidad = edtxNumeroIdentidadRegistroCliente.getText().toString();
                String nombreCompleto = edtxNombreCliente.getText().toString();
                String numeroTelefonico = edtxNumeroTelefonoCliente.getText().toString();
                String email = edtxEmailCliente.getText().toString();
                String direccion = edtxDireccionCliente.getText().toString();
                String contrasena = edtxContrasenaRegistro.getText().toString();

                Cliente cliente = new Cliente(documentoIdentidad, nombreCompleto, numeroTelefonico, email, direccion, contrasena);
                datosCliente.add(cliente);
                int posicion = datosCliente.indexOf(cliente);
                cliente.setClientes(datosCliente);

                registrar(documentoIdentidad, nombreCompleto, numeroTelefonico, email, direccion, contrasena, posicion);

                limpiarCampos();
            }
        });
    }

    public void registrar(String documentoIdentidad, String nombreCompleto, String numeroTelefonico, String email, String direccion, String contrasena, int posicion) {

        auth.createUserWithEmailAndPassword(email, contrasena).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

            @Override
            public void onComplete(@NonNull Task<AuthResult> task1) {
                if (task1.isSuccessful()) {
                    String id = auth.getCurrentUser().getUid();
                    Map<String, Object> datos = new HashMap<>();
                    datos.put("documentoIdentidad", documentoIdentidad);
                    datos.put("nombreCompleto", nombreCompleto);
                    datos.put("numeroTelefonico", numeroTelefonico);
                    datos.put("email", email);
                    datos.put("direccion", direccion);

                    firestore.collection("usuarios").document(documentoIdentidad).set(datos).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task2) {
                            if(task2.isSuccessful()) {
                                Toast.makeText(getApplicationContext(), "Cliente registrado", Toast.LENGTH_SHORT).show();

                                Intent interfazMenuPrincipal = new Intent(getApplicationContext(), MenuPrincipal.class);
                                interfazMenuPrincipal.putExtra("posicionCliente", posicion);
                                startActivity(interfazMenuPrincipal);

                            } else {

                                Toast.makeText(getApplicationContext(), "Problemas al registrar el usuario", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }

    public void limpiarCampos() {

        edtxNumeroIdentidadRegistroCliente.setText("");
        edtxNombreCliente.setText("");
        edtxNumeroTelefonoCliente.setText("");
        edtxEmailCliente.setText("");
        edtxDireccionCliente.setText("");
        edtxContrasenaRegistro.setText("");
    }
}