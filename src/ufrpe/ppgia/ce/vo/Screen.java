/**
 * 
 */
package ufrpe.ppgia.ce.vo;

import ufrpe.ppgia.ce.util.ConstantsValues;

/**
 * @author leonardo
 *
 */

public class Screen extends Component {
	private double inches;
	private String technology;
	
	/**
	 * @param priceChanger
	 * @param inches
	 * @param technology
	 */
	public Screen(double priceChanger, double inches, String technology) {
		super(priceChanger);
		this.inches = inches;
		this.technology = technology;
	}
	/**
	 * @return the inches
	 */
	public double getInches() {
		return inches;
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
				"Tela polegadas" + ConstantsValues.CVS_SEPARATOR + 
				"Tela tecnologia" + ConstantsValues.CVS_SEPARATOR +
				"Tela preço";
		
		return csvHeader;
		
	}
	
	/**
	 * @return the object values in CSV format
	 */
	public String toCsvFormat() {
		String objectCsvValues = 
				this.inches + ConstantsValues.CVS_SEPARATOR + 
				this.technology + ConstantsValues.CVS_SEPARATOR + 
				this.priceChanger;
		
		return objectCsvValues;
		
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(inches);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Screen other = (Screen) obj;
		if (Double.doubleToLongBits(inches) != Double.doubleToLongBits(other.inches))
			return false;
		if (technology == null) {
			if (other.technology != null)
				return false;
		} else if (!technology.equals(other.technology))
			return false;
		return true;
	}
	
}
