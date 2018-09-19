package naves;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import Inteligencias.Inteligencia;
import disparos.FabricaDisparos;
import power_ups.PowerUp;
import utilidades.Constantes;

public final class Squid extends NaveEnemiga {

	public Squid(int x, int y, int vida, int durabilidad, int alcance, int dmg, int velocidad, Inteligencia intel, FabricaDisparos fab) {
		super(x, y, vida, durabilidad, alcance, dmg, velocidad, intel, fab);
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
		return new ImageIcon("src/resources/Squid.png");
	}

	@Override
	public void colision(NaveEnemiga naveEnemiga) {
	}

	@Override
	public void colision(PowerUp powerUp) {
	}



}
