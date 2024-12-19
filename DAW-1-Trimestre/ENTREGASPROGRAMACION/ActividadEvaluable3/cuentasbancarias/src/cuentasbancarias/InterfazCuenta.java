package cuentasbancarias;

/**
 * Interfaz que define el contrato para cuentas bancarias.
 * Especifica los métodos que deben implementar todas las cuentas.
 */
public interface InterfazCuenta {
    /**
     * Consigna una cantidad de dinero en la cuenta.
     * 
     */
    void consignar(float cantidad);

    /**
     * Retira una cantidad de dinero de la cuenta.
     * 
     */
    boolean retirar(float cantidad);

    /**
     * Calcula el interés mensual de la cuenta.
     */
    void calcularInterés();

    /**
     * Genera el extracto mensual de la cuenta.
     */
    void extractoMensual();

    /**
     * Imprime la información de la cuenta.
     */
    void imprimir();

    /**
     * Método estático para comparar dos cuentas y devolver la de mayor saldo.

     */
    static InterfazCuenta cuentaMayor(InterfazCuenta cuenta1, InterfazCuenta cuenta2) {
        // Asumimos que las cuentas tienen un método para obtener saldo
        return cuenta1.getSaldo() > cuenta2.getSaldo() ? cuenta1 : cuenta2;
    }

    /**
     * Obtiene el saldo actual de la cuenta.
     */
    float getSaldo();
}