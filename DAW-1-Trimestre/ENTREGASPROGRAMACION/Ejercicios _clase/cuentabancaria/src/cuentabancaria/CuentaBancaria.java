package cuentabancaria;

public class CuentaBancaria {
    public enum TipoCuenta {AHORROS, CORRIENTE}
    private String nombre;
    private String apellidos;
    private String numeroCuenta;
    private double saldo=0;
    private TipoCuenta tipoCuenta;
    
    public CuentaBancaria(String nombre, String apellidos, String numeroCuenta, double saldo, TipoCuenta tipoCuenta) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.numeroCuenta = numeroCuenta;
        this.saldo = 0;
        this.tipoCuenta = tipoCuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void consultarSaldo() {
        System.out.println("Saldo de la cuenta " + numeroCuenta + " es de " + saldo + "€");
    }
    
    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }
    
    public void ingresar(double cantidadIngreso) { 
        saldo += cantidadIngreso;
        System.out.println("Se ha ingresado " + cantidadIngreso + " al saldo de la cuenta de " + nombre + " con número de cuenta: " + numeroCuenta);
        if (cantidadIngreso < 0) {
            System.out.println("La cantidad ingresada es negativa");
        }
    }

    public void retirar(double cantidadRetiro) {
        if (cantidadRetiro > saldo) {
            System.out.println("No se puede retirar más que el saldo de la cuenta");
        }else if (cantidadRetiro < 0) {
            System.out.println("La cantidad a retirar es negativa");
        } else {
            saldo -= cantidadRetiro;
            System.out.println("Se ha retirado " + cantidadRetiro + " al saldo de la cuenta de " + nombre + " con número de cuenta: " + numeroCuenta);
        }
    }

    public static void main(String[] args) {
        CuentaBancaria cuenta1 = new CuentaBancaria("Miguel Ángel", "Conde Díaz", "11111111111111111111", 1000, TipoCuenta.AHORROS);

        cuenta1.consultarSaldo();
        cuenta1.ingresar(500);
        cuenta1.consultarSaldo();
        cuenta1.retirar(500);
        cuenta1.consultarSaldo();

    }
}
