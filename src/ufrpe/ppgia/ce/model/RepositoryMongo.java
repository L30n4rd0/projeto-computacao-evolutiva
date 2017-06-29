/**
 * 
 */
package ufrpe.ppgia.ce.model;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import ufrpe.ppgia.ce.util.StringConverter;
import ufrpe.ppgia.ce.vo.Battery;
import ufrpe.ppgia.ce.vo.ChipSet;
import ufrpe.ppgia.ce.vo.KeyBoard;
import ufrpe.ppgia.ce.vo.NotebookVO;
import ufrpe.ppgia.ce.vo.OperationalSystem;
import ufrpe.ppgia.ce.vo.Price;
import ufrpe.ppgia.ce.vo.Processor;
import ufrpe.ppgia.ce.vo.RAMMemory;
import ufrpe.ppgia.ce.vo.SATA;
import ufrpe.ppgia.ce.vo.Screen;
import ufrpe.ppgia.ce.vo.StorageMemory;
import ufrpe.ppgia.ce.vo.VideoCard;
import ufrpe.ppgia.ce.vo.WirelessCard;

/**
 * @author leonardo
 *
 */
public class RepositoryMongo implements InterfaceRepository {
	
	private String serverAddress, dataBaseName, collection;
	private int port;
	
	/**
	 * @param serverAddress
	 * @param dataBaseName
	 * @param port
	 * @param mongoClient
	 */
	public RepositoryMongo() {
		this.serverAddress = "127.0.0.1";
		this.dataBaseName = "avell";
		this.collection = "notebooks";
		this.port = 27017;
	}
	
	@Override
	public void insertNotebook(NotebookVO notebook) throws Exception {
	}

	@Override
	public void alterNotebook(NotebookVO notebook) throws Exception {
		
	}

	@Override
	public void deleteNotebook(String name) throws Exception {
	}
	
