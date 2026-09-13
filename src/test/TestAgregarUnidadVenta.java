package test;


import datos.Empleado;
import datos.Festival;
import negocio.FestivalABM;
import negocio.UnidadVentaABM;
import negocio.EmpleadoABM;

public class TestAgregarUnidadVenta {

	public static void main(String[] args) {
		System.out.println("=== TestAgregarUnidadVenta ===");
		
		FestivalABM fABM = FestivalABM.getInstancia();
	    UnidadVentaABM uABM = UnidadVentaABM.getInstancia();
	    EmpleadoABM eABM = EmpleadoABM.getInstancia();

		try {
        //----AGREGAR UNIDADES DE VENTA----
        Festival festival1 = fABM.traerFestival(1L);
        Empleado responsable1 = eABM.traerEmpleado(1L);
        Empleado responsable2 = eABM.traerEmpleado(2L);
        Empleado responsable3 = eABM.traerEmpleado(6L);
        
	        int idPuesto1 = uABM.agregarPuestoDesarmable("Hamburguesas Deliciosas", "HBD123", 15, responsable2, festival1, 4, 2);
	        System.out.printf("Id Puesto Desarmable: %d\n", idPuesto1);
	        
	        int idFoodTruck1 = uABM.agregarFoodTruck("Pizzas Ledesma", "AJL199", 10, responsable1, festival1, "AJL199", true);
	        System.out.printf("Id FoodTruck 1: %d\n", idFoodTruck1);
	        
	        int idFoodTruck2 = uABM.agregarFoodTruck("Sushi Express", "SE-001", 18.0, responsable3, festival1, "SUX999", true);
	        System.out.printf("Id FoodTruck 2: %d\n", idFoodTruck2);
			
		
	    
		
		} catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}