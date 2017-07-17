/**
 * 
 */
package ufrpe.ppgia.ce.problemas.avellNotebooks.vo;

import java.util.List;

/**
 * @author leonardo
 *
 */
public class DefaultNotebookModel {
	private String nameModel, actionProduct, url; 
	private double width, height, depth, weight;
	private Battery battery;
	private ChipSet chipSet;
	private KeyBoard keyBoard;
	private List<Color> colors;
	private List<OperationalSystem> operatingSystems;
	private List<Office> offices;
	private Price defaultPrice;
	private List<Processor> processors;
	private List<RAMMemory> ramMemories;
	private List<StorageMemory> storageMemories, secondStorageMemories, firstSATAS_eM2, secondSATAS_eM2;
	private List<Screen> screens;
	private List<VideoCard> videoCards;
	private List<WirelessCard> wirelessCards;
	
	/**
	 * @param nameModel
	 * @param actionProduct
	 * @param url
	 * @param width
	 * @param height
	 * @param depth
	 * @param weight
	 * @param battery
	 * @param chipSet
	 * @param keyBoard
	 * @param colors
	 * @param operatingSystems
	 * @param offices
	 * @param defaultPrice
	 * @param processors
	 * @param ramMemories
	 * @param storageMemories
	 * @param secondStorageMemories
	 * @param firstSATAS_eM2
	 * @param secondSATAS_eM2
	 * @param screens
	 * @param videoCards
	 * @param wirelessCards
	 */
	public DefaultNotebookModel(String nameModel, String actionProduct, String url, double width, double height,
			double depth, double weight, Battery battery, ChipSet chipSet, KeyBoard keyBoard, List<Color> colors,
			List<OperationalSystem> operatingSystems, List<Office> offices, Price defaultPrice,
			List<Processor> processors, List<RAMMemory> ramMemories, List<StorageMemory> storageMemories,
			List<StorageMemory> secondStorageMemories, List<StorageMemory> firstSATAS_eM2,
			List<StorageMemory> secondSATAS_eM2, List<Screen> screens, List<VideoCard> videoCards,
			List<WirelessCard> wirelessCards) {
		super();
		this.nameModel = nameModel;
		this.actionProduct = actionProduct;
		this.url = url;
		this.width = width;
		this.height = height;
		this.depth = depth;
		this.weight = weight;
		this.battery = battery;
		this.chipSet = chipSet;
		this.keyBoard = keyBoard;
		this.colors = colors;
		this.operatingSystems = operatingSystems;
		this.offices = offices;
		this.defaultPrice = defaultPrice;
		this.processors = processors;
		this.ramMemories = ramMemories;
		this.storageMemories = storageMemories;
		this.secondStorageMemories = secondStorageMemories;
		this.firstSATAS_eM2 = firstSATAS_eM2;
		this.secondSATAS_eM2 = secondSATAS_eM2;
		this.screens = screens;
		this.videoCards = videoCards;
		this.wirelessCards = wirelessCards;
	}

	/**
	 * @return the nameModel
	 */
	public String getNameModel() {
		return nameModel;
	}

