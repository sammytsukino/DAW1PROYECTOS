package main.java;

import java.util.List;

public class Cliente {
    private int idCliente;
    private String nombre;
    private List<Telefono> telefonos;

    public Cliente(int idCliente, String nombre, List<Telefono> telefonos) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.telefonos = telefonos;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Telefono> getTelefonos() {
        return telefonos;
    }

    @Override
    public String toString() {
        return "Cliente: " + nombre + " (" + idCliente + ")\nTeléfonos: " + telefonos;
    }
}
