package com.burtton.rapidfoodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.burtton.rapidfoodapp.Model.Cliente;
import com.burtton.rapidfoodapp.Model.Producto;

import java.util.ArrayList;

public class Factura extends AppCompatActivity {

    TextView txvNumeroFactura, txvTiempoEspera, txvTotalAPagar;
    ListView lsvProductosComprados;

    ArrayList<Producto> facturaProductos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factura);

        lsvProductosComprados = findViewById(R.id.lsvProductosComprados);
        txvNumeroFactura = findViewById(R.id.txvNumeroFactura);
        txvTiempoEspera = findViewById(R.id.txvTiempoEspera);
        txvTotalAPagar = findViewById(R.id.txvTotalAPagar);

        String nombreP1 = "Ajiaco";
        Double precioP1 = 50000d;
        int numeroImagenP1 = 1;

        String nombreP2 = "Carne de cerdo";
        Double precioP2 = 20000d;
        int numeroImagenP2 = 2;

        String nombreP3 = "Frutas";
        Double precioP3 = 25000d;
        int numeroImagenP3 = 6;

        String nombreP4 = "Postre limon";
        Double precioP4 = 15000d;
        int numeroImagenP4 = 8;

        Producto producto1 = new Producto(nombreP1, precioP1, numeroImagenP1);
        producto1.setCantidad(3);
        Producto producto2 = new Producto(nombreP2, precioP2, numeroImagenP2);
        producto2.setCantidad(5);
        Producto producto3 = new Producto(nombreP3, precioP3, numeroImagenP3);
        producto3.setCantidad(2);
        Producto producto4 = new Producto(nombreP4, precioP4, numeroImagenP4);
        producto4.setCantidad(1);

        Double totalAPagar = 50000d * 3 + 20000d * 5 + 25000d * 2 + 15000d *1;

        facturaProductos.add(producto1);
        facturaProductos.add(producto2);
        facturaProductos.add(producto3);
        facturaProductos.add(producto4);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, facturaProductos);
        lsvProductosComprados.setAdapter(adapter);

        txvNumeroFactura.setText("0001");
        txvTiempoEspera.setText("30:00 min");

        String total = new Double(totalAPagar).toString();
        txvTotalAPagar.setText(total);
    }
}