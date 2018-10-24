package naves;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import Inteligencias.Inteligencia;
import disparos.FabricaDisparos;
import juego.Agregable;
import juego.NaveState;
import power_ups.FabricaPowerUp;
import power_ups.PowerUp;
import utilidades.Constantes;

public final class Squid extends NaveEnemiga {

	public Squid(int x, int y, int lvl, Inteligencia intel, Agregable mapa) {
		this(x, y, 0, 0, 0, 0, 0, intel,mapa);
		setearEstadisticas(lvl);
	}
	
	public Squid(int x, int y, int vida, int durabilidad, int alcance, int dmg, int velocidad, Inteligencia intel, Agregable mapa) {
		super(x, y, vida, durabilidad, alcance, dmg, velocidad, intel, mapa);
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
		return new Squid(rec.x, rec.y, state.getVida(), state.getDurabilidad(), state.getAlcance(), state.getDmg(),
				state.getVelocidad(), this.inteligencia,mapa);
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
