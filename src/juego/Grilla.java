package juego;

import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JPanel;

import naves.NaveAliada;
import utilidades.Constantes;
import utilidades.Punto;

public class Grilla extends JPanel {

	private NaveAliada jugador;

	protected int dificultad;
	protected Celda[][] tablaJuego;

	private Random rnd;

	public Grilla(int dificultad) {
		
		//utils
		rnd = new Random();
		
		this.setLayout(new GridLayout(15, 20));
		this.dificultad = dificultad;
		tablaJuego = new Celda[15][20];
		
		boolean agregar = true;
		// Se crea un tablero vacio
		for (int f = 0; f < 15; f++) {
			for (int c = 0; c < 20; c++) {
				tablaJuego[f][c] = new Celda();
				this.add(tablaJuego[f][c], f, c);
				
				/*//inicializacion de enemigos
				if(agregar) {
					tablaJuego[f][c].setObjeto(new NaveEnemiga()); // debe ser "random"
					agregar = false;
				}else {
					agregar = true;
				}*/
			}
		}
		
		// Agregamos la nave del jugador
		jugador = new NaveAliada(new Punto(14,9), 
				Constantes.NAVE_ALIADA_VIDA,
				Constantes.NAVE_ALIADA_DURABILIDAD,
				Constantes.NAVE_ALIADA_ALCANCE,
				Constantes.NAVE_ALIADA_DAÑO,
				Constantes.NAVE_ALIADA_VELOCIDAD);
		
		tablaJuego[14][9].setObjeto(jugador);
		
		// Agregamos los obstaculos
		//tablaJuego[10][rnd.nextInt(20)].setObjeto(new ObstaculoConcreto());
		//tablaJuego[10][rnd.nextInt(20)].setObjeto(new ObstaculoConcreto());
	}
}
