package test;

import java.time.LocalDate;

import datos.Empleado;
import negocio.EmpleadoABM;

public class TestTraerCocinero {

	public static void main(String[] args) {
		EmpleadoABM eABM = EmpleadoABM.getInstancia();
		
		long idEmpleado = eABM.agregarCocinero("Paula", "Suarez", 87654321, LocalDate.of(2000, 6, 15), LocalDate.of(2021, 9, 5), 70, 3, "Pasteleria", 10);
		
		Empleado e = eABM.traer(idEmpleado);
		
		System.out.println("Cocinero ID " + e.getIdEmpleado());
		System.out.println(e);
	}

}