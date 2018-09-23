package naves;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import Inteligencias.Inteligencia;
import disparos.FabricaDisparos;
import power_ups.PowerUp;
import utilidades.Constantes;

public final class ShapeShifter extends NaveEnemiga {

	public ShapeShifter(int x, int y, int vida, int durabilidad, int alcance, int dmg, int velocidad, Inteligencia intel, FabricaDisparos fab) {
		super(x, y, vida, durabilidad, alcance, dmg, velocidad, intel, fab);

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
	public NaveEnemiga clone() {
		return new ShapeShifter(rec.x, rec.y, state.getVida(), state.getDurabilidad(), state.getAlcance(), state.getDmg(),
				state.getVelocidad(), this.inteligencia, this.arma);
	}


}
