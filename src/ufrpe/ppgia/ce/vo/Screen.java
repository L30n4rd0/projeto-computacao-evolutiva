/**
 * 
 */
package ufrpe.ppgia.ce.vo;
/**
 * @author leonardo
 *
 */

public class Screen extends Component {
	private double inches;
	private String technology;
	
	/**
	 * @param priceChanger
	 * @param inches
	 * @param technology
	 */
	public Screen(double priceChanger, double inches, String technology) {
		super(priceChanger);
		this.inches = inches;
		this.technology = technology;
	}
	/**
	 * @return the inches
	 */
	public double getInches() {
		return inches;
	}
	/**
	 * @return the technology
	 */
	public String getTechnology() {
		return technology;
	}
	
	
}
