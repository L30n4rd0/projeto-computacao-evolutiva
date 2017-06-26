/**
 * 
 */
package model.vo;

/**
 * @author leonardo
 *
 */
public class Processor extends Component {
	private String manufacturer, family, model;
	private int cacheMemory;
	private double frequency;
	/**
	 * @param priceChanger
	 * @param manufacturer
	 * @param family
	 * @param model
	 * @param cacheMemory
	 * @param frequency
	 */
	public Processor(double priceChanger, String manufacturer, String family, String model, int cacheMemory,
			double frequency) {
		super(priceChanger);
		this.manufacturer = manufacturer;
		this.family = family;
		this.model = model;
		this.cacheMemory = cacheMemory;
		this.frequency = frequency;
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
	public double getFrequency() {
		return frequency;
	}
	
}
