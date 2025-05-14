package main.java;

public class Telefono {
    private String tipo;
    private String numero;

    public Telefono(String tipo, String numero) {
        this.tipo = tipo;
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return tipo + ": " + numero;
    }
}
