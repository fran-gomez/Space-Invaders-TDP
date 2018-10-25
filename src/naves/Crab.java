package naves;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import Inteligencias.Inteligencia;
import juego.Agregable;
import juego.NaveState;
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
		return new Crab(rec.x, rec.y, state.getVida(), state.getDurabilidad(), state.getAlcance(), state.getDmg(),
				state.getVelocidad(), this.inteligencia, mapa);
	}

	protected void setearEstadisticas(int lvl) {
		int vida = 100 + lvl;
		int durabilidad = 10 + lvl;
		int alcance = 10 + lvl;
		int dmg = 20 + lvl;
		int velocidad = 10 + (lvl / 2);
		this.state = new NaveState(vida, durabilidad, alcance, dmg, velocidad);
	}
}
