package Inteligencias;

import java.awt.Rectangle;
import java.util.Random;

import naves.NaveEnemiga;
import utilidades.Constantes;

public abstract class Inteligencia {
	
	protected Random rnd;

	public Inteligencia() {
		rnd = new Random();
	}
	
	public void actualizarPosicion(NaveEnemiga g) {
		Rectangle rec = g.getRectangle();
		
		if (rec.getY() > Constantes.MAP_HEIGHT) {
			rec.setLocation(rnd.nextInt(Constantes.MAP_WIDTH), 0);
		}
	}
}
