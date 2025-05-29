package model;

public class Libro {
    private int id;
    private String titulo;
    private String genero;
    private int idAutor;

    public Libro(int id, String titulo, String genero, int idAutor) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.idAutor = idAutor;
    }

    public Libro(String titulo, String genero, int idAutor) {
        this.titulo = titulo;
        this.genero = genero;
        this.idAutor = idAutor;
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getGenero() { return genero; }
    public int getIdAutor() { return idAutor; }

    public void setId(int id) { this.id = id; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setGenero(String genero) { this.genero = genero; }
    public void setIdAutor(int idAutor) { this.idAutor = idAutor; }

    @Override
    public String toString() {
        return id + ": " + titulo + " (" + genero + ") - Autor ID: " + idAutor;
    }
}