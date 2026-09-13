package test;

import datos.Empleado;
import datos.UnidadVenta;
import negocio.UnidadVentaABM;
import negocio.EmpleadoABM;

public class AgregarEmpleadoAUnidadVenta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
		    UnidadVentaABM uABM = UnidadVentaABM.getInstancia();
		    EmpleadoABM eABM = EmpleadoABM.getInstancia();
			
			UnidadVenta foodtruck1 = uABM.traerUnidadVenta(1L);
			
			Empleado emp1 = eABM.traerEmpleado(3L);
			Empleado emp2 = eABM.traerEmpleado(4L);
			
			boolean agregado1 = uABM.agregarStaff(foodtruck1, emp1);
			boolean agregado2 = uABM.agregarStaff(foodtruck1, emp2);
			
			System.out.println("¿Empleado 3 agregado al staff?: " + agregado1);
			System.out.println("¿Empleado 4 agregado al staff?: " + agregado2);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
