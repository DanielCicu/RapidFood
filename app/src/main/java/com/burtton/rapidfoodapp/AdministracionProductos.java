package com.burtton.rapidfoodapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.burtton.rapidfoodapp.Model.Producto;

import java.util.ArrayList;

public class AdministracionProductos extends AppCompatActivity {

    RecyclerView rcvAdminProductos;
    ArrayList<Producto> productos = new ArrayList<>();
    Button btnGuardarAdminProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administracion_productos);

        rcvAdminProductos = findViewById(R.id.rcvAdminProductos);

        btnGuardarAdminProductos = findViewById(R.id.btnGuardarAdminProductos);

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
        rcvAdminProductos.setLayoutManager(llm);

        rcvAdminProductos.setAdapter(new AdaptadorProducto());

        btnGuardarAdminProductos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Cambios guardados", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private class AdaptadorProducto extends RecyclerView.Adapter<AdaptadorProducto.AdaptadorProductosHolder> {

        @NonNull
        @Override
        public AdaptadorProducto.AdaptadorProductosHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new AdaptadorProductosHolder(getLayoutInflater().inflate(R.layout.diseno_vista_productos, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull AdaptadorProducto.AdaptadorProductosHolder holder, int position) {
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