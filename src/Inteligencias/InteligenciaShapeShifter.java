package Inteligencias;

import java.awt.Rectangle;
import java.util.HashMap;
import naves.NaveEnemiga;
import utilidades.Constantes;

public class InteligenciaShapeShifter extends Inteligencia {

	private static InteligenciaShapeShifter intelDefecto;

	private static boolean movDer, movAbajo;
	private static HashMap<NaveEnemiga, Boolean> mapMover;

	private InteligenciaShapeShifter() {
		super();
		intelDefecto = null;
		movDer = true;
		mapMover = new HashMap<NaveEnemiga, Boolean>();
		movAbajo = false;
	}

	@Override
	public void actualizarPosicion(NaveEnemiga nave) {
		super.actualizarPosicion(nave);
		Rectangle rec = nave.getRectangle();
		int newX = rec.x, newY = rec.y;
		if (movDer) {
			if (movAbajo && mapMover.get(nave) != null) {
				movAbajo = false;
				mapMover = new HashMap<NaveEnemiga, Boolean>();
			}
			if (rec.getX() <= Constantes.MAP_WIDTH - Constantes.DEFAULT_SIZE) { // Se puede seguir moviendo a la derecha
				newX = rec.x + Constantes.NAVE_ALEATORIA_VELOCIDAD;
			} else {
				movDer = false;
			}
			if (movAbajo) {
				newY = rec.y + Constantes.NAVE_ALEATORIA_VELOCIDAD*3;
				mapMover.put(nave, true);
			}
		} else {
			if (rec.getX() >= 0) { // Se puede seguir moviendo a la izquierda
				newX = rec.x - Constantes.NAVE_ALEATORIA_VELOCIDAD;
			} else {
				movDer = true;
				movAbajo = true;
			}
		}

		nave.cambiarUbicacion(newX, newY);
		
		if(nave.getVida() < nave.getVidaTotal() * 0.5) {
			nave.setInteligencia(InteligenciaAleatoria.getInstance());
		}
	}

	public static InteligenciaShapeShifter getInstance() {
		if (intelDefecto == null) {
			intelDefecto = new InteligenciaShapeShifter();
		}
		return intelDefecto;
	}

}
