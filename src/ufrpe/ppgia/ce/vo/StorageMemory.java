/**
 * 
 */
package ufrpe.ppgia.ce.vo;

import ufrpe.ppgia.ce.util.ConstantsValues;

/**
 * @author leonardo
 *
 */
public class StorageMemory extends Component {
	private String type, unitMeasure;
	private int size;
	/**
	 * @param priceChanger
	 * @param type
	 * @param unitMeasure
	 * @param size
	 */
	public StorageMemory(double priceChanger, String type, String unitMeasure, int size) {
		super(priceChanger);
		this.type = type;
		this.unitMeasure = unitMeasure;
		this.size = size;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @return the unitMeasure
	 */
	public String getUnitMeasure() {
		return unitMeasure;
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
				"Armazenamento tipo" + ConstantsValues.CVS_SEPARATOR + 
				"Armazenamento tamanho" + ConstantsValues.CVS_SEPARATOR +
				"Armazenamento preço";
		
		return csvHeader;
		
	}
	
	/**
	 * @return the object values in CSV format
	 */
	public String toCsvFormat() {
		String objectCsvValues = 
				this.type + ConstantsValues.CVS_SEPARATOR + 
				this.size + this.unitMeasure + ConstantsValues.CVS_SEPARATOR + 
				this.priceChanger;
		
		return objectCsvValues;
		
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StorageMemory [type=" + type + ", unitMeasure=" + unitMeasure + ", size=" + size + ", priceChanger="
				+ priceChanger + "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + size;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((unitMeasure == null) ? 0 : unitMeasure.hashCode());
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
		StorageMemory other = (StorageMemory) obj;
		if (size != other.size)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (unitMeasure == null) {
			if (other.unitMeasure != null)
				return false;
		} else if (!unitMeasure.equals(other.unitMeasure))
			return false;
		return true;
	}
	
	
}
