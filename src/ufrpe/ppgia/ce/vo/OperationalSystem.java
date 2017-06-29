/**
 * 
 */
package ufrpe.ppgia.ce.vo;

/**
 * @author leonardo
 *
 */
public class OperationalSystem extends Component {
	
	private String description;

	/**
	 * @param priceChanger
	 * @param description
	 */
	public OperationalSystem(double priceChanger, String description) {
		super(priceChanger);
		this.description = description;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
}
