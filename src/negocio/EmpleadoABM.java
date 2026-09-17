package negocio;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import dao.EmpleadoDao;
import datos.Cajero;
import datos.Cocinero;
import datos.Empleado;
import datos.UnidadVenta;

public class EmpleadoABM {

    private static EmpleadoABM abm = null;
    private EmpleadoDao dao = EmpleadoDao.getInstance();

    private EmpleadoABM() {}

    public static EmpleadoABM getInstancia() {
        if(abm == null) {
            abm = new EmpleadoABM();
        }
        return abm;
    }

    public int agregarCajero(String nombre, String apellido, long dni,
            LocalDate fechNacimiento, LocalDate fechaIngreso, double sueldoBase, UnidadVenta unidad,
            String turnoTrabajo, double plusAntiguedad) throws Exception {
        if(dao.existeEmpleadoEnUnidadVenta(dni, unidad)) {
			throw new Exception("Ya existe un Empleado con DNI " + dni + " en la unidad de venta " + unidad.getNombreComercial());
		}
        if(Period.between(fechNacimiento, LocalDate.now()).getYears() < 18) {
        	throw new Exception("El Empleado debe ser mayor de edad (18 años o mayor)");
        }
        Cajero aux = new Cajero(nombre, apellido, dni, fechNacimiento, fechaIngreso,
                sueldoBase, unidad, turnoTrabajo, plusAntiguedad);
        return dao.agregar(aux);

    }

    public int agregarCocinero(String nombre, String apellido, long dni,
            LocalDate fechNacimiento, LocalDate fechaIngreso, double sueldoBase, UnidadVenta unidad,
            long categoria, String especialidad, long porcentaje) throws Exception {
        if(dao.existeEmpleadoEnUnidadVenta(dni, unidad)) {
			throw new Exception("Ya existe un Empleado con DNI " + dni + " en la unidad de venta " + unidad.getNombreComercial());
		}
        if(Period.between(fechNacimiento, LocalDate.now()).getYears() < 18) {
        	throw new Exception("El Empleado debe ser mayor de edad (18 años o mayor)");
        }
        if((categoria < 1) || (categoria > 3)) {
        	throw new Exception("La categoria del cocinero debe ser un valor entre 1 y 3 inclusive");
        }
        Cocinero aux = new Cocinero(nombre, apellido, dni, fechNacimiento, fechaIngreso,
                sueldoBase, unidad, categoria, especialidad, porcentaje);
        return dao.agregar(aux);
    }

    public void modificar(Empleado empleado) {
        dao.actualizar(empleado);
    }

    public void eliminar(long idEmpleado) {
        Empleado aux = dao.traer(idEmpleado);
        dao.eliminar(aux);
    }

    public Empleado traer(long idEmpleado) {
        return dao.traer(idEmpleado);
    }

    public List<Empleado> traerEmpleado() {
        return dao.traer();
    }
}