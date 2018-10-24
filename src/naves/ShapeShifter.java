package naves;

import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

import Inteligencias.Inteligencia;
import disparos.FabricaDisparos;
import juego.Agregable;
import juego.NaveState;
import power_ups.FabricaPowerUp;
import power_ups.PowerUp;
import utilidades.Constantes;

public final class ShapeShifter extends NaveEnemiga {

	public ShapeShifter(int x, int y, int lvl, Inteligencia intel, Agregable mapa) {
		this(x, y, 0, 0, 0, 0, 0, intel, mapa);
		setearEstadisticas(lvl);
	}
	
	public ShapeShifter(int x, int y, int vida, int durabilidad, int alcance, int dmg, int velocidad, Inteligencia intel, Agregable mapa) {
		super(x, y, vida, durabilidad, alcance, dmg, velocidad, intel,mapa);

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
		return new ImageIcon("src/resources/Enemigo" + (r+1) + ".png");
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
	public NaveEnemiga clone() {
		return new ShapeShifter(rec.x, rec.y, state.getVida(), state.getDurabilidad(), state.getAlcance(), state.getDmg(),
				state.getVelocidad(), this.inteligencia, mapa);
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
