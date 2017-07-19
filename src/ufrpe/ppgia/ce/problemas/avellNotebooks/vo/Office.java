/**
 * 
 */
package ufrpe.ppgia.ce.problemas.avellNotebooks.vo;

/**
 * @author leonardo
 *
 */
public class Office extends Component {

	private String type;
	
	/**
	 * @param priceChanger
	 * @param type
	 */
	public Office(double priceChanger, String type) {
		super(priceChanger);
		this.type = type;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Office\n"
				+ "\ttype=" + type + "\n"
				+ "\tpriceChanger=" + priceChanger + "\n";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
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
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Office other = (Office) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	

}
