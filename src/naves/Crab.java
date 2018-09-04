package naves;

import power_ups.PowerUp;
import utilidades.Punto;

public final class Crab extends NaveEnemiga {

	public Crab(Punto posicion, int vida, int durabilidad, int alcance, int dmg, int velocidad) {
		super(posicion, vida, durabilidad, alcance, dmg, velocidad);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void disparar() {
	}

	@Override
	public void aplicarPowerUp(PowerUp p) {

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

	public String getName() {
		return "Crab";
	}
}
