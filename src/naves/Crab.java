package naves;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import Inteligencias.Inteligencia;
import juego.Agregable;
import power_ups.PowerUp;
import utilidades.Constantes;

public final class Crab extends NaveEnemiga {

	public Crab(int x, int y, int lvl, Inteligencia intel, Agregable mapa) {
		this(x, y, 0, 0, 0, 0, 0, intel, mapa);
		setearEstadisticas(lvl);
	}

	public Crab(int x, int y, int vida, int durabilidad, int alcance, int dmg, int velocidad, Inteligencia intel,
			Agregable mapa) {
		super(x, y, vida, durabilidad, alcance, dmg, velocidad, intel, mapa);
		puntos = 10;
	}

	@Override
	protected Rectangle createRectangle(int x, int y) {
		return new Rectangle(x, y, Constantes.CRAB_WIDTH, Constantes.CRAB_HEIGHT);
	}

	@Override
	public void aplicarPowerUp(PowerUp p) {

	}

	@Override
	public String getName() {
		return "Crab";
	}

	@Override
	public ImageIcon getGrafico() {
		return new ImageIcon("src/resources/Enemigo10.png");
	}

	@Override
	public NaveEnemiga clone() {
		return new Crab(rec.x, rec.y, getVida(), getDurabilidad(), getAlcance(), getDmg(),
				getVelocidad(), this.inteligencia, mapa);
	}

	@Override
	protected void setearEstadisticas(int lvl) {
		this.vida = Constantes.CRAB_VIDA + lvl;
		this.durabilidad = 10 + lvl;
		this.alcance = 10 + lvl;
		this.dmg = 20 + lvl;
		this.velocidad = 10 + (lvl / 2);
	}
}
