package conectores;
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException;
public class SHA256Hashing {
	public  static String generateSHA256Hash (String input) { 
        try { 
            // Crear una instancia de MessageDigest para SHA-256 
            MessageDigest  digest  = MessageDigest.getInstance( "SHA-256" ); 

            // Realizar el cálculo del hash 
            byte [] encodedhash = digest.digest(input.getBytes()); 

            // Convertir la matriz de bytes en una cadena hexadecimal 
            StringBuilder  hexString  =  new  StringBuilder (); 
            for ( byte b : encodedhash) { 
                String  hex  = Integer.toHexString( 0xff & b); 
                if (hex.length() == 1 ) { 
                    hexString.append( '0' ); 
                } 
                hexString.append(hex); 
            } 
            return hexString.toString(); 
        } catch (NoSuchAlgorithmException e) { 
            throw  new  RuntimeException (e); 
        } 
    } 

    public  static  void  main (String[] args) { 
        String  entrada  =  "Hola, ¡SHA-256!" ; 
        String  hash  = generateSHA256Hash(entrada); 
        System.out.println( "Entrada: " + entrada); 
        System.out.println( "Hash SHA-256: " + hash); 
    } 
}
