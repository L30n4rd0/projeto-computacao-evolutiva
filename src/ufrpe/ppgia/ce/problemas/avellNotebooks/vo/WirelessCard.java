/**
 * 
 */
package ufrpe.ppgia.ce.problemas.avellNotebooks.vo;

import ufrpe.ppgia.ce.util.ConstantsValues;

/**
 * @author leonardo
 *
 */
public class WirelessCard extends Component {
	private String manufacturer, model;

	/**
	 * @param priceChanger
	 * @param manufacturer
	 * @param model
	 */
	public WirelessCard(double priceChanger, String manufacturer, String model) {
		super(priceChanger);
		this.manufacturer = manufacturer;
		this.model = model;
	}

	/**
	 * @return the manufacturer
	 */
	public String getManufacturer() {
		return manufacturer;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}
	
	/**
	 * @return the header values of CSV format
	 */
	public String getCsvHeader() {
		String csvHeader = 
				"Wireless fabricante" + ConstantsValues.CVS_SEPARATOR + 
				"Wireless modelo" + ConstantsValues.CVS_SEPARATOR +
				"Wireless preço";
		
		return csvHeader;
		
	}
	
	/**
	 * @return the object values in CSV format
	 */
	public String toCsvFormat() {
		String objectCsvValues = 
				this.manufacturer + ConstantsValues.CVS_SEPARATOR + 
				this.model + ConstantsValues.CVS_SEPARATOR + 
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
		result = prime * result + ((manufacturer == null) ? 0 : manufacturer.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
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
		WirelessCard other = (WirelessCard) obj;
		if (manufacturer == null) {
			if (other.manufacturer != null)
				return false;
		} else if (!manufacturer.equals(other.manufacturer))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "WirelessCard\n"
				+ "\tmanufacturer=" + manufacturer + "\n"
				+ "\tmodel=" + model + "\n"
				+ "\tpriceChanger=" + priceChanger + "\n";
	}
	
	
	
}
