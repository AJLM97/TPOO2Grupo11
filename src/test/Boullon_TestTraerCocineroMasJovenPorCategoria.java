package test;

import java.time.LocalDate;
import java.time.Period;

import datos.Empleado;
import datos.Festival;
import negocio.FestivalABM;

public class Boullon_TestTraerCocineroMasJovenPorCategoria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Trae al cocinero mas joven del festival dado una categoria determinada

		try {
			FestivalABM fABM = FestivalABM.getInstancia();
			
			Festival f = fABM.traer(1);
			
			Empleado joven1 = fABM.traerCocineroMasJovenPorCategoria(f, 1);
			Empleado joven2 = fABM.traerCocineroMasJovenPorCategoria(f, 2);
			Empleado joven3 = fABM.traerCocineroMasJovenPorCategoria(f, 3);
			
			if (joven1 != null) {
		        System.out.println("=== EMPLEADO MÁS JOVEN EN " + f.getNombre() + " DE CATEGORIA 1 ===");
		        System.out.println("ID: " + joven1.getIdEmpleado());
		        System.out.println("Nombre: " + joven1.getNombre() + " " + joven1.getApellido());
		        System.out.println("Edad: " + Period.between(joven1.getFechNacimiento(), LocalDate.now()).getYears());
		    } else {
		        System.out.println("La feria no tiene cocineros de categoria 1.");
		    }
			
			if (joven1 != null) {
		        System.out.println("=== EMPLEADO MÁS JOVEN EN " + f.getNombre() + " DE CATEGORIA 2 ===");
		        System.out.println("ID: " + joven2.getIdEmpleado());
		        System.out.println("Nombre: " + joven1.getNombre() + " " + joven1.getApellido());
		        System.out.println("Edad: " + Period.between(joven1.getFechNacimiento(), LocalDate.now()).getYears());
		    } else {
		        System.out.println("La feria no tiene cocineros de categoria 1.");
		    }
			
			if (joven1 != null) {
		        System.out.println("=== EMPLEADO MÁS JOVEN EN " + f.getNombre() + " DE CATEGORIA 3 ===");
		        System.out.println("ID: " + joven3.getIdEmpleado());
		        System.out.println("Nombre: " + joven1.getNombre() + " " + joven1.getApellido());
		        System.out.println("Edad: " + Period.between(joven1.getFechNacimiento(), LocalDate.now()).getYears());
		    } else {
		        System.out.println("La feria no tiene cocineros de categoria 1.");
		    }
		}
		catch (Exception e) {
	    e.printStackTrace();
		}
	}

}
