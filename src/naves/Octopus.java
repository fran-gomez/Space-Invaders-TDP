package naves;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import Inteligencias.Inteligencia;
import disparos.FabricaDisparos;
import juego.NaveState;
import power_ups.PowerUp;
import utilidades.Constantes;

public final class Octopus extends NaveEnemiga {

	public Octopus(int x, int y, int lvl, Inteligencia intel, FabricaDisparos fab) {
		this(x, y, 0, 0, 0, 0, 0, intel, fab);
		setearEstadisticas(lvl);
	}
	
	public Octopus(int x, int y, int vida, int durabilidad, int alcance, int dmg, int velocidad, Inteligencia intel, FabricaDisparos fab) {
		super(x, y, vida, durabilidad, alcance, dmg, velocidad, intel, fab);
	}

	@Override
	protected Rectangle createRectangle(int x, int y) {
		return new Rectangle(x, y, Constantes.OCTOPUS_WIDTH, Constantes.OCTOPUS_HEIGHT);
	}


	@Override
	public void aplicarPowerUp(PowerUp p) {

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
		return new Octopus(rec.x, rec.y, state.getVida(), state.getDurabilidad(), state.getAlcance(), state.getDmg(),
				state.getVelocidad(), this.inteligencia, this.arma);
	}

	@Override
	protected void setearEstadisticas(int lvl) {
		int vida = 100 + lvl;
		int durabilidad = 10 + lvl;
		int alcance = 10 + lvl;
		int dmg = 20 + lvl;
		int velocidad = 10 + (lvl/2);
		this.state = new NaveState(vida, durabilidad, alcance, dmg, velocidad);
	}
}