	/* (non-Javadoc)
	 * @see model.InterfaceRepository#getAllNotebook()
	 */
	@Override
	public List<NotebookVO> getAllNotebook() throws Exception {
		
		List<NotebookVO> notebooksReturn = new ArrayList<>();
		
		MongoClient mongoClient = new MongoClient(this.serverAddress, this.port);
		
		MongoDatabase avellDatabase = mongoClient.getDatabase(this.dataBaseName);
		
		MongoCollection<Document> notebooksCollection = avellDatabase.getCollection(this.collection);
		
		MongoCursor<Document> notebooksCursor = notebooksCollection.find().iterator();
		
//		FindIterable<Document> notebooksCursor = notebooksCollection.find();
		
		int tempCont = 0;
		
		while (notebooksCursor.hasNext()) {
			Document notebook = notebooksCursor.next();
			
			JsonObject notebookJsonObject = new Gson().fromJson(notebook.toJson(), JsonObject.class);
			
			// *** Temp param variables *** 
			String nameModel = notebookJsonObject.get("title").getAsString();
			
			String actionProduct = notebookJsonObject.get("action_product").getAsString();
			
			String url = notebookJsonObject.get("url").getAsString();
			
			JsonArray specificationsJson = notebookJsonObject.get("especifications").getAsJsonArray();
			
			JsonObject pricesJson = notebookJsonObject.getAsJsonObject("prices");
			
			JsonArray settingsJson = notebookJsonObject.get("settings").getAsJsonArray();
			
			String color = null;
			
			double width = 0, height = 0, depth = 0, weight = 0, componentsPrice = 0.0;
			
			Battery battery = null;
			
			ChipSet chipSet = null;
			
			KeyBoard keyBoard = null;
			
			Price price = null;
			
			List<VideoCard> videoCards = new ArrayList<>();
			
			List<Processor> processors = new ArrayList<>();
			
			List<RAMMemory> ramMemories = new ArrayList<>();
			
			List<StorageMemory> storageMemories = new ArrayList<>();
			
			List<SATA> satas = new ArrayList<>();
			
			List<OperationalSystem> operationalSystems = new ArrayList<>();
			
			List<Screen> screens = new ArrayList<>();
			
			List<WirelessCard> wirelessCards = new ArrayList<>();
			// ***
			
			if (settingsJson.size() > 0) {
				
				tempCont++;
				System.out.println("\n" + tempCont);
				
				// Get all specifications
				for (JsonElement specification : specificationsJson) {
					
					String currentLabel = specification.getAsJsonObject().get("label").getAsString();
					
					if (currentLabel.equalsIgnoreCase("Descrição Física")) {
						
						JsonArray descriptionArray = specification.getAsJsonObject().get("description").getAsJsonArray();
						
						// *** Dimensions
						String dimensionsString = descriptionArray.get(0).getAsString();
						
						double[] dimensionValues = getDimensionsByString(dimensionsString);
						
						width = dimensionValues[0];
						depth = dimensionValues[1];
						height = dimensionValues[2];
						
//						System.out.println(width);
//						System.out.println(depth);
//						System.out.println(height);
						// ***
						
						// *** Weight
						String weightString = descriptionArray.get(1).getAsString();
						
						weight = StringConverter.getDoubleNumbersByString(weightString)[0];
						
//						System.out.println(weight);
						// ***
						
						// *** Color
						if (descriptionArray.size() > 2)
							color = descriptionArray.get(2).getAsString().substring(7);
							
						else
							color = null;
						
//						System.out.println(tempCont + color);
						// ***
						
					} else if (currentLabel.equalsIgnoreCase("Chipset") || currentLabel.equalsIgnoreCase("Core Logic")) {
						
						JsonArray chipsetPropertiesArray = specification.getAsJsonObject().get("description").getAsJsonArray();
						
						chipSet = getChipSetByJsonArray(chipsetPropertiesArray);
						
//						System.out.println(chipSet.getManufacturer() + " " + chipSet.getModel() + "\n");
						// ***
						
					} else if (currentLabel.equalsIgnoreCase("Teclado")) {
						
						JsonArray keyBoardPropertiesArray = specification.getAsJsonObject().get("description").getAsJsonArray();
						
						keyBoard = getKeyBoardByJsonArray(keyBoardPropertiesArray);
						
//						System.out.println(
//								keyBoard.getLayout() + "\n" + 
//								keyBoard.getLighting() + "\n" +
//								keyBoard.getType() + "\n" +
//								keyBoard.isGamingKeys() + "\n" +
//								keyBoard.isProgrammableKeys() + "\n" +
//								keyBoard.isAntiGhost() + "\n");
						// ***
						
					} else if (currentLabel.equalsIgnoreCase("Bateria")) {
						
						JsonArray batteryPropertiesArray = specification.getAsJsonObject().get("description").getAsJsonArray();
						
//						System.out.println(batteryPropertiesArray);
						
						battery = getBatteryByJsonArray(batteryPropertiesArray);
						
//						System.out.println(
//								battery.getCells() + "\n" +
//								battery.getTecnology() + "\n");
						// ***
						
					}
					
					
				}
				
				// *** Getting prices
//				System.out.println(pricesJson);
				
				price = getPriceByJsonObject(pricesJson);
				
//				System.out.println(
//						price.getInCash() + "\n" +
//						price.getDiscount() + "\n" +
//						price.getCreditCard() + "\n" +
//						price.getInstallments() + "\n"
//						);
				// ***
				
				for (JsonElement setting : settingsJson) {
					
					String currentLabel = setting.getAsJsonObject().get("label").getAsString();
					
					// *** Getting Video Cards Values
					if (currentLabel.equalsIgnoreCase("PLACA DE VÍDEO")) {
						JsonArray choiceArray = setting.getAsJsonObject().get("choice").getAsJsonArray();
						
						for (JsonElement videoCardJson : choiceArray) {
							
							VideoCard tempVideoCard = getVideoCardByJsonObject(videoCardJson.getAsJsonObject());
							
							videoCards.add(tempVideoCard);
							
//							System.out.println(
//									tempVideoCard.getManufacturer() + "\n" +
//									tempVideoCard.getModel() + "\n" +
//									tempVideoCard.getDedicatedMemory() + "\n" + 
//									tempVideoCard.getPriceChanger() + "\n" +
//									tempVideoCard.isSli() + "\n"
//									);
							
						}
					}
					// ***
					

					// *** Getting processors Values
					if (currentLabel.equalsIgnoreCase("PROCESSADOR")) {
						JsonArray choiceArray = setting.getAsJsonObject().get("choice").getAsJsonArray();
						
						for (JsonElement processorJson : choiceArray) {
							
							Processor tempProcessor = getProcessorByJsonObject(processorJson.getAsJsonObject());
							
							processors.add(tempProcessor);
							
//							System.out.println(
//									tempProcessor.getManufacturer() + "\n" +
//									tempProcessor.getFamily() + "\n" + 
//									tempProcessor.getModel() + "\n" +
//									tempProcessor.getCacheMemory() + "\n" +
//									tempProcessor.getMaxFrequency() + "\n" + 
//									tempProcessor.getPriceChanger() + "\n"
//									);
							
						}
					}
					// ***
					
					// *** Getting ramMemories Values
					if (currentLabel.equalsIgnoreCase("MEMÓRIA")) {
						JsonArray choiceArray = setting.getAsJsonObject().get("choice").getAsJsonArray();
						
						for (JsonElement ramMemoryJson : choiceArray) {
							
							RAMMemory tempRamMemory = getRamMemoryByJsonObject(ramMemoryJson.getAsJsonObject());
							
							ramMemories.add(tempRamMemory);
							
//							System.out.println(
//									tempRamMemory.getType() + "\n" +
//									tempRamMemory.getSize() + "\n" + 
//									tempRamMemory.getFrequency() + "\n" +
//									tempRamMemory.getPriceChanger() + "\n"
//									);
							
						}
					}
					// ***
					
					// *** Getting storageMemories Values
					if (currentLabel.equalsIgnoreCase("HARD DISK (HDD), SSD ou SSHD")) {
						JsonArray choiceArray = setting.getAsJsonObject().get("choice").getAsJsonArray();
						
						for (JsonElement storageMemoryJson : choiceArray) {
							
							StorageMemory tempStorageMemory = getStorageMemoryByJsonObject(storageMemoryJson.getAsJsonObject());
							
							storageMemories.add(tempStorageMemory);
							
//							System.out.println(
//									tempStorageMemory.getType() + "\n" +
//									tempStorageMemory.getSize() + "\n" + 
//									tempStorageMemory.getUnitMeasure() + "\n" +
//									tempStorageMemory.getPriceChanger() + "\n"
//									);
							
						}
					}
					// ***
					
					// *** Getting screen Values
					if (currentLabel.equalsIgnoreCase("TELA (LCD)")) {
						JsonArray choiceArray = setting.getAsJsonObject().get("choice").getAsJsonArray();
						
						for (JsonElement screenJson : choiceArray) {
							
							Screen tempScreen = getScreenByJsonObject(screenJson.getAsJsonObject());
							
							screens.add(tempScreen);
							
//							System.out.println(
//									tempScreen.getInches() + "\n" +
//									tempScreen.getTechnology() + "\n" +
//									tempScreen.getPriceChanger() + "\n"
//									);
							
						}
					}
					// ***
					
					// *** Getting wirelessCards Values
					if (currentLabel.equalsIgnoreCase("WIRELESS")) {
						JsonArray choiceArray = setting.getAsJsonObject().get("choice").getAsJsonArray();
						
						for (JsonElement wirelessCardJson : choiceArray) {
							
							WirelessCard tempWirelessCard = getWirelessCardByJsonObject(wirelessCardJson.getAsJsonObject());
							
							wirelessCards.add(tempWirelessCard);
							
//							System.out.println(
//									tempWirelessCard.getManufacturer() + "\n" +
//									tempWirelessCard.getModel() + "\n" + 
//									tempWirelessCard.getPriceChanger() + "\n"
//									);
							
						}
					}
					// ***
					
					// *** Getting wirelessCards Values
					if (currentLabel.equalsIgnoreCase("SISTEMA OPERACIONAL")) {
						JsonArray choiceArray = setting.getAsJsonObject().get("choice").getAsJsonArray();
						
						for (JsonElement operationalSystemJson : choiceArray) {
							
							OperationalSystem tempOperationalSystem = getOperationalSystemByJsonObject(operationalSystemJson.getAsJsonObject());
							
							operationalSystems.add(tempOperationalSystem);
							
//							System.out.println(
//									tempOperationalSystem.getDescription() + "\n" +
//									tempOperationalSystem.getPriceChanger() + "\n"
//									);
							
						}
					}
					// ***
					
				}
				
			} // End if settingsJson.size
			
			for (VideoCard videoCard : videoCards) {
				for (Processor processor : processors) {
					for (RAMMemory ramMemory : ramMemories) {
						for (StorageMemory storageMemory : storageMemories) {
							for (OperationalSystem operationalSystem : operationalSystems) {
								for (Screen screen : screens) {
									for (WirelessCard wirelessCard : wirelessCards) {
										
										notebooksReturn.add (
												new NotebookVO(
														nameModel, 
														actionProduct, 
														url, 
														color, 
														width, 
														height, 
														depth, 
														weight, 
														battery, 
														chipSet, 
														keyBoard, 
														operationalSystem, 
														price, 
														processor, 
														ramMemory, 
														new SATA(0, null, "", 0), 
														screen, 
														storageMemory, 
														videoCard, 
														wirelessCard
														)
												);
										
									} // Ene for wirelessCards
									
								} // End for screens
								
							} // End for operationalSystems
							
						} // End for storageMemories
						
					} // End for ramMemories
					
				} // End for processors
				
			} // End for videoCards
			
//			break;
			
         } // End while
		
		mongoClient.close();
		
		for (NotebookVO notebookVO : notebooksReturn) {
			
			notebookVO.updatePrices();
			
			System.out.println(
					notebookVO.getNameModel() + " " + 
					notebookVO.getDefaultPrice().getCreditCard() + " " + 
					notebookVO.getPersonalizedPrice().getCreditCard()
					);
		}
		
		System.out.println("notebooksReturn.size: " + notebooksReturn.size());
		
		return notebooksReturn;
	}

