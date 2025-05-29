package model;

import java.sql.Date;

public class Prestamo {
    private int id;
    private int idLibro;
    private int idSocio;
    private Date fechaPrestamo;
    private Date fechaDevolucion;

    public Prestamo(int id, int idLibro, int idSocio, Date fechaPrestamo, Date fechaDevolucion) {
        this.id = id;
        this.idLibro = idLibro;
        this.idSocio = idSocio;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public Prestamo(int idLibro, int idSocio, Date fechaPrestamo, Date fechaDevolucion) {
        this.idLibro = idLibro;
        this.idSocio = idSocio;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public int getId() { return id; }
    public int getIdLibro() { return idLibro; }
    public int getIdSocio() { return idSocio; }
    public Date getFechaPrestamo() { return fechaPrestamo; }
    public Date getFechaDevolucion() { return fechaDevolucion; }

    public void setId(int id) { this.id = id; }
    public void setIdLibro(int idLibro) { this.idLibro = idLibro; }
    public void setIdSocio(int idSocio) { this.idSocio = idSocio; }
    public void setFechaPrestamo(Date fechaPrestamo) { this.fechaPrestamo = fechaPrestamo; }
    public void setFechaDevolucion(Date fechaDevolucion) { this.fechaDevolucion = fechaDevolucion; }

    @Override
    public String toString() {
        return id + ": Libro ID " + idLibro + ", Socio ID " + idSocio + " (" + fechaPrestamo + " a " + fechaDevolucion + ")";
    }
}