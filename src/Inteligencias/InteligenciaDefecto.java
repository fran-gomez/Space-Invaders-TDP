package Inteligencias;

import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Random;

import naves.NaveEnemiga;
import utilidades.Constantes;

public class InteligenciaDefecto extends Inteligencia {

	private static InteligenciaDefecto intelDefecto;

	private static boolean movDer, movAbajo;
	private static Random rnd;

	private static HashMap<NaveEnemiga, Boolean> mapMover;

	private InteligenciaDefecto() {
		intelDefecto = null;
		movDer = true;
		rnd = new Random();
		mapMover = new HashMap<NaveEnemiga, Boolean>();
		movAbajo = false;
	}

	@Override
	public void actualizarPosicion(NaveEnemiga nave) {
		super.actualizarPosicion(nave);
		Rectangle rec = nave.getRectangle();

		if (movDer) {
			if (movAbajo && mapMover.get(nave) != null) {
				movAbajo = false;
				mapMover = new HashMap<NaveEnemiga, Boolean>();
			}
			if (rec.getX() <= Constantes.MAP_WIDTH - Constantes.DEFAULT_SIZE) { // Se puede seguir moviendo a la derecha
				rec.setLocation((int) rec.getX() + Constantes.NAVE_ALEATORIA_VELOCIDAD, (int) rec.getY());
			} else {
				movDer = false;
			}
			if (movAbajo) {
				rec.setLocation((int) rec.getX(), (int) rec.getY() + Constantes.NAVE_ALEATORIA_VELOCIDAD * 5);
				mapMover.put(nave, true);
			}
		} else {
			if (rec.getX() >= 0) { // Se puede seguir moviendo a la izquierda
				rec.setLocation((int) rec.getX() - Constantes.NAVE_ALEATORIA_VELOCIDAD, (int) rec.getY());
			} else {
				movDer = true;
				movAbajo = true;
			}
		}

		nave.setLocation((int) rec.getX(), (int) rec.getY());
	}

	public static InteligenciaDefecto getInstance() {
		if (intelDefecto == null) {
			intelDefecto = new InteligenciaDefecto();
		}
		return intelDefecto;
	}

}
