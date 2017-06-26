/**
 * 
 */
package ufrpe.ppgia.ce.vo;

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
	
}
