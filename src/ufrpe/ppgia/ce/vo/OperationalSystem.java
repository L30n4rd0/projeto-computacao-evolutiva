/**
 * 
 */
package ufrpe.ppgia.ce.vo;

/**
 * @author leonardo
 *
 */
public class OperationalSystem extends Component {
	
	private String type, version, edition;

	/**
	 * @param priceChanger
	 * @param type
	 * @param version
	 * @param edition
	 */
	public OperationalSystem(double priceChanger, String type, String version, String edition) {
		super(priceChanger);
		this.type = type;
		this.version = version;
		this.edition = edition;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @return the edition
	 */
	public String getEdition() {
		return edition;
	}
	
}
