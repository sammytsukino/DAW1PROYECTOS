package cuentasbancarias;

/**
 * Clase de prueba para demostrar el funcionamiento de CuentaAhorrosInterfaz.
 */
public class PruebaAhorroInterfaz {
    public static void main(String[] args) {
        // Crear una cuenta de ahorros con saldo inicial de 15000 y tasa anual del 5%
        InterfazCuenta miCuenta = new CuentaAhorrosInterfaz(15000, 0.05f);

        System.out.println("--- Estado Inicial ---");
        miCuenta.imprimir();

        // Realizar algunas consignaciones y retiros
        miCuenta.consignar(5000);
        miCuenta.retirar(2000);
        miCuenta.retirar(2000);
        miCuenta.retirar(2000);
        miCuenta.retirar(2000);
        miCuenta.retirar(2000);  // Quinto retiro

        System.out.println("\n--- Después de Transacciones ---");
        miCuenta.imprimir();

        // Generar extracto mensual
        miCuenta.extractoMensual();

        System.out.println("\n--- Después de Extracto Mensual ---");
        miCuenta.imprimir();
    }
}