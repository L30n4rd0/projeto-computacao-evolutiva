/**
 * 
 */
package ufrpe.ppgia.ce.vo;

/**
 * @author leonardo
 *
 */
public class NotebookVO {
	private String nome, actionProduct, url, color; 
	private double width, height, depth, weight;
	private Battery battery;
	private ChipSet chipSet;
	private KeyBoard keyBoard;
	private OperationalSystem system;
	private Price price;
	private Processor processor;
	private RAMMemory ramMemory;
	private SATA sata;
	private Screen screen;
	private StorageMemory storageMemory;
	private VideoCard videoCard;
	private WirelessCard wirelessCard;
	/**
	 * @param nome
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
	 * @param system
	 * @param price
	 * @param processor
	 * @param ramMemory
	 * @param sata
	 * @param screen
	 * @param storageMemory
	 * @param videoCard
	 * @param wirelessCard
	 */
	public NotebookVO(String nome, String actionProduct, String url, String color, double width, double height,
			double depth, double weight, Battery battery, ChipSet chipSet, KeyBoard keyBoard, OperationalSystem system,
			Price price, Processor processor, RAMMemory ramMemory, SATA sata, Screen screen,
			StorageMemory storageMemory, VideoCard videoCard, WirelessCard wirelessCard) {
		super();
		this.nome = nome;
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
		this.system = system;
		this.price = price;
		this.processor = processor;
		this.ramMemory = ramMemory;
		this.sata = sata;
		this.screen = screen;
		this.storageMemory = storageMemory;
		this.videoCard = videoCard;
		this.wirelessCard = wirelessCard;
	}
	/**
	 * @param nome
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
	public NotebookVO(String nome, String actionProduct, String url, String color, double width, double height,
			double depth, double weight, Battery battery, Price price, Processor processor, RAMMemory ramMemory,
			SATA sata, StorageMemory storageMemory, VideoCard videoCard) {
		super();
		this.nome = nome;
		this.actionProduct = actionProduct;
		this.url = url;
		this.color = color;
		this.width = width;
		this.height = height;
		this.depth = depth;
		this.weight = weight;
		this.battery = battery;
		this.price = price;
		this.processor = processor;
		this.ramMemory = ramMemory;
		this.sata = sata;
		this.storageMemory = storageMemory;
		this.videoCard = videoCard;
	}
	/**
	 * @param nome
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
	public NotebookVO(String nome, String actionProduct, String url, String color, double width, double height,
			double depth, double weight, OperationalSystem system, Price price, Processor processor,
			RAMMemory ramMemory, StorageMemory storageMemory, VideoCard videoCard) {
		super();
		this.nome = nome;
		this.actionProduct = actionProduct;
		this.url = url;
		this.color = color;
		this.width = width;
		this.height = height;
		this.depth = depth;
		this.weight = weight;
		this.system = system;
		this.price = price;
		this.processor = processor;
		this.ramMemory = ramMemory;
		this.storageMemory = storageMemory;
		this.videoCard = videoCard;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
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
	public OperationalSystem getSystem() {
		return system;
	}
	/**
	 * @return the price
	 */
	public Price getPrice() {
		return price;
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
	
}
