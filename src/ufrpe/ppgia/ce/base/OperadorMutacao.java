package ufrpe.ppgia.ce.base;

public interface OperadorMutacao <S> {
	public S executarMutacao(S pai);
	public double getPm();
	public void setPm(double pm);

}