	/**
	 * @return the actionProduct
	 */
	public String getActionProduct() {
		return actionProduct;
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
	 * @return the colors
	 */
	public List<Color> getColors() {
		return colors;
	}

	/**
	 * @return the operatingSystems
	 */
	public List<OperationalSystem> getOperatingSystems() {
		return operatingSystems;
	}

	/**
	 * @return the offices
	 */
	public List<Office> getOffices() {
		return offices;
	}

	/**
	 * @return the defaultPrice
	 */
	public Price getDefaultPrice() {
		return defaultPrice;
	}

	/**
	 * @return the processors
	 */
	public List<Processor> getProcessors() {
		return processors;
	}

	/**
	 * @return the ramMemories
	 */
	public List<RAMMemory> getRamMemories() {
		return ramMemories;
	}

	/**
	 * @return the storageMemories
	 */
	public List<StorageMemory> getStorageMemories() {
		return storageMemories;
	}

	/**
	 * @return the secondStorageMemories
	 */
	public List<StorageMemory> getSecondStorageMemories() {
		return secondStorageMemories;
	}

	/**
	 * @return the firstSATAS_eM2
	 */
	public List<StorageMemory> getFirstSATAS_eM2() {
		return firstSATAS_eM2;
	}

	/**
	 * @return the secondSATAS_eM2
	 */
	public List<StorageMemory> getSecondSATAS_eM2() {
		return secondSATAS_eM2;
	}

	/**
	 * @return the screens
	 */
	public List<Screen> getScreens() {
		return screens;
	}

	/**
	 * @return the videoCards
	 */
	public List<VideoCard> getVideoCards() {
		return videoCards;
	}

	/**
	 * @return the wirelessCards
	 */
	public List<WirelessCard> getWirelessCards() {
		return wirelessCards;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DefaultNotebookModel [nameModel=" + nameModel + ", actionProduct=" + actionProduct + ", url=" + url
				+ ", width=" + width + ", height=" + height + ", depth=" + depth + ", weight=" + weight + ", battery="
				+ battery + ", chipSet=" + chipSet + ", keyBoard=" + keyBoard + ", colors=" + colors
				+ ", operatingSystems=" + operatingSystems + ", offices=" + offices + ", defaultPrice=" + defaultPrice
				+ ", processors=" + processors + ", ramMemories=" + ramMemories + ", storageMemories=" + storageMemories
				+ ", secondStorageMemories=" + secondStorageMemories + ", firstSATAS_eM2=" + firstSATAS_eM2
				+ ", secondSATAS_eM2=" + secondSATAS_eM2 + ", screens=" + screens + ", videoCards=" + videoCards
				+ ", wirelessCards=" + wirelessCards + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actionProduct == null) ? 0 : actionProduct.hashCode());
		result = prime * result + ((battery == null) ? 0 : battery.hashCode());
		result = prime * result + ((chipSet == null) ? 0 : chipSet.hashCode());
		result = prime * result + ((colors == null) ? 0 : colors.hashCode());
		result = prime * result + ((defaultPrice == null) ? 0 : defaultPrice.hashCode());
		long temp;
		temp = Double.doubleToLongBits(depth);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((firstSATAS_eM2 == null) ? 0 : firstSATAS_eM2.hashCode());
		temp = Double.doubleToLongBits(height);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((keyBoard == null) ? 0 : keyBoard.hashCode());
		result = prime * result + ((nameModel == null) ? 0 : nameModel.hashCode());
		result = prime * result + ((offices == null) ? 0 : offices.hashCode());
		result = prime * result + ((operatingSystems == null) ? 0 : operatingSystems.hashCode());
		result = prime * result + ((processors == null) ? 0 : processors.hashCode());
		result = prime * result + ((ramMemories == null) ? 0 : ramMemories.hashCode());
		result = prime * result + ((screens == null) ? 0 : screens.hashCode());
		result = prime * result + ((secondSATAS_eM2 == null) ? 0 : secondSATAS_eM2.hashCode());
		result = prime * result + ((secondStorageMemories == null) ? 0 : secondStorageMemories.hashCode());
		result = prime * result + ((storageMemories == null) ? 0 : storageMemories.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		result = prime * result + ((videoCards == null) ? 0 : videoCards.hashCode());
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(width);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((wirelessCards == null) ? 0 : wirelessCards.hashCode());
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
		DefaultNotebookModel other = (DefaultNotebookModel) obj;
		if (actionProduct == null) {
			if (other.actionProduct != null)
				return false;
		} else if (!actionProduct.equals(other.actionProduct))
			return false;
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
		if (colors == null) {
			if (other.colors != null)
				return false;
		} else if (!colors.equals(other.colors))
			return false;
		if (defaultPrice == null) {
			if (other.defaultPrice != null)
				return false;
		} else if (!defaultPrice.equals(other.defaultPrice))
			return false;
		if (Double.doubleToLongBits(depth) != Double.doubleToLongBits(other.depth))
			return false;
		if (firstSATAS_eM2 == null) {
			if (other.firstSATAS_eM2 != null)
				return false;
		} else if (!firstSATAS_eM2.equals(other.firstSATAS_eM2))
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
		if (offices == null) {
			if (other.offices != null)
				return false;
		} else if (!offices.equals(other.offices))
			return false;
		if (operatingSystems == null) {
			if (other.operatingSystems != null)
				return false;
		} else if (!operatingSystems.equals(other.operatingSystems))
			return false;
		if (processors == null) {
			if (other.processors != null)
				return false;
		} else if (!processors.equals(other.processors))
			return false;
		if (ramMemories == null) {
			if (other.ramMemories != null)
				return false;
		} else if (!ramMemories.equals(other.ramMemories))
			return false;
		if (screens == null) {
			if (other.screens != null)
				return false;
		} else if (!screens.equals(other.screens))
			return false;
		if (secondSATAS_eM2 == null) {
			if (other.secondSATAS_eM2 != null)
				return false;
		} else if (!secondSATAS_eM2.equals(other.secondSATAS_eM2))
			return false;
		if (secondStorageMemories == null) {
			if (other.secondStorageMemories != null)
				return false;
		} else if (!secondStorageMemories.equals(other.secondStorageMemories))
			return false;
		if (storageMemories == null) {
			if (other.storageMemories != null)
				return false;
		} else if (!storageMemories.equals(other.storageMemories))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		if (videoCards == null) {
			if (other.videoCards != null)
				return false;
		} else if (!videoCards.equals(other.videoCards))
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		if (Double.doubleToLongBits(width) != Double.doubleToLongBits(other.width))
			return false;
		if (wirelessCards == null) {
			if (other.wirelessCards != null)
				return false;
		} else if (!wirelessCards.equals(other.wirelessCards))
			return false;
		return true;
	}
	
}
