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
	
	public boolean intersecta(Recuadro r) {
		return (r.x == this.x && r.y == this.y) ||
				(r.x >= this.x - this.ancho/2 && r.y <= this.y + this.alto/2) ||
				(r.x <= this.x + this.ancho/2 && r.y <= this.y + this.alto/2) ||
				(r.x >= this.x + this.ancho/2 && r.y >= this.y + this.alto/2) ||
				(r.x <= this.x + this.ancho/2 && r.y >= this.y - this.alto/2);
				
	}
}
