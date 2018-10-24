package disparos;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import juego.GameObject;
import naves.NaveAliada;
import naves.NaveEnemiga;
import obstaculos.Nimbus;
import obstaculos.Obstaculo;
import power_ups.PowerUp;
import utilidades.Constantes;

public final class DisparoEnemigo extends Disparo {
	
	public DisparoEnemigo(int x, int y, int vida, int durabilidad, int dmg) {
		super(x, y, vida, durabilidad, dmg);
	}

	@Override
	public void mover() {
		rec.setLocation(rec.x, rec.y + Constantes.DISPARO_ENEMIGO_VELOCIDAD);
		setLocation((int) rec.getX(), (int) rec.getY());
		super.mover();
	}

	@Override
	public ImageIcon getGrafico() {
		return new ImageIcon("src/resources/Disparo.png");
	}

	@Override
	public void colision(GameObject obs) {
		obs.colision(this);
	}

	@Override
	public void colision(NaveAliada naveAliada) {
		naveAliada.recibirDano(this.dmg);
	}

	@Override
	public void colision(NaveEnemiga naveEnemiga) {
	}

	@Override
	public void colision(Obstaculo obs) {
	}

	@Override
	public void colision(PowerUp powerUp) {
	}

	@Override
	public void colision(DisparoPenetrante disparo) {
	}

	@Override
	public void colision(DisparoEnemigo disparo) {
	}

	@Override
	public void colision(DisparoSimple disparo) {
		disparo.eliminar();
	}

	@Override
	public void colision(DisparoTriple disparo) {
	}
	
	public void coliion(Nimbus n) {
		n.colision(this);
	}
	
	@Override
	protected Rectangle createRectangle(int x, int y) {
		return new Rectangle(x,y, Constantes.DISPARO_ENEMIGO_WIDTH, Constantes.DISPARO_ENEMIGO_HEIGHT);
	}
}
