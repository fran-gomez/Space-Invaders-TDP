package power_ups;

import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

import disparos.DisparoEnemigo;
import disparos.DisparoPenetrante;
import disparos.DisparoSimple;
import disparos.DisparoTriple;
import naves.NaveAliada;
import naves.NaveEnemiga;
import obstaculos.Obstaculo;
import utilidades.Constantes;

public class AuroraBoreal extends PowerUp {

	private int valorEscudo;
	
	public AuroraBoreal(int x, int y, int vida, int durabilidad) {
		super(x, y, vida, durabilidad);
		valorEscudo = (new Random()).nextInt(20);
	}

	@Override
	protected Rectangle createRectangle(int x, int y) {
		return new Rectangle(x, y, Constantes.BARRERADEDIAMANTIUM_WIDTH, Constantes.APARATOCATASTROFICO_HEIGHT);
	}

	@Override
	public ImageIcon getGrafico() {
		return new ImageIcon("src/resources/auroraBoreal.png");
	}

	@Override
	public void colision(NaveEnemiga naveEnemiga) {
	}

	@Override
	public void colision(NaveAliada naveEnemiga) {
		naveEnemiga.setEscudo(valorEscudo);
		System.out.println("(AB) Colisione con nave aliada");
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
