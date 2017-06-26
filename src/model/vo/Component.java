/**
 * 
 */
package model.vo;

/**
 * @author leonardo
 *
 */
public abstract class Component {
	protected double priceChanger;

	/**
	 * @param priceChanger
	 */
	public Component(double priceChanger) {
		super();
		this.priceChanger = priceChanger;
	}

	/**
	 * @return the priceChanger
	 */
	public double getPriceChanger() {
		return priceChanger;
	}
	
}
