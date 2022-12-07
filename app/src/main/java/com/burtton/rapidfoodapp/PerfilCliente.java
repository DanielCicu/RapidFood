package com.burtton.rapidfoodapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.burtton.rapidfoodapp.Model.Cliente;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class PerfilCliente extends AppCompatActivity {

    TextView txvDocumentoIdentidadCliente, txvNombreCliente, txvTelefonoCliente, txvEmailCliente, txvDireccionCliente;
    Button btnActualizarDatosCliente, btnEliminarCuentaCliente;

    FirebaseFirestore firestore = FirebaseFirestore.getInstance();
    FirebaseAuth auth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_cliente);

        txvDocumentoIdentidadCliente = findViewById(R.id.txvDocumentoIdentidadCliente);
        txvNombreCliente = findViewById(R.id.txvNombreCliente);
        txvTelefonoCliente = findViewById(R.id.txvTelefonoCliente);
        txvEmailCliente = findViewById(R.id.txvEmailCliente);
        txvDireccionCliente = findViewById(R.id.txvDireccionCliente);

        btnActualizarDatosCliente = findViewById(R.id.btnActualizarDatosCliente);
        btnEliminarCuentaCliente = findViewById(R.id.btnEliminarCuentaCliente);

        int posicionCliente = getIntent().getExtras().getInt("posicionCliente");

        txvDocumentoIdentidadCliente.setText(Cliente.clientes.get(posicionCliente).getDocumentoIdentidad() + "");
        txvNombreCliente.setText(Cliente.clientes.get(posicionCliente).getNombreCompleto() + "");
        txvTelefonoCliente.setText(Cliente.clientes.get(posicionCliente).getNumeroTelefonico() + "");
        txvEmailCliente.setText(Cliente.clientes.get(posicionCliente).getEmail() + "");
        txvDireccionCliente.setText(Cliente.clientes.get(posicionCliente).getDireccion() + "");

        btnActualizarDatosCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent interfazActualizacionDatos = new Intent(getApplicationContext(), ActualizacionDatosCliente.class);
                // interfazActualizacionDatos.putExtra("posicionCliente", posicionCliente);
                startActivity(interfazActualizacionDatos);
            }
        });

        btnEliminarCuentaCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                eliminar(Cliente.clientes.get(posicionCliente).getDocumentoIdentidad());
                Cliente.clientes.remove(posicionCliente);
                Toast.makeText(PerfilCliente.this, "Se eliminó la cuenta", Toast.LENGTH_SHORT).show();

                auth.signOut();

                Intent interfazInicio = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(interfazInicio);
                finish();
            }
        });
    }

    public void eliminar(String id) {

        firestore.collection("usuarios").document(id).delete();
    }
}