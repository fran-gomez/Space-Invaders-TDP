package obstaculos;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import disparos.Disparo;
import juego.GameObject;
import naves.NaveAliada;
import naves.NaveEnemiga;
import power_ups.PowerUp;
import utilidades.Constantes;

public class Asteroide extends Obstaculo {

	public Asteroide(int x, int y, int vida, int durabilidad, int d) {
		super(x, y, vida, durabilidad, d);
	}

	@Override
	public String getName() {
		return "Asteroide";
	}

	@Override
	public void mover() {
	}

	@Override
	protected Rectangle createRectangle(int x, int y) {
		return new Rectangle(x, y, Constantes.ASTEROIDE_WIDTH, Constantes.ASTEROIDE_HEIGHT);
	}

	@Override
	public ImageIcon getGrafico() {
		return new ImageIcon("src/resources/asteroid.png");
	}

	@Override
	public void colision(NaveAliada naveAliada) {
	}

	@Override
	public void colision(Obstaculo obs) {
	}

	@Override
	public void colision(PowerUp powerUp) {
	}

}
