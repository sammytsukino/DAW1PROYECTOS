package cuentasbancarias;

/**
 * Representa una cuenta de ahorros con características específicas.
 */
public class CuentaAhorros extends Cuenta {
    private boolean cuentaActiva;

    /**
     * Constructor de CuentaAhorros.
     * 
     */
    public CuentaAhorros(float saldoInicial, float tasaAnual) {
        super(saldoInicial, tasaAnual);
        this.cuentaActiva = saldoInicial >= 10000;
    }

    /**
     * Sobrescribe el método consignar para verificar estado de la cuenta.
     */
    @Override
    public void consignar(float cantidad) {
        if (cuentaActiva) {
            super.consignar(cantidad);
            cuentaActiva = saldo >= 10000;
        }
    }

    /**
     * Sobrescribe el método retirar para verificar estado de la cuenta.
     */
    @Override
    public boolean retirar(float cantidad) {
        if (cuentaActiva) {
            boolean retiroExitoso = super.retirar(cantidad);
            cuentaActiva = saldo >= 10000;
            return retiroExitoso;
        }
        return false;
    }

    /**
     * Sobrescribe el extracto mensual para aplicar comisión adicional.
     */
    @Override
    public void extractoMensual() {
        if (numRetiros > 4) {
            comisionMensual += (numRetiros - 4) * 1000;
        }
        super.extractoMensual();
        cuentaActiva = saldo >= 10000;
    }

    /**
     * Sobrescribe el método imprimir para mostrar información específica.
     */
    @Override
    public void imprimir() {
        System.out.println("Saldo: " + saldo);
        System.out.println("Comisión mensual: " + comisionMensual);
        System.out.println("Total transacciones: " + (numConsignaciones + numRetiros));
        System.out.println("Estado de cuenta: " + (cuentaActiva ? "Activa" : "Inactiva"));
    }
}