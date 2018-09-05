package power_ups;

import juego.GameObject;
import utilidades.Constantes;
import utilidades.Recuadro;

public class LenteDeAmplificacion extends PowerUp {

	public LenteDeAmplificacion(int x, int y, int vida, int durabilidad) {
		super(x,y, vida, durabilidad);
		
	}
	
	@Override
	protected Recuadro createRectangle(int x, int y) {
		return new Recuadro(x,y, Constantes.LENTEDEAMPLIFICACION_WIDTH, Constantes.LENTEDEAMPLIFICACION_HEIGHT);
	}

	@Override
	public void borrar() {
	}

	@Override
	public void colision(GameObject o1) {
	}

	@Override
	public void mover() {
	}

	 

}
