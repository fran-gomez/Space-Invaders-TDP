package power_ups;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import juego.GameObject;
import utilidades.Constantes;

public class ParenElReloj extends PowerUp {

	public ParenElReloj(int x, int y, int vida, int durabilidad) {
		super(x,y, vida, durabilidad);
		
	}
	
	@Override
	protected Rectangle createRectangle(int x, int y) {
		return new Rectangle(x,y, Constantes.PARENELRELOJ_WIDTH, Constantes.PARENELRELOJ_HEIGHT);
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

 

}
