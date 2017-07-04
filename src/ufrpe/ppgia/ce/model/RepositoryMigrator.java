/**
 * 
 */
package ufrpe.ppgia.ce.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.bson.Document;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import ufrpe.ppgia.ce.util.ConstantsValues;
import ufrpe.ppgia.ce.util.FileManager;
import ufrpe.ppgia.ce.util.StringConverter;
import ufrpe.ppgia.ce.vo.Battery;
import ufrpe.ppgia.ce.vo.ChipSet;
import ufrpe.ppgia.ce.vo.DefaultNotebookModel;
import ufrpe.ppgia.ce.vo.KeyBoard;
import ufrpe.ppgia.ce.vo.NotebookVO;
import ufrpe.ppgia.ce.vo.OperationalSystem;
import ufrpe.ppgia.ce.vo.Price;
import ufrpe.ppgia.ce.vo.Processor;
import ufrpe.ppgia.ce.vo.RAMMemory;
import ufrpe.ppgia.ce.vo.Screen;
import ufrpe.ppgia.ce.vo.StorageMemory;
import ufrpe.ppgia.ce.vo.VideoCard;
import ufrpe.ppgia.ce.vo.WirelessCard;

/**
 * @author leonardo
 *
 */
public class RepositoryMigrator {
	
	private String serverAddress, oldDataBase, newDataBase, collection;
	private int port;
	private String colectedCSV;
	private String sourceJsonCSV;
	
	/**
	 * @param serverAddress
	 * @param oldDataBaseName
	 * @param port
	 * @param mongoClient
	 */
	public RepositoryMigrator() {
		this.serverAddress = "127.0.0.1";
		this.oldDataBase = "avell";
		this.newDataBase = "avellNew";
		this.collection = "notebooks";
		this.port = 27017;
		this.colectedCSV = 
				"modelo,"
				+ "videoCards,"
				+ "processors,"
				+ "ramMemories,"
				+ "storageMemories,"
				+ "firstSATAS_eM2,"
				+ "secondSATAS_eM2,"
				+ "screens,"
				+ "wirelessCards,"
				+ "operatingSystems\n";
		
		this.sourceJsonCSV = 
				"modelo,"
				+ "videoCards,"
				+ "processors,"
				+ "ramMemories,"
				+ "storageMemories,"
				+ "firstSATAS_eM2,"
				+ "secondSATAS_eM2,"
				+ "screens,"
				+ "wirelessCards,"
				+ "operatingSystems\n";
	}
	
