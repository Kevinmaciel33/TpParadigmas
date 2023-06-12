package tpparadigmas;

public class PromocionAbsoluta extends Promocion {

	private int costoReducido;
	
	public PromocionAbsoluta(String nom, TipoAtraccion tipo, int costoPaquete) {
		super(nom, tipo);
		this.costoReducido = costoPaquete;
	}

	@Override
	public void calcularCosto() {
		this.costo = this.costoReducido;
	}



}
