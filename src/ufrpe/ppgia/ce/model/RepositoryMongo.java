/**
 * 
 */
package ufrpe.ppgia.ce.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import ufrpe.ppgia.ce.util.StringConverter;
import ufrpe.ppgia.ce.vo.Battery;
import ufrpe.ppgia.ce.vo.ChipSet;
import ufrpe.ppgia.ce.vo.KeyBoard;
import ufrpe.ppgia.ce.vo.NotebookVO;

/**
 * @author leonardo
 *
 */
public class RepositoryMongo implements InterfaceRepository {
	
	private String serverAddress, dataBaseName, collection;
	private int port;
//	private MongoClient mongoClient;
	
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
//		this.mongoClient = new MongoClient(this.sever, this.port);
	}
	
//	private MongoDatabase getDataBase() throws Exception {
//		
//		return this.mongoClient.getDatabase(this.dataBaseName);
//		
//	}

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
		
		while (notebooksCursor.hasNext()) {
			Document notebook = notebooksCursor.next();
			
			JsonObject notebookJson = new Gson().fromJson(notebook.toJson(), JsonObject.class);
			
			// *** Temp param variables *** 
			String nameModel = notebookJson.get("title").getAsString();
			
			String actionProduct = notebookJson.get("action_product").getAsString();
			
			String url = notebookJson.get("url").getAsString();
			
			JsonArray specificationsJson = notebookJson.get("especifications").getAsJsonArray();
			
			String color;
			
			double width, height, depth, weight;
			
			Battery battery;
			
			ChipSet chipSet;
			
			KeyBoard keyBoard;
			// ****
			
			for (JsonElement specification : specificationsJson) {
				
				String currentLabel = specification.getAsJsonObject().get("label").getAsString();
				
				if (currentLabel.equalsIgnoreCase("Descrição Física")) {
					
					JsonArray arrayDescription = specification.getAsJsonObject().get("description").getAsJsonArray();
					
					// Dimensions
					
					String dimensions = arrayDescription.get(0).getAsString();
					
					double[] dimensionsArray = StringConverter.convertToNumbers(dimensions);
					
					for (double d : dimensionsArray) {
						System.out.println(d);
					}
					
					// Weight
					System.out.println(arrayDescription.get(1));
					
					// Color
					System.out.println(arrayDescription.get(2));
					
					
				}
				
				
			}
			
//			Iterator<E>
			
//			while (specificationsJson.iterator().hasNext()) {
//				JsonObject specification = (JsonObject) specificationsJson.iterator().next();
//				
//				System.out.println(specification.getAsJsonObject().get("label"));
//				
//				
//			}
			
			
//			System.out.println(notebook.toJson());
			
//			Document price = (Document) notebook.get("prices");
//			System.out.println( ( (Document) notebook.get("prices") ).get("cartao_credito") );
			
			break;
 
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

	
}