	@Override
	public NotebookVO getNotebookByName(String name) throws Exception {
		return null;
	}

	@Override
	public List<NotebookVO> getFilteredNotebookList(NotebookVO notebook) throws Exception {
		return null;
	}
	
	private double[] getDimensionsByString(String inputString) {
		double[] dimensionsValues = new double[3];
		
		dimensionsValues = StringConverter.getDoubleNumbersByString(inputString);
		
		if (inputString.contains("mm")) {
			
			for (int i = 0; i < dimensionsValues.length; i++) {
				dimensionsValues[i] = dimensionsValues[i] / 10;
				
			}
			
		} else if (inputString.contains("\"") || inputString.contains("”")) {
			for (int i = 0; i < dimensionsValues.length; i++) {
				dimensionsValues[i] = dimensionsValues[i] * 2.54;
				
			}
			
		}
		
		for (int i = 0; i < dimensionsValues.length; i++) {
			dimensionsValues[i] = StringConverter.formatDouble(dimensionsValues[i]);
			
		}
		
		return dimensionsValues;
		
	}
	
	private ChipSet getChipSetByJsonArray(JsonArray jsonArrayProperties) {
		
		// *** Chipset
		String chipsetString = jsonArrayProperties.get(0).getAsString();
		
		String manufacturer = null, model = null;
		
		// Get ChipSet manufacturer
		if (chipsetString.contains("Intel"))
			manufacturer = "Intel";
		
		// Get ChipSet model 
		if (chipsetString.contains("HM175"))						
			model = "HM175";
			
		else if (chipsetString.contains("Z170"))
			model = "Z170";
		
		// Create ChipSet
		return new ChipSet(manufacturer, model);
		
	}

