/**
 * 
 */
package ufrpe.ppgia.ce.vo;

import ufrpe.ppgia.ce.util.ConstantsValues;

/**
 * @author leonardo
 *
 */
public class OperationalSystem extends Component {
	
	private String description;

	/**
	 * @param priceChanger
	 * @param description
	 */
	public OperationalSystem(double priceChanger, String description) {
		super(priceChanger);
		this.description = description;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * @return the header values of CSV format
	 */
	public String getCsvHeader() {
		String csvHeader = 
				"SO descrição" + ConstantsValues.CVS_SEPARATOR + 
				"SO preço";
		
		return csvHeader;
		
	}
	
	/**
	 * @return the object values in CSV format
	 */
	public String toCsvFormat() {
		String objectCsvValues = 
				this.description + ConstantsValues.CVS_SEPARATOR + 
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
		result = prime * result + ((description == null) ? 0 : description.hashCode());
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
		OperationalSystem other = (OperationalSystem) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		return true;
	}
	
}
