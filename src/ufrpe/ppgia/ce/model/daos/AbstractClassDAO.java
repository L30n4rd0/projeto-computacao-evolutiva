/**
 * 
 */
package ufrpe.ppgia.ce.model.daos;

/**
 * @author leonardo
 *
 */
public abstract class AbstractClassDAO {
	
	private String dataBaseName, collection;

	/**
	 * @param dataBaseName
	 * @param collection
	 */
	public AbstractClassDAO(String dataBaseName, String collection) {
		super();
		this.dataBaseName = dataBaseName;
		this.collection = collection;
	}

	/**
	 * @return the dataBaseName
	 */
	public String getDataBaseName() {
		return dataBaseName;
	}

	/**
	 * @return the collection
	 */
	public String getCollection() {
		return collection;
	}
	
		
	
}
