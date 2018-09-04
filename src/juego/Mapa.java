package juego;

import java.awt.GridLayout;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
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

public class Mapa extends JPanel {

	private NaveAliada jugador;

	protected int dificultad;
	protected Celda[][] tablaJuego;
	protected Collection<GameObject> objetos;

	protected Random rnd;

	public Mapa(int dificultad) {

		NaveEnemiga enemigo = null;
		int areaAliensH = 1000;
		int areaAliensW = 1000;
		int cuadradoAlienW = areaAliensW / Constantes.ENEMIGOS_X_FILA;
		int cuadradoAlienH = areaAliensH / Constantes.CANT_FILAS_ENEMIGOS;

		// utils
		rnd = new Random();
		objetos = new LinkedList<>();
		
		// Creacion y adicion de los enemigos
		for (int f = 0; f < Constantes.CANT_FILAS_ENEMIGOS; f++)
			for (int c = 0; c < Constantes.ENEMIGOS_X_FILA; c++) {
				enemigo = naveAleatoria(new Punto(c*cuadradoAlienW + cuadradoAlienW / 2,
						f*cuadradoAlienH + cuadradoAlienH / 2));
				this.add(enemigo);
				objetos.add(enemigo);
			}
		
		// Colocamos la nave del jugador
		NaveAliada jugador = new NaveAliada(new Punto(0,0), 0, 0, 0, 0, 0);
		this.add(jugador);
		objetos.add(jugador);
		
		// Colocamos dos obstaculos
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
