/**
 * 
 */
package ufrpe.ppgia.ce.problemas.avellNotebooks.model.daos;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import ufrpe.ppgia.ce.problemas.avellNotebooks.model.interfaces.ColorDAOInterface;
import ufrpe.ppgia.ce.problemas.avellNotebooks.vo.ChipSet;
import ufrpe.ppgia.ce.problemas.avellNotebooks.vo.Color;
import ufrpe.ppgia.ce.util.ConstantsValues;

/**
 * @author leonardo
 *
 */
public class MongoColorDAO extends AbstractClassDAO implements ColorDAOInterface {

	/**
	 * 
	 */
	public MongoColorDAO() {
		super("avellNew", "colors");
	}

	@Override
	public void insert(Color s) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alter(Color s) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String data) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Color getByStringData(String data) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Color> getAll() throws Exception {
		List<Color> results = new ArrayList<>();
		
		MongoClient mongoClient = new MongoClient(ConstantsValues.SERVER_ADDRESS, ConstantsValues.SERVER_PORT);
		
		MongoDatabase avellDatabase = mongoClient.getDatabase(this.getDataBaseName());
		
		MongoCollection<Document> notebooksCollection = avellDatabase.getCollection(this.getCollection());
		
		MongoCursor<Document> cursor = notebooksCollection.find().iterator();
		
//		FindIterable<Document> notebooksCursor = notebooksCollection.find();
		
//		int tempCont = 0;
		
		while (cursor.hasNext()) {
			Document item = cursor.next();
			
			Gson gson = new Gson();

			// JSON to Java object, read it from a Json String.
			Color result = gson.fromJson(item.toJson(), Color.class);
			
			results.add(result);
			
			
		} // End while
		
		mongoClient.close();
		
		return results;
	}

	

}
