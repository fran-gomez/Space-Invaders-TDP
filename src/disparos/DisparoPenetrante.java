package disparos;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import naves.NaveAliada;
import naves.NaveEnemiga;
import obstaculos.Obstaculo;
import power_ups.PowerUp;

public final class DisparoPenetrante extends Disparo {

	public DisparoPenetrante(int x, int y, int vida, int durabilidad, int dmg) {
		super(x, y, vida, durabilidad, dmg);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void eliminar() {
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
