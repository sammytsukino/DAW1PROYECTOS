package model;

public class Socio {
    private int id;
    private String nombre;
    private String email;

    public Socio(int id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    public Socio(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }

    public void setId(int id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return id + ": " + nombre + " - " + email;
    }
}