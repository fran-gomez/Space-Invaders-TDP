package juego;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

import naves.Crab;
import naves.Inteligencia;
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

	protected JFrame juego;
	protected int dificultad;
	protected List<GameObject> objetos;

	protected Random rnd;

	public Mapa(int dificultad, JFrame juego) {
		this.juego = juego;
		this.setLayout(null);
		juego.requestFocus();
		juego.setFocusable(true);
		this.setSize(Constantes.MAP_WIDTH, Constantes.MAP_HEIGHT);
		this.setPreferredSize(new Dimension(Constantes.MAP_WIDTH, Constantes.MAP_HEIGHT));
		this.setBackground(Color.BLACK);

		// utils
		rnd = new Random();
		objetos = new LinkedList<>();

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

		// Colocamos la nave del jugador
		jugador = new NaveAliada(Constantes.MAP_WIDTH / 2, Constantes.MAP_HEIGHT - Constantes.NAVE_ALIADA_HEIGHT / 2,
				Constantes.NAVE_ALIADA_VIDA, Constantes.NAVE_ALIADA_DURABILIDAD, Constantes.NAVE_ALIADA_ALCANCE,
				Constantes.NAVE_ALIADA_DANIO, Constantes.NAVE_ALIADA_DURABILIDAD);
		this.add(jugador);
		objetos.add(jugador);
		
		juego.addKeyListener(new PlayerMovementListener());

		// Colocamos dos obstaculos
		Obstaculo obs1 = new NaveErrante(rnd.nextInt(Constantes.MAP_WIDTH), Constantes.MAP_HEIGHT * 2 / 3, 0, 0);
		Obstaculo obs2 = new Asteroide(rnd.nextInt(Constantes.MAP_WIDTH), Constantes.MAP_HEIGHT * 2 / 3, 0, 0);
		
		while(intersects(obs1, obs2)) {
			obs2 = new Asteroide(rnd.nextInt(Constantes.MAP_WIDTH), Constantes.MAP_HEIGHT*2/3,0,0);
		}
		
		this.add(obs1);
		this.add(obs2);
		objetos.add(obs1);
		objetos.add(obs2);
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
			n = new Octopus(x, y, rand, rand, rand, rand, rand, new Inteligencia());
			break;
		case 1:
			n = new Squid(x, y, rand, rand, rand, rand, rand, new Inteligencia());
			break;
		case 2:
			n = new ShapeShifter(x, y, rand, rand, rand, rand, rand, new Inteligencia());
			break;
		case 3:
			n = new UFO(x, y, rand, rand, rand, rand, rand, new Inteligencia());
			break;
		default:
			n = new Crab(x, y, rand, rand, rand, rand, rand, new Inteligencia());
			break;
		}

		return n;
	}
	
	private class PlayerMovementListener implements KeyListener{

		@Override
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			switch(keyCode) {
			
			case KeyEvent.VK_RIGHT:
				jugador.mover(1);
				break;
				
			case KeyEvent.VK_LEFT:
				jugador.mover(-1);
				break;
				
			case KeyEvent.VK_UP:
			case KeyEvent.VK_SPACE:
				//TODO disparar
				break;
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}

		@Override
		public void keyTyped(KeyEvent e) {
		}
		
	}

}
