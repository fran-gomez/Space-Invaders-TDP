package naves;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import Inteligencias.Inteligencia;
import juego.Agregable;
import power_ups.PowerUp;
import utilidades.Constantes;

public final class Octopus extends NaveEnemiga {

	public Octopus(int x, int y, int lvl, Inteligencia intel, Agregable mapa) {
		this(x, y, 0, 0, 0, intel, mapa);
		setearEstadisticas(lvl);
	}

	public Octopus(int x, int y, int vida, int dmg, int velocidad, Inteligencia intel,
			Agregable mapa) {
		super(x, y, vida, dmg, velocidad, intel, mapa);
		puntos = 15;
	}

	@Override
	protected Rectangle createRectangle(int x, int y) {
		return new Rectangle(x, y, Constantes.OCTOPUS_WIDTH, Constantes.OCTOPUS_HEIGHT);
	}

	@Override
	public void aplicarPowerUp(PowerUp p) {

	}

	@Override
	public void mover() {
		super.mover();
		if (getVida() < getVidaTotal() * 0.8) {
			this.arma = null;
		}
	}

	@Override
	public String getName() {
		return "Octopus";
	}

	@Override
	public ImageIcon getGrafico() {
		return new ImageIcon("src/resources/Enemigo12.png");
	}

	@Override
	public void colision(NaveEnemiga naveEnemiga) {
	}

	@Override
	public void colision(PowerUp powerUp) {
	}

	@Override
	public NaveEnemiga clone() {
		return new Octopus(rec.x, rec.y, getVida(), getDmg(),
				getVelocidad(), this.inteligencia, mapa);
	}

	@Override
	protected void setearEstadisticas(int lvl) {
		this.vida = Constantes.OCTOPUS_VIDA + lvl;
		this.dmg = 20 + lvl;
		this.velocidad = 10 + (lvl / 2);
	}
}
