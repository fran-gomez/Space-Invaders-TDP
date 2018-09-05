package obstaculos;

import juego.GameObject;
import utilidades.Recuadro;

public class NaveErrante extends Obstaculo {

	public NaveErrante(Recuadro posicion, int vida, int durabilidad) {
		super(posicion, vida, durabilidad);
	
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

}
