package com.burtton.rapidfoodapp.Model;

import java.util.Objects;

public class Producto {

    private String nombre;
    private Double precio;
    private Integer cantidad;
    private int imagen;

    public Producto() {
    }

    public Producto(String nombre, Double precio, int imagen) {
        this.nombre = nombre;
        this.precio = precio;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return imagen == producto.imagen && Objects.equals(nombre, producto.nombre) && Objects.equals(precio, producto.precio) && Objects.equals(cantidad, producto.cantidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, precio, cantidad, imagen);
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                ", imagen=" + imagen +
                '}';
    }
}
