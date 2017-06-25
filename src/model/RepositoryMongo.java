/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import model.vo.NotebookVO;

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
			
			System.out.println(notebook.get("_id"));
			
			Document price = (Document) notebook.get("prices");
			System.out.println( ( (Document) notebook.get("prices") ).get("boleto") );
			
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
