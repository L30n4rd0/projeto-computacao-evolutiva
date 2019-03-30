/**
 * 
 */
package ufrpe.ppgia.ce.problemas.avellNotebooks.vo;

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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(priceChanger);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Component other = (Component) obj;
		if (Double.doubleToLongBits(priceChanger) != Double.doubleToLongBits(other.priceChanger))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Component [priceChanger=" + priceChanger + "]";
	}
	
	
	
}
