package naves;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import juego.GameObject;
import juego.Nave;
import power_ups.PowerUp;
import utilidades.Constantes;
import utilidades.Recuadro;

public final class NaveAliada extends Nave {

	public NaveAliada(Recuadro posicion, int vida, int durabilidad, int alcance, int dmg, int velocidad) {
		super(posicion, vida, durabilidad, alcance, dmg, velocidad);
	}

	@Override
	public void disparar() {

	}

	@Override
	public void aplicarPowerUp(PowerUp p) {

	}

	@Override
	public void borrar() {

	}

	public String getName() {
		return "Aliado";
	}

	@Override
	public void colision(GameObject o1) {
	}

	@Override
	public void mover() {
	}
}
