package utilidades;

public class Vector {
	protected float x, y;

	public Vector(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public Vector(float x1, float y1, float x2, float y2) {
		this.x = x1 - x2;
		this.y = y1 - y2;
	}

	public float x() {
		return x;
	}

	public float y() {
		return y;
	}

	public void hacerUnitario() {
		float modulo = (float) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		this.x /= modulo;
		this.y /= modulo;
	}

	public static float distanceBetween(float x1, float y1, float x2, float y2) {
		return (float) Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}
}
