package power_ups;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import disparos.DisparoEnemigo;
import disparos.DisparoPenetrante;
import disparos.DisparoSimple;
import disparos.DisparoTriple;
import juego.Agregable;
import naves.NaveAliada;
import naves.NaveEnemiga;
import obstaculos.Obstaculo;
import utilidades.Constantes;

public class Robot1X extends PowerUp {

	public Robot1X(int x, int y, int vida, int durabilidad, Agregable mapa) {
		super(x, y, vida, durabilidad, mapa);

	}

	@Override
	protected Rectangle createRectangle(int x, int y) {
		return new Rectangle(x, y, Constantes.ROBOT1X_WIDTH, Constantes.ROBOT1X_HEIGHT);
	}

	@Override
	public ImageIcon getGrafico() {
		return new ImageIcon("src/resources/Robot_1-X.png");
	}

	@Override
	public void colision(NaveEnemiga naveEnemiga) {
	}

	@Override
	public void colision(NaveAliada ne) {
		eliminar();
		int vidaActual = ne.getVida(); 
		ne.setVida(vidaActual + (vidaActual * 20 / 100));
		System.out.println("Cure a la nave aliada de" + vidaActual + " a " + ne.getVida());
	}


	@Override
	public void colision(Obstaculo naveEnemiga) {
	}

	@Override
	public void colision(PowerUp powerUp) {
	}

	@Override
	public void colision(DisparoPenetrante disparo) {
	}

	@Override
	public void colision(DisparoEnemigo disparo) {
	}

	@Override
	public void colision(DisparoSimple disparo) {
	}

	@Override
	public void colision(DisparoTriple disparo) {
	}

	@Override
	public void efecto() {
		// TODO Auto-generated method stub
		
	}

}
