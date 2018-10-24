package naves;

public class RecibidorDanoEscudado extends RecibidorDano {

	public RecibidorDanoEscudado(NaveAliada na) {
		super(na);
	}

	@Override
	public void recibirDano(NaveEnemiga na) {
		na.eliminar();
		System.out.println("elimino");
		jugador.setRecibidorDano(new RecibidorDanoNoEscudado(jugador));
	}
}
