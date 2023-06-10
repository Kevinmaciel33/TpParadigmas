package tpparadigmas;

public class PromocionAxB extends Promocion {

	private Atraccion attracionGratis;
	
	public PromocionAxB(String nom, TipoAtraccion tipo, Atraccion att) {
		super(nom, tipo);
		this.attracionGratis = att;
	}

	@Override
	public void calcularCosto() {
		this.costo = this.costoOriginal - this.attracionGratis.getCosto();
	}

}
