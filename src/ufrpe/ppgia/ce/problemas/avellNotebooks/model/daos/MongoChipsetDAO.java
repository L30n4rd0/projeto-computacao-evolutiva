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
import ufrpe.ppgia.ce.problemas.avellNotebooks.vo.ChipSet;
import ufrpe.ppgia.ce.util.ConstantsValues;

/**
 * @author leonardo
 *
 */
public class MongoChipsetDAO extends AbstractClassDAO implements ChipsetDAOInterface {

	/**
	 * 
	 */
	public MongoChipsetDAO() {
		super("avellNew", "chipsets");
	}

	/* (non-Javadoc)
	 * @see ufrpe.ppgia.ce.model.interfaces.DAOInterface#insert(java.lang.Object)
	 */
	@Override
	public void insert(ChipSet s) throws Exception {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see ufrpe.ppgia.ce.model.interfaces.DAOInterface#alter(java.lang.Object)
	 */
	@Override
	public void alter(ChipSet s) throws Exception {
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
	public ChipSet getByStringData(String data) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see ufrpe.ppgia.ce.model.interfaces.DAOInterface#getAll()
	 */
	@Override
	public List<ChipSet> getAll() throws Exception {
		List<ChipSet> results = new ArrayList<>();
		
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
			ChipSet result = gson.fromJson(item.toJson(), ChipSet.class);
			
			results.add(result);
			
			
		} // End while
		
		mongoClient.close();
		
		return results;
	}

}
