package com.burtton.rapidfoodapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.burtton.rapidfoodapp.Model.Producto;

import java.util.ArrayList;

public class CompraProductos extends AppCompatActivity {

    RecyclerView rcvCompraProductos;
    ArrayList<Producto> productos = new ArrayList<>();
    Button btnConfirmarCompra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compra_productos);

        rcvCompraProductos = findViewById(R.id.rcvCompraProductos);

        btnConfirmarCompra = findViewById(R.id.btnConfirmarCompra);

        Producto p1 = new Producto("Ajiaco", 50000d, R.drawable.ajiaco);
        Producto p2 = new Producto("Carne de cerdo", 20000d, R.drawable.carne_cerdo);
        Producto p3 = new Producto("Hamburguesa", 70000d, R.drawable.hamburguesa);
        Producto p4 = new Producto("Lasagna", 10000d, R.drawable.lasagna);
        Producto p5 = new Producto("Posole", 15000d, R.drawable.posole);
        Producto p6 = new Producto("Frutas", 25000d, R.drawable.frutas);
        Producto p7 = new Producto("Postre de chocolates", 20000d, R.drawable.postre_chocolates);
        Producto p8 = new Producto("Postre de limón", 15000d, R.drawable.postre_limon);

        productos.add(p1);
        productos.add(p2);
        productos.add(p3);
        productos.add(p4);
        productos.add(p5);
        productos.add(p6);
        productos.add(p7);
        productos.add(p8);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rcvCompraProductos.setLayoutManager(llm);

        rcvCompraProductos.setAdapter(new CompraProductos.AdaptadorProductoCompra());

        btnConfirmarCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent interfazFactura = new Intent(getApplicationContext(), Factura.class);
                startActivity(interfazFactura);
            }
        });

    }

    private class AdaptadorProductoCompra extends RecyclerView.Adapter<CompraProductos.AdaptadorProductoCompra.AdaptadorProductosHolder> {

        @NonNull
        @Override
        public CompraProductos.AdaptadorProductoCompra.AdaptadorProductosHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new CompraProductos.AdaptadorProductoCompra.AdaptadorProductosHolder(getLayoutInflater().inflate(R.layout.diseno_vista_productos, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull CompraProductos.AdaptadorProductoCompra.AdaptadorProductosHolder holder, int position) {
            holder.imprimir(position);
        }

        @Override
        public int getItemCount() {
            return productos.size();
        }

        public class AdaptadorProductosHolder extends RecyclerView.ViewHolder {

            TextView txvNombreProducto,txvPrecioProducto;
            ImageView imgvImagenProducto;

            public AdaptadorProductosHolder(@NonNull View itemView) {
                super(itemView);

                txvNombreProducto = itemView.findViewById(R.id.txvNombreProducto);
                txvPrecioProducto = itemView.findViewById(R.id.txvPrecioProducto);
                imgvImagenProducto = itemView.findViewById(R.id.imgvImagenProducto);

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getApplicationContext(), "Esta presionando " + txvNombreProducto.getText(), Toast.LENGTH_SHORT).show();
                    }
                });
            }

            public void imprimir(int posicion) {
                imgvImagenProducto.setImageResource(productos.get(posicion).getImagen());
                txvNombreProducto.setText(productos.get(posicion).getNombre());
                txvPrecioProducto.setText(productos.get(posicion).getPrecio()+"");
            }
        }
    }
}