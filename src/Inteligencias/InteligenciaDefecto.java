package Inteligencias;

import java.awt.Rectangle;

import naves.NaveEnemiga;
import utilidades.Constantes;

public class InteligenciaDefecto extends Inteligencia {

	private static InteligenciaDefecto intelDefecto;

	private static boolean movDer;

	private InteligenciaDefecto() {
		intelDefecto = null;
		movDer = true;
	}

	@Override
	public void actualizarPosicion(NaveEnemiga nave) {
		Rectangle rec = nave.getRectangle();
		
		if(movDer) {
			if(rec.getX() <= Constantes.MAP_WIDTH - Constantes.DEFAULT_SIZE) { // Se puede seguir moviendo a la derecha
				rec.setLocation((int)rec.getX() + 4, (int) rec.getY());
			}else {
				movDer = false;
			}
		}else {
			if(rec.getX() >= 0) { // Se puede seguir moviendo a la izquierda
				rec.setLocation((int)rec.getX() - 4, (int) rec.getY());
			}else {
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
