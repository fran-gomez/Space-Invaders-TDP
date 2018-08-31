package utilidades;

public class Punto {

	protected int x;
	protected int y;
	
	public Punto(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int X() {
		return x;
	}
	
	public int Y() {
		return y;
	}
	
	public void X(int x) {
		this.x = x;
	}
	
	public void Y(int y) {
		this.y = y;
	}
}