	public void migrateCromossomoOptions() throws Exception {
		List<DefaultNotebookModel> notebookModels = getNotebookModelsFromOldMongoDB();
		
		Set<String> namesModel = new HashSet<>(), 
				productActions = new HashSet<>(), 
				colors = new HashSet<>();
		
		Set<Double> weights = new HashSet<>();
		Set<Battery> batteries = new HashSet<>();
		Set<ChipSet> chipSets = new HashSet<>();
		Set<KeyBoard> keyBoards = new HashSet<>();
		Set<OperationalSystem> operatingSystem = new HashSet<>();
//		Set<Price> defaultPrice, personalizedPrice;
		Set<Processor> processors = new HashSet<>();
		Set<RAMMemory> ramMemories = new HashSet<>();
		Set<Screen> screens = new HashSet<>();
		Set<StorageMemory> storageMemories = new HashSet<>(), 
				firstSATAs_eM2 = new HashSet<>(), 
				secondSATAs_eM2 = new HashSet<>();
		
		Set<VideoCard> videoCards = new HashSet<>();
		Set<WirelessCard> wirelessCards = new HashSet<>();
		
		System.out.println("Migratting Cromossomo Options");
		System.out.println("Data unique!");
		
		for (DefaultNotebookModel notebookModel : notebookModels) {
			
			namesModel.add(notebookModel.getNameModel());
		
			productActions.add(notebookModel.getActionProduct());
			
			colors.add(notebookModel.getColor());
		
			weights.add(notebookModel.getWeight());
		
			batteries.add(notebookModel.getBattery());
		
			chipSets.add(notebookModel.getChipSet());
		
			keyBoards.add(notebookModel.getKeyBoard());
			
			operatingSystem.addAll(notebookModel.getOperatingSystems());
			
			processors.addAll(notebookModel.getProcessors());
			
			ramMemories.addAll(notebookModel.getRamMemories());
			
			screens.addAll(notebookModel.getScreens());
			
			storageMemories.addAll(notebookModel.getStorageMemories());
			
			firstSATAs_eM2.addAll(notebookModel.getFirstSATAS_eM2());
			
			secondSATAs_eM2.addAll(notebookModel.getSecondSATAS_eM2());
			
			videoCards.addAll(notebookModel.getVideoCards());
			
			wirelessCards.addAll(notebookModel.getWirelessCards());
			
		} // End for notebookModels
		
		System.out.println("Saving data!");
		
		MongoClient mongoClient = new MongoClient(this.serverAddress, this.port);
		
		MongoDatabase avellDatabase = mongoClient.getDatabase(this.newDataBase);
		
		MongoCollection<Document> collection = null;
		
		String jsonString = "";
		
		Gson gson = new Gson();
		
		// *** Dropping collections if exists
		avellDatabase.getCollection("namesModels").drop();
		
		avellDatabase.getCollection("productsActions").drop();
		
		avellDatabase.getCollection("colors").drop();
		
		avellDatabase.getCollection("weights").drop();
	
		avellDatabase.getCollection("batteries").drop();
		
		avellDatabase.getCollection("chipsets").drop();
	
		avellDatabase.getCollection("keyboards").drop();
		
		avellDatabase.getCollection("operatingSystem").drop();
	
		avellDatabase.getCollection("processors").drop();
	
		avellDatabase.getCollection("ramMemories").drop();
	
		avellDatabase.getCollection("screens").drop();
	
		avellDatabase.getCollection("storageMemories").drop();
	
		avellDatabase.getCollection("firstSATAs").drop();
	
		avellDatabase.getCollection("secondSATAs").drop();
	
		avellDatabase.getCollection("videoCards").drop();
	
		avellDatabase.getCollection("wirelessCards").drop();
		// ***
		
		// *** Data inserting
		for (String name : namesModel) {
			collection = avellDatabase.getCollection("namesModels");
			collection.insertOne(new Document("nameModel", name));
			
		}
		
		for (String productAction : productActions) {
			collection = avellDatabase.getCollection("productsActions");
			
			collection.insertOne(new Document("productAction", productAction));
			
		}
		
		for (String color : colors) {
			collection = avellDatabase.getCollection("colors");
			collection.insertOne(new Document("color", color));
			
		}
			
		for (Double weight : weights) {
			collection = avellDatabase.getCollection("weights");
			collection.insertOne(new Document("weight", weight));
			
		}
		
		for (Battery battery : batteries) {
			collection = avellDatabase.getCollection("batteries");
			jsonString = gson.toJson(battery);
			
			collection.insertOne(Document.parse(jsonString));
			
		}
		
		for (ChipSet chipset : chipSets) {
			collection = avellDatabase.getCollection("chipsets");
			jsonString = gson.toJson(chipset);
			
			collection.insertOne(Document.parse(jsonString));
			
		}
		
		for (KeyBoard keyboard : keyBoards) {
			collection = avellDatabase.getCollection("keyboards");
			jsonString = gson.toJson(keyboard);
			
			collection.insertOne(Document.parse(jsonString));
			
		}
		
		for (OperationalSystem currentOS : operatingSystem) {
			collection = avellDatabase.getCollection("operatingSystem");
			jsonString = gson.toJson(currentOS);
			
			collection.insertOne(Document.parse(jsonString));
			
		}
		
		for (Processor currentProcessor : processors) {
			collection = avellDatabase.getCollection("processors");
			jsonString = gson.toJson(currentProcessor);
			
			collection.insertOne(Document.parse(jsonString));
			
		}
		
		for (RAMMemory currentRamMemory : ramMemories) {
			collection = avellDatabase.getCollection("ramMemories");
			jsonString = gson.toJson(currentRamMemory);
			
			collection.insertOne(Document.parse(jsonString));
			
		}
		
		for (Screen currentScreen : screens) {
			collection = avellDatabase.getCollection("screens");
			jsonString = gson.toJson(currentScreen);
			
			collection.insertOne(Document.parse(jsonString));
			
		}
		
		for (StorageMemory currentStorageMemory : storageMemories) {
			collection = avellDatabase.getCollection("storageMemories");
			jsonString = gson.toJson(currentStorageMemory);
			
			collection.insertOne(Document.parse(jsonString));
			
		}
		
		for (StorageMemory currentFirstSATA : firstSATAs_eM2) {
			collection = avellDatabase.getCollection("firstSATAs");
			jsonString = gson.toJson(currentFirstSATA);
			
			collection.insertOne(Document.parse(jsonString));
			
		}
		
		for (StorageMemory currentSecondSATA : secondSATAs_eM2) {
			collection = avellDatabase.getCollection("secondSATAs");
			jsonString = gson.toJson(currentSecondSATA);
			
			collection.insertOne(Document.parse(jsonString));
			
		}
		
		for (VideoCard currentVideoCard : videoCards) {
			collection = avellDatabase.getCollection("videoCards");
			jsonString = gson.toJson(currentVideoCard);
			
			collection.insertOne(Document.parse(jsonString));
			
		}
		
		for (WirelessCard currentWirelessCard : wirelessCards) {
			collection = avellDatabase.getCollection("wirelessCards");
			jsonString = gson.toJson(currentWirelessCard);
			
			collection.insertOne(Document.parse(jsonString));
			
		}
		
		mongoClient.close();
		System.out.println("Done!");
		
	}
	
