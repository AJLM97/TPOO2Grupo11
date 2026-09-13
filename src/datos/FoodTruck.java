package datos;

public class FoodTruck extends UnidadVenta {
	private String patente;
	private boolean conexionElectrica;

	public FoodTruck() {}

	public FoodTruck(String nombreComercial, String codigo, double superficie, Empleado responsable, Festival festival,
			String patente, boolean conexionElectrica) {
		super(nombreComercial, codigo, superficie, responsable, festival);
		this.patente = patente;
		this.conexionElectrica = conexionElectrica;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public boolean isConexionElectrica() {
		return conexionElectrica;
	}

	public void setConexionElectrica(boolean conexionElectrica) {
		this.conexionElectrica = conexionElectrica;
	}

	@Override
	public String toString() {
		return "FoodTruck [" + super.toString() + ", patente=" + patente + ", conexionElectrica=" + conexionElectrica + "]";
	}

}
