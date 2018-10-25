package naves;

import java.util.Random;

import Inteligencias.Inteligencia;
import disparos.DisparoEnemigo;
import disparos.DisparoPenetrante;
import disparos.DisparoSimple;
import disparos.DisparoTriple;
import disparos.FabricaDisparoEnemigo;
import juego.Agregable;
import juego.GameObject;
import obstaculos.Obstaculo;
import power_ups.FabricaAleatoria;
import power_ups.FabricaPowerUp;
import power_ups.PowerUp;

public abstract class NaveEnemiga extends Nave {

	protected Inteligencia inteligencia;
	protected FabricaPowerUp powerUp;

	public NaveEnemiga(int x, int y, int vida, int durabilidad, int alcance, int dmg, int velocidad,
			Inteligencia inteligencia, Agregable mapa) {
		super(x, y, vida, durabilidad, alcance, dmg, velocidad, mapa);
		this.inteligencia = inteligencia;
		powerUp = new FabricaAleatoria(mapa);
		arma = new FabricaDisparoEnemigo(mapa);
	}

	@Override
	public void mover() {
		inteligencia.actualizarPosicion(this);

		// DISPARO RANDOM
		Random rnd = new Random();
		if (rnd.nextInt(100) == 0) {
			disparar();
		}
	}

	@Override
	public void eliminar() {
		// TODO Auto-generated method stub
		powerUp.crearPowerUp(rec.x, rec.y);
		super.eliminar();
	}

	public Inteligencia obtenerInteligencia() {
		return inteligencia;
	}

	public void inteligencia(Inteligencia i) {
		this.inteligencia = i;
	}

	@Override
	public void colision(GameObject obs) {
		obs.colision(this);
	}

	@Override
	public void colision(NaveAliada na) {
		recibirDano(this.getVida() / 20);
	}

	@Override
	public void colision(DisparoSimple disparo) {
		disparo.eliminar();
	}

	@Override
	public void colision(DisparoTriple disparo) {
		disparo.eliminar();
	}

	@Override
	public void colision(DisparoPenetrante disparo) {
	}

	@Override
	public void colision(NaveEnemiga naveEnemiga) {
	}

	@Override
	public void colision(PowerUp powerUp) {
	}

	@Override
	public void colision(Obstaculo obs) {
		// se saltea el obstaculo
		cambiarUbicacion(rec.x, (float) (rec.y + obs.getRectangle().getHeight()));
	}

	@Override
	public void colision(DisparoEnemigo disparo) {
	}

	@Override
	public abstract NaveEnemiga clone();

}
