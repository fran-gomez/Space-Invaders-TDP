package utilidades;

public class Punto {

	protected int x;
	protected int y;

	public Punto(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int x() {
		return x;
	}

	public int y() {
		return y;
	}

	public void x(int x) {
		this.x = x;
	}

	public void y(int y) {
		this.y = y;
	}

	public String toString() {
		return "(" + x + "," + y + ")";
	}
}
