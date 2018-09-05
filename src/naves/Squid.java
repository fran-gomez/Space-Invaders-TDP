package naves;

import javax.swing.ImageIcon;

import juego.GameObject;
import power_ups.PowerUp;
import utilidades.Constantes;
import utilidades.Recuadro;

public final class Squid extends NaveEnemiga {

	public Squid(int x, int y, int vida, int durabilidad, int alcance, int dmg, int velocidad, Inteligencia intel) {
		super(x,y, vida, durabilidad, alcance, dmg, velocidad, intel);
		// TODO Auto-generated constructor stub
		visual = new ImageIcon("src/naves/Squid.jpg");
		this.setIcon(visual);
		this.setText(null);
	}

	@Override
	protected Recuadro createRectangle(int x, int y) {
		return new Recuadro(x,y,Constantes.SQUID_WIDTH, Constantes.SQUID_HEIGHT);
	}

	@Override
	public void disparar() {
	
	}

	@Override
	public void aplicarPowerUp(PowerUp p) {
	
	}


	public String getName() {
		return "Squid";
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
