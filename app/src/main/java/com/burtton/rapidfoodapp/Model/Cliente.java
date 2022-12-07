package com.burtton.rapidfoodapp.Model;

import java.util.ArrayList;
import java.util.Objects;

public class Cliente {
    private String documentoIdentidad;
    private String nombreCompleto;
    private String numeroTelefonico;
    private String email;
    private String direccion;
    private String contraseña;
    public static ArrayList<Cliente> clientes;

    public Cliente() {
    }

    public Cliente(String documentoIdentidad, String nombreCompleto, String numeroTelefonico, String email, String direccion, String contraseña) {
        this.documentoIdentidad = documentoIdentidad;
        this.nombreCompleto = nombreCompleto;
        this.numeroTelefonico = numeroTelefonico;
        this.email = email;
        this.direccion = direccion;
        this.contraseña = contraseña;
        this.clientes = clientes;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(documentoIdentidad, cliente.documentoIdentidad) && Objects.equals(nombreCompleto, cliente.nombreCompleto) && Objects.equals(numeroTelefonico, cliente.numeroTelefonico) && Objects.equals(email, cliente.email) && Objects.equals(direccion, cliente.direccion) && Objects.equals(contraseña, cliente.contraseña) && Objects.equals(clientes, cliente.clientes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(documentoIdentidad, nombreCompleto, numeroTelefonico, email, direccion, contraseña, clientes);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "documentoIdentidad='" + documentoIdentidad + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", numeroTelefonico='" + numeroTelefonico + '\'' +
                ", email='" + email + '\'' +
                ", direccion='" + direccion + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", clientes=" + clientes +
                '}';
    }
}