	private KeyBoard getKeyBoardByJsonArray(JsonArray jsonArrayProperties) {
		
		String type = "not specified", layout = "not specified", lighting = "not specified";
		boolean gamingKeys = false, programmableKeys = false, antiGhost = false;
		
		for (JsonElement jsonElement : jsonArrayProperties) {
//			System.out.println(jsonElement);
			
			if (jsonElement.getAsString().contains("ilum")) {
				lighting = jsonElement.getAsString().replaceAll("-", "");
				
				if (lighting.charAt(0) == ' ') {
					lighting = lighting.substring(1);					
				}
			}
			
			else if (jsonElement.getAsString().contains("gaming"))
				gamingKeys = true;
			
			else if (jsonElement.getAsString().contains("Padrão"))
				layout = jsonElement.getAsString().substring(2);
			
			else if (jsonElement.getAsString().contains("programáveis"))
				programmableKeys = true;
			
			else if (jsonElement.getAsString().contains("chiclet") || jsonElement.getAsString().contains("Mecânico"))
				type = jsonElement.getAsString().substring(2);
			
			else if (jsonElement.getAsString().contains("anti-ghost"))
				antiGhost = true;
				
				
		}
		
		return new KeyBoard(type, layout, lighting, gamingKeys, programmableKeys, antiGhost);
	}
	
