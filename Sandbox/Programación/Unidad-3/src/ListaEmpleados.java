import java.util.ArrayList;
import java.util.Iterator;

public class ListaEmpleados {
    public static void main(String[] args) {
        ArrayList<Empleado> empleados = new ArrayList<Empleado>();

        Empleado e1 = new Empleado("Samuel", "Cabello", "samy.cabello.g", "49129335R", 1500, "Marketing");

        Empleado e2 = new Empleado("Julia", "Naranjo", "julia.n@gmail.com", "5554846R", 1600, "Marketing");

        Empleado e3 = new Empleado("Juan", "Perez", "juan@gmail.com", "987329843F", 1700, "Marketing");

        Empleado e4 = new Empleado("Maria", "Garcia", "maria@gmail.com", "3423423J", 1400, "Marketing");

        empleados.add(e1);
        empleados.add(e2);
        empleados.add(e3);
        empleados.add(e4);

        Iterator<Empleado> it = empleados.iterator();
        while (it.hasNext()) {
            Empleado empleado = it.next();
            empleado.setEmail(empleado.getNombre() + "." + empleado.getApellido() + "@daw.com");
            if (empleado.getDni().equals ("987329843F")) {
                empleado.setNomina(1800);
            }
            System.out.println(empleado.toString());
        }



        /*System.out.println(e1.getEmail());

        e2.setEmail(e2.getEmail());
        System.out.println(e2.getEmail());

        e3.setEmail(e3.getEmail());
        System.out.println(e3.getEmail());

        e4.setEmail(e4.getEmail());
        System.out.println(e4.getEmail());

        for (Empleado empleado : empleados) {
            empleado.setEmail(empleado.getEmail());
            System.out.println(empleado.getEmail());
        }*/

    }
}
