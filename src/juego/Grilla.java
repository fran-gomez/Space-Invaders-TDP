package juego;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class Grilla extends JPanel {

	protected int dificultad;
	protected Celda[][] tablaJuego;
	
	public Grilla(int dificultad) {
		boolean agregar = true;
		
		this.setLayout(new GridLayout(15, 20));
		this.dificultad = dificultad;
		tablaJuego = new Celda[15][20];
		
		// Se crea un tablero vacio
		for (int f = 0; f < 15; f++) {
			for (int c = 0; c < 20; c++) {
				tablaJuego[f][c] = new Celda();
				this.add(tablaJuego[f][c], f, c);
			}
		}
		// Agregamos la nave del jugador
		//tablaJuego[15][10].setObjeto(new NaveAliada());
		
		// Agregamos los obstaculos
		//tablaJuego[10][Random.nextInt(20)].setObjeto(new ObstaculoConcreto())
		//tablaJuego[10][Random.nextInt(20)].setObjeto(new ObstaculoConcreto())
	}
}