	private Battery getBatteryByJsonArray(JsonArray jsonArrayProperties) {
		
		int cells = 0;
		String tecnology = null;
		
		cells = (int) StringConverter.getDoubleNumbersByString( jsonArrayProperties.getAsString() )[0];
		
		tecnology = jsonArrayProperties.getAsString().substring(4);
		
		return new Battery(cells, tecnology);
	}
	
	private Price getPriceByJsonObject(JsonObject pricesJsonObject) {
		
		double inCash = 0, creditCard = 0, discount = 0;
		int installments = 0;
		String tempString;
		
		// *** Getting inCash value
		if (!pricesJsonObject.get("boleto").getAsJsonObject().get("valor").isJsonNull()) {
			
			tempString = pricesJsonObject.get("boleto").getAsJsonObject().get("valor").getAsString();
			
			inCash = StringConverter.getPriceByString(tempString);
			
		}
		// ***
		
		// *** Getting discount value
		if (!pricesJsonObject.get("boleto").getAsJsonObject().get("desconto").isJsonNull()) {
			
			tempString = pricesJsonObject.get("boleto").getAsJsonObject().get("desconto").getAsString();
			
			discount = StringConverter.getDoubleNumbersByString(tempString)[0];
			
		}
		// ***
		
		// *** Getting creditCard value
		if (!pricesJsonObject.get("cartao_credito").getAsJsonObject().get("valor_total").isJsonNull()) {
			
			tempString = pricesJsonObject.get("cartao_credito").getAsJsonObject().get("valor_total").getAsString();
			
			creditCard = StringConverter.getPriceByString(tempString);
			
		}
		// ***
		
		// *** Getting installments value
		if (!pricesJsonObject.get("cartao_credito").getAsJsonObject().get("quantidade").isJsonNull()) {
			
			tempString = pricesJsonObject.get("cartao_credito").getAsJsonObject().get("quantidade").getAsString();
			
			installments = (int) StringConverter.getDoubleNumbersByString(tempString)[0];
			
		}
		// ***
		
		return new Price(inCash, creditCard, discount, installments);
		
	}
	
