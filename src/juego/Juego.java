package juego;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Juego {

	public static void main(String[] args) {

		JFrame ventana = new JFrame();
		Tablero t = new Tablero(2, ventana);
		ventana.setLayout(new FlowLayout());
		ventana.add(t);

		ventana.setTitle("Space Invaders");
		ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		ventana.pack();
		ventana.setVisible(true);
	}
}
