package juego;

import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;

import javax.swing.JPanel;

import naves.Crab;
import naves.NaveAliada;
import naves.NaveEnemiga;
import naves.Octopus;
import naves.Shapeshifter;
import naves.Squid;
import naves.UFO;
import obstaculos.Asteroide;
import obstaculos.NaveErrante;
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

		this.setLayout(new GridLayout(Constantes.JUEGO_CANT_FILAS, Constantes.JUEGO_CANT_COLUMNAS));
		this.dificultad = dificultad;
		this.setSize(Constantes.JUEGO_CANT_FILAS * Celda.ALTO_CELDA,
				Constantes.JUEGO_CANT_COLUMNAS * Celda.ANCHO_CELDA);
		tablaJuego = new Celda[Constantes.JUEGO_CANT_FILAS][Constantes.JUEGO_CANT_COLUMNAS];

		// Se crea un tablero vacio
		boolean agregar;
		for (int f = 0; f < Constantes.JUEGO_CANT_FILAS; f++) {
			agregar = true;
			for (int c = 0; c < Constantes.JUEGO_CANT_COLUMNAS; c++) {
				Celda celda = new Celda(
						new Punto(Constantes.JUEGO_CANT_FILAS - f - 1, c));
				tablaJuego[Constantes.JUEGO_CANT_FILAS - f - 1][c] = celda;
				this.add(celda, f, c);

				// inicializacion de enemigos
				if (f < Constantes.JUEGO_CANT_FILAS - 1 && f > 10 && c > 0 && c < Constantes.JUEGO_CANT_COLUMNAS - 1) {
					if (agregar) {
						celda.setObject(naveAleatoria(celda.getPunto()));
						agregar = false;
					} else {
						agregar = true;
					}
				}
			}
		}

		// Agregamos la nave del jugador
		jugador = new NaveAliada(tablaJuego[19][7].getPunto(), Constantes.NAVE_ALIADA_VIDA,
				Constantes.NAVE_ALIADA_DURABILIDAD, Constantes.NAVE_ALIADA_ALCANCE, Constantes.NAVE_ALIADA_DANIO,
				Constantes.NAVE_ALIADA_VELOCIDAD);

		tablaJuego[19][7].setObject(jugador);

		// Agregamos los obstaculos
		Celda celdaObs1 = tablaJuego[15][rnd.nextInt(15)];
		Celda celdaObs2 = tablaJuego[15][rnd.nextInt(15)];
		while (celdaObs2 == celdaObs1) {
			celdaObs2 = tablaJuego[15][rnd.nextInt(15)];
		}

		celdaObs1.setObject(new Asteroide(celdaObs1.getPunto(), 10, 10));
		celdaObs2.setObject(new NaveErrante(celdaObs2.getPunto(), 10, 10));
		System.out.println(celdaObs1.getPunto());
		System.out.println(celdaObs2.getPunto());
	}

	private NaveEnemiga naveAleatoria(Punto p) {

		NaveEnemiga n;
		int rand = rnd.nextInt(6);

		// TODO Corregir todos los parametros de creacion
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

	private void updateOjs() {
		GameObject obj;
		HashMap<Punto, Punto> hashMap = new HashMap<Punto, Punto>();
		for (int f = 0; f < Constantes.JUEGO_CANT_FILAS; f++) {
			for (int c = 0; c < Constantes.JUEGO_CANT_COLUMNAS; c++) {
				obj = tablaJuego[f][c].mover();

				if (obj != null && tablaJuego[f][c].getPunto() != obj.getPos()) { // Si el objeto actualizó su posición
																					// y no se quedó en la misma
					boolean movido = false;
					movido = mover(tablaJuego[f][c].getPunto(), obj.getPos());

					if (!movido) {
						hashMap.put(tablaJuego[f][c].getPunto(), obj.getPos());
					}
				}
			}
		}

		// Hash de Punto que tiene el objeto no movido en punto a destino
	}

	private boolean mover(Punto src, Punto dst) {
		boolean sePudo = false;
		Celda celdaSrc = tablaJuego[src.x()][src.y()];
		Celda celdaDst = tablaJuego[dst.x()][dst.y()];
		GameObject objSrc = celdaSrc.getObject();
		GameObject objDst = celdaDst.getObject();

		if (celdaDst.isEmpty()) {
			celdaDst.setObject(objSrc);
			celdaSrc.setObject(null);
			sePudo = true;
		}

		return sePudo;
	}
}
