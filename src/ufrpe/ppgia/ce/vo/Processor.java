/**
 * 
 */
package ufrpe.ppgia.ce.vo;

import ufrpe.ppgia.ce.util.ConstantsValues;

/**
 * @author leonardo
 *
 */
public class Processor extends Component {
	private String manufacturer, family, model;
	private int cacheMemory;
	private double maxFrequency;
	/**
	 * @param priceChanger
	 * @param manufacturer
	 * @param family
	 * @param model
	 * @param cacheMemory
	 * @param maxFrequency
	 */
	public Processor(double priceChanger, String manufacturer, String family, String model, int cacheMemory,
			double maxFrequency) {
		super(priceChanger);
		this.manufacturer = manufacturer;
		this.family = family;
		this.model = model;
		this.cacheMemory = cacheMemory;
		this.maxFrequency = maxFrequency;
	}
	/**
	 * @return the manufacturer
	 */
	public String getManufacturer() {
		return manufacturer;
	}
	/**
	 * @return the family
	 */
	public String getFamily() {
		return family;
	}
	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}
	/**
	 * @return the cacheMemory
	 */
	public int getCacheMemory() {
		return cacheMemory;
	}
	/**
	 * @return the frequency
	 */
	public double getMaxFrequency() {
		return maxFrequency;
	}
	
	/**
	 * @return the header values of CSV format
	 */
	public String getCsvHeader() {
		String csvHeader = 
				"Processador fabricante" + ConstantsValues.CVS_SEPARATOR + 
				"Processador família" + ConstantsValues.CVS_SEPARATOR +
				"Processador modelo" + ConstantsValues.CVS_SEPARATOR +
				"Processador cache" + ConstantsValues.CVS_SEPARATOR +
				"Processador frequênciaMax" + ConstantsValues.CVS_SEPARATOR +
				"Processador preço";
		
		return csvHeader;
		
	}
	
	/**
	 * @return the object values in CSV format
	 */
	public String toCsvFormat() {
		String objectCsvValues = 
				this.manufacturer + ConstantsValues.CVS_SEPARATOR + 
				this.family + ConstantsValues.CVS_SEPARATOR +
				this.model + ConstantsValues.CVS_SEPARATOR +
				this.cacheMemory + ConstantsValues.CVS_SEPARATOR +
				this.maxFrequency + ConstantsValues.CVS_SEPARATOR +
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
		result = prime * result + cacheMemory;
		result = prime * result + ((family == null) ? 0 : family.hashCode());
		result = prime * result + ((manufacturer == null) ? 0 : manufacturer.hashCode());
		long temp;
		temp = Double.doubleToLongBits(maxFrequency);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Processor other = (Processor) obj;
		if (cacheMemory != other.cacheMemory)
			return false;
		if (family == null) {
			if (other.family != null)
				return false;
		} else if (!family.equals(other.family))
			return false;
		if (manufacturer == null) {
			if (other.manufacturer != null)
				return false;
		} else if (!manufacturer.equals(other.manufacturer))
			return false;
		if (Double.doubleToLongBits(maxFrequency) != Double.doubleToLongBits(other.maxFrequency))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		return true;
	}
	
}
