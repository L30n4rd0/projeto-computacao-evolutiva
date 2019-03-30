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

import ufrpe.ppgia.ce.problemas.avellNotebooks.model.interfaces.ChipsetDAOInterface;
import ufrpe.ppgia.ce.problemas.avellNotebooks.model.interfaces.OfficeDAOInterface;
import ufrpe.ppgia.ce.problemas.avellNotebooks.vo.ChipSet;
import ufrpe.ppgia.ce.problemas.avellNotebooks.vo.Office;
import ufrpe.ppgia.ce.util.ConstantsValues;

/**
 * @author leonardo
 *
 */
public class MongoOfficeDAO extends AbstractClassDAO implements OfficeDAOInterface {

	/**
	 * 
	 */
	public MongoOfficeDAO() {
		super("avellNew", "offices");
	}

	@Override
	public void insert(Office s) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alter(Office s) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String data) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Office getByStringData(String data) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Office> getAll() throws Exception {
		List<Office> results = new ArrayList<>();
		
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
			Office result = gson.fromJson(item.toJson(), Office.class);
			
			results.add(result);
			
			
		} // End while
		
		mongoClient.close();
		
		return results;
	}

}
