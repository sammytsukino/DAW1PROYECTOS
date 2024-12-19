package cuentasbancarias;

/**
 * Clase de prueba para demostrar el funcionamiento de CuentaCorriente.
 */
public class PruebaCorriente {
    public static void main(String[] args) {
        // Crear una cuenta corriente con saldo inicial de 10000 y tasa anual del 6%
        CuentaCorriente miCuenta = new CuentaCorriente(10000, 0.06f);

        System.out.println("--- Estado Inicial ---");
        miCuenta.imprimir();

        // Realizar algunas consignaciones y retiros
        miCuenta.consignar(5000);
        miCuenta.retirar(12000);  // Probando sobregiro

        System.out.println("\n--- Después de Transacciones ---");
        miCuenta.imprimir();

        // Generar extracto mensual
        miCuenta.extractoMensual();

        System.out.println("\n--- Después de Extracto Mensual ---");
        miCuenta.imprimir();
    }
}