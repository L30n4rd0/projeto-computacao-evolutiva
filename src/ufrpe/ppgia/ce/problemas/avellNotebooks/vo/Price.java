/**
 * 
 */
package ufrpe.ppgia.ce.problemas.avellNotebooks.vo;

import ufrpe.ppgia.ce.util.ConstantsValues;

/**
 * @author leonardo
 *
 */
public class Price {
	private double inCash, creditCard, discount;
	private int installments;
	/**
	 * @param inCash
	 * @param creditCard
	 * @param discount
	 * @param installments
	 */
	public Price(double inCash, double creditCard, double discount, int installments) {
		super();
		this.inCash = inCash;
		this.creditCard = creditCard;
		this.discount = discount;
		this.installments = installments;
	}
	/**
	 * @return the inCash
	 */
	public double getInCash() {
		return inCash;
	}
	/**
	 * @return the creditCard
	 */
	public double getCreditCard() {
		return creditCard;
	}
	/**
	 * @return the discount
	 */
	public double getDiscount() {
		return discount;
	}
	/**
	 * @return the installments
	 */
	public int getInstallments() {
		return installments;
	}
	/**
	 * @param inCash the inCash to set
	 */
	public void setInCash(double inCash) {
		this.inCash = inCash;
	}
	/**
	 * @param creditCard the creditCard to set
	 */
	public void setCreditCard(double creditCard) {
		this.creditCard = creditCard;
	}
	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	/**
	 * @return the header values of CSV format
	 */
	public String getCsvHeader() {
		String csvHeader = 
				"Preço a vista" + ConstantsValues.CVS_SEPARATOR + 
				"Preço no cartão" + ConstantsValues.CVS_SEPARATOR +
				"Preço desconto";
		
		return csvHeader;
		
	}
	
	/**
	 * @return the object values in CSV format
	 */
	public String toCsvFormat() {
		String objectCsvValues = 
				this.inCash + ConstantsValues.CVS_SEPARATOR + 
				this.creditCard + ConstantsValues.CVS_SEPARATOR + 
				this.discount + "%";
		
		return objectCsvValues;
		
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(creditCard);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(discount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(inCash);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + installments;
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
		Price other = (Price) obj;
		if (Double.doubleToLongBits(creditCard) != Double.doubleToLongBits(other.creditCard))
			return false;
		if (Double.doubleToLongBits(discount) != Double.doubleToLongBits(other.discount))
			return false;
		if (Double.doubleToLongBits(inCash) != Double.doubleToLongBits(other.inCash))
			return false;
		if (installments != other.installments)
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Price\n"
				+ "\tinCash=" + inCash + "\n"
				+ "\tcreditCard=" + creditCard + "\n"
				+ "\tdiscount=" + discount + "\n"
				+ "\tinstallments="	+ installments + "\n";
	}
	

}
