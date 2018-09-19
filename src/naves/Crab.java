package naves;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import Inteligencias.Inteligencia;
import disparos.DisparoEnemigo;
import disparos.FabricaDisparos;
import obstaculos.Obstaculo;
import power_ups.PowerUp;
import utilidades.Constantes;

public final class Crab extends NaveEnemiga {

	public Crab(int x, int y, int vida, int durabilidad, int alcance, int dmg, int velocidad, Inteligencia intel, FabricaDisparos fab) {
		super(x, y, vida, durabilidad, alcance, dmg, velocidad, intel, fab);
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
		return new ImageIcon("src/resources/Crab.png");
	}
}
