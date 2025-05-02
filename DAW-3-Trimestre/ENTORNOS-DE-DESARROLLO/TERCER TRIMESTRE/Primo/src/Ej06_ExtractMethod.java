public class Ej06_ExtractMethod {
    /**
     * Determina si un número es primo
     * @param numero El número a verificar
     * @return true si el número es primo, false en caso contrario
     */
    public boolean esPrimo(int numero) {
        // Casos especiales
        if (esNumeroPequeno(numero)) {
            return numero == 2 || numero == 3;
        }
        
        // Los números pares mayores que 2 no son primos
        if (esPar(numero)) {
            return false;
        }
        
        return !tieneDivisoresImpares(numero);
    }
    
    /**
     * Verifica si un número es muy pequeño (0, 1 o negativo)
     * @param numero El número a verificar
     * @return true si el número es 0, 1 o negativo
     */
    private boolean esNumeroPequeno(int numero) {
        return numero <= 3;
    }
    
    /**
     * Verifica si un número tiene divisores impares hasta su raíz cuadrada
     * @param numero El número a verificar
     * @return true si tiene al menos un divisor impar
     */
    private boolean tieneDivisoresImpares(int numero) {
        // Comprobar solo divisores impares empezando desde 3
        int divisor = 3;
        int limite = (int) Math.sqrt(numero);
        
        while (divisor <= limite) {
            if (esDivisible(numero, divisor)) {
                return true;
            }
            // Saltar al siguiente número impar
            divisor += 2;
        }
        
        return false;
    }
    
    /**
     * Verifica si un número es divisible por otro
     * @param numero El dividendo
     * @param divisor El divisor
     * @return true si el número es divisible por el divisor
     */
    public boolean esDivisible(int numero, int divisor) {
        return (numero % divisor == 0);
    }
    
    /**
     * Verifica si un número es par
     * @param numero El número a verificar
     * @return true si el número es par
     */
    public boolean esPar(int numero) {
        return (numero % 2 == 0);
    }
}