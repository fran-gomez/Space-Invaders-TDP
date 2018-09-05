package naves;

import javax.swing.ImageIcon;

import juego.GameObject;
import power_ups.PowerUp;
import utilidades.Constantes;
import utilidades.Recuadro;

public final class UFO extends NaveEnemiga {

	public UFO(int x, int y, int vida, int durabilidad, int alcance, int dmg, int velocidad) {
		super(x,y, vida, durabilidad, alcance, dmg, velocidad);
		// TODO Auto-generated constructor stub
		visual = new ImageIcon("src/naves/UFO.jpg");
		this.setIcon(visual);
		this.setText(null);
	}

	@Override
	protected Recuadro createRectangle(int x, int y) {
		return new Recuadro(x,y,Constantes.UFO_WIDTH, Constantes.UFO_HEIGHT);
	}

	@Override
	public void disparar() {
	
	}

	@Override
	public void aplicarPowerUp(PowerUp p) {
	
	}


	public String getName() {
		return "UFO";
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
