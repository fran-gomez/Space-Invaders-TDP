package naves;

import juego.GameObject;
import power_ups.PowerUp;
import utilidades.Recuadro;

public final class Octopus extends NaveEnemiga {

	public Octopus(Recuadro posicion, int vida, int durabilidad, int alcance, int dmg, int velocidad) {
		super(posicion, vida, durabilidad, alcance, dmg, velocidad);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void disparar() {

	}

	@Override
	public void aplicarPowerUp(PowerUp p) {

	}


	public String getName() {
		return "Octopus";
	}
	@Override
	public void borrar() {
	
	}

	@Override
	public void colision(GameObject o1) {
	}

	@Override
	public void mover() {
	}



}
