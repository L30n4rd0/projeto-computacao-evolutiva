/**
 * 
 */
package ufrpe.ppgia.ce.problemas.avellNotebooks.vo;

import ufrpe.ppgia.ce.util.ConstantsValues;

/**
 * @author leonardo
 *
 */
public class VideoCard extends Component {
	private String manufacturer, model;
	private int dedicatedMemory;
	private boolean sli;
	//Scalable Link Interface is a method (technology) 
	//that allows you to merge two or more video cards 
	//into just one video output.
	/**
	 * @param priceChanger
	 * @param manufacturer
	 * @param model
	 * @param dedicatedMemory
	 * @param sli
	 */
	public VideoCard(double priceChanger, String manufacturer, String model, int dedicatedMemory, boolean sli) {
		super(priceChanger);
		this.manufacturer = manufacturer;
		this.model = model;
		this.dedicatedMemory = dedicatedMemory;
		this.sli = sli;
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
	 * @return the dedicatedMemory
	 */
	public int getDedicatedMemory() {
		return dedicatedMemory;
	}
	/**
	 * @return the sli
	 */
	public boolean isSli() {
		return sli;
	}
	
	/**
	 * @return the header values of CSV format
	 */
	public String getCsvHeader() {
		String csvHeader = 
				"Placa vídeo fabricante" + ConstantsValues.CVS_SEPARATOR + 
				"Placa vídeo medelo" + ConstantsValues.CVS_SEPARATOR + 
				"Placa vídeo memória" + ConstantsValues.CVS_SEPARATOR +
				"Placa vídeo SLI" + ConstantsValues.CVS_SEPARATOR + 
				"Placa vídeo preço";
		
		return csvHeader;
		
	}
	
	/**
	 * @return the object values in CSV format
	 */
	public String toCsvFormat() {
		String objectCsvValues = 
				this.manufacturer + ConstantsValues.CVS_SEPARATOR + 
				this.model + ConstantsValues.CVS_SEPARATOR +
				this.dedicatedMemory + ConstantsValues.CVS_SEPARATOR + 
				this.sli + ConstantsValues.CVS_SEPARATOR + 
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
		result = prime * result + dedicatedMemory;
		result = prime * result + ((manufacturer == null) ? 0 : manufacturer.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + (sli ? 1231 : 1237);
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
		VideoCard other = (VideoCard) obj;
		if (dedicatedMemory != other.dedicatedMemory)
			return false;
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
		if (sli != other.sli)
			return false;
		return true;
	}
	
	
	
}
