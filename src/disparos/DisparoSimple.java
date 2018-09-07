package disparos;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import juego.GameObject;
import naves.NaveAliada;
import naves.NaveEnemiga;
import obstaculos.Obstaculo;
import power_ups.PowerUp;

public final class DisparoSimple extends Disparo {

	public DisparoSimple(int x, int y, int vida, int durabilidad) {
		super(x, y, vida, durabilidad);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void borrar() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void mover() {
		// TODO Auto-generated method stub

	}

	@Override
	public ImageIcon getGrafico() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Rectangle createRectangle(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void colision(NaveEnemiga naveEnemiga) {
	}

	@Override
	public void colision(NaveAliada naveEnemiga) {
	}

	@Override
	public void colision(Obstaculo naveEnemiga) {
	}

	@Override
	public void colision(PowerUp powerUp) {
	}

	@Override
	public void colision(Disparo disparo) {
	}


}
