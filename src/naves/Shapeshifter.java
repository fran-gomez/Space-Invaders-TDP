package naves;

import power_ups.PowerUp;
import utilidades.Punto;

public class Shapeshifter extends NaveEnemiga {

	public Shapeshifter(Punto posicion, int vida, int durabilidad, int alcance, int dmg, int velocidad) {
		super(posicion, vida, durabilidad, alcance, dmg, velocidad);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void disparar() {
	}

	@Override
	protected void aplicarPowerUp(PowerUp p) {
	}

	@Override
	public void actualizarPosicion() {

	}

	@Override
	public void borrar() {
	
	}

	@Override
	public void colision() {
	}

}
