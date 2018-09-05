package utilidades;

public final class Recuadro {

	private int x, y; // Coordenadas del centro (x, y)
	private int alto, ancho; // Alto y ancho del recuadro
	
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


	public Recuadro(int x, int y, int alto, int ancho) {
		this.x = x;
		this.y = y;
		this.alto = alto;
		this.ancho = ancho;
	}

	
	public boolean intersects(Recuadro r) {
		
		return (r.x == this.x && r.y == this.y) ||
				(r.x >= this.x - this.ancho/2 && r.y <= this.y + this.alto/2) ||
				(r.x <= this.x + this.ancho/2 && r.y <= this.y + this.alto/2) ||
				(r.x >= this.x + this.ancho/2 && r.y >= this.y + this.alto/2) ||
				(r.x <= this.x + this.ancho/2 && r.y >= this.y - this.alto/2);		
	}
}
