/**
 * 
 */
package ufrpe.ppgia.ce.vo;

/**
 * @author leonardo
 *
 */
public class KeyBoard {
	private String type, layout, lighting;
	private boolean gamingKeys, programmableKeys, antiGhost;
	/**
	 * @param type
	 * @param layout
	 * @param lighting
	 * @param gamingKeys
	 * @param programmableKeys
	 * @param antiGhost
	 */
	public KeyBoard(String type, String layout, String lighting, boolean gamingKeys, boolean programmableKeys,
			boolean antiGhost) {
		super();
		this.type = type;
		this.layout = layout;
		this.lighting = lighting;
		this.gamingKeys = gamingKeys;
		this.programmableKeys = programmableKeys;
		this.antiGhost = antiGhost;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @return the layout
	 */
	public String getLayout() {
		return layout;
	}
	/**
	 * @return the lighting
	 */
	public String getLighting() {
		return lighting;
	}
	/**
	 * @return the gamingKeys
	 */
	public boolean isGamingKeys() {
		return gamingKeys;
	}
	/**
	 * @return the programmableKeys
	 */
	public boolean isProgrammableKeys() {
		return programmableKeys;
	}
	/**
	 * @return the antiGhost
	 */
	public boolean isAntiGhost() {
		return antiGhost;
	}
	
}
