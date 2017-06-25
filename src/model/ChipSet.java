/**
 * 
 */
package model;

/**
 * @author leonardo
 *
 */
public class ChipSet {
	private String manufacturer, model;

	/**
	 * @param manufacturer
	 * @param model
	 */
	public ChipSet(String manufacturer, String model) {
		super();
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
	
	

}
