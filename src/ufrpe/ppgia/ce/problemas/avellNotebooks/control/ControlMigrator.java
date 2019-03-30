/**
 * 
 */
package ufrpe.ppgia.ce.problemas.avellNotebooks.control;

import ufrpe.ppgia.ce.problemas.avellNotebooks.model.RepositoryMigrator;

/**
 * @author leonardo
 *
 */
public class ControlMigrator {
	
	public void migrateAllNotebooksToCSV() throws Exception {
		new RepositoryMigrator().migrateAllNotebooksToCSV();;
		
	}
	
	public void migrateAllNotebooksToNewMongo() throws Exception {
		new RepositoryMigrator().migrateAllNotebooksToNewMongo();
		
	}
	
	public void migrateCromossomoOptions() throws Exception {
		new RepositoryMigrator().migrateCromossomoOptions();		
		
	}
	
	public void migrateAllModelsToNewMongo() throws Exception {
		new RepositoryMigrator().migrateAllModelsToNewMongo();;
	}

}
