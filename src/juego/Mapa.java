package juego;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;
import Inteligencias.InteligenciaAleatoria;
import Inteligencias.InteligenciaDefecto;
import Inteligencias.InteligenciaKamikaze;
import disparos.FabricaEnemigo;
import disparos.FabricaSimple;
import naves.Crab;
import naves.NaveAliada;
import naves.NaveEnemiga;
import naves.Octopus;
import naves.ShapeShifter;
import naves.Squid;
import naves.UFO;
import obstaculos.Asteroide;
import obstaculos.NaveErrante;
import obstaculos.Obstaculo;
import utilidades.Constantes;

public class Mapa extends JPanel {

	private NaveAliada jugador;

	protected int dificultad;
	protected List<GameObject> objetos, toAdd;

	protected Random rnd;

	public Mapa(int dificultad) {

		this.setLayout(null);
		this.setSize(Constantes.MAP_WIDTH, Constantes.MAP_HEIGHT);
		this.setPreferredSize(new Dimension(Constantes.MAP_WIDTH, Constantes.MAP_HEIGHT));
		this.setBackground(Color.BLACK);
		// this.drawImage(new ImageIcon("src/resources/mapa_bg.jpg"),0 ,0 ,null);

		// utils
		rnd = new Random();
		objetos = new LinkedList<>();
		toAdd = new LinkedList<>();

		// Colocamos la nave del jugador
		jugador = new NaveAliada(Constantes.MAP_WIDTH / 2,
				Constantes.MAP_HEIGHT - (Constantes.NAVE_ALIADA_HEIGHT + GameObject.BARRA_VIDA_HEIGHT + 10) / 2,
				Constantes.NAVE_ALIADA_VIDA, Constantes.NAVE_ALIADA_DURABILIDAD, Constantes.NAVE_ALIADA_ALCANCE,
				Constantes.NAVE_ALIADA_DANIO, Constantes.NAVE_ALIADA_DURABILIDAD, new FabricaSimple(this));
		this.add(jugador);
		objetos.add(jugador);

		// Creacion y adicion de los enemigos
		NaveEnemiga enemigo = null;
		int x, y;
		int areaAliensH = Constantes.MAP_HEIGHT / 3;
		int areaAliensW = Constantes.MAP_WIDTH;
		int cuadradoAlienW = areaAliensW / Constantes.ENEMIGOS_X_FILA;
		int cuadradoAlienH = areaAliensH / Constantes.CANT_FILAS_ENEMIGOS;

		for (int f = 0; f < Constantes.CANT_FILAS_ENEMIGOS; f++) {
			for (int c = 0; c < Constantes.ENEMIGOS_X_FILA; c++) {
				x = c * cuadradoAlienW + cuadradoAlienW / 2;
				y = f * cuadradoAlienH + cuadradoAlienH / 2;
				enemigo = naveAleatoria(x, y);
				this.add(enemigo);
				objetos.add(enemigo);
			}
		}

		// Colocamos dos obstaculos
		Obstaculo obs1 = new NaveErrante(rnd.nextInt(Constantes.MAP_WIDTH), Constantes.MAP_HEIGHT * 2 / 3, 10, 0, 5);
		Obstaculo obs2 = new Asteroide(rnd.nextInt(Constantes.MAP_WIDTH), Constantes.MAP_HEIGHT * 2 / 3, 10, 0, 5);

		while (intersects(obs1, obs2)) {
			obs2 = new Asteroide(rnd.nextInt(Constantes.MAP_WIDTH), Constantes.MAP_HEIGHT * 2 / 3, 0, 0, 5);
		}

		this.add(obs1);
		this.add(obs2);
		objetos.add(obs1);
		objetos.add(obs2);
	}

	public void gameLoop() {
		// Movimiento de objetos
		Iterator<GameObject> it = objetos.iterator();
		while (it.hasNext()) {
			GameObject obj = it.next();
			obj.mover();
		}

		// Deteccion de colisiones
		GameObject obj1, obj2;
		for (int i = 0; i < objetos.size(); i++) {
			obj1 = objetos.get(i);

			for (int j = i + 1; j < objetos.size(); j++) {
				obj2 = objetos.get(j);

				if (intersects(obj1, obj2)) {
					obj1.colision(obj2);
					obj2.colision(obj1);
				}

				if (!obj2.estaVivo()) {
					obj2.eliminar();
					objetos.remove(obj2);
				}

			}
			if (!obj1.estaVivo()) {
				obj1.eliminar();
				objetos.remove(obj1);
			}
		}
		
		//Para evitar el concurrentModificationException
		objetos.addAll(toAdd);
		toAdd.clear();
	}

	public NaveAliada obtenerJugador() {
		return jugador;
	}

	public void terminarJuego() {
		for (GameObject go : objetos)
			go.eliminar();

		this.setBackground(Color.red);

	}
	
	public boolean estaVacio() {
		return objetos.isEmpty();
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
			n = new Octopus(x, y, 100, rand, rand, 20, rand, InteligenciaDefecto.getInstance(), new FabricaEnemigo(this));
			break;
		case 1:
			n = new Squid(x, y, 100, rand, rand, 20, rand, InteligenciaKamikaze.getInstance(jugador), new FabricaEnemigo(this));
			break;
		case 2:
			n = new ShapeShifter(x, y, 100, rand, rand, 20, rand, InteligenciaAleatoria.getInstance(), new FabricaEnemigo(this));
			break;
		case 3:
			n = new UFO(x, y, 100, rand, rand, 20, rand, InteligenciaDefecto.getInstance(), new FabricaEnemigo(this));
			break;
		default:
			n = new Crab(x, y, 100, rand, rand, 20, rand, InteligenciaDefecto.getInstance(), new FabricaEnemigo(this));
			break;
		}

		return n;
	}

	public void addToObjects(GameObject o) {
		this.add(o);
		toAdd.add(o);
	}
}
