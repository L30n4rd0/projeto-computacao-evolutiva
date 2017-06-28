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
import ufrpe.ppgia.ce.vo.Price;

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
		
		List<NotebookVO> notebooks = new ArrayList<>();
		
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
			
			JsonArray settingsJson = notebookJsonObject.get("especifications").getAsJsonArray();
			
			String color;
			
			double width, height, depth, weight;
			
			Battery battery;
			
			ChipSet chipSet = null;
			
			KeyBoard keyBoard;
			
			Price price;
			// ****
			
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
					
//					tempCont++;
//					System.out.println(tempCont);
//					System.out.println(width);
//					System.out.println(depth);
//					System.out.println(height);
					// ***
					
					// *** Weight
					String weightString = descriptionArray.get(1).getAsString();
					
					weight = StringConverter.getDoubleNumbersByString(weightString)[0];
					
//					tempCont++;
//					System.out.println(tempCont);
//					System.out.println(weight);
					// ***
					
					// *** Color
					if (descriptionArray.size() > 2)
						color = descriptionArray.get(2).getAsString().substring(7);
						
					else
						color = null;
					
//					tempCont++;
//					System.out.println(tempCont);
//					System.out.println(tempCont + color);
					// ***
					
				} else if (currentLabel.equalsIgnoreCase("Chipset") || currentLabel.equalsIgnoreCase("Core Logic")) {
					
					JsonArray chipsetPropertiesArray = specification.getAsJsonObject().get("description").getAsJsonArray();
					
					chipSet = getChipSetByJsonArray(chipsetPropertiesArray);
					
//					tempCont++;
//					System.out.println(tempCont);
//					System.out.println(chipSet.getManufacturer() + " " + chipSet.getModel() + "\n");
					// ***
					
				} else if (currentLabel.equalsIgnoreCase("Teclado")) {
					
					JsonArray keyBoardPropertiesArray = specification.getAsJsonObject().get("description").getAsJsonArray();
					
					keyBoard = getKeyBoardByJsonArray(keyBoardPropertiesArray);
					
//					tempCont++;
//					System.out.println(tempCont);
//					System.out.println(
//							keyBoard.getLayout() + "\n" + 
//							keyBoard.getLighting() + "\n" +
//							keyBoard.getType() + "\n" +
//							keyBoard.isGamingKeys() + "\n" +
//							keyBoard.isProgrammableKeys() + "\n" +
//							keyBoard.isAntiGhost() + "\n");
					// ***
					
				} else if (currentLabel.equalsIgnoreCase("Bateria")) {
					
					JsonArray batteryPropertiesArray = specification.getAsJsonObject().get("description").getAsJsonArray();
					
//					tempCont++;
//					System.out.println(tempCont);
//					System.out.println(batteryPropertiesArray);
					
					battery = getBatteryByJsonArray(batteryPropertiesArray);
					
//					System.out.println(
//							battery.getCells() + "\n" +
//							battery.getTecnology() + "\n");
					// ***
					
				}
				
				
			}
			
			tempCont++;
			System.out.println(tempCont);
			
			price = getPriceByJsonObject(pricesJson);
			
			System.out.println(
					price.getCreditCard() + "\n" +
					price.getDiscount() + "\n" +
					price.getInCash() + "\n" +
					price.getInstallments() + "\n"
					);
			
//			while (specificationsJson.iterator().hasNext()) {
//				JsonObject specification = (JsonObject) specificationsJson.iterator().next();
//				
//				System.out.println(specification.getAsJsonObject().get("label"));
//				
//				
//			}
			
         }
		
		mongoClient.close();
		
		return notebooks;
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
		
		String inCashString = pricesJsonObject.get("boleto").getAsJsonObject().get("valor").getAsString();
		
		inCashString = inCashString.replaceAll(",", "#");
		inCashString = inCashString.replaceAll(".", "");
		inCashString = inCashString.replaceAll("#", ".");
		
		System.out.println(StringConverter.getDoubleNumbersByString(inCashString));
//		inCash = StringConverter.getDoubleNumbersByString(inCashString)[0];
//		System.out.println(inCash);
		
		return new Price(inCash, creditCard, discount, installments);
		
	}
}
