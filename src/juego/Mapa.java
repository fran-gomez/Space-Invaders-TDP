package juego;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;

import javax.swing.JPanel;

import naves.Crab;
import naves.NaveAliada;
import naves.NaveEnemiga;
import naves.Octopus;
import naves.ShapeShifter;
import naves.Squid;
import naves.UFO;
import obstaculos.Asteroide;
import obstaculos.NaveErrante;
import utilidades.Constantes;
import utilidades.Recuadro;

public class Mapa extends JPanel {

	private NaveAliada jugador;

	protected int dificultad;
	protected List<GameObject> objetos;

	protected Random rnd;

	public Mapa(int dificultad) {

		this.setLayout(null);
		this.setSize(Constantes.MAP_WIDTH, Constantes.MAP_HEIGHT);
		this.setPreferredSize(new Dimension(Constantes.MAP_WIDTH, Constantes.MAP_HEIGHT));
		this.setBackground(Color.BLACK);

		int areaAliensH = Constantes.MAP_HEIGHT / 3;
		int areaAliensW = Constantes.MAP_WIDTH;
		int cuadradoAlienW = areaAliensW / Constantes.ENEMIGOS_X_FILA;
		int cuadradoAlienH = areaAliensH / Constantes.CANT_FILAS_ENEMIGOS;

		// utils
		rnd = new Random();
		objetos = new LinkedList<>();

		// Creacion y adicion de los enemigos
		NaveEnemiga enemigo = null;
		int x, y;

		for (int f = 0; f < Constantes.CANT_FILAS_ENEMIGOS; f++) {
			for (int c = 0; c < Constantes.ENEMIGOS_X_FILA; c++) {
				x = c * cuadradoAlienW + cuadradoAlienW / 2;
				y = f * cuadradoAlienH + cuadradoAlienH / 2;
				enemigo = naveAleatoria(x, y);
				this.add(enemigo);
				objetos.add(enemigo);
			}
		}

		// Colocamos la nave del jugador
		jugador = new NaveAliada(
				new Recuadro(Constantes.MAP_WIDTH / 2, Constantes.MAP_HEIGHT - Constantes.PLAYER_HEIGHT,
						Constantes.PLAYER_WIDTH, Constantes.PLAYER_HEIGHT),
				Constantes.NAVE_ALIADA_VIDA, Constantes.NAVE_ALIADA_DURABILIDAD, Constantes.NAVE_ALIADA_ALCANCE,
				Constantes.NAVE_ALIADA_DANIO, Constantes.NAVE_ALIADA_DURABILIDAD);
		this.add(jugador);
		objetos.add(jugador);

		// Colocamos dos obstaculos
	}

	private void gameLoop() {
		// Movimiento de los objetos del mapa
		for (GameObject obj : objetos) {
			obj.mover();
		}

		// Deteccion de colisiones
		for (int i = 0; i < objetos.size(); i++) {
			for (int j = i + 1; j < objetos.size(); j++) {
				GameObject obj1 = objetos.get(i);
				GameObject obj2 = objetos.get(j);

				if (intersects(obj1, obj2)) {
					obj1.colision(obj2);
					obj2.colision(obj1);
				}
			}
		}
	}

	private boolean intersects(GameObject o1, GameObject o2) {
		return o1.getRectangle().intersects(o2.getRectangle());
	}

	private NaveEnemiga naveAleatoria(int x, int y) {

		NaveEnemiga n;
		int rand = rnd.nextInt(7);

		// TODO Corregir todos los parametros de creacion
		switch (rand) {
		case 0:
			n = new Octopus(new Recuadro(x, y, Constantes.OCTOPUS_WIDTH, Constantes.OCTOPUS_HEIGHT), rand, rand, rand,
					rand, rand);
			break;
		case 1:
			n = new Squid(new Recuadro(x, y, Constantes.SQUID_WIDTH, Constantes.SQUID_HEIGHT), rand, rand, rand, rand,
					rand);
			break;
		case 2:
			n = new ShapeShifter(new Recuadro(x, y, Constantes.SHAPESHIFTER_WIDTH, Constantes.SHAPESHIFTER_HEIGHT),
					rand, rand, rand, rand, rand);
			break;
		case 3:
			n = new UFO(new Recuadro(x, y, Constantes.UFO_WIDTH, Constantes.UFO_HEIGHT), rand, rand, rand, rand, rand);
			break;
		default:
			n = new Crab(new Recuadro(x, y, Constantes.CRAB_WIDTH, Constantes.CRAB_HEIGHT), rand, rand, rand, rand,
					rand);
			break;
		}

		return n;
	}

}
