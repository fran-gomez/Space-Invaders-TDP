package utilidades;

public final class Recuadro {

	private int x, y; // Coordenadas del centro (x, y)
	private int alto, ancho; // Alto y ancho del recuadro

	public Recuadro(int x, int y, int alto, int ancho) {
		this.x = x;
		this.y = y;
		this.alto = alto;
		this.ancho = ancho;
	}

	public int x() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int y() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public boolean intersects(Recuadro r) {
		int topLeftX = r.x - r.ancho / 2, topLeftY = r.y - r.alto / 2;
		int topRightX = r.x + r.ancho / 2, topRightY = r.y - r.alto / 2;
		int botLeftX = r.x - r.ancho / 2, botLeftY = r.y + r.alto / 2;
		int botRightX = r.x + r.ancho / 2, botRightY = r.y + r.alto / 2;

		return contienePunto(topLeftX, topLeftY) || contienePunto(topRightX, topRightY)
				|| contienePunto(botLeftX, botLeftY) || contienePunto(botRightX, botRightY);
	}

	private boolean contienePunto(int x, int y) {
		return x <= this.x + this.ancho / 2 && x >= this.x - this.ancho / 2 && y >= this.y - this.alto / 2
				&& y <= y + this.alto / 2;
	}
}
