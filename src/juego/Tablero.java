package juego;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import controlador.PlayerThread;
import controlador.MainThread;

public class Tablero extends JPanel {

	protected Mapa mapa;

	protected Juego juego;
	// protected long puntos;
	protected MainThread mainThread;
	protected PlayerThread jugadorThread;

	public Tablero(int dificultad, Juego juego) {
		this.juego = juego;
		mapa = new Mapa(dificultad, juego);

		mainThread = new MainThread(mapa);
		jugadorThread = new PlayerThread(mapa.obtenerJugador());

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(mapa);
	}

	public void startThreads() {
		mainThread.start();
		jugadorThread.start();
	}

	public void killThreads() {
		jugadorThread.interrupt();
		mainThread.interrupt();
	}
}