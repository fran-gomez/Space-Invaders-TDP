package utilidades;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

/**
 * JLabel para representar la vida de un gameObject
 * 
 * @author ezequiel
 *
 */
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

	@Override
	public void paint(Graphics g) {
		int porcentaje = vida * 100 / vidaTotal;
		
		g.setColor(Color.green);
		g.fillRect(0, 0, porcentaje * this.getWidth() / 100, 5); 
		// dibujamos la vida en funcion del porcentaje de la vida actual con respecto al total
	}

}
