package naves;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import juego.GameObject;
import power_ups.PowerUp;
import utilidades.Constantes;
import utilidades.Recuadro;

public final class Crab extends NaveEnemiga {

	public Crab(int x, int y, int vida, int durabilidad, int alcance, int dmg, int velocidad) {
		super(x,y, vida, durabilidad, alcance, dmg, velocidad);
		// TODO Auto-generated constructor stub
		visual = new ImageIcon("src/naves/Crab.jpg");
		this.setIcon(visual);
		this.setText(null);
	}

	@Override
	protected Recuadro createRectangle(int x, int y) {
		return new Recuadro(x,y,Constantes.CRAB_WIDTH, Constantes.CRAB_HEIGHT);
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
		this.setIcon(visual);
		return "Crab";
	}

	@Override
	public void colision(GameObject o1) {
	}

	@Override
	public void mover() {
	}
}
