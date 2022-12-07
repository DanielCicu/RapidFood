package com.burtton.rapidfoodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.burtton.rapidfoodapp.Model.Cliente;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class ActualizacionDatosCliente extends AppCompatActivity {

    EditText edtxNombreClienteAct, edtxNumeroTelefonoAct, edtxEmailClienteAct, edtxDireccionClienteAct, edtxContraseñaAct;
    Button btnActualizar;

    FirebaseFirestore firestore = FirebaseFirestore.getInstance();

    // int posicionCliente = getIntent().getExtras().getInt("posicionCliente");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizacion_datos_cliente);

        edtxNombreClienteAct = findViewById(R.id.edtxNombreClienteAct);
        edtxNumeroTelefonoAct = findViewById(R.id.edtxNumeroTelefonoAct);
        edtxEmailClienteAct = findViewById(R.id.edtxEmailClienteAct);
        edtxDireccionClienteAct = findViewById(R.id.edtxDireccionClienteAct);
        edtxContraseñaAct = findViewById(R.id.edtxContraseñaAct);

        btnActualizar = findViewById(R.id.btnActualizar);

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //actualizar();
                // actualizacionLista();
                Toast.makeText(ActualizacionDatosCliente.this, "Datos actualizados", Toast.LENGTH_SHORT).show();

                Intent interfazPerfilCliente = new Intent(getApplicationContext(), PerfilCliente.class);
                startActivity(interfazPerfilCliente);
            }
        });
    }

    /*
    public void actualizar() {

        Map<String, Object> persona = new HashMap<>();

        persona.put("nombre", edtxNombreClienteAct.getText().toString());
        persona.put("nombre", edtxNumeroTelefonoAct.getText().toString());
        persona.put("telefono", edtxEmailClienteAct.getText().toString());
        persona.put("email", edtxDireccionClienteAct.getText().toString());
        persona.put("email", edtxContraseñaAct.getText().toString());


        firestore.collection("usuarios").document(Cliente.clientes.get(posicionCliente).getDocumentoIdentidad()).update(persona);

    }


    public void actualizacionLista() {
        Cliente.clientes.get(posicionCliente).setNombreCompleto(edtxNombreClienteAct.getText().toString());
        Cliente.clientes.get(posicionCliente).setNumeroTelefonico(edtxNumeroTelefonoAct.getText().toString());
        Cliente.clientes.get(posicionCliente).setEmail(edtxEmailClienteAct.getText().toString());
        Cliente.clientes.get(posicionCliente).setDireccion(edtxDireccionClienteAct.getText().toString());
        Cliente.clientes.get(posicionCliente).setContraseña(edtxContraseñaAct.getText().toString());
    }

     */
}