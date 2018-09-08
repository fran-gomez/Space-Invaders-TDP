package Inteligencias;

import java.awt.Rectangle;

import naves.NaveEnemiga;
import utilidades.Constantes;

public abstract class Inteligencia {

	public void actualizarPosicion(NaveEnemiga nave) {

		Rectangle rec = nave.getRectangle();

		if (rec.getY() > Constantes.MAP_HEIGHT) {
			rec.setLocation((int) rec.getX(), 0);
		}

	}
}