	public void migrateAllNotebooksToCSV() throws Exception {
		
		List<NotebookVO> notebooks = getAllNotebooksFromModels( getNotebookModelsFromOldMongoDB() );
		
		System.out.println("Number of notebooks to save: " + notebooks.size());
		
		String csvContent = notebooks.get(0).getCsvHeader() + "\n";
		
		FileManager.writeFile("NotebooksCSV.csv", csvContent, false);
		
		System.out.println("Migrating data to CSV.....");
		
		int cont = 1;
		
		for (NotebookVO notebookVO : notebooks) {
			
			csvContent = notebookVO.toCsvFormat() + "\n";
			
			FileManager.writeFile("NotebooksCSV.csv", csvContent, true);
			
			System.out.println(cont + " Added!");
			
			cont++;
		}
		
		System.out.println("Done!!");
		
		
	}
	
	public void migrateAllNotebooksToNewMongo() throws Exception {
		List<NotebookVO> notebooks = getAllNotebooksFromModels( getNotebookModelsFromOldMongoDB() );
		
		System.out.println("Number of notebooks to save: " + notebooks.size());
		
		MongoClient mongoClient = new MongoClient(this.serverAddress, this.port);
		
		MongoDatabase avellDatabase = mongoClient.getDatabase(this.newDataBase);
		
		avellDatabase.getCollection(this.collection).drop();
		
		MongoCollection<Document> notebooksCollection = avellDatabase.getCollection(this.collection);
		
		String jsonNotebookString = "";
		
		System.out.println("Migrating data to new mongo DB .....");
		
		int cont = 1;
		for (NotebookVO notebookVO : notebooks) {
			
			Gson gson = new Gson();
			
			jsonNotebookString = gson.toJson(notebookVO);
			
			notebooksCollection.insertOne(Document.parse(jsonNotebookString));
			
			System.out.println(cont + " added!");
			cont++;
		}
		
		System.out.println("Done!!");
		
		mongoClient.close();
	}
	
	private List<NotebookVO> getAllNotebooksFromModels(List<DefaultNotebookModel> notebookModels) {
		
		List<NotebookVO> notebooks = new ArrayList<>();
		
		for (DefaultNotebookModel notebookModel : notebookModels) {
			
			for (VideoCard videoCard : notebookModel.getVideoCards()) {
				
				for (Processor processor : notebookModel.getProcessors()) {
					
					for (RAMMemory ramMemory : notebookModel.getRamMemories()) {
						
						for (StorageMemory storageMemory : notebookModel.getStorageMemories()) {

							for (StorageMemory firstSATA_eM2 : notebookModel.getFirstSATAS_eM2()) {
							
								for (StorageMemory secondSATA_eM2 : notebookModel.getSecondSATAS_eM2()) {
								
									for (OperationalSystem operationalSystem : notebookModel.getOperatingSystems()) {
										
										for (Screen screen : notebookModel.getScreens()) {
										
											for (WirelessCard wirelessCard : notebookModel.getWirelessCards()) {

												notebooks.add (
														new NotebookVO(
																notebookModel.getNameModel(), 
																notebookModel.getActionProduct(), 
																notebookModel.getUrl(), 
																notebookModel.getColor(), 
																notebookModel.getWidth(), 
																notebookModel.getHeight(), 
																notebookModel.getDepth(), 
																notebookModel.getWeight(), 
																notebookModel.getBattery(), 
																notebookModel.getChipSet(), 
																notebookModel.getKeyBoard(), 
																operationalSystem, 
																notebookModel.getDefaultPrice(), 
																processor, 
																ramMemory, 
																screen, 
																storageMemory, 
																firstSATA_eM2, 
																secondSATA_eM2, 
																videoCard, 
																wirelessCard
																)
														
														); // End add new notebook
											
											} // End for wirelessCards
											
										} // End for screens
										
									} // End for operationalSystems
									
								} // End for secondSATAS_eM2
								
							} // End for firstSATAS_eM2
							
						} // End for storageMemories
						
					} // End for ramMemories
					
				} // End for processors
				
			} // End for videoCards
			
		} // End for notebookModels
		
		// Update personalized prices
		for (NotebookVO notebookVO : notebooks)
			notebookVO.updatePrices();
		
		return notebooks;
	}
	
