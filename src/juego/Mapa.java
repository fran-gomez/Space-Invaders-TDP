package juego;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;

import controlador.GeneradorEnemigos;
import controlador.GeneradorEnemigosNivel;
import disparos.FabricaTriple;
import naves.NaveAliada;
import obstaculos.Asteroide;
import obstaculos.NaveErrante;
import obstaculos.Obstaculo;
import utilidades.Constantes;

public class Mapa extends JPanel {

	private NaveAliada jugador;

	protected int dificultad;
	protected List<GameObject> objetos, toAdd;
	protected GeneradorEnemigos generadorEnemigos;

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
		this.dificultad = dificultad;
		
		inicializarMapa();
	}

	public int dificultad() {
		return dificultad;
	}
	protected void inicializarMapa() {
		// Colocamos la nave del jugador
		jugador = new NaveAliada(Constantes.MAP_WIDTH / 2,
				Constantes.MAP_HEIGHT - (Constantes.NAVE_ALIADA_HEIGHT + GameObject.BARRA_VIDA_HEIGHT + 10) / 2,
				Constantes.NAVE_ALIADA_VIDA, Constantes.NAVE_ALIADA_DURABILIDAD, Constantes.NAVE_ALIADA_ALCANCE,
				Constantes.NAVE_ALIADA_DANIO, Constantes.NAVE_ALIADA_DURABILIDAD, new FabricaTriple(this));
		this.add(jugador);
		objetos.add(jugador);

		// Creacion y adicion de los enemigos
		generadorEnemigos = new GeneradorEnemigosNivel(this);
		generadorEnemigos.generarNavesEnemigas();

		// Colocamos dos obstaculos
		Obstaculo obs1 = new NaveErrante(rnd.nextInt(Constantes.MAP_WIDTH), Constantes.MAP_HEIGHT * 2 / 3, 100, 0, 20);
		Obstaculo obs2 = new Asteroide(rnd.nextInt(Constantes.MAP_WIDTH), Constantes.MAP_HEIGHT * 2 / 3, 100, 0, 20);

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

		// Para evitar el concurrentModificationException
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
		return objetos.size() == 1;
	}

	private boolean intersects(GameObject o1, GameObject o2) {
		return o1.getRectangle().intersects(o2.getRectangle());
	}

	public void addToObjects(GameObject o) {
		this.add(o);
		toAdd.add(o);
	}
}
