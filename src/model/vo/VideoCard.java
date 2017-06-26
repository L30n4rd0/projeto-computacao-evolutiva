/**
 * 
 */
package model.vo;

/**
 * @author leonardo
 *
 */
public class VideoCard extends Component {
	private String manufacturer, model;
	private int dedicatedMemory;
	/**
	 * @param priceChanger
	 * @param manufacturer
	 * @param model
	 * @param dedicatedMemory
	 */
	public VideoCard(double priceChanger, String manufacturer, String model, int dedicatedMemory) {
		super(priceChanger);
		this.manufacturer = manufacturer;
		this.model = model;
		this.dedicatedMemory = dedicatedMemory;
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
	
}
