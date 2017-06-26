/**
 * 
 */
package ufrpe.ppgia.ce.vo;

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
	
}
