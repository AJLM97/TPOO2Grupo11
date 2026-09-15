package test;

import java.util.List;

import datos.Empleado;
import negocio.EmpleadoABM;

public class TestTraerEmpleados {
	
	public static void main(String[] args) {
		System.out.println("=== TestTraerEmpleados ===");
		
		try {
			EmpleadoABM eABM = EmpleadoABM.getInstancia();
			
			List<Empleado> lista = eABM.traerEmpleado();
			
			for(Empleado e : lista) {
				System.out.println(e);
			}	
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
	}

}
