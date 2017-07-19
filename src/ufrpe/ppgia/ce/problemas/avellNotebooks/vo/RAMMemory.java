/**
 * 
 */
package ufrpe.ppgia.ce.problemas.avellNotebooks.vo;

import ufrpe.ppgia.ce.util.ConstantsValues;

/**
 * @author leonardo
 *
 */
public class RAMMemory extends Component {
	private String type;
	private double frequency;
	private int size;
	/**
	 * @param priceChanger
	 * @param type
	 * @param frequency
	 * @param size
	 */
	public RAMMemory(double priceChanger, String type, double frequency, int size) {
		super(priceChanger);
		this.type = type;
		this.frequency = frequency;
		this.size = size;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @return the frequency
	 */
	public double getFrequency() {
		return frequency;
	}
	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * @return the header values of CSV format
	 */
	public String getCsvHeader() {
		String csvHeader = 
				"RAM tipo" + ConstantsValues.CVS_SEPARATOR + 
				"RAM frequênca" + ConstantsValues.CVS_SEPARATOR +
				"RAM tamanho" + ConstantsValues.CVS_SEPARATOR +
				"RAM preço";
		
		return csvHeader;
		
	}
	
	/**
	 * @return the object values in CSV format
	 */
	public String toCsvFormat() {
		String objectCsvValues = 
				this.type + ConstantsValues.CVS_SEPARATOR + 
				this.frequency + ConstantsValues.CVS_SEPARATOR + 
				this.size + ConstantsValues.CVS_SEPARATOR +
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
		temp = Double.doubleToLongBits(frequency);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + size;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		RAMMemory other = (RAMMemory) obj;
		if (Double.doubleToLongBits(frequency) != Double.doubleToLongBits(other.frequency))
			return false;
		if (size != other.size)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RAMMemory\n"
				+ "\ttype=" + type + "\n"
				+ "\tfrequency=" + frequency + "\n"
				+ "\tsize=" + size + "\n"
				+ "\tpriceChanger=" + priceChanger + "\n";
	}
	
	
	
}
