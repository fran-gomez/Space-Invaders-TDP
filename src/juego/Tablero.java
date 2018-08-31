package juego;

import javax.swing.JPanel;

public class Tablero extends JPanel {

	protected Grilla g;
	//protected JPanel puntos;
	//protected JPanel otroPanel;
	
	public Tablero() {
		g = new Grilla(2);
		
		this.add(g);
	}
}
