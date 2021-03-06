package disparos;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import juego.Agregable;
import juego.GameObject;
import naves.NaveAliada;
import naves.NaveEnemiga;
import obstaculos.Obstaculo;
import power_ups.PowerUp;
import utilidades.Constantes;

public final class DisparoTriple extends DisparoAliado {

	protected DisparoSimple proyectiles[];

	public DisparoTriple(int x, int y, int vida, int dmg, Agregable mapa) {
		super(x, y, vida, dmg, mapa);

		proyectiles = new DisparoSimple[3];
		proyectiles[0] = new DisparoSimple(x + 10, y, vida, dmg, mapa);
		proyectiles[1] = new DisparoSimple(x, y, vida, dmg, mapa);
		proyectiles[2] = new DisparoSimple(x - 10, y, vida, dmg, mapa);
	}

	@Override
	public void mover() {
		for (int i = 0; i < 3; i++)
			proyectiles[i].mover();

	}

	@Override
	public ImageIcon getGrafico() {
		return new ImageIcon("src/resources/Disparo.png");
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
		return new Rectangle(x, y, Constantes.DISPARO_TRIPLE_WIDTH, Constantes.DISPARO_TRIPLE_HEIGHT);
	}

	@Override
	public void colision(GameObject obs) {
		obs.colision(this);
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
