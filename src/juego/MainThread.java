package juego;

public class MainThread extends Thread {

	private Mapa mapa;
	private int tiempoPausa;

	public MainThread(Mapa m) {
		this.mapa = m;
		this.tiempoPausa = 16;
	}

	/*
	 * public void run() { while (true) { try { Thread.sleep(tiempoPausa); } catch
	 * (InterruptedException e) { e.printStackTrace(); } mapa.gameLoop(); } }
	 */

	public void run() {
		long lastTime = System.nanoTime();
		double fps = 30.0; ////////////////// FPS
		double ns = 1000000000 / fps;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (true) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				mapa.gameLoop();
				delta--;
			}
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frames = 0;
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			mapa.repaint();
		}
	}
}
