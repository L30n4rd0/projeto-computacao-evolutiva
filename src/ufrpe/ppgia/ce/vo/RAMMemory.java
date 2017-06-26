/**
 * 
 */
package ufrpe.ppgia.ce.vo;

/**
 * @author leonardo
 *
 */
public class RAMMemory extends Component {
	private String type, frequency;
	private int size;
	/**
	 * @param priceChanger
	 * @param type
	 * @param frequency
	 * @param size
	 */
	public RAMMemory(double priceChanger, String type, String frequency, int size) {
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
	public String getFrequency() {
		return frequency;
	}
	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}
	
}
