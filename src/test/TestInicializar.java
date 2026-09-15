package test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import datos.Empleado;
import datos.Festival;
import datos.FoodTruck;
import datos.Pedido;
import datos.Plato;
import datos.PuestoDesarmable;
import negocio.EmpleadoABM;
import negocio.FestivalABM;
import negocio.PedidoABM;
import negocio.PlatoABM;
import negocio.UnidadVentaABM;

public class TestInicializar {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
        FestivalABM fABM = FestivalABM.getInstancia();
		UnidadVentaABM uABM = UnidadVentaABM.getInstancia();
        EmpleadoABM eABM = EmpleadoABM.getInstancia();
        PlatoABM platoABM = PlatoABM.getInstancia();
        PedidoABM peABM = PedidoABM.getInstancia();

        Festival festivalA = null;
		Festival festivalB = null;
		Festival festivalC = null;
		
		PuestoDesarmable unidadVentaA = null;
        FoodTruck unidadVentaB = null;
        FoodTruck unidadVentaC = null;

        Empleado empleadoA = null;
        Empleado empleadoB = null;
        Empleado empleadoC = null;
        Empleado empleadoD = null;
        Empleado empleadoE = null;
        Empleado empleadoF = null;
        Empleado empleadoG = null;
        Empleado empleadoH = null;
        Empleado empleadoI = null;
        Empleado empleadoJ = null;
        Empleado empleadoK = null;
        Empleado empleadoL = null;

        Plato platoA = null;
        Plato platoB = null;
        Plato platoC = null;
        Plato platoD = null;
        Plato platoE = null;
        Plato platoF = null;
        Plato platoG = null;
        Plato platoH = null;
        Plato platoI = null;
        Plato platoJ = null;
        Plato platoK = null;
        Plato platoL = null;
        Plato platoM = null;
        Plato platoN = null;
        Plato platoO = null;
        Plato platoP = null;
        Plato platoQ = null;
        Plato platoR = null;
        Plato platoS = null;
        Plato platoT = null;

        // Inicializar festivales
        try {
			long idFestival = fABM.agregar("Sabores del Sur", "Verano", LocalDate.of(2026, 12, 15), LocalDate.of(2026, 12, 21), 500f, 10f, 2000f);
			System.out.printf("Id Festival: %d", idFestival);
            festivalA = fABM.traer(idFestival);

		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			long idFestival = fABM.agregar("Festival Gastronómico", "Otoño", LocalDate.of(2026, 4, 10), LocalDate.of(2026, 4, 16), 500f, 10f, 2000f);
			System.out.printf("Id Festival: %d", idFestival);
            festivalB = fABM.traer(idFestival);

		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			long idFestival = fABM.agregar("Festival de Lanús", "Invierno", LocalDate.of(2026, 7, 15), LocalDate.of(2026, 7, 21), 500f, 10f, 2000f);
			System.out.printf("Id Festival: %d", idFestival);
            festivalC = fABM.traer(idFestival);

		} catch(Exception e) {
			e.printStackTrace();
		}
		
		// Inicializar unidades de venta
        try {
            long idUnidadVenta = uABM.agregarPuestoDesarmable("Hamburguesas Deliciosas", "HBD123", 15, festivalA, 4, 2);
			System.out.printf("Id Puesto Desarmable: %d", idUnidadVenta);
            unidadVentaA = (PuestoDesarmable) uABM.traer(idUnidadVenta);

		} catch(Exception e) {
			e.printStackTrace();
		}

        try {
            long idUnidadVenta = uABM.agregarFoodTruck("Pizzas Ledesma", "AJL199", 10, festivalA, "AJL199", true);
			System.out.printf("Id FoodTruck: %d", idUnidadVenta);
            unidadVentaB = (FoodTruck) uABM.traer(idUnidadVenta);

		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
            long idUnidadVenta = uABM.agregarFoodTruck("Sushi Express", "SE-001", 18.0, festivalA, "SUX999", true);
			System.out.printf("Id FoodTruck: %d", idUnidadVenta);
            unidadVentaC = (FoodTruck) uABM.traer(idUnidadVenta);

		} catch(Exception e) {
			e.printStackTrace();
		}