	private VideoCard getVideoCardByJsonObject(JsonObject videoCardJsonObject) {
		String manufacturer = null, model = null;
		int dedicatedMemory = 0;
		boolean sli = false;
		double priceChanger = 0;
		
		String tempString = videoCardJsonObject.get("label").getAsString();
		
		// *** Getting manufacturer
		if (tempString.contains("NVIDIA")) {
			manufacturer = "NVIDIA";
			
			// *** Getting model
			if (tempString.contains("950M "))
				model = "GeForce GTX 950M";
			
			else if (tempString.contains("1050 "))
				model = "GeForce GTX 1050";
			
			else if (tempString.contains("1050ti "))
				model = "GeForce GTX 1050ti";
			
			else if (tempString.contains("1060 "))
				model = "GeForce GTX 1060";
			
			else if (tempString.contains("1070 "))
				model = "GeForce GTX 1070";
			
			else if (tempString.contains("1080 "))
				model = "GeForce GTX 1080";
			// ***
			
			// *** Getting dedicatedMemory
			if (tempString.contains("2GB"))
				dedicatedMemory = 2;
			
			else if (tempString.contains("4GB"))
				dedicatedMemory = 4;
			
			else if (tempString.contains("6GB"))
				dedicatedMemory = 6;
			
			else if (tempString.contains("8GB"))
				dedicatedMemory = 8;
			// ***
			
			// *** Getting sli
			if (tempString.contains("SLi"))
				sli = true;
			// ***
			
		}
		// ***
		
		// *** Getting priceChanger
		priceChanger = getPriceChanger(videoCardJsonObject);
		// ***
		
		return new VideoCard(priceChanger, manufacturer, model, dedicatedMemory, sli);
		
	}
	
	private Processor getProcessorByJsonObject(JsonObject processorJsonObject) {
		String manufacturer = null, family = null, model = null;
		int cacheMemory = 0;
		double maxFrequency = 0, priceChanger = 0;
		
		String tempString = processorJsonObject.get("label").getAsString();
		
		// *** Getting manufacturer
		if (tempString.contains("Intel")) {
			manufacturer = "Intel";
			
			// *** Getting family
			if (tempString.contains("i3"))
				family = "i3";
			
			else if (tempString.contains("i5"))
				family = "i3";
			
			else if (tempString.contains("i7"))
				family = "i7";
			
			// ***

			// *** Getting manufacturer
			if (tempString.contains("Intel"))
				manufacturer = "Intel";
			// ***

			// *** Getting model
			if (tempString.contains("7300HQ"))
				model = "7300HQ";
			
			else if (tempString.contains("7700HQ"))
				model = "7700HQ";
			
			else if (tempString.contains("7820HK"))
				model = "7820HK";
			
			else if (tempString.contains("7700 "))
				model = "7700";
			
			else if (tempString.contains("7700K "))
				model = "7700K";
			// ***
			
			double[] tempNumbers = StringConverter.getDoubleNumbersByString(tempString);
			
			// *** Getting cacheMemory
			cacheMemory = (int) tempNumbers[tempNumbers.length - 2];
			// ***
			
			// *** Getting maxFrequency
			maxFrequency = tempNumbers[tempNumbers.length - 1];
			// ***
			
		}
		// ***
		
		// *** Getting priceChanger
		priceChanger = getPriceChanger(processorJsonObject);
		// ***
		
		return new Processor(priceChanger, manufacturer, family, model, cacheMemory, maxFrequency);
		
	}
	
	private RAMMemory getRamMemoryByJsonObject(JsonObject ramMemoryJsonObject) {
		String type = null;
		int size = 0;
		double priceChanger = 0.0, frequency = 0.0;
		
		String tempString = ramMemoryJsonObject.get("label").getAsString();
		
		double[] ramMemoryValues = StringConverter.getDoubleNumbersByString(tempString);
		
		// *** Getting size
		size = (int) ramMemoryValues[0];
		// ***
		
		// *** Getting type
		type = "DDR" + (int) ramMemoryValues[1];
		// ***

		// *** Getting frequency
		frequency = (int) ramMemoryValues[2];
		// ***
		
		// *** Getting priceChanger
		priceChanger = getPriceChanger(ramMemoryJsonObject);
		// ***
		
		return new RAMMemory(priceChanger, type, frequency, size);
		
	}
	
