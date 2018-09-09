package obstaculos;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import disparos.Disparo;
import juego.GameObject;
import naves.NaveAliada;
import naves.NaveEnemiga;
import power_ups.PowerUp;
import utilidades.Constantes;

public class NaveErrante extends Obstaculo {

	public NaveErrante(int x, int y, int vida, int durabilidad) {
		super(x, y, vida, durabilidad);

	}

	public String getName() {
		return "NaveErrante";
	}

	@Override
	public void borrar() {
	}

	@Override
	public void mover() {
	}

	@Override
	public ImageIcon getGrafico() {
		return new ImageIcon("src/resources/asteroid.png");
	}

	@Override
	protected Rectangle createRectangle(int x, int y) {
		return new Rectangle(x, y, Constantes.NAVEERRANTE_WIDTH, Constantes.NAVEERRANTE_HEIGHT);
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

	@Override
	public void colision(GameObject obs) {
	}

}
