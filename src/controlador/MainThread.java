package controlador;

import juego.Mapa;

public class MainThread extends Thread {

	private Mapa mapa;
	private boolean ejecutar;

	public MainThread(Mapa m) {
		this.mapa = m;
		ejecutar = true;
	}

	@Override
	public void run() {
		long lastTime = System.nanoTime();
		double fps = 30.0; ////////////////// FPS
		double ns = 1000000000 / fps;
		double delta = 0;

		while (ejecutar) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				mapa.gameLoop();
				delta--;
			}

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			mapa.repaint();
			
			if (mapa.obtenerJugador().getVida() <= 0) {
				System.out.println("Perdiste capo."); // Termino el juego
				mapa.terminarJuego();
				ejecutar = false;
				//this.interrupt();
			}
			
			if (mapa.estaVacio()) {
				System.out.println("Ganaste papa!");
				mapa.terminarJuego();
				ejecutar = false;
			}
				
		}
	}

	public void pausar() {
		ejecutar = false;
	}

	public void reiniciar() {
		ejecutar = true;
	}
}
