package cuentasbancarias;

/**
 * Implementación de cuenta corriente que sigue el contrato de la interface InterfazCuenta.
 */
public class CuentaCorrienteInterfaz implements InterfazCuenta {
    // Atributos
    private float saldo;
    private int numConsignaciones;
    private int numRetiros;
    private float tasaAnual;
    private float comisionMensual;
    private float sobregiro;

    /**
     * Constructor de CuentaCorrienteInterfaz.
     */
    public CuentaCorrienteInterfaz(float saldoInicial, float tasaAnual) {
        this.saldo = saldoInicial;
        this.tasaAnual = tasaAnual;
        this.numConsignaciones = 0;
        this.numRetiros = 0;
        this.comisionMensual = 0;
        this.sobregiro = 0;
    }

    @Override
    public void consignar(float cantidad) {
        saldo += cantidad;
        numConsignaciones++;
        System.out.println("Saldo actual: " + saldo);
    }

    @Override
    public boolean retirar(float cantidad) {
        if (cantidad <= saldo) {
            saldo -= cantidad;
            numRetiros++;
            return true;
        } else {
            sobregiro += cantidad - saldo;
            saldo = 0;
            numRetiros++;
            return true;
        }
    }

    @Override
    public void calcularInterés() {
        float tasaMensual = tasaAnual / 12;
        float interesMensual = saldo * tasaMensual;
        saldo += interesMensual;
    }

    @Override
    public void extractoMensual() {
        saldo -= comisionMensual;
        calcularInterés();
        System.out.println("Saldo actual: " + saldo);
    }

    @Override
    public void imprimir() {
        System.out.println("Saldo: " + saldo);
        System.out.println("Comisión mensual: " + comisionMensual);
        System.out.println("Total transacciones: " + (numConsignaciones + numRetiros));
        System.out.println("Sobregiro: " + sobregiro);
    }

    @Override
    public float getSaldo() {
        return saldo;
    }
}