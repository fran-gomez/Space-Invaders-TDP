package obstaculos;

import juego.GameObject;
import utilidades.Constantes;
import utilidades.Recuadro;

public class NaveErrante extends Obstaculo {

	public NaveErrante(int x, int y, int vida, int durabilidad) {
		super(x,y, vida, durabilidad);
	
	}
	
	public String getName() {
		return "NaveErrante";
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

	@Override
	protected Recuadro createRectangle(int x, int y) {
		return new Recuadro(x,y, Constantes.NAVEERRANTE_WIDTH, Constantes.NAVEERRANTE_HEIGHT);
	}

}
