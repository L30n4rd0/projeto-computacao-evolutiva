/**
 * 
 */
package ufrpe.ppgia.ce.vo;

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
	
}