		// Inicializar y agregar empleados a unidades de venta
        try {
			long idEmpleado = eABM.agregarCajero("Nicolás", "Ledesma", 18061993, LocalDate.of(1993, 6, 18), LocalDate.of(2021, 3, 10), 700000, unidadVentaB, "Mañana", 500);
			System.out.printf("Id Empleado: %d", idEmpleado);
            empleadoA = eABM.traer(idEmpleado);

		} catch(Exception e) {
			e.printStackTrace();
		}

        try {
			long idEmpleado = eABM.agregarCocinero("María", "González", 15071989, LocalDate.of(1989, 7, 15), LocalDate.of(2018, 2, 20), 800000, unidadVentaA, 1, "Pizza", 10);
			System.out.printf("Id Cocinero: %d", idEmpleado);
            empleadoB = eABM.traer(idEmpleado);

		} catch(Exception e) {
			e.printStackTrace();
		}

        try {
            long idEmpleado = eABM.agregarCajero("Juan", "Pérez", 20081994, LocalDate.of(1994, 8, 20), LocalDate.of(2022, 5, 12), 700000, unidadVentaA, "Noche", 700);
            System.out.printf("Id Empleado: %d", idEmpleado);
            empleadoC = eABM.traer(idEmpleado);

        } catch(Exception e) {
            e.printStackTrace();
        }

        try {
            long idEmpleado = eABM.agregarCocinero("Lucía", "Martínez", 25091996, LocalDate.of(1996, 9, 25), LocalDate.of(2020, 11, 8), 800000, unidadVentaA, 1, "Hamburguesa", 800);
            System.out.printf("Id Cocinero: %d", idEmpleado);
            empleadoD = eABM.traer(idEmpleado);

        } catch(Exception e) {
            e.printStackTrace();
        }

        try {
            long idEmpleado = eABM.agregarCajero("Carlos", "Rodríguez", 30101998, LocalDate.of(1998, 10, 30), LocalDate.of(2023, 4, 15), 50000, unidadVentaB, "Tarde", 900);
            System.out.printf("Id Empleado: %d", idEmpleado);
            empleadoE = eABM.traer(idEmpleado);

        } catch(Exception e) {
            e.printStackTrace();
        }

        try {
            long idEmpleado = eABM.agregarCajero( "Carlos", "López", 18111987, LocalDate.of(1987, 11, 18), LocalDate.of(2020, 1, 10), 31000, unidadVentaC, "Mañana", 2100);
            System.out.printf("Id Empleado: %d", idEmpleado);
            empleadoF = eABM.traer(idEmpleado);

        } catch(Exception e) {
            e.printStackTrace();
        }

        try {
            long idEmpleado = eABM.agregarCocinero("Sofía", "Benítez", 4042000, LocalDate.of(2000, 4, 4), LocalDate.of(2023, 6, 1), 620000, unidadVentaB, 2, "Sushi", 12);
            System.out.printf("Id Cocinero: %d", idEmpleado);
            empleadoG = eABM.traer(idEmpleado);
        } catch(Exception e) {
            e.printStackTrace();
        }

        try {
            long idEmpleado = eABM.agregarCajero("Mateo", "Gómez", 12072001, LocalDate.of(2001, 7, 12), LocalDate.of(2024, 1, 15), 580000, unidadVentaB, "Tarde", 1100);
            System.out.printf("Id Empleado: %d", idEmpleado);
            empleadoH = eABM.traer(idEmpleado);
        } catch(Exception e) {
            e.printStackTrace();
        }

        try {
            long idEmpleado = eABM.agregarCocinero("Valentina", "Silva", 22091994, LocalDate.of(1994, 9, 22), LocalDate.of(2021, 9, 3), 760000, unidadVentaB, 3, "Pastas", 15);
            System.out.printf("Id Cocinero: %d", idEmpleado);
            empleadoI = eABM.traer(idEmpleado);
        } catch(Exception e) {
            e.printStackTrace();
        }

        try {
            long idEmpleado = eABM.agregarCajero("Tomás", "Rojas", 7111992, LocalDate.of(1992, 11, 7), LocalDate.of(2022, 2, 22), 650000, unidadVentaC, "Noche", 900);
            System.out.printf("Id Empleado: %d", idEmpleado);
            empleadoJ = eABM.traer(idEmpleado);
        } catch(Exception e) {
            e.printStackTrace();
        }

