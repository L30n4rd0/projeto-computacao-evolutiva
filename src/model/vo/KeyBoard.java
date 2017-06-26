/**
 * 
 */
package model.vo;

/**
 * @author leonardo
 *
 */
public class KeyBoard {
	private String style, layout;
	private boolean illuminated;
	/**
	 * @param style
	 * @param layout
	 * @param illuminated
	 */
	public KeyBoard(String style, String layout, boolean illuminated) {
		super();
		this.style = style;
		this.layout = layout;
		this.illuminated = illuminated;
	}
	/**
	 * @return the style
	 */
	public String getStyle() {
		return style;
	}
	/**
	 * @return the layout
	 */
	public String getLayout() {
		return layout;
	}
	/**
	 * @return the illuminated
	 */
	public boolean isIlluminated() {
		return illuminated;
	}

}
