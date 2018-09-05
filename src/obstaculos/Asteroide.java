package obstaculos;

import juego.GameObject;
import utilidades.Recuadro;

public class Asteroide extends Obstaculo {

	public Asteroide(Recuadro posicion, int vida, int durabilidad) {
		super(posicion, vida, durabilidad);

	}



	public String getName() {
		return "Asteroide";
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
