package Inteligencias;

import java.awt.Rectangle;

import naves.NaveAliada;
import naves.NaveEnemiga;
import utilidades.Constantes;

public class InteligenciaKamikaze extends Inteligencia {

	private static InteligenciaKamikaze intel;
	private static NaveAliada jugador;

	private InteligenciaKamikaze() {
		intel = null;
	}

	@Override
	public void actualizarPosicion(NaveEnemiga nave) {
		super.actualizarPosicion(nave);
		Rectangle rec = nave.getRectangle();
		
		int newX = (int) rec.getX(), newY = (int) (rec.getY() + Constantes.NAVE_ALEATORIA_VELOCIDAD);
		if(jugador.getRectangle().getX() - rec.getX() > 0) { // El jugador está a la derecha 
			newX += Constantes.NAVE_ALEATORIA_VELOCIDAD;
		}else { // el jugador está a la izquierda
			newX -= Constantes.NAVE_ALEATORIA_VELOCIDAD;
		}
		
		rec.setLocation(newX, newY);
		nave.setBounds(rec);
	}

	public static InteligenciaKamikaze getInstance(NaveAliada j) {
		if (intel == null) {
			jugador = j;
			intel = new InteligenciaKamikaze();
		}
		return intel;
	}

}
