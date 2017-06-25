/**
 * 
 */
package model.vo;

/**
 * @author leonardo
 *
 */
public class RamMemory {
	private String type, frequency;
	private int size;
	/**
	 * @param type
	 * @param frequency
	 * @param size
	 */
	public RamMemory(String type, String frequency, int size) {
		super();
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
