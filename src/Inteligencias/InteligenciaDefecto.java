package Inteligencias;

import java.awt.Rectangle;
import java.util.Random;

import naves.NaveEnemiga;
import utilidades.Constantes;

public class InteligenciaDefecto extends Inteligencia {

	private static InteligenciaDefecto intelDefecto;

	private static boolean movDer;
	private static Random rnd;

	private InteligenciaDefecto() {
		intelDefecto = null;
		movDer = true;
		rnd = new Random();
		
	}

	@Override
	public void actualizarPosicion(NaveEnemiga nave) {
		super.actualizarPosicion(nave);
		Rectangle rec = nave.getRectangle();

		if (movDer) {
			if (rec.getX() <= Constantes.MAP_WIDTH - Constantes.DEFAULT_SIZE) { // Se puede seguir moviendo a la derecha
				rec.setLocation((int) rec.getX() + Constantes.NAVE_ALEATORIA_VELOCIDAD, (int) rec.getY());
			} else {
				movDer = false;
			}
		} else {
			if (rec.getX() >= 0) { // Se puede seguir moviendo a la izquierda
				rec.setLocation((int) rec.getX() - Constantes.NAVE_ALEATORIA_VELOCIDAD, (int) rec.getY());
			} else {
				movDer = true;
			}
		}

		nave.setBounds(rec);
	}

	public static InteligenciaDefecto getInstance() {
		if (intelDefecto == null) {
			intelDefecto = new InteligenciaDefecto();
		}
		return intelDefecto;
	}

}
