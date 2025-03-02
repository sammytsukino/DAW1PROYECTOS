package listas;
import java.util.ArrayList;
import java.util.Iterator;
public class ListadeEmpleados {
	public static void main (String[] args) {
		ArrayList <Empleado> empleados=new ArrayList <Empleado>();
		Empleado e1=new Empleado("Daniel","Morales", "daniel@gmail.com", "27656787Q", 1450.54, "Desarrollo Web");
		Empleado e2=new Empleado("Daniel","García", "daniel45@gmail.com", "23256756Q", 1650.54, "Desarrollo Web");
		Empleado e3=new Empleado("Miguel","Fernandez", "miguel@gmail.com", "27234787Q", 1250.54, "Desarrollo Web");
		Empleado e4=new Empleado("Manuel","García", "manuel@gmail.com", "19866756Q", 1950.54, "Desarrollo Web");
		
		empleados.add(e1);
		empleados.add(e2);
		empleados.add(e3);
		empleados.add(e4);
		
		Iterator <Empleado> itrEmpleados=empleados.iterator();
		while (itrEmpleados.hasNext()) {
			Empleado empleado = itrEmpleados.next();
			empleado.setEmail(empleado.getNombre()+"."+empleado.getApellidos()+"@daw.com");
			if (empleado.getDni().equals("27234787Q")) {
				empleado.setNomina(1650.54);
			}
			System.out.println(empleado.toString());
		}
		
	}
}
