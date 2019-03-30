package ufrpe.ppgia.ce.base;

public interface OperadorRecombinacao <S> {
	public S[] recombinar(S pai1, S pai2);
	public void setPr(double pr);
	public double getPr();
}
