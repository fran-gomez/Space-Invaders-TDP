package disparos;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import naves.NaveAliada;
import naves.NaveEnemiga;
import obstaculos.Obstaculo;
import power_ups.PowerUp;
import utilidades.Constantes;

public final class DisparoTriple extends Disparo {
	
	public DisparoTriple(int x, int y, int vida, int durabilidad, int dmg) {
		super(x, y, vida, durabilidad, dmg);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void mover() {
		rec.setLocation(rec.x, rec.y - Constantes.DISPARO_TRIPLE_VELOCIDAD);
		setLocation((int) rec.getX(), (int) rec.getY());
		super.mover();
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
	
	@Override
	protected Rectangle createRectangle(int x, int y) {
		return new Rectangle(x,y, Constantes.DISPARO_TRIPLE_WIDTH, Constantes.DISPARO_TRIPLE_HEIGHT);
	}

}
