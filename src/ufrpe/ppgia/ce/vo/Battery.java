package ufrpe.ppgia.ce.vo;

public class Battery {
	private int cells;
	private String tecnology;
	/**
	 * @param cells
	 * @param tecnology
	 */
	public Battery(int cells, String tecnology) {
		super();
		this.cells = cells;
		this.tecnology = tecnology;
	}
	/**
	 * @return the cells
	 */
	public int getCells() {
		return cells;
	}
	/**
	 * @return the tecnology
	 */
	public String getTecnology() {
		return tecnology;
	}

}
