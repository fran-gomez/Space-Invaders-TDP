package obstaculos;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import disparos.DisparoEnemigo;
import disparos.DisparoPenetrante;
import disparos.DisparoSimple;
import disparos.DisparoTriple;
import juego.Agregable;
import naves.NaveAliada;
import naves.NaveEnemiga;
import power_ups.PowerUp;
import utilidades.Constantes;

public class Asteroide extends Obstaculo {

	public Asteroide(int x, int y, int vida, int d, Agregable mapa) {
		super(x, y, vida, d, mapa);
	}

	@Override
	public String getName() {
		return "Asteroide";
	}

	@Override
	public void mover() {
	}

	@Override
	protected Rectangle createRectangle(int x, int y) {
		return new Rectangle(x, y, Constantes.ASTEROIDE_WIDTH, Constantes.ASTEROIDE_HEIGHT);
	}

	@Override
	public ImageIcon getGrafico() {
		return new ImageIcon("src/resources/asteroid.png");
	}

	@Override
	public void colision(NaveAliada naveAliada) {
	}

	@Override
	public void colision(Obstaculo obs) {
	}

	@Override
	public void colision(PowerUp powerUp) {
	}

	@Override
	public void colision(DisparoPenetrante disparo) {
		this.setVida(this.getVida() - disparo.getDmg());
		disparo.eliminar();
	}

	@Override
	public void colision(DisparoEnemigo disparo) {
	}

	@Override
	public void colision(NaveEnemiga ne) {
		ne.recibirDano(dmg);
	}

	@Override
	public void colision(DisparoSimple disparo) {
		this.setVida(this.getVida() - disparo.getDmg());
		disparo.eliminar();
	}

	@Override
	public void colision(DisparoTriple disparo) {
		this.setVida(this.getVida() - disparo.getDmg());
		disparo.eliminar();
	}

}
