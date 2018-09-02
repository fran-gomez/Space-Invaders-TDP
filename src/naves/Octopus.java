package naves;

import power_ups.PowerUp;
import utilidades.Punto;

public class Octopus extends NaveEnemiga {

	public Octopus(Punto posicion, int vida, int durabilidad, int alcance, int dmg, int velocidad) {
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

	public String getName() {
		return "Octopus";
	}
	@Override
	public void borrar() {
	
	}

	@Override
	public void colision() {
		
	}

}
