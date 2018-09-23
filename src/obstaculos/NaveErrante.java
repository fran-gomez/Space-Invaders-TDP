package obstaculos;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import disparos.Disparo;
import disparos.DisparoEnemigo;
import disparos.DisparoPenetrante;
import disparos.DisparoSimple;
import disparos.DisparoTriple;
import juego.BarraVida;
import naves.NaveAliada;
import power_ups.PowerUp;
import utilidades.Constantes;
import utilidades.FormateadorDeImagen;

public class NaveErrante extends Obstaculo {

	private JLabel partesObstaculo[][];
	private int alto, ancho;
	private int count;

	public NaveErrante(int x, int y, int vida, int durabilidad, int d) {
		super(x, y, vida, durabilidad, d);
	}

	@Override
	protected void setImage() {
		this.setOpaque(false);

		// Cantidad de bloques
		ancho = 5;
		alto = 4;

		JPanel cuerpoAux = new JPanel();
		cuerpoAux.setLayout(new GridLayout(alto, ancho));

		cuerpoAux = new JPanel();
		cuerpoAux.setLayout(new GridLayout(alto, ancho));
		cuerpoAux.setOpaque(false);

		partesObstaculo = new JLabel[alto][ancho];
		count = alto * ancho;
		JLabel parte;
		for (int i = 0; i < alto; i++) {
			for (int j = 0; j < ancho; j++) {
				parte = new JLabel();
				parte.setSize(Constantes.NAVEERRANTE_WIDTH / alto, Constantes.NAVEERRANTE_HEIGHT / ancho);
				parte.setPreferredSize(
						new Dimension(Constantes.NAVEERRANTE_WIDTH / alto, Constantes.NAVEERRANTE_HEIGHT / ancho));
				partesObstaculo[i][j] = parte;
				parte.setOpaque(true);
				parte.setBackground(Color.YELLOW);
				cuerpoAux.add(parte);
			}
		}
		vidaLabel = new BarraVida(10);
		cuerpo = cuerpoAux;
		this.add(cuerpo);
	}

	@Override
	public String getName() {
		return "NaveErrante";
	}

	@Override
	public void mover() {
	}

	@Override
	public ImageIcon getGrafico() {
		return null;
	}

	@Override
	protected Rectangle createRectangle(int x, int y) {
		return new Rectangle(x, y, Constantes.NAVEERRANTE_WIDTH, Constantes.NAVEERRANTE_HEIGHT);
	}

	@Override
	public void colision(NaveAliada naveAliada) {
	}

	@Override
	public void colision(Obstaculo obs) {
	}

	@Override
	public void colision(PowerUp powerUp) {
	}

	@Override
	public void colision(DisparoPenetrante disparo) {
	}

	@Override
	public void colision(DisparoEnemigo disparo) {
		daniar(disparo);
	}

	private void daniar(Disparo disparo) {
		int dist = (int) (disparo.getRectangle().getX() - rec.x);
		int pos = (int) (dist / (rec.width / alto));

		while (pos >= ancho)
			pos--;

		boolean encontro = false;
		for (int i = 0; i < ancho && !encontro; i++) {
			if (partesObstaculo[i][pos].isVisible()) {
				partesObstaculo[i][pos].setVisible(false);
				encontro = true;
			}
		}
		if (encontro) {
			disparo.eliminar();
		}
	}

	@Override
	public boolean estaVivo() {
		return count > 0;
	}

	@Override
	public void colision(DisparoSimple disparo) {
	}

	@Override
	public void colision(DisparoTriple disparo) {
	}

}
