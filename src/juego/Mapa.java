package juego;

import java.awt.Color;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controlador.GeneradorEnemigos;
import controlador.GeneradorEnemigosNivel;
import disparos.FabricaSimple;
import disparos.FabricaTriple;
import naves.NaveAliada;
import obstaculos.Asteroide;
import obstaculos.NaveErrante;
import obstaculos.Nimbus;
import obstaculos.Obstaculo;
import power_ups.PowerUp;
import utilidades.Constantes;

public class Mapa extends JPanel implements Agregable {

	private NaveAliada jugador;

	protected int dificultad;
	protected List<GameObject> objetos, toAdd;
	protected GeneradorEnemigos generadorEnemigos;
	protected boolean estaJugando;
	protected Random rnd;
	protected Juego juego;

	protected Colisionador c;

	public Mapa(int dificultad, Juego juego) {
		this.juego = juego;
		this.setLayout(null);
		this.setSize(Constantes.MAP_WIDTH, Constantes.MAP_HEIGHT);
		this.setPreferredSize(new Dimension(Constantes.MAP_WIDTH, Constantes.MAP_HEIGHT));
		this.setBackground(Color.BLACK);

		// utils
		rnd = new Random();
		objetos = new LinkedList<>();
		toAdd = new LinkedList<>();
		this.dificultad = dificultad;
		c = new Colisionador(objetos, toAdd);
		inicializarMapa();
	}

	public int dificultad() {
		return dificultad;
	}

	protected void inicializarMapa() {
		estaJugando = true;

		// Colocamos la nave del jugador
		jugador = new NaveAliada(Constantes.MAP_WIDTH / 2,
				Constantes.MAP_HEIGHT - (Constantes.NAVE_ALIADA_HEIGHT + GameObject.BARRA_VIDA_HEIGHT + 10) / 2,
				Constantes.NAVE_ALIADA_VIDA, Constantes.NAVE_ALIADA_DURABILIDAD, Constantes.NAVE_ALIADA_ALCANCE,
				Constantes.NAVE_ALIADA_DANIO, Constantes.NAVE_ALIADA_DURABILIDAD, this);
		this.add(jugador);
		objetos.add(jugador);

		armarNivel();
	}

	public void gameLoop() {
		// Movimiento de objetos
		Iterator<GameObject> it = objetos.iterator();
		while (it.hasNext()) {
			GameObject obj = it.next();
			obj.mover();
		}
		c.colisionar();

		// Iniciar nuevo nivel una vez eliminados todos los enemigos
		if (estaVacio()) {
			++dificultad;
			actualizarNivelCompletado();
			armarNivel();
		}
	}

	private void actualizarNivelCompletado() {
		try {
			File file = new File("nivelesCompletados");
			int lastLevel = 0;
			if (file.isFile()) {
				BufferedReader reader = new BufferedReader(new FileReader(file));

				String line = reader.readLine();

				if (line != null && line.length() > 0) {
					lastLevel = Integer.parseInt(line);
				}
				reader.close();
			}

			BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
			writer.write("" + (lastLevel + 1));
			writer.close();

		} catch (IOException e) {

		}
	}

	public void armarNivel() {
		generadorEnemigos = new GeneradorEnemigosNivel(this);
		generadorEnemigos.generarNavesEnemigas();

		// Colocamos dos obstaculos
		Obstaculo obs1 = new Nimbus(rnd.nextInt(Constantes.MAP_WIDTH), Constantes.MAP_HEIGHT * 2 / 3, 100, 0, 20, this);
		Obstaculo obs2 = new Asteroide(rnd.nextInt(Constantes.MAP_WIDTH), Constantes.MAP_HEIGHT * 2 / 3, 100, 0, 20,
				this);

		while (intersects(obs1, obs2)) {
			obs2 = new Asteroide(rnd.nextInt(Constantes.MAP_WIDTH), Constantes.MAP_HEIGHT * 2 / 3, 0, 0, 5, this);
		}

		this.add(obs1);
		this.add(obs2);
		objetos.add(obs1);
		objetos.add(obs2);
	}

	public NaveAliada obtenerJugador() {
		return jugador;
	}

	public void terminarJuego() {
		estaJugando = false;

		for (GameObject go : objetos)
			go.eliminar();

		this.add(new JLabel(new ImageIcon("src/resources/hipnosapo.png")));
		juego.startGUI();
	}

	public boolean estaVacio() {
		return objetos.size() == 1;
	}

	private boolean intersects(GameObject o1, GameObject o2) {
		return o1.getRectangle().intersects(o2.getRectangle());
	}

	public void addToObjects(GameObject o) {
		if (estaJugando) {
			this.add(o);
			toAdd.add(o);
		}
	}
}