	private StorageMemory getStorageMemoryByJsonObject(JsonObject ramMemoryJsonObject) {
		String type = null, unitMeasure = null;
		int size = 0;
		double priceChanger = 0.0;
		
		String tempString = ramMemoryJsonObject.get("label").getAsString();
		
		// *** Getting type
		if (tempString.contains("SSHD"))
			type = "SSHD";
		
		else if (tempString.contains("SATA III"))
			type = "SSD - SATA III";
		
		else if (tempString.contains("5400 RPM"))
			type = "HD";
		
		else if (tempString.contains("SATAe"))
			type = "SATAe - SSD";
		
		// ***
		
		// *** Getting unitMeasure
		if (tempString.contains("TB"))
			unitMeasure = "TB";
		
		else if (tempString.contains("GB"))
			unitMeasure = "GB";
		// ***
		
		double[] storageMemoryValues = StringConverter.getDoubleNumbersByString(tempString);
		
		// *** Getting size
		if (storageMemoryValues.length == 1)
			size = (int) storageMemoryValues[0];
		
		else
			size = (int) storageMemoryValues[storageMemoryValues.length-2];
		
		// ***
		
		// *** Getting priceChanger
		priceChanger = getPriceChanger(ramMemoryJsonObject);
		// ***
		
		return new StorageMemory(priceChanger, type, unitMeasure, size);
		
	}
	
	private Screen getScreenByJsonObject(JsonObject screenJsonObject) {
		double inches = 0.0;
		double priceChanger = 0.0;
		String technology = "";
		
		String tempString = screenJsonObject.get("label").getAsString();
		
		double[] storageMemoryValues = StringConverter.getDoubleNumbersByString(tempString);
		
		// *** Getting inches
		inches = storageMemoryValues[0];
		// ***
		
		// *** Getting technology
		if (tempString.contains("FullHD") || tempString.contains("FULLHD"))
			technology += "FullHD ";

		if (tempString.contains("3K QHD"))
			technology += "3K QHD ";
		
		if (tempString.contains("4K QFHD"))
			technology += "4K QFHD ";
		
		if (tempString.contains("120Hz / 5ms"))
			technology += "120Hz / 5ms ";
		
		if (tempString.contains("LED-Backlit"))
			technology += "LED-Backlit ";
		
		if (tempString.contains("com Tecnologia G-SYNC"))
			technology += "com Tecnologia G-SYNC ";
		
		if (tempString.contains("Matte"))
			technology += "(Matte)";
		// ***
		
		// *** Getting priceChanger
		priceChanger = getPriceChanger(screenJsonObject);
		// ***
		
		return new Screen(priceChanger, inches, technology);
		
	}
	
	private WirelessCard getWirelessCardByJsonObject(JsonObject wirelessCardJsonObject) {
		double priceChanger = 0.0;
		String manufacturer = null, model = null;
		
		String tempString = wirelessCardJsonObject.get("label").getAsString();
		
		double[] storageMemoryValues = StringConverter.getDoubleNumbersByString(tempString);
		
		// *** Getting manufacturer
		if (tempString.contains("Intel"))
			manufacturer = "Intel";
		
		else if (tempString.contains("Killer"))
			manufacturer = "Killer";
		// ***
		
		// *** Getting model
		
		model = "" + (int) storageMemoryValues[0];
		
		if (model.equalsIgnoreCase("2200"))
			model = "1535";
		// ***
		
		// *** Getting priceChanger
		priceChanger = getPriceChanger(wirelessCardJsonObject);
		// ***
		
		return new WirelessCard(priceChanger, manufacturer, model);
		
	}
	
	private OperationalSystem getOperationalSystemByJsonObject(JsonObject operationalSystemJsonObject) {
		double priceChanger = 0.0;
		String description = null;
		
		String tempString = operationalSystemJsonObject.get("label").getAsString();
		
		// *** Getting description
		description = tempString.substring(0, tempString.length() - 1);
		// ***
		
		// *** Getting priceChanger
		priceChanger = getPriceChanger(operationalSystemJsonObject);
		// ***
		
		return new OperationalSystem(priceChanger, description);
		
	}
	
	private double getPriceChanger(JsonObject jsonObject) {
		
		double priceChanger = 0.0;
		String tempString;
		
		if (!jsonObject.get("signal").isJsonNull()) {
			tempString = jsonObject.get("value").getAsString();
			
			priceChanger = StringConverter.getPriceByString(tempString);
			
			tempString = jsonObject.get("signal").getAsString();
			
			if (tempString.equalsIgnoreCase("-"))
				priceChanger *= -1;
			
		}
		
		return priceChanger;
	}
	
}
