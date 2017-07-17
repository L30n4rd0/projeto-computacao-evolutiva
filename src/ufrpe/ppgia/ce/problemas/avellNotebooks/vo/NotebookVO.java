/**
 * 
 */
package ufrpe.ppgia.ce.problemas.avellNotebooks.vo;

import ufrpe.ppgia.ce.util.ConstantsValues;

/**
 * @author leonardo
 *
 */
public class NotebookVO {
	private String nameModel, productAction, url; 
	private double width, height, depth, weight;
	private Color color;
	private Battery battery;
	private ChipSet chipSet;
	private KeyBoard keyBoard;
	private OperationalSystem operationalSystem;
	private Office office;
	private Price defaultPrice, personalizedPrice;
	private Processor processor;
	private RAMMemory ramMemory;
	private Screen screen;
	private StorageMemory storageMemory,secondStorageMemory, firstSATA_eM2, secondSATA_eM2;
	private VideoCard videoCard;
	private WirelessCard wirelessCard;
	
	/**
	 * @param nameModel
	 * @param productAction
	 * @param url
	 * @param width
	 * @param height
	 * @param depth
	 * @param weight
	 * @param color
	 * @param battery
	 * @param chipSet
	 * @param keyBoard
	 * @param operationalSystem
	 * @param office
	 * @param defaultPrice
	 * @param processor
	 * @param ramMemory
	 * @param screen
	 * @param storageMemory
	 * @param secondStorageMemory
	 * @param firstSATA_eM2
	 * @param secondSATA_eM2
	 * @param videoCard
	 * @param wirelessCard
	 */
	public NotebookVO(String nameModel, String productAction, String url, double width, double height, double depth,
			double weight, Color color, Battery battery, ChipSet chipSet, KeyBoard keyBoard,
			OperationalSystem operationalSystem, Office office, Price defaultPrice, Processor processor,
			RAMMemory ramMemory, Screen screen, StorageMemory storageMemory, StorageMemory secondStorageMemory,
			StorageMemory firstSATA_eM2, StorageMemory secondSATA_eM2, VideoCard videoCard, WirelessCard wirelessCard) {
		super();
		this.nameModel = nameModel;
		this.productAction = productAction;
		this.url = url;
		this.width = width;
		this.height = height;
		this.depth = depth;
		this.weight = weight;
		this.color = color;
		this.battery = battery;
		this.chipSet = chipSet;
		this.keyBoard = keyBoard;
		this.operationalSystem = operationalSystem;
		this.office = office;
		this.defaultPrice = defaultPrice;
		this.processor = processor;
		this.ramMemory = ramMemory;
		this.screen = screen;
		this.storageMemory = storageMemory;
		this.secondStorageMemory = secondStorageMemory;
		this.firstSATA_eM2 = firstSATA_eM2;
		this.secondSATA_eM2 = secondSATA_eM2;
		this.videoCard = videoCard;
		this.wirelessCard = wirelessCard;
		
		// The personalized price initial is the same default price
		this.personalizedPrice = new Price(
			this.defaultPrice.getInCash(), 
			this.defaultPrice.getCreditCard(), 
			this.defaultPrice.getDiscount(), 
			12
		);
		
	}
	
	/**
	 * @return the nameModel
	 */
	public String getNameModel() {
		return nameModel;
	}

