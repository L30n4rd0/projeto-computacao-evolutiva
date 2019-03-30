/**
 * 
 */
package ufrpe.ppgia.ce.problemas.avellNotebooks.model.daos;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import ufrpe.ppgia.ce.problemas.avellNotebooks.model.interfaces.ProductActionDAOInterface;
import ufrpe.ppgia.ce.util.ConstantsValues;

/**
 * @author leonardo
 *
 */
public class MongoProductActionDAO extends AbstractClassDAO implements ProductActionDAOInterface {

	/**
	 * 
	 */
	public MongoProductActionDAO() {
		super("avellNew", "productsActions");
	}

	/* (non-Javadoc)
	 * @see ufrpe.ppgia.ce.model.interfaces.DAOInterface#insert(java.lang.Object)
	 */
	@Override
	public void insert(String s) throws Exception {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see ufrpe.ppgia.ce.model.interfaces.DAOInterface#alter(java.lang.Object)
	 */
	@Override
	public void alter(String s) throws Exception {
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
	public String getByStringData(String data) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see ufrpe.ppgia.ce.model.interfaces.DAOInterface#getAll()
	 */
	@Override
	public List<String> getAll() throws Exception {
		List<String> results = new ArrayList<>();
		
		MongoClient mongoClient = new MongoClient(ConstantsValues.SERVER_ADDRESS, ConstantsValues.SERVER_PORT);
		
		MongoDatabase avellDatabase = mongoClient.getDatabase(this.getDataBaseName());
		
		MongoCollection<Document> collection = avellDatabase.getCollection(this.getCollection());
		
		MongoCursor<Document> cursor = collection.find().iterator();
		
//		FindIterable<Document> notebooksCursor = notebooksCollection.find();
		
//		int tempCont = 0;
		
		while (cursor.hasNext()) {
			Document item = cursor.next();
			
			results.add(item.getString("productAction"));
			
			
		} // End while
		
		mongoClient.close();
		
		return results;
	}

}
