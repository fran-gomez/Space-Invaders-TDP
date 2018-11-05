package naves;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import Inteligencias.Inteligencia;
import juego.Agregable;
import power_ups.PowerUp;
import utilidades.Constantes;

public final class Squid extends NaveEnemiga {

	public Squid(int x, int y, int lvl, Inteligencia intel, Agregable mapa) {
		this(x, y, 0, 0, 0, intel, mapa);
		setearEstadisticas(lvl);
	}

	public Squid(int x, int y, int vida, int dmg, int velocidad, Inteligencia intel,
			Agregable mapa) {
		super(x, y, vida, dmg, velocidad, intel, mapa);
		puntos = 20;
	}

	@Override
	protected Rectangle createRectangle(int x, int y) {
		return new Rectangle(x, y, Constantes.SQUID_WIDTH, Constantes.SQUID_HEIGHT);
	}

	@Override
	public void aplicarPowerUp(PowerUp p) {

	}

	@Override
	public String getName() {
		return "Squid";
	}

	@Override
	public ImageIcon getGrafico() {
		return new ImageIcon("src/resources/Enemigo13.png");
	}

	@Override
	public void colision(NaveEnemiga naveEnemiga) {
	}

	@Override
	public void colision(PowerUp powerUp) {
	}

	@Override
	public NaveEnemiga clone() {
		return new Squid(rec.x, rec.y, getVida(), getDmg(), getVelocidad(), this.inteligencia, mapa);
	}

	@Override
	protected void setearEstadisticas(int lvl) {
		this.vida = Constantes.SQUID_VIDA + lvl;
		this.dmg = 20 + lvl;
		this.velocidad = 10 + (lvl / 2);
	}

}
