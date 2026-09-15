package test;

import datos.Empleado;
import datos.UnidadVenta;
import negocio.UnidadVentaABM;

public class Leal_TestTraerEmpleadoMasAntiguo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		
		UnidadVentaABM uABM = UnidadVentaABM.getInstancia();
			
		UnidadVenta puesto = uABM.traer(1L);

	    Empleado masAntiguo = uABM.traerEmpleadoMasAntiguo(puesto);

	    if (masAntiguo != null) {
	        System.out.println("=== EMPLEADO MÁS ANTIGUO EN " + puesto.getNombreComercial() + " ===");
	        System.out.println("ID: " + masAntiguo.getIdEmpleado());
	        System.out.println("Nombre: " + masAntiguo.getNombre() + " " + masAntiguo.getApellido());
	        System.out.println("Fecha de Ingreso: " + masAntiguo.getFechaIngreso());
	    } else {
	        System.out.println("La unidad de venta no tiene empleados en su staff.");
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
	}

}
