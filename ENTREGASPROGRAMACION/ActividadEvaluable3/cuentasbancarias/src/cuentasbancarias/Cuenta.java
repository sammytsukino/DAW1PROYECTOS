package cuentasbancarias;

/**
 * Representa una cuenta bancaria genérica con operaciones básicas.
 * Contiene atributos y métodos comunes para diferentes tipos de cuentas.
 */
public class Cuenta {
    // Atributos protegidos
    protected float saldo;
    protected int numConsignaciones;
    protected int numRetiros;
    protected float tasaAnual;
    protected float comisionMensual;

    /**
     * Constructor de la cuenta bancaria.
     */
    public Cuenta(float saldoInicial, float tasaAnual) {
        this.saldo = saldoInicial;
        this.tasaAnual = tasaAnual;
        this.numConsignaciones = 0;
        this.numRetiros = 0;
        this.comisionMensual = 0;
    }

    /**
     * Método para consignar dinero en la cuenta.
     */
    public void consignar(float cantidad) {
        saldo += cantidad;
        numConsignaciones++;
    }

    /**
     * Método para retirar dinero de la cuenta.
     * 
     */
    public boolean retirar(float cantidad) {
        if (cantidad <= saldo) {
            saldo -= cantidad;
            numRetiros++;
            return true;
        }
        return false;
    }

    /**
     * Calcula y añade el interés mensual al saldo.
     */
    public void calcularInterés() {
        float tasaMensual = tasaAnual / 12;
        float interesMensual = saldo * tasaMensual;
        saldo += interesMensual;
    }

    /**
     * Genera el extracto mensual de la cuenta.
     */
    public void extractoMensual() {
        saldo -= comisionMensual;
        calcularInterés();
    }

    /**
     * Imprime la información de la cuenta.
     */
    public void imprimir() {
        System.out.println("Saldo: " + saldo);
        System.out.println("Número de consignaciones: " + numConsignaciones);
        System.out.println("Número de retiros: " + numRetiros);
    }

    public static Cuenta cuentaMayor(Cuenta cuenta1, Cuenta cuenta2) {
        return cuenta1.saldo > cuenta2.saldo ? cuenta1 : cuenta2;
    }
}