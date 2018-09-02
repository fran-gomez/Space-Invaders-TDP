package juego;

import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JPanel;

import naves.Crab;
import naves.NaveAliada;
import naves.NaveEnemiga;
import naves.Octopus;
import naves.Shapeshifter;
import naves.Squid;
import naves.UFO;
import utilidades.Constantes;
import utilidades.Punto;

public class Grilla extends JPanel {

	private NaveAliada jugador;

	protected int dificultad;
	protected Celda[][] tablaJuego;

	protected Random rnd;

	public Grilla(int dificultad) {

		// utils
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

				// inicializacion de enemigos
				if (agregar) {
					tablaJuego[f][c].setObject(naveAleatoria(new Punto(f, c)));
					agregar = false;
				} else {
					agregar = true;
				}
			}
		}

		// Agregamos la nave del jugador
		jugador = new NaveAliada(new Punto(14, 9),
				Constantes.NAVE_ALIADA_VIDA, 
				Constantes.NAVE_ALIADA_DURABILIDAD,
				Constantes.NAVE_ALIADA_ALCANCE,
				Constantes.NAVE_ALIADA_DANIO, 
				Constantes.NAVE_ALIADA_VELOCIDAD);

		tablaJuego[14][9].setObject(jugador);

		// Agregamos los obstaculos
		// tablaJuego[10][rnd.nextInt(20)].setObjeto(new ObstaculoConcreto());
		// tablaJuego[10][rnd.nextInt(20)].setObjeto(new ObstaculoConcreto());
	}

	private NaveEnemiga naveAleatoria(Punto p) {

		NaveEnemiga n;
		int rand = rnd.nextInt(6); // nextInt va desde 0(incluido) hasta el parámetro(excluido)

		// Corregir todos los parametros de creacion
		switch (rand) {
		case 0:
			n = new Octopus(p, rand, rand, rand, rand, rand);
			break;
		case 1:
			n = new Squid(p, rand, rand, rand, rand, rand);
			break;
		case 2:
			n = new Shapeshifter(p, rand, rand, rand, rand, rand);
			break;
		case 3:
			n = new UFO(p, rand, rand, rand, rand, rand);
			break;
		default:
			n = new Crab(p, rand, rand, rand, rand, rand);
			break;
		}

		return n;
	}

	private boolean mover(Punto src, Punto dst) {
		boolean sePudo = false;
		Celda celdaSrc = tablaJuego[src.x()][src.y()];
		Celda celdaDst = tablaJuego[dst.x()][dst.y()];
		if (celdaDst.getObject() == null) {
			sePudo = true;
			celdaDst.setObject(celdaSrc.getObject());
			celdaSrc.setObject(null);
		} else {
			// TODO colisiones
		}
		return sePudo;
	}

	private void mover(Celda c) {
		c.mover();
	}

	public boolean estaLibre(Punto p) {
		return tablaJuego[p.x()][p.y()].getObject() == null;
	}
}
