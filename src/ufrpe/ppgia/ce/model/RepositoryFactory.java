/**
 * 
 */
package ufrpe.ppgia.ce.model;

/**
 * @author leonardo
 *
 */
public class RepositoryFactory {
	private static InterfaceRepository uniqueInstanceRepository = null;
	
	private RepositoryFactory() {}
	
	/*
	 * Create a single instance of repository for facilitate the data management
	 * */  
	public static synchronized InterfaceRepository getRepositoryInstance() {
		
		if (uniqueInstanceRepository == null)
			uniqueInstanceRepository = new RepositoryMongo();

		return uniqueInstanceRepository;
		
	}
	
}
