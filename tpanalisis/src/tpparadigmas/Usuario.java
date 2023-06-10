package tpparadigmas;


public class Usuario {
	
	private String nombre;
	private int presupuesto;
	private double tiempoDisponible;
	private TipoAtraccion preferencia;
	
	public Usuario(String nombre, int presupuesto, double tiempoDisponible, TipoAtraccion preferencia) 
	{
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.preferencia = preferencia;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", presupuesto=" + presupuesto + ", tiempoDisponible=" + tiempoDisponible
				+ ", preferencia=" + preferencia + "]";
	}
	
	
}
