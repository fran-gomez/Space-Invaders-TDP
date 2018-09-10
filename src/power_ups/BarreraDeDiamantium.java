package power_ups;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import disparos.Disparo;
import naves.NaveAliada;
import naves.NaveEnemiga;
import obstaculos.Obstaculo;
import utilidades.Constantes;

public class BarreraDeDiamantium extends PowerUp {

	public BarreraDeDiamantium(int x, int y, int vida, int durabilidad) {
		super(x, y, vida, durabilidad);

	}

	@Override
	protected Rectangle createRectangle(int x, int y) {
		return new Rectangle(x, y, Constantes.BARRERADEDIAMANTIUM_WIDTH, Constantes.APARATOCATASTROFICO_HEIGHT);
	}

	@Override
	public void mover() {
	}

	@Override
	public ImageIcon getGrafico() {
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
