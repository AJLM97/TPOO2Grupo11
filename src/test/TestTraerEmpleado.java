package test;

import datos.Empleado;
import negocio.EmpleadoABM;

public class TestTraerEmpleado {

	public static void main(String[] args) {
		System.out.println("=== TestTraerEmpleado ===");
		
		try {
			EmpleadoABM eABM = EmpleadoABM.getInstancia();
			
			Empleado e = eABM.traer(1L);
	
			System.out.println("Empleado ID " + e.getIdEmpleado());
			System.out.println(e);
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
	}

}