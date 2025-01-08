public class Roles {
    static String rol = "admin";

    public static void main(String[] args) {
        
        if (rol.equals("admin")) {
            System.out.println("Acceso total");
        } else if (rol.equals("editor")) {
            System.out.println("Acceso limitado");
        } else {
            System.out.println("Acceso denegado");
        }
    }
}

