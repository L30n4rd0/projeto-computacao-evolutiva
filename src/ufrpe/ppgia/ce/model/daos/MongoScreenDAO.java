/**
 * 
 */
package ufrpe.ppgia.ce.model.daos;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import ufrpe.ppgia.ce.model.interfaces.ScreenDAOInterface;
import ufrpe.ppgia.ce.util.ConstantsValues;
import ufrpe.ppgia.ce.vo.Screen;

/**
 * @author leonardo
 *
 */
public class MongoScreenDAO extends AbstractClassDAO implements ScreenDAOInterface {

	/**
	 * 
	 */
	public MongoScreenDAO() {
		super("avellNew", "screens");
	}

	/* (non-Javadoc)
	 * @see ufrpe.ppgia.ce.model.interfaces.DAOInterface#insert(java.lang.Object)
	 */
	@Override
	public void insert(Screen s) throws Exception {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see ufrpe.ppgia.ce.model.interfaces.DAOInterface#alter(java.lang.Object)
	 */
	@Override
	public void alter(Screen s) throws Exception {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see ufrpe.ppgia.ce.model.interfaces.DAOInterface#delete(java.lang.String)
	 */
	@Override
	public void delete(String data) throws Exception {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see ufrpe.ppgia.ce.model.interfaces.DAOInterface#getByStringData(java.lang.String)
	 */
	@Override
	public Screen getByStringData(String data) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see ufrpe.ppgia.ce.model.interfaces.DAOInterface#getAll()
	 */
	@Override
	public List<Screen> getAll() throws Exception {
		List<Screen> results = new ArrayList<>();
		
		MongoClient mongoClient = new MongoClient(ConstantsValues.SERVER_ADDRESS, ConstantsValues.SERVER_PORT);
		
		MongoDatabase avellDatabase = mongoClient.getDatabase(this.getDataBaseName());
		
		MongoCollection<Document> collection = avellDatabase.getCollection(this.getCollection());
		
		MongoCursor<Document> cursor = collection.find().iterator();
		
//		FindIterable<Document> notebooksCursor = notebooksCollection.find();
		
//		int tempCont = 0;
		
		while (cursor.hasNext()) {
			Document item = cursor.next();
			
			Gson gson = new Gson();

			// JSON to Java object, read it from a Json String.
			Screen result = gson.fromJson(item.toJson(), Screen.class);
			
			results.add(result);
			
			
		} // End while
		
		mongoClient.close();
		
		return results;
	}

}
