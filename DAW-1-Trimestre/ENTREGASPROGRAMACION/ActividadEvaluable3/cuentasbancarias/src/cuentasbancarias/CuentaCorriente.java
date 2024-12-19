package cuentasbancarias;

/**
 * Representa una cuenta corriente con características específicas.
 */
public class CuentaCorriente extends Cuenta {
    private float sobregiro;

    /**
     * Constructor de CuentaCorriente.
     * 
     */
    public CuentaCorriente(float saldoInicial, float tasaAnual) {
        super(saldoInicial, tasaAnual);
        this.sobregiro = 0;
    }

    /**
     * Sobrescribe el método retirar para permitir sobregiro.
     */
    @Override
    public boolean retirar(float cantidad) {
        if (cantidad <= saldo) {
            return super.retirar(cantidad);
        } else {
            sobregiro += cantidad - saldo;
            saldo = 0;
            numRetiros++;
            return true;
        }
    }

    /**
     * Sobrescribe el método consignar para mostrar saldo.
     */
    @Override
    public void consignar(float cantidad) {
        super.consignar(cantidad);
        System.out.println("Saldo actual: " + saldo);
    }

    /**
     * Sobrescribe el método extracto mensual.
     */
    @Override
    public void extractoMensual() {
        super.extractoMensual();
        System.out.println("Saldo actual: " + saldo);
    }

    /**
     * Sobrescribe el método imprimir para mostrar información específica.
     */
    @Override
    public void imprimir() {
        System.out.println("Saldo: " + saldo);
        System.out.println("Comisión mensual: " + comisionMensual);
        System.out.println("Total transacciones: " + (numConsignaciones + numRetiros));
        System.out.println("Sobregiro: " + sobregiro);
    }
}