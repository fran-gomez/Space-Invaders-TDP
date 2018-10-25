package obstaculos;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import disparos.DisparoEnemigo;
import disparos.DisparoPenetrante;
import disparos.DisparoSimple;
import disparos.DisparoTriple;
import juego.Agregable;
import naves.NaveAliada;
import naves.NaveEnemiga;
import power_ups.PowerUp;
import utilidades.Constantes;

public class Nimbus extends Obstaculo {

	public Nimbus(int x, int y, int vida, int durabilidad, int d, Agregable mapa) {
		super(x, y, vida, durabilidad, d, mapa);
		// TODO Auto-generated constructor stub
		if (mapa == null)
			System.err.println("Fuck it");
	}

	@Override
	public void mover() {
	}

	@Override
	public ImageIcon getGrafico() {
		return new ImageIcon("src/resources/nimbus.png");
	}

	@Override
	protected Rectangle createRectangle(int x, int y) {
		return new Rectangle(x, y, Constantes.ASTEROIDE_WIDTH*2, Constantes.ASTEROIDE_HEIGHT*2);
	}

	@Override
	public void colision(NaveEnemiga naveEnemiga) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void colision(NaveAliada naveAliada) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void colision(Obstaculo obs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void colision(PowerUp powerUp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void colision(DisparoPenetrante disparo) {
		// TODO Auto-generated method stub
	}

	@Override
	public void colision(DisparoEnemigo disparo) {
		this.setVida(this.getVida() - disparo.getDmg());
		disparo.eliminar();
	}

	@Override
	public void colision(DisparoSimple disparo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void colision(DisparoTriple disparo) {
		// TODO Auto-generated method stub
		
	}
}
