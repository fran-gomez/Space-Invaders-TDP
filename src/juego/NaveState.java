package juego;

public class NaveState extends ObjectState {

	private int dmg;
	public int getAlcance() {
		return alcance;
	}

	public void setAlcance(int alcance) {
		this.alcance = alcance;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	protected int alcance;
	protected int velocidad;

	public NaveState(int vida, int durabilidad, int dmg, int alcance, int velocidad) {
		super(vida, durabilidad);
		this.setDmg(dmg);
		this.alcance = alcance;
		this.velocidad = velocidad;
	}

	public int getDmg() {
		return dmg;
	}

	public void setDmg(int dmg) {
		this.dmg = dmg;
	}
}
