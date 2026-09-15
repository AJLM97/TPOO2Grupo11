package test;

import java.time.LocalDate;

import datos.Empleado;
import negocio.EmpleadoABM;

public class TestTraerCajero {

	public static void main(String[] args) {
		EmpleadoABM eABM = EmpleadoABM.getInstancia();
		
		long idEmpleado = eABM.agregarCajero("Paula", "Alvarez", 46464646, LocalDate.of(2003, 5, 1), LocalDate.of(2021, 3, 5), 50, "Tarde", 7);
		
		Empleado e = eABM.traer(idEmpleado);

		System.out.println("Cajero ID " + e.getIdEmpleado());
		System.out.println(e);
	}

}