	public void migrateAllModelsToNewMongo() throws Exception {
		
		List<DefaultNotebookModel> notebookModels = getNotebookModelsFromOldMongoDB();
		
		MongoClient mongoClient = new MongoClient(this.serverAddress, this.port);
		
		MongoDatabase avellDatabase = mongoClient.getDatabase(this.newDataBase);
		
		avellDatabase.getCollection("models").drop();
		
		MongoCollection<Document> modelsCollection = avellDatabase.getCollection("models");
		
		String jsonModelString = "";
		
		System.out.println("Migrating data to new mongo DB .....");
		
		int cont = 1;
		
		for (DefaultNotebookModel defaultNotebookModel : notebookModels) {
			Gson gson = new Gson();
			
			jsonModelString = gson.toJson(defaultNotebookModel);
			
			modelsCollection.insertOne(Document.parse(jsonModelString));
			
			System.out.println(cont + " added!");
			cont++;
			
		}
		
		System.out.println("Done!!");
		
		mongoClient.close();
		
	}
	
	private List<DefaultNotebookModel> getNotebookModelsFromOldMongoDB() throws Exception {
		
		List<DefaultNotebookModel> notebookModels = new ArrayList<>();
		
		MongoClient mongoClient = new MongoClient(this.serverAddress, this.port);
		
		MongoDatabase avellDatabase = mongoClient.getDatabase(this.oldDataBase);
		
		MongoCollection<Document> notebooksCollection = avellDatabase.getCollection(this.collection);
		
		MongoCursor<Document> notebooksCursor = notebooksCollection.find().iterator();
		
//		FindIterable<Document> notebooksCursor = notebooksCollection.find();
		
		int currentModelCont = 0;
		
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
			
			double width = 0, height = 0, depth = 0, weight = 0;
			
			Battery battery = null;
			
			ChipSet chipSet = null;
			
			KeyBoard keyBoard = null;
			
			Price defaultPrice = null;
			
			List<VideoCard> videoCards = new ArrayList<>();
			
			List<Processor> processors = new ArrayList<>();
			
			List<RAMMemory> ramMemories = new ArrayList<>();
			
			List<StorageMemory> 
			storageMemories = new ArrayList<>(), 
			
			firstSATAS_eM2 = new ArrayList<>(), 
			
			secondSATAS_eM2 = new ArrayList<>();
			
			List<OperationalSystem> operatingSystems = new ArrayList<>();
			
			List<Screen> screens = new ArrayList<>();
			
			List<WirelessCard> wirelessCards = new ArrayList<>();
			// ***
			
			if (settingsJson.size() > 0) {
				
				currentModelCont++;
//				System.out.println("\n" + tempCont);
				
				// Get all specifications
				for (JsonElement specification : specificationsJson) {
					
					String currentLabel = specification.getAsJsonObject().get("label").getAsString();
//					System.out.println("Current: " + currentLabel);
					
					if (currentLabel.contains("Descrição Física")) {
						
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
							color = "Preto";
						
//						System.out.println(tempCont + color);
						// ***
						
					} else if (currentLabel.contains("Chipset") || currentLabel.equalsIgnoreCase("Core Logic")) {
						
						JsonArray chipsetPropertiesArray = specification.getAsJsonObject().get("description").getAsJsonArray();
						
						chipSet = getChipSetByJsonArray(chipsetPropertiesArray);
						
//						System.out.println(chipSet.getManufacturer() + " " + chipSet.getModel() + "\n");
						// ***
						
					} else if (currentLabel.contains("Teclado")) {
						
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
						
					} else if (currentLabel.contains("Bateria")) {
						
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
				defaultPrice = getPriceByJsonObject(pricesJson);
				
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
					if (currentLabel.contains("PLACA DE VÍDEO")) {
						JsonArray choiceArray = setting.getAsJsonObject().get("choice").getAsJsonArray();
						
						this.sourceJsonCSV += nameModel + ConstantsValues.CVS_SEPARATOR + 
								choiceArray.size() + ConstantsValues.CVS_SEPARATOR;
						
						for (JsonElement videoCardJson : choiceArray) {
							
							VideoCard tempVideoCard = getVideoCardByJsonObject(videoCardJson.getAsJsonObject());
							
//							System.out.println(videoCardJson.getAsJsonObject());
							
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
					else if (currentLabel.contains("PROCESSADOR")) {
						JsonArray choiceArray = setting.getAsJsonObject().get("choice").getAsJsonArray();
						
						this.sourceJsonCSV += choiceArray.size() + ConstantsValues.CVS_SEPARATOR;
						
						for (JsonElement processorJson : choiceArray) {
							
							Processor tempProcessor = getProcessorByJsonObject(processorJson.getAsJsonObject());
							
//							System.out.println(processorJson.getAsJsonObject());
							
							processors.add(tempProcessor);
//							System.out.println("Size" + processors.size());
							
//							System.out.println(
//									nameModel + "\n" +
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
					else if (currentLabel.contains("MEMÓRIA")) {
						JsonArray choiceArray = setting.getAsJsonObject().get("choice").getAsJsonArray();
						
						this.sourceJsonCSV += choiceArray.size() + ConstantsValues.CVS_SEPARATOR;
						
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
					else if (currentLabel.contains("HARD DISK (HDD), SSD ou SSHD") && storageMemories.isEmpty()) {
						JsonArray choiceArray = setting.getAsJsonObject().get("choice").getAsJsonArray();
						
						this.sourceJsonCSV += choiceArray.size() + ConstantsValues.CVS_SEPARATOR;
						
						for (JsonElement storageMemoryJson : choiceArray) {
							
							StorageMemory tempStorageMemory = getStorageMemoryByJsonObject(storageMemoryJson.getAsJsonObject());
							
							storageMemories.add(tempStorageMemory);
							
//							System.out.println(tempStorageMemory.toString() + "\n");
							
						}
					}
					// ***
					
					// *** Getting 1ª SATAe M.2 Values
					else if (currentLabel.contains("SATAe M.2") && firstSATAS_eM2.isEmpty()) {
						JsonArray choiceArray = setting.getAsJsonObject().get("choice").getAsJsonArray();
						
						this.sourceJsonCSV += choiceArray.size() + ConstantsValues.CVS_SEPARATOR +
								1 + ConstantsValues.CVS_SEPARATOR; // Add this because same models don't have 2ª SATAe M.2
						
//						System.out.println(nameModel);
//						System.out.println("Sata 1\n" + choiceArray);
						
						for (JsonElement storaJson : choiceArray) {
							
							StorageMemory tempStorageMemory = getStorageMemoryByJsonObject(storaJson.getAsJsonObject());
							
							firstSATAS_eM2.add(tempStorageMemory);
							
//							System.out.println(tempStorageMemory.toString() + "\n");
							
						}
					}
					// ***
					
					// *** Getting 2ª SATAe M.2 Values
					else if (currentLabel.contains("SATAe M.2") && secondSATAS_eM2.isEmpty()) {
						JsonArray choiceArray = setting.getAsJsonObject().get("choice").getAsJsonArray();
						
						this.sourceJsonCSV = this.sourceJsonCSV.substring(0, this.sourceJsonCSV.length() - 2);
						
						this.sourceJsonCSV += choiceArray.size() + ConstantsValues.CVS_SEPARATOR;
						
//						System.out.println(nameModel);
//						System.out.println("Sata 2\n" + choiceArray);
						
						for (JsonElement storaJson : choiceArray) {
							
							StorageMemory tempStorageMemory = getStorageMemoryByJsonObject(storaJson.getAsJsonObject());
							
							secondSATAS_eM2.add(tempStorageMemory);
							
//							System.out.println(tempStorageMemory.toString() + "\n");
							
						}
					}
					// ***
					
					// *** Getting screen Values
					else if (currentLabel.contains("TELA (LCD)")) {
						JsonArray choiceArray = setting.getAsJsonObject().get("choice").getAsJsonArray();
						
						this.sourceJsonCSV += choiceArray.size() + ConstantsValues.CVS_SEPARATOR;
						
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
					else if (currentLabel.contains("WIRELESS")) {
						JsonArray choiceArray = setting.getAsJsonObject().get("choice").getAsJsonArray();
						
						this.sourceJsonCSV += choiceArray.size() + ConstantsValues.CVS_SEPARATOR;
						
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
					else if (currentLabel.contains("SISTEMA OPERACIONAL")) {
						JsonArray choiceArray = setting.getAsJsonObject().get("choice").getAsJsonArray();
						
						this.sourceJsonCSV += choiceArray.size() + ConstantsValues.CVS_SEPARATOR + "\n";
						
						for (JsonElement operationalSystemJson : choiceArray) {
							
							OperationalSystem tempOperationalSystem = getOperationalSystemByJsonObject(operationalSystemJson.getAsJsonObject());
							
							operatingSystems.add(tempOperationalSystem);
							
//							System.out.println(
//									tempOperationalSystem.getDescription() + "\n" +
//									tempOperationalSystem.getPriceChanger() + "\n"
//									);
							
						}
					}
					// ***
					
				}
				
				// Add new DefaultNotebookModel to array
				if (true) {
					
					// The SATAS are optionals
					if (firstSATAS_eM2.size() == 0)
						firstSATAS_eM2.add(new StorageMemory(0.0, null, null, 0));
					
					if (secondSATAS_eM2.size() == 0)
						secondSATAS_eM2.add(new StorageMemory(0.0, null, null, 0));
					
					notebookModels.add(
							new DefaultNotebookModel(
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
									operatingSystems, 
									defaultPrice, 
									processors, 
									ramMemories, 
									storageMemories, 
									firstSATAS_eM2, 
									secondSATAS_eM2, 
									screens, 
									videoCards, 
									wirelessCards
									)
							
							); // End add DefaultNotebookModel
					
					
				} // End if add
				
				colectedCSV += nameModel + ConstantsValues.CVS_SEPARATOR +
						videoCards.size() + ConstantsValues.CVS_SEPARATOR +
						processors.size() + ConstantsValues.CVS_SEPARATOR +
						ramMemories.size() + ConstantsValues.CVS_SEPARATOR +
						storageMemories.size() + ConstantsValues.CVS_SEPARATOR +
						firstSATAS_eM2.size() + ConstantsValues.CVS_SEPARATOR +
						secondSATAS_eM2.size() + ConstantsValues.CVS_SEPARATOR +
						screens.size() + ConstantsValues.CVS_SEPARATOR +
						wirelessCards.size() + ConstantsValues.CVS_SEPARATOR +
						operatingSystems.size() + "\n";
				
			} // End if settingsJson.size
			
         } // End while
		
//		System.out.println("Models size: " + notebookModels.size());
//		
//		System.out.println(this.colectedCSV);
//		
//		System.out.println(this.sourceJsonCSV);
		
//		FileManager.writeFile("colectedCSV.csv", this.colectedCSV);
//		
//		FileManager.writeFile("sourceJsonCSV.csv", this.sourceJsonCSV);
		
		mongoClient.close();
		
		return notebookModels;
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
		if (chipsetString.contains("Intel")) {
			manufacturer = "Intel";
			
			// Get ChipSet model 
			if (chipsetString.contains("HM175"))						
				model = "HM175";
			
			else if (chipsetString.contains("Z170"))
				model = "Z170";
			
		}
		
		
		// Create ChipSet
		return new ChipSet(manufacturer, model);
		
	}

	private KeyBoard getKeyBoardByJsonArray(JsonArray jsonArrayProperties) {
		
		String type = "not specified", layout = "not specified", lighting = "not specified";
		boolean gamingKeys = false, programmableKeys = false, antiGhost = false;
		
		for (JsonElement jsonElement : jsonArrayProperties) {
			
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
		String technology = null;
		
		cells = (int) StringConverter.getDoubleNumbersByString( jsonArrayProperties.getAsString() )[0];
		
		technology = jsonArrayProperties.getAsString().substring(4);
		
		return new Battery(cells, technology);
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
				family = "i5";
			
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
		
		if (!tempString.contains("Nenhum")) {
			
			type = "";
			
			// *** Getting type
			if (tempString.contains("SSHD"))
				type += "SSHD ";
			
			if (tempString.contains("SSD"))
				type += "SSD ";
			
			if (tempString.contains("5400 RPM"))
				type += "HD 5400 RPM ";
			
			if (tempString.contains("SATA III"))
				type += "SATA III ";
			
			if (tempString.contains("SATAe"))
				type += "SATAe ";
			
			if (tempString.contains("M.2"))
				type += "M.2";
			
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
			
		}
		
		if (type != null && type.charAt(type.length() -1) == ' ')
			type = type.substring(0, type.length() - 1);
		
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
