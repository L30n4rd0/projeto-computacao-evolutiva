/**
 * 
 */
package ufrpe.ppgia.ce.model.daos;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import ufrpe.ppgia.ce.model.interfaces.WeightDAOInterface;
import ufrpe.ppgia.ce.util.ConstantsValues;

/**
 * @author leonardo
 *
 */
public class MongoWeightDAO extends AbstractClassDAO implements WeightDAOInterface {

	/**
	 * 
	 */
	public MongoWeightDAO() {
		super("avellNew", "weights");
	}

	@Override
	public void insert(Double s) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alter(Double s) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String data) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Double getByStringData(String data) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Double> getAll() throws Exception {
		List<Double> results = new ArrayList<>();
		
		MongoClient mongoClient = new MongoClient(ConstantsValues.SERVER_ADDRESS, ConstantsValues.SERVER_PORT);
		
		MongoDatabase avellDatabase = mongoClient.getDatabase(this.getDataBaseName());
		
		MongoCollection<Document> collection = avellDatabase.getCollection(this.getCollection());
		
		MongoCursor<Document> cursor = collection.find().iterator();
		
//		FindIterable<Document> notebooksCursor = notebooksCollection.find();
		
//		int tempCont = 0;
		
		while (cursor.hasNext()) {
			Document item = cursor.next();
			
			results.add(item.getDouble("weight"));
			
		} // End while
		
		mongoClient.close();
		
		return results;
	}

	
	
}
