package ufrpe.ppgia.ce.vo;

import ufrpe.ppgia.ce.util.ConstantsValues;

public class Battery {
	private int cells;
	private String technology;
	/**
	 * @param cells
	 * @param technology
	 */
	public Battery(int cells, String technology) {
		super();
		this.cells = cells;
		this.technology = technology;
	}
	/**
	 * @return the cells
	 */
	public int getCells() {
		return cells;
	}
	/**
	 * @return the technology
	 */
	public String getTechnology() {
		return technology;
	}
	
	/**
	 * @return the header values of CSV format
	 */
	public String getCsvHeader() {
		String csvHeader = 
				"Bateria células" + ConstantsValues.CVS_SEPARATOR + 
				"Bateria tecnologia";
		
		return csvHeader;
		
	}
	
	/**
	 * @return the object values in CSV format
	 */
	public String toCsvFormat() {
		String objectCsvValues = 
				this.cells + ConstantsValues.CVS_SEPARATOR + 
				this.technology;
		
		return objectCsvValues;
		
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cells;
		result = prime * result + ((technology == null) ? 0 : technology.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Battery other = (Battery) obj;
		if (cells != other.cells)
			return false;
		if (technology == null) {
			if (other.technology != null)
				return false;
		} else if (!technology.equals(other.technology))
			return false;
		return true;
	}
	
	
}
