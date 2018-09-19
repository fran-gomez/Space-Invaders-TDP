package disparos;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import juego.GameObject;
import naves.NaveAliada;
import naves.NaveEnemiga;
import obstaculos.Obstaculo;
import power_ups.PowerUp;
import utilidades.Constantes;

public final class DisparoPenetrante extends DisparoAliado {

	public DisparoPenetrante(int x, int y, int vida, int durabilidad, int dmg) {
		super(x, y, vida, durabilidad, dmg);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mover() {
		rec.setLocation(rec.x, rec.y - Constantes.DISPARO_PENETRANTE_VELOCIDAD);
		setLocation((int) rec.getX(), (int) rec.getY());
		
		super.mover();
	}

	@Override
	public ImageIcon getGrafico() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void colision(GameObject obs) {
		obs.colision(this);
	}
	@Override
	public void colision(NaveEnemiga naveEnemiga) {
		naveEnemiga.recibirDano(dmg);
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
	protected Rectangle createRectangle(int x, int y) {
		return new Rectangle(x, y, Constantes.DISPARO_PENETRANTE_WIDTH, Constantes.DISPARO_PENETRANTE_HEIGHT);
	}

	@Override
	public void colision(DisparoPenetrante disparo) {
	}

	@Override
	public void colision(DisparoEnemigo disparo) {
	}

	@Override
	public void colision(DisparoSimple disparo) {
	}

	@Override
	public void colision(DisparoTriple disparo) {
	}
}
