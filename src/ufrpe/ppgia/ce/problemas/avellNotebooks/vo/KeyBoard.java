/**
 * 
 */
package ufrpe.ppgia.ce.problemas.avellNotebooks.vo;

import ufrpe.ppgia.ce.util.ConstantsValues;

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
	
	/**
	 * @return the header values of CSV format
	 */
	public String getCsvHeader() {
		String csvHeader = 
				"Teclado tipo" + ConstantsValues.CVS_SEPARATOR +
				"Teclado layout" + ConstantsValues.CVS_SEPARATOR + 
				"Teclado iluminação" + ConstantsValues.CVS_SEPARATOR +
				"Teclado teclas game" + ConstantsValues.CVS_SEPARATOR +
				"Teclado teclas programáveis" + ConstantsValues.CVS_SEPARATOR +
				"Teclado anti ghost";
		
		return csvHeader;
		
	}
	
	/**
	 * @return the object values in CSV format
	 */
	public String toCsvFormat() {
		String objectCsvValues = 
				this.type + ConstantsValues.CVS_SEPARATOR + 
				this.layout + ConstantsValues.CVS_SEPARATOR +
				this.lighting + ConstantsValues.CVS_SEPARATOR +
				this.gamingKeys + ConstantsValues.CVS_SEPARATOR +
				this.programmableKeys + ConstantsValues.CVS_SEPARATOR +
				this.antiGhost;
		
		return objectCsvValues;
		
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (antiGhost ? 1231 : 1237);
		result = prime * result + (gamingKeys ? 1231 : 1237);
		result = prime * result + ((layout == null) ? 0 : layout.hashCode());
		result = prime * result + ((lighting == null) ? 0 : lighting.hashCode());
		result = prime * result + (programmableKeys ? 1231 : 1237);
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KeyBoard other = (KeyBoard) obj;
		if (antiGhost != other.antiGhost)
			return false;
		if (gamingKeys != other.gamingKeys)
			return false;
		if (layout == null) {
			if (other.layout != null)
				return false;
		} else if (!layout.equals(other.layout))
			return false;
		if (lighting == null) {
			if (other.lighting != null)
				return false;
		} else if (!lighting.equals(other.lighting))
			return false;
		if (programmableKeys != other.programmableKeys)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
}
