package naves;

import java.awt.Rectangle;
import javax.swing.ImageIcon;

import disparos.DisparoEnemigo;
import disparos.DisparoPenetrante;
import disparos.DisparoSimple;
import disparos.DisparoTriple;
import disparos.FabricaDisparos;
import juego.GameObject;
import juego.Nave;
import obstaculos.Obstaculo;
import power_ups.PowerUp;
import utilidades.Constantes;

public final class NaveAliada extends Nave {

	public static final int DERECHA = 1, IZQUIERDA = -1, STOPDER = 2, STOPIZQ = -2;

	public NaveAliada(int x, int y, int vida, int durabilidad, int alcance, int dmg, int velocidad, FabricaDisparos fab) {
		super(x, y, vida, durabilidad, alcance, dmg, velocidad, fab);
	}

	@Override
	protected Rectangle createRectangle(int x, int y) {
		return new Rectangle(x, y, Constantes.NAVE_ALIADA_WIDTH, Constantes.NAVE_ALIADA_HEIGHT);
	}

	@Override
	public void aplicarPowerUp(PowerUp p) {

	}

	@Override
	public String getName() {
		return "Aliado";
	}

	@Override
	public void mover() {
	}

	@Override
	public ImageIcon getGrafico() {
		return new ImageIcon("src/resources/NaveAliada.png");
	}

	@Override
	public void colision(NaveEnemiga naveEnemiga) {
		//System.out.println("Colision de nave aliada con naveEnemiga");
		naveEnemiga.recibirDano(this.getVida() / 10);;
	}

	@Override
	public void colision(PowerUp powerUp) {
		powerUp.efecto();
	}

	@Override
	public void colision(GameObject obs) {
		obs.colision(this);
	}

	public void mover(int d) { // Ignoramos STOPIZQ Y STOPDER pues se dejan de mover
		int nuevoX = (int) rec.getLocation().getX();
		switch (d) {
		case DERECHA:
			if (rec.getLocation().getX() < Constantes.MAP_WIDTH - Constantes.NAVE_ALIADA_WIDTH)
				nuevoX += Constantes.NAVE_ALIADA_VELOCIDAD;
			break;
		case IZQUIERDA:
			if (rec.getLocation().getX() > 0)
				nuevoX -= Constantes.NAVE_ALIADA_VELOCIDAD;
			break;
		}

		rec.setLocation(nuevoX, (int) rec.getY());
		this.setLocation((int) rec.getX(), (int) rec.getY());
		repaint();
	}

	@Override
	public void colision(DisparoEnemigo disparo) {
		disparo.eliminar();
	}

	@Override
	public void colision(NaveAliada naveAliada) {
		// TODO Auto-generated method stub
	}

	@Override
	public void colision(Obstaculo obs) {
		// TODO Auto-generated method stub
	}

	@Override
	public void colision(DisparoPenetrante disparo) {
		// TODO Auto-generated method stub
	}

	@Override
	public void colision(DisparoSimple disparo) {
		// TODO Auto-generated method stub
	}

	@Override
	public void colision(DisparoTriple disparo) {
		// TODO Auto-generated method stub
	}
}