	/**
	 * @return the productAction
	 */
	public String getProductAction() {
		return productAction;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @return the width
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * @return the depth
	 */
	public double getDepth() {
		return depth;
	}

	/**
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @return the battery
	 */
	public Battery getBattery() {
		return battery;
	}

	/**
	 * @return the chipSet
	 */
	public ChipSet getChipSet() {
		return chipSet;
	}

	/**
	 * @return the keyBoard
	 */
	public KeyBoard getKeyBoard() {
		return keyBoard;
	}

	/**
	 * @return the operationalSystem
	 */
	public OperationalSystem getOperationalSystem() {
		return operationalSystem;
	}

	/**
	 * @return the office
	 */
	public Office getOffice() {
		return office;
	}

	/**
	 * @return the defaultPrice
	 */
	public Price getDefaultPrice() {
		return defaultPrice;
	}

	/**
	 * @return the personalizedPrice
	 */
	public Price getPersonalizedPrice() {
		return personalizedPrice;
	}

	/**
	 * @return the processor
	 */
	public Processor getProcessor() {
		return processor;
	}

	/**
	 * @return the ramMemory
	 */
	public RAMMemory getRamMemory() {
		return ramMemory;
	}

	/**
	 * @return the screen
	 */
	public Screen getScreen() {
		return screen;
	}

	/**
	 * @return the storageMemory
	 */
	public StorageMemory getStorageMemory() {
		return storageMemory;
	}

	/**
	 * @return the secondStorageMemory
	 */
	public StorageMemory getSecondStorageMemory() {
		return secondStorageMemory;
	}

	/**
	 * @return the firstSATA_eM2
	 */
	public StorageMemory getFirstSATA_eM2() {
		return firstSATA_eM2;
	}

	/**
	 * @return the secondSATA_eM2
	 */
	public StorageMemory getSecondSATA_eM2() {
		return secondSATA_eM2;
	}

	/**
	 * @return the videoCard
	 */
	public VideoCard getVideoCard() {
		return videoCard;
	}

	/**
	 * @return the wirelessCard
	 */
	public WirelessCard getWirelessCard() {
		return wirelessCard;
	}

	public void updatePrices() {
		
		double sumComponentPrices = 0.0;
		
//		Color color;
//		OperationalSystem operationalSystem;
//		Office office;
//		Processor processor;
//		RAMMemory ramMemory;
//		Screen screen;
//		StorageMemory storageMemory,secondStorageMemory, firstSATA_eM2, secondSATA_eM2;
//		VideoCard videoCard;
//		WirelessCard wirelessCard;
		
		sumComponentPrices += this.office.priceChanger;
		sumComponentPrices += this.color.priceChanger;
		sumComponentPrices += this.videoCard.getPriceChanger();
		sumComponentPrices += this.processor.getPriceChanger();
		sumComponentPrices += this.ramMemory.getPriceChanger();
		sumComponentPrices += this.storageMemory.getPriceChanger();
		sumComponentPrices += this.secondStorageMemory.getPriceChanger();
		sumComponentPrices += this.firstSATA_eM2.getPriceChanger();
		sumComponentPrices += this.secondSATA_eM2.getPriceChanger();
		sumComponentPrices += this.operationalSystem.getPriceChanger();
		sumComponentPrices += this.screen.getPriceChanger();
		sumComponentPrices += this.wirelessCard.getPriceChanger();
		
		this.personalizedPrice.setCreditCard(this.personalizedPrice.getCreditCard() + sumComponentPrices);
		
		// (1 - (getDiscount() / 100) = 0.9 -> discount of 10%
		this.personalizedPrice.setInCash( this.personalizedPrice.getCreditCard() * (1 - (this.personalizedPrice.getDiscount() / 100) ) );
		
	}

	/**
	 * @return the header values of CSV format
	 */
	public String getCsvHeader() {
		String csvHeader = 
				"Nome modelo" + ConstantsValues.CVS_SEPARATOR + 
				"Action Produto" + ConstantsValues.CVS_SEPARATOR +
				"URL" + ConstantsValues.CVS_SEPARATOR +
				"Cor" + ConstantsValues.CVS_SEPARATOR +
				"Largura" + ConstantsValues.CVS_SEPARATOR +
				"Altura" + ConstantsValues.CVS_SEPARATOR +
				"Profundidade" + ConstantsValues.CVS_SEPARATOR +
				"Peso" + ConstantsValues.CVS_SEPARATOR +
				this.battery.getCsvHeader() + ConstantsValues.CVS_SEPARATOR +
				this.chipSet.getCsvHeader() + ConstantsValues.CVS_SEPARATOR +
				this.keyBoard.getCsvHeader() + ConstantsValues.CVS_SEPARATOR +
				this.operationalSystem.getCsvHeader() + ConstantsValues.CVS_SEPARATOR +
				"Preço padrão a vista" + ConstantsValues.CVS_SEPARATOR + 
				"Preço padrão no cartao" + ConstantsValues.CVS_SEPARATOR +
				"Preço padrão desconto" + ConstantsValues.CVS_SEPARATOR +
				"Preço personalizado a vista" + ConstantsValues.CVS_SEPARATOR + 
				"Preço personalizado no cartao" + ConstantsValues.CVS_SEPARATOR +
				"Preço personalizado desconto" + ConstantsValues.CVS_SEPARATOR +
				this.processor.getCsvHeader() + ConstantsValues.CVS_SEPARATOR +
				this.ramMemory.getCsvHeader() + ConstantsValues.CVS_SEPARATOR +
				this.storageMemory.getCsvHeader() + ConstantsValues.CVS_SEPARATOR +
				"SATAe M2 tipo" + ConstantsValues.CVS_SEPARATOR +
				"SATAe M2 tamanho" + ConstantsValues.CVS_SEPARATOR +
				"SATAe M2 preço" + ConstantsValues.CVS_SEPARATOR +
				"SATAe M2 tipo" + ConstantsValues.CVS_SEPARATOR +
				"SATAe M2 tamanho" + ConstantsValues.CVS_SEPARATOR +
				"SATAe M2 preço" + ConstantsValues.CVS_SEPARATOR +
				this.screen.getCsvHeader() + ConstantsValues.CVS_SEPARATOR +
				this.videoCard.getCsvHeader() + ConstantsValues.CVS_SEPARATOR +
				this.wirelessCard.getCsvHeader();
		
		return csvHeader;
		
	}
	
	/**
	 * @return the object values in CSV format
	 */
	public String toCsvFormat() {
		String objectCsvValues = 
				this.nameModel + ConstantsValues.CVS_SEPARATOR + 
				this.productAction + ConstantsValues.CVS_SEPARATOR +
				this.url + ConstantsValues.CVS_SEPARATOR +
				this.color + ConstantsValues.CVS_SEPARATOR +
				this.width + ConstantsValues.CVS_SEPARATOR +
				this.height + ConstantsValues.CVS_SEPARATOR +
				this.depth + ConstantsValues.CVS_SEPARATOR +
				this.weight + ConstantsValues.CVS_SEPARATOR +
				this.battery.toCsvFormat() + ConstantsValues.CVS_SEPARATOR +
				this.chipSet.toCsvFormat() + ConstantsValues.CVS_SEPARATOR +
				this.keyBoard.toCsvFormat() + ConstantsValues.CVS_SEPARATOR +
				this.operationalSystem.toCsvFormat() + ConstantsValues.CVS_SEPARATOR +
				this.defaultPrice.toCsvFormat() + ConstantsValues.CVS_SEPARATOR +
				this.personalizedPrice.toCsvFormat() + ConstantsValues.CVS_SEPARATOR +
				this.processor.toCsvFormat() + ConstantsValues.CVS_SEPARATOR +
				this.ramMemory.toCsvFormat() + ConstantsValues.CVS_SEPARATOR +
				this.storageMemory.toCsvFormat() + ConstantsValues.CVS_SEPARATOR +
				this.firstSATA_eM2.toCsvFormat() + ConstantsValues.CVS_SEPARATOR +
				this.secondSATA_eM2.toCsvFormat() + ConstantsValues.CVS_SEPARATOR +
				this.screen.toCsvFormat() + ConstantsValues.CVS_SEPARATOR +
				this.videoCard.toCsvFormat() + ConstantsValues.CVS_SEPARATOR +
				this.wirelessCard.toCsvFormat();
		
		return objectCsvValues;
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((battery == null) ? 0 : battery.hashCode());
		result = prime * result + ((chipSet == null) ? 0 : chipSet.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((defaultPrice == null) ? 0 : defaultPrice.hashCode());
		long temp;
		temp = Double.doubleToLongBits(depth);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((firstSATA_eM2 == null) ? 0 : firstSATA_eM2.hashCode());
		temp = Double.doubleToLongBits(height);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((keyBoard == null) ? 0 : keyBoard.hashCode());
		result = prime * result + ((nameModel == null) ? 0 : nameModel.hashCode());
		result = prime * result + ((office == null) ? 0 : office.hashCode());
		result = prime * result + ((operationalSystem == null) ? 0 : operationalSystem.hashCode());
		result = prime * result + ((personalizedPrice == null) ? 0 : personalizedPrice.hashCode());
		result = prime * result + ((processor == null) ? 0 : processor.hashCode());
		result = prime * result + ((productAction == null) ? 0 : productAction.hashCode());
		result = prime * result + ((ramMemory == null) ? 0 : ramMemory.hashCode());
		result = prime * result + ((screen == null) ? 0 : screen.hashCode());
		result = prime * result + ((secondSATA_eM2 == null) ? 0 : secondSATA_eM2.hashCode());
		result = prime * result + ((secondStorageMemory == null) ? 0 : secondStorageMemory.hashCode());
		result = prime * result + ((storageMemory == null) ? 0 : storageMemory.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		result = prime * result + ((videoCard == null) ? 0 : videoCard.hashCode());
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(width);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((wirelessCard == null) ? 0 : wirelessCard.hashCode());
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
		NotebookVO other = (NotebookVO) obj;
		if (battery == null) {
			if (other.battery != null)
				return false;
		} else if (!battery.equals(other.battery))
			return false;
		if (chipSet == null) {
			if (other.chipSet != null)
				return false;
		} else if (!chipSet.equals(other.chipSet))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (defaultPrice == null) {
			if (other.defaultPrice != null)
				return false;
		} else if (!defaultPrice.equals(other.defaultPrice))
			return false;
		if (Double.doubleToLongBits(depth) != Double.doubleToLongBits(other.depth))
			return false;
		if (firstSATA_eM2 == null) {
			if (other.firstSATA_eM2 != null)
				return false;
		} else if (!firstSATA_eM2.equals(other.firstSATA_eM2))
			return false;
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
			return false;
		if (keyBoard == null) {
			if (other.keyBoard != null)
				return false;
		} else if (!keyBoard.equals(other.keyBoard))
			return false;
		if (nameModel == null) {
			if (other.nameModel != null)
				return false;
		} else if (!nameModel.equals(other.nameModel))
			return false;
		if (office == null) {
			if (other.office != null)
				return false;
		} else if (!office.equals(other.office))
			return false;
		if (operationalSystem == null) {
			if (other.operationalSystem != null)
				return false;
		} else if (!operationalSystem.equals(other.operationalSystem))
			return false;
		if (personalizedPrice == null) {
			if (other.personalizedPrice != null)
				return false;
		} else if (!personalizedPrice.equals(other.personalizedPrice))
			return false;
		if (processor == null) {
			if (other.processor != null)
				return false;
		} else if (!processor.equals(other.processor))
			return false;
		if (productAction == null) {
			if (other.productAction != null)
				return false;
		} else if (!productAction.equals(other.productAction))
			return false;
		if (ramMemory == null) {
			if (other.ramMemory != null)
				return false;
		} else if (!ramMemory.equals(other.ramMemory))
			return false;
		if (screen == null) {
			if (other.screen != null)
				return false;
		} else if (!screen.equals(other.screen))
			return false;
		if (secondSATA_eM2 == null) {
			if (other.secondSATA_eM2 != null)
				return false;
		} else if (!secondSATA_eM2.equals(other.secondSATA_eM2))
			return false;
		if (secondStorageMemory == null) {
			if (other.secondStorageMemory != null)
				return false;
		} else if (!secondStorageMemory.equals(other.secondStorageMemory))
			return false;
		if (storageMemory == null) {
			if (other.storageMemory != null)
				return false;
		} else if (!storageMemory.equals(other.storageMemory))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		if (videoCard == null) {
			if (other.videoCard != null)
				return false;
		} else if (!videoCard.equals(other.videoCard))
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		if (Double.doubleToLongBits(width) != Double.doubleToLongBits(other.width))
			return false;
		if (wirelessCard == null) {
			if (other.wirelessCard != null)
				return false;
		} else if (!wirelessCard.equals(other.wirelessCard))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "NotebookVO [nameModel=" + nameModel + ", productAction=" + productAction + ", url=" + url + ", width="
				+ width + ", height=" + height + ", depth=" + depth + ", weight=" + weight + ", color=" + color
				+ ", battery=" + battery + ", chipSet=" + chipSet + ", keyBoard=" + keyBoard + ", operationalSystem="
				+ operationalSystem + ", office=" + office + ", defaultPrice=" + defaultPrice + ", personalizedPrice="
				+ personalizedPrice + ", processor=" + processor + ", ramMemory=" + ramMemory + ", screen=" + screen
				+ ", storageMemory=" + storageMemory + ", secondStorageMemory=" + secondStorageMemory
				+ ", firstSATA_eM2=" + firstSATA_eM2 + ", secondSATA_eM2=" + secondSATA_eM2 + ", videoCard=" + videoCard
				+ ", wirelessCard=" + wirelessCard + "]";
	}
	
	
	
}
