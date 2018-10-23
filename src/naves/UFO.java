package naves;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import Inteligencias.Inteligencia;
import disparos.FabricaDisparos;
import juego.NaveState;
import power_ups.FabricaPowerUp;
import power_ups.PowerUp;
import utilidades.Constantes;

public final class UFO extends NaveEnemiga {
	
	public UFO(int x, int y, int lvl, Inteligencia intel, FabricaDisparos fab, FabricaPowerUp pu) {
		this(x, y, 0, 0, 0, 0, 0, intel, fab, pu);
		setearEstadisticas(lvl);
	}

	public UFO(int x, int y, int vida, int durabilidad, int alcance, int dmg, int velocidad, Inteligencia intel, FabricaDisparos fab, FabricaPowerUp pu) {
		super(x, y, vida, durabilidad, alcance, dmg, velocidad, intel, fab, pu);
	}

	@Override
	protected Rectangle createRectangle(int x, int y) {
		return new Rectangle(x, y, Constantes.UFO_WIDTH, Constantes.UFO_HEIGHT);
	}

	@Override
	public void aplicarPowerUp(PowerUp p) {

	}

	@Override
	public String getName() {
		return "UFO";
	}

	@Override
	public ImageIcon getGrafico() {
		return new ImageIcon("src/resources/Enemigo9.png");
	}

	@Override
	public void colision(NaveEnemiga naveEnemiga) {
	}

	@Override
	public void colision(PowerUp powerUp) {
	}

	@Override
	public NaveEnemiga clone() {
		return new UFO(rec.x, rec.y, state.getVida(), state.getDurabilidad(), state.getAlcance(), state.getDmg(),
				state.getVelocidad(), this.inteligencia, this.arma, powerUp);
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
