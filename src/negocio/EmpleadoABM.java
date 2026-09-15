package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.EmpleadoDao;
import datos.Cajero;
import datos.Cocinero;
import datos.Empleado;

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
            LocalDate fechNacimiento, LocalDate fechaIngreso, double sueldoBase,
            String turnoTrabajo, double plusAntiguedad) {
        Cajero aux = new Cajero(nombre, apellido, dni, fechNacimiento, fechaIngreso,
                sueldoBase, turnoTrabajo, plusAntiguedad);
        return dao.agregar(aux);

    }

    public int agregarCocinero(String nombre, String apellido, long dni,
            LocalDate fechNacimiento, LocalDate fechaIngreso, double sueldoBase,
            long categoria, String especialidad, long porcentaje) {
        Cocinero aux = new Cocinero(nombre, apellido, dni, fechNacimiento, fechaIngreso,
                sueldoBase, categoria, especialidad, porcentaje);
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