/**
 * 
 */
package ufrpe.ppgia.ce.vo;

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

}
