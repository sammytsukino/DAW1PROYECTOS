package cuentasbancarias;

/**
 * Implementación de cuenta de ahorros que sigue el contrato de la interface InterfazCuenta.
 */
public class CuentaAhorrosInterfaz implements InterfazCuenta {
    // Atributos
    private float saldo;
    private int numConsignaciones;
    private int numRetiros;
    private float tasaAnual;
    private float comisionMensual;
    private boolean cuentaActiva;

    /**
     * Constructor de CuentaAhorrosInterfaz.
     * 
     */
    public CuentaAhorrosInterfaz(float saldoInicial, float tasaAnual) {
        this.saldo = saldoInicial;
        this.tasaAnual = tasaAnual;
        this.numConsignaciones = 0;
        this.numRetiros = 0;
        this.comisionMensual = 0;
        this.cuentaActiva = saldoInicial >= 10000;
    }

    @Override
    public void consignar(float cantidad) {
        if (cuentaActiva) {
            saldo += cantidad;
            numConsignaciones++;
            cuentaActiva = saldo >= 10000;
        }
    }

    @Override
    public boolean retirar(float cantidad) {
        if (cuentaActiva && cantidad <= saldo) {
            saldo -= cantidad;
            numRetiros++;
            cuentaActiva = saldo >= 10000;
            return true;
        }
        return false;
    }

    @Override
    public void calcularInterés() {
        float tasaMensual = tasaAnual / 12;
        float interesMensual = saldo * tasaMensual;
        saldo += interesMensual;
    }

    @Override
    public void extractoMensual() {
        if (numRetiros > 4) {
            comisionMensual += (numRetiros - 4) * 1000;
        }
        saldo -= comisionMensual;
        calcularInterés();
        cuentaActiva = saldo >= 10000;
    }

    @Override
    public void imprimir() {
        System.out.println("Saldo: " + saldo);
        System.out.println("Comisión mensual: " + comisionMensual);
        System.out.println("Total transacciones: " + (numConsignaciones + numRetiros));
        System.out.println("Estado de cuenta: " + (cuentaActiva ? "Activa" : "Inactiva"));
    }

    @Override
    public float getSaldo() {
        return saldo;
    }
}