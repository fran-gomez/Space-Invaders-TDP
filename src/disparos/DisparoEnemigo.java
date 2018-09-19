package disparos;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import juego.GameObject;
import naves.NaveAliada;
import naves.NaveEnemiga;
import obstaculos.Obstaculo;
import power_ups.PowerUp;
import utilidades.Constantes;

public final class DisparoEnemigo extends Disparo {
	
	public DisparoEnemigo(int x, int y, int vida, int durabilidad, int dmg) {
		super(x, y, vida, durabilidad, dmg);
	}

	public void mover() {
		rec.setLocation(rec.x, rec.y + Constantes.DISPARO_ENEMIGO_VELOCIDAD);
		setLocation((int) rec.getX(), (int) rec.getY());
		super.mover();
	}

	public ImageIcon getGrafico() {
		return new ImageIcon("src/resources/Disparo.png");
	}

	public void colision(GameObject obs) {
		obs.colision(this);
	}

	public void colision(NaveAliada naveAliada) {
		naveAliada.recibirDano(this.dmg);
	}

	public void colision(NaveEnemiga naveEnemiga) {
	}

	public void colision(Obstaculo obs) {
	}

	public void colision(PowerUp powerUp) {
	}

	public void colision(DisparoPenetrante disparo) {
	}

	public void colision(DisparoEnemigo disparo) {
	}

	public void colision(DisparoSimple disparo) {
	}

	public void colision(DisparoTriple disparo) {
	}
	
	protected Rectangle createRectangle(int x, int y) {
		return new Rectangle(x,y, Constantes.DISPARO_ENEMIGO_WIDTH, Constantes.DISPARO_ENEMIGO_HEIGHT);
	}
}
