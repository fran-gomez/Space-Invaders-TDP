package naves;

import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

import Inteligencias.Inteligencia;
import juego.Agregable;
import power_ups.PowerUp;
import utilidades.Constantes;

public final class ShapeShifter extends NaveEnemiga {

	public ShapeShifter(int x, int y, int lvl, Inteligencia intel, Agregable mapa) {
		this(x, y, 0, 0, 0, 0, 0, intel, mapa);
		setearEstadisticas(lvl);
	}

	public ShapeShifter(int x, int y, int vida, int durabilidad, int alcance, int dmg, int velocidad,
			Inteligencia intel, Agregable mapa) {
		super(x, y, vida, durabilidad, alcance, dmg, velocidad, intel, mapa);
		puntos = 20;
	}

	@Override
	protected Rectangle createRectangle(int x, int y) {
		return new Rectangle(x, y, Constantes.SHAPESHIFTER_WIDTH, Constantes.SHAPESHIFTER_HEIGHT);
	}

	@Override
	public void aplicarPowerUp(PowerUp p) {
	}

	@Override
	public String getName() {
		return "Shapeshifter";
	}

	@Override
	public ImageIcon getGrafico() {
		int r = (new Random()).nextInt(14);
		return new ImageIcon("src/resources/Enemigo" + (r + 1) + ".png");
	}

	@Override
	public void colision(NaveEnemiga naveEnemiga) {
	}

	@Override
	public void colision(PowerUp powerUp) {
	}

	@Override
	public NaveEnemiga clone() {
		return new ShapeShifter(rec.x, rec.y, getVida(), getDurabilidad(), getAlcance(),
				getDmg(), getVelocidad(), this.inteligencia, mapa);
	}

	@Override
	protected void setearEstadisticas(int lvl) {
		this.vida = Constantes.SHAPESHIFTER_VIDA + lvl;
		this.durabilidad = 10 + lvl;
		this.alcance = 10 + lvl;
		this.dmg = 20 + lvl;
		this.velocidad = 10 + (lvl / 2);
	}

}
