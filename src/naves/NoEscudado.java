package naves;

public class NoEscudado extends RecibidorDano {

	public NoEscudado(NaveAliada na) {
		super(na);
	}

	@Override
	public void recibirDano(NaveEnemiga na) {
		jugador.recibirDano(na.getDmg());
	}

}
