package obstaculos;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import juego.GameObject;
import utilidades.Constantes;

public class NaveErrante extends Obstaculo {

	public NaveErrante(int x, int y, int vida, int durabilidad) {
		super(x,y, vida, durabilidad);
	
	}
	
	public String getName() {
		return "NaveErrante";
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

	@Override
	public ImageIcon getGrafico() {
		return null;
	}

	@Override
	protected Rectangle createRectangle(int x, int y) {
		return new Rectangle(x,y, Constantes.NAVEERRANTE_WIDTH, Constantes.NAVEERRANTE_HEIGHT);
	}

}
