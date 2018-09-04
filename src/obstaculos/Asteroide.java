package obstaculos;

import utilidades.Punto;

public class Asteroide extends Obstaculo {

	public Asteroide(Punto posicion, int vida, int durabilidad) {
		super(posicion, vida, durabilidad);

	}

	@Override
	public void actualizarPosicion() {

	}

	@Override
	public void borrar() {
	
	}

	@Override
	public void colision() {
	
	}

	public String getName() {
		return "Asteroide";
	}
	
}
