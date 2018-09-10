package naves;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import Inteligencias.Inteligencia;
import disparos.Disparo;
import power_ups.PowerUp;
import utilidades.Constantes;

public final class ShapeShifter extends NaveEnemiga {

	public ShapeShifter(int x, int y, int vida, int durabilidad, int alcance, int dmg, int velocidad,
			Inteligencia intel) {
		super(x, y, vida, durabilidad, alcance, dmg, velocidad, intel);
	}

	@Override
	protected Rectangle createRectangle(int x, int y) {
		return new Rectangle(x, y, Constantes.SHAPESHIFTER_WIDTH, Constantes.SHAPESHIFTER_HEIGHT);
	}

	@Override
	public void disparar() {
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
		return new ImageIcon("src/resources/Shapeshifter.png");
	}

	@Override
	public void colision(NaveEnemiga naveEnemiga) {
		// TODO Auto-generated method stub

	}

	@Override
	public void colision(PowerUp powerUp) {
		// TODO Auto-generated method stub

	}

	@Override
	public void colision(Disparo disparo) {
		// TODO Auto-generated method stub

	}
}
