/**
 * 
 */
package ufrpe.ppgia.ce.vo;

/**
 * @author leonardo
 *
 */
public class NotebookVO {
	private String nameModel, actionProduct, url, color; 
	private double width, height, depth, weight;
	private Battery battery;
	private ChipSet chipSet;
	private KeyBoard keyBoard;
	private OperationalSystem operationalSystem;
	private Price defaultPrice, personalizedPrice;
	private Processor processor;
	private RAMMemory ramMemory;
	private SATA sata;
	private Screen screen;
	private StorageMemory storageMemory;
	private VideoCard videoCard;
	private WirelessCard wirelessCard;
	/**
	 * @param nameModel
	 * @param actionProduct
	 * @param url
	 * @param color
	 * @param width
	 * @param height
	 * @param depth
	 * @param weight
	 * @param battery
	 * @param chipSet
	 * @param keyBoard
	 * @param operationalSystem
	 * @param defaultPrice
	 * @param processor
	 * @param ramMemory
	 * @param sata
	 * @param screen
	 * @param storageMemory
	 * @param videoCard
	 * @param wirelessCard
	 */
	public NotebookVO(String nameModel, String actionProduct, String url, String color, double width, double height,
			double depth, double weight, Battery battery, ChipSet chipSet, KeyBoard keyBoard, OperationalSystem operationalSystem,
			Price defaultPrice, Processor processor, RAMMemory ramMemory, SATA sata, Screen screen,
			StorageMemory storageMemory, VideoCard videoCard, WirelessCard wirelessCard) {
		super();
		this.nameModel = nameModel;
		this.actionProduct = actionProduct;
		this.url = url;
		this.color = color;
		this.width = width;
		this.height = height;
		this.depth = depth;
		this.weight = weight;
		this.battery = battery;
		this.chipSet = chipSet;
		this.keyBoard = keyBoard;
		this.operationalSystem = operationalSystem;
		this.defaultPrice = defaultPrice;
		this.processor = processor;
		this.ramMemory = ramMemory;
		this.sata = sata;
		this.screen = screen;
		this.storageMemory = storageMemory;
		this.videoCard = videoCard;
		this.wirelessCard = wirelessCard;
		
		this.personalizedPrice = new Price(0.0, 0.0, 10, 12);
		
		this.personalizedPrice.setCreditCard(this.defaultPrice.getCreditCard());
		this.personalizedPrice.setInCash(this.defaultPrice.getInCash());
		this.personalizedPrice.setDiscount(this.defaultPrice.getDiscount());
		
	}
	/**
	 * @param nameModel
	 * @param actionProduct
	 * @param url
	 * @param color
	 * @param width
	 * @param height
	 * @param depth
	 * @param weight
	 * @param battery
	 * @param price
	 * @param processor
	 * @param ramMemory
	 * @param sata
	 * @param storageMemory
	 * @param videoCard
	 */
	public NotebookVO(String nameModel, String actionProduct, String url, String color, double width, double height,
			double depth, double weight, Battery battery, Price price, Processor processor, RAMMemory ramMemory,
			SATA sata, StorageMemory storageMemory, VideoCard videoCard) {
		super();
		this.nameModel = nameModel;
		this.actionProduct = actionProduct;
		this.url = url;
		this.color = color;
		this.width = width;
		this.height = height;
		this.depth = depth;
		this.weight = weight;
		this.battery = battery;
		this.defaultPrice = price;
		this.processor = processor;
		this.ramMemory = ramMemory;
		this.sata = sata;
		this.storageMemory = storageMemory;
		this.videoCard = videoCard;
	}
	/**
	 * @param nameModel
	 * @param actionProduct
	 * @param url
	 * @param color
	 * @param width
	 * @param height
	 * @param depth
	 * @param weight
	 * @param system
	 * @param price
	 * @param processor
	 * @param ramMemory
	 * @param storageMemory
	 * @param videoCard
	 */
	public NotebookVO(String nameModel, String actionProduct, String url, String color, double width, double height,
			double depth, double weight, OperationalSystem system, Price price, Processor processor,
			RAMMemory ramMemory, StorageMemory storageMemory, VideoCard videoCard) {
		super();
		this.nameModel = nameModel;
		this.actionProduct = actionProduct;
		this.url = url;
		this.color = color;
		this.width = width;
		this.height = height;
		this.depth = depth;
		this.weight = weight;
		this.operationalSystem = system;
		this.defaultPrice = price;
		this.processor = processor;
		this.ramMemory = ramMemory;
		this.storageMemory = storageMemory;
		this.videoCard = videoCard;
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
	 * @return the color
	 */
	public String getColor() {
		return color;
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
	 * @return the system
	 */
	public OperationalSystem getOperationalSystem() {
		return operationalSystem;
	}
	/**
	 * @return the price
	 */
	public Price getDefaultPrice() {
		return defaultPrice;
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
	 * @return the sata
	 */
	public SATA getSata() {
		return sata;
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
	/**
	 * @return the personalizedPrice
	 */
	public Price getPersonalizedPrice() {
		return personalizedPrice;
	}
	/**
	 * @param personalizedPrice the personalizedPrice to set
	 */
	public void setPersonalizedPrice(Price personalizedPrice) {
		this.personalizedPrice = personalizedPrice;
	}
	public void updatePrices() {
		
		double sumComponentPrices = 0.0;
		
		sumComponentPrices += this.videoCard.getPriceChanger();
		sumComponentPrices += this.processor.getPriceChanger();
		sumComponentPrices += this.ramMemory.getPriceChanger();
		sumComponentPrices += this.storageMemory.getPriceChanger();
//		sumComponentPrices += this.sata.getPriceChanger();
		sumComponentPrices += this.operationalSystem.getPriceChanger();
		sumComponentPrices += this.screen.getPriceChanger();
		sumComponentPrices += this.wirelessCard.getPriceChanger();
		
		this.personalizedPrice.setCreditCard(this.personalizedPrice.getCreditCard() + sumComponentPrices);
		
		// (1 - (getDiscount() / 100) = 0.9 -> discount of 10%
		this.personalizedPrice.setInCash( this.personalizedPrice.getCreditCard() * (1 - (this.personalizedPrice.getDiscount() / 100)) );
		
		
	}
	
}
