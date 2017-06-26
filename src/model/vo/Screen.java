/**
 * 
 */
package model.vo;
/**
 * @author leonardo
 *
 */

public class Screen {
	private double inches;
	private int[] resolution;
	/**
	 * @param inches
	 * @param resolution
	 */
	public Screen(double inches, int[] resolution) {
		super();
		this.inches = inches;
		this.resolution = resolution;
	}
	/**
	 * @return the inches
	 */
	public double getInches() {
		return inches;
	}
	/**
	 * @return the resolution
	 */
	public int[] getResolution() {
		return resolution;
	}
	
}
