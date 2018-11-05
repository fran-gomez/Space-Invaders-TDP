package juego;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

public class BarraVida extends JLabel {

	protected int vida, vidaTotal;

	/**
	 * Constructor de la clase
	 * 
	 * @param v vida Total
	 */
	public BarraVida(int vT) {
		this.vidaTotal = vT;
		this.vida = vidaTotal;
	}

	/**
	 * setea la vida del gameObject para asi representarla;
	 * 
	 * @param v porcentaje de vida
	 */
	public void setVida(int v) {
		this.vida = v;
		repaint();
	}

	public int getVidaTotal() {
		return vidaTotal;
	}

	@Override
	public void paint(Graphics g) {
		int porcentaje;

		if (vidaTotal != 0)
			porcentaje = vida * 100 / vidaTotal;
		else
			porcentaje = 0;
		
		g.setColor(Color.green);
		g.fillRect(0, 0, porcentaje * this.getWidth() / 100, GameObject.BARRA_VIDA_HEIGHT);
	}

}
