package conectores;

public class DataIntegrity {
	 public  static  boolean  verifiedDataIntegrity (String originalData, String receivedData) { 
	        String  originalHash  = SHA256Hashing.generateSHA256Hash(originalData); 
	        String  receivedHash  = SHA256Hashing.generateSHA256Hash(receivedData); 
	        return originalHash.equals(receivedHash); 
	    } 

	    public  static  void  main (String[] args) { 
	        String  originalData  =  "Datos importantes" ; 
	        String  receivedData  =  "Datos importantes" ; // Cambio para probar la falla de integridad 

	        boolean  isDataIntact  = verifiedDataIntegrity(originalData, receivedData); 
	        if (isDataIntact) { 
	            System.out.println( "Integridad de datos verificada." ); 
	        } else { 
	            System.out.println( "Integridad de datos comprometida." ); 
	        } 
	    } 
}
