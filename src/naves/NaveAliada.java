package naves;
import juego.Nave;
import power_ups.PowerUp;
import utilidades.Punto;

public final class NaveAliada extends Nave {

	public NaveAliada(Punto posicion, int vida, int durabilidad, int alcance, int dmg, int velocidad) {
		super(posicion, vida, durabilidad, alcance, dmg, velocidad);
	}

	@Override
	public void disparar() {

	}

	@Override
	public void aplicarPowerUp(PowerUp p) {
	
	}

	@Override
	public void actualizarPosicion() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void colision() {
		// TODO Auto-generated method stub
		
	}

	public String getName() {
		return "Aliado";
	}
}