        try {
            long idEmpleado = eABM.agregarCocinero("Florencia", "Acosta", 29082095, LocalDate.of(1995, 8, 29), LocalDate.of(2023, 5, 5), 710000, unidadVentaC, 2, "Mariscos", 18);
            System.out.printf("Id Cocinero: %d", idEmpleado);
            empleadoK = eABM.traer(idEmpleado);
        } catch(Exception e) {
            e.printStackTrace();
        }

        try {
            long idEmpleado = eABM.agregarCajero("Ezequiel", "Morales", 14021989, LocalDate.of(1989, 2, 14), LocalDate.of(2019, 8, 12), 690000, unidadVentaA, "Mañana", 1300);
            System.out.printf("Id Empleado: %d", idEmpleado);
            empleadoL = eABM.traer(idEmpleado);
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        // Asignar encargado de unidad de venta
        try {
			uABM.asignarResponsable(unidadVentaA, empleadoB);
			uABM.asignarResponsable(unidadVentaB, empleadoA);
			uABM.asignarResponsable(unidadVentaC, empleadoF);

		} catch(Exception e) {
			e.printStackTrace();
		}

        // Inicializar y agregar platos a unidades de venta
        try {
			long idPlato = platoABM.agregar("Choripán", 950, 420, unidadVentaA);
			System.out.printf("Id Plato: %d", idPlato);
            platoA = platoABM.traer(idPlato);
            System.out.println(platoA);

		} catch(Exception e) {
			e.printStackTrace();
		}

        try {
			long idPlato = platoABM.agregar("Hamburguesa doble", 1400, 620, unidadVentaA);
			System.out.printf("Id Plato: %d", idPlato);
            platoB = platoABM.traer(idPlato);

		} catch(Exception e) {
			e.printStackTrace();
		}

        try {
			long idPlato = platoABM.agregar("Milanesa napolitana", 1550, 700, unidadVentaA);
			System.out.printf("Id Plato: %d", idPlato);
            platoC = platoABM.traer(idPlato);

		} catch(Exception e) {
			e.printStackTrace();
		}

        try {
			long idPlato = platoABM.agregar("Empanada de carne", 250, 105, unidadVentaA);
			System.out.printf("Id Plato: %d", idPlato);
            platoD = platoABM.traer(idPlato);

		} catch(Exception e) {
			e.printStackTrace();
		}

        try {
			long idPlato = platoABM.agregar("Taco de pollo", 280, 130, unidadVentaA);
			System.out.printf("Id Plato: %d", idPlato);
            platoE = platoABM.traer(idPlato);

		} catch(Exception e) {
			e.printStackTrace();
		}

        try {
			long idPlato = platoABM.agregar("Lomito con papas", 1800, 900, unidadVentaA);
			System.out.printf("Id Plato: %d", idPlato);
            platoF = platoABM.traer(idPlato);

		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			long idPlato = platoABM.agregar("Pizza fugazzeta", 1450, 680, unidadVentaA);
			System.out.printf("Id Plato: %d", idPlato);
            platoG = platoABM.traer(idPlato);

		} catch(Exception e) {
			e.printStackTrace();
		}

        try {
			long idPlato = platoABM.agregar("Sandwich de milanesa", 1200, 540, unidadVentaA);
			System.out.printf("Id Plato: %d", idPlato);
            platoH = platoABM.traer(idPlato);

		} catch(Exception e) {
			e.printStackTrace();
		}

        try {
			long idPlato = platoABM.agregar("Wrap de pollo", 1050, 470, unidadVentaA);
			System.out.printf("Id Plato: %d", idPlato);
            platoI = platoABM.traer(idPlato);
            
		} catch(Exception e) {
			e.printStackTrace();
		}

        try {
			long idPlato = platoABM.agregar("Quesadilla de carne", 11000, 470, unidadVentaA);
			System.out.printf("Id Plato: %d", idPlato);
            platoJ = platoABM.traer(idPlato);

		} catch(Exception e) {
			e.printStackTrace();
		}

        try {
			long idPlato = platoABM.agregar("Churros con dulce de leche", 600, 220, unidadVentaA);
			System.out.printf("Id Plato: %d", idPlato);
            platoK = platoABM.traer(idPlato);

		} catch(Exception e) {
			e.printStackTrace();
		}

        try {
			long idPlato = platoABM.agregar("Pizza margarita", 1400, 600, unidadVentaB);
			System.out.printf("Id Plato: %d", idPlato);
            platoL = platoABM.traer(idPlato);

		} catch(Exception e) {
			e.printStackTrace();
		}

        try {
			long idPlato = platoABM.agregar("Ensalada César con pollo", 1300, 610, unidadVentaB);
			System.out.printf("Id Plato: %d", idPlato);
            platoM = platoABM.traer(idPlato);

		} catch(Exception e) {
			e.printStackTrace();
		}

        try {
			long idPlato = platoABM.agregar("Pizza napolitana", 1500, 650, unidadVentaB);
			System.out.printf("Id Plato: %d", idPlato);
            platoN = platoABM.traer(idPlato);

		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			long idPlato = platoABM.agregar("Nigiri", 520, 200, unidadVentaB);
			System.out.printf("Id Plato: %d", idPlato);
            platoO = platoABM.traer(idPlato);

		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			long idPlato = platoABM.agregar("Tempura", 380, 140, unidadVentaB);
			System.out.printf("Id Plato: %d", idPlato);
            platoP = platoABM.traer(idPlato);

		} catch(Exception e) {
			e.printStackTrace();
		}

        try {
            long idPlato = platoABM.agregar("Pizza de calabresa", 3000, 720, unidadVentaC);
            System.out.printf("Id Plato: %d", idPlato);
            platoQ = platoABM.traer(idPlato);
        } catch(Exception e) {
            e.printStackTrace();
        }

        try {
            long idPlato = platoABM.agregar("Pizza cuatro quesos", 1850, 780, unidadVentaC);
            System.out.printf("Id Plato: %d", idPlato);
            platoR = platoABM.traer(idPlato);
        } catch(Exception e) {
            e.printStackTrace();
        }

        try {
            long idPlato = platoABM.agregar("Sashimi de salmón", 980, 360, unidadVentaC);
            System.out.printf("Id Plato: %d", idPlato);
            platoS = platoABM.traer(idPlato);
        } catch(Exception e) {
            e.printStackTrace();
        }

        try {
            long idPlato = platoABM.agregar("Roll de atún", 1150, 430, unidadVentaC);
            System.out.printf("Id Plato: %d", idPlato);
            platoT = platoABM.traer(idPlato);
        } catch(Exception e) {
            e.printStackTrace();
        }

        // Inicializar pedidos de UnidadVentaA
        try {
            long idPedido = peABM.agregar(LocalDateTime.of(2026, 12, 15, 11, 15), unidadVentaA);
            Pedido pedido = peABM.traer(idPedido);
            peABM.agregarItemPedido(pedido, platoA, 2);
            peABM.agregarItemPedido(pedido, platoB, 1);
            peABM.agregarItemPedido(pedido, platoE, 2);
            peABM.cerrarPedido(pedido);

            idPedido = peABM.agregar(LocalDateTime.of(2026, 12, 16, 12, 00), unidadVentaA);
            pedido = peABM.traer(idPedido);
            peABM.agregarItemPedido(pedido, platoC, 3);
            peABM.agregarItemPedido(pedido, platoD, 4);
            peABM.cerrarPedido(pedido);

            idPedido = peABM.agregar(LocalDateTime.of(2026, 12, 17, 18, 10), unidadVentaA);
            pedido = peABM.traer(idPedido);
            peABM.agregarItemPedido(pedido, platoF, 1);
            peABM.agregarItemPedido(pedido, platoH, 2);
            peABM.agregarItemPedido(pedido, platoK, 3);
            peABM.cerrarPedido(pedido);

            idPedido = peABM.agregar(LocalDateTime.of(2026, 12, 18, 20, 05), unidadVentaA);
            pedido = peABM.traer(idPedido);
            peABM.agregarItemPedido(pedido, platoI, 2);
            peABM.agregarItemPedido(pedido, platoJ, 1);
            peABM.agregarItemPedido(pedido, platoM, 4);
            peABM.cerrarPedido(pedido);

            idPedido = peABM.agregar(LocalDateTime.of(2026, 12, 19, 14, 20), unidadVentaA);
            pedido = peABM.traer(idPedido);
            peABM.agregarItemPedido(pedido, platoB, 2);
            peABM.agregarItemPedido(pedido, platoD, 3);
            peABM.agregarItemPedido(pedido, platoE, 1);
            peABM.cerrarPedido(pedido);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Inicializar pedidos de UnidadVentaB
        try {
            long idPedido = peABM.agregar(LocalDateTime.of(2026, 12, 15, 13, 00), unidadVentaB);
            Pedido pedido = peABM.traer(idPedido);
            peABM.agregarItemPedido(pedido, platoG, 2);
            peABM.agregarItemPedido(pedido, platoL, 1);
            peABM.cerrarPedido(pedido);

            idPedido = peABM.agregar(LocalDateTime.of(2026, 12, 17, 10, 30), unidadVentaB);
            pedido = peABM.traer(idPedido);
            peABM.agregarItemPedido(pedido, platoN, 3);
            peABM.agregarItemPedido(pedido, platoQ, 2);
            peABM.cerrarPedido(pedido);

            idPedido = peABM.agregar(LocalDateTime.of(2026, 12, 18, 19, 40), unidadVentaB);
            pedido = peABM.traer(idPedido);
            peABM.agregarItemPedido(pedido, platoR, 1);
            peABM.agregarItemPedido(pedido, platoG, 4);
            peABM.cerrarPedido(pedido);

            idPedido = peABM.agregar(LocalDateTime.of(2026, 12, 19, 12, 50), unidadVentaB);
            pedido = peABM.traer(idPedido);
            peABM.agregarItemPedido(pedido, platoL, 2);
            peABM.agregarItemPedido(pedido, platoN, 1);
            peABM.agregarItemPedido(pedido, platoQ, 3);
            peABM.cerrarPedido(pedido);

            idPedido = peABM.agregar(LocalDateTime.of(2026, 12, 21, 15, 20), unidadVentaB);
            pedido = peABM.traer(idPedido);
            peABM.agregarItemPedido(pedido, platoG, 3);
            peABM.agregarItemPedido(pedido, platoR, 2);
            peABM.cerrarPedido(pedido);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Inicializar pedidos de UnidadVentaC
        try {
            long idPedido = peABM.agregar(LocalDateTime.of(2026, 12, 15, 18, 15), unidadVentaC);
            Pedido pedido = peABM.traer(idPedido);
            peABM.agregarItemPedido(pedido, platoO, 2);
            peABM.agregarItemPedido(pedido, platoP, 3);
            peABM.cerrarPedido(pedido);

            idPedido = peABM.agregar(LocalDateTime.of(2026, 12, 17, 13, 45), unidadVentaC);
            pedido = peABM.traer(idPedido);
            peABM.agregarItemPedido(pedido, platoS, 1);
            peABM.agregarItemPedido(pedido, platoT, 2);
            peABM.cerrarPedido(pedido);

            idPedido = peABM.agregar(LocalDateTime.of(2026, 12, 18, 13, 35), unidadVentaC);
            pedido = peABM.traer(idPedido);
            peABM.agregarItemPedido(pedido, platoO, 3);
            peABM.agregarItemPedido(pedido, platoS, 1);
            peABM.cerrarPedido(pedido);

            idPedido = peABM.agregar(LocalDateTime.of(2026, 12, 19, 17, 55), unidadVentaC);
            pedido = peABM.traer(idPedido);
            peABM.agregarItemPedido(pedido, platoP, 2);
            peABM.agregarItemPedido(pedido, platoT, 4);
            peABM.cerrarPedido(pedido);

            idPedido = peABM.agregar(LocalDateTime.of(2026, 12, 21, 20, 10), unidadVentaC);
            pedido = peABM.traer(idPedido);
            peABM.agregarItemPedido(pedido, platoO, 1);
            peABM.agregarItemPedido(pedido, platoP, 1);
            peABM.agregarItemPedido(pedido, platoS, 2);
            peABM.agregarItemPedido(pedido, platoT, 1);
            peABM.cerrarPedido(pedido);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println("Listo, todo cargado");
        
	}

}