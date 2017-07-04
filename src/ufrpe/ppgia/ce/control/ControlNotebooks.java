/**
 * 
 */
package ufrpe.ppgia.ce.control;

import java.util.List;

import ufrpe.ppgia.ce.model.DAOsFactory;
import ufrpe.ppgia.ce.model.RepositoryMigrator;
import ufrpe.ppgia.ce.vo.NotebookVO;

/**
 * @author leonardo
 *
 */
public class ControlNotebooks {
	
	/*
	 * Insert a new notebook to actual repository
	 * */
	public void insertNotebook(NotebookVO notebook) throws Exception {
		
	}
	
	/*
	 * Update data of a notebook previously registered
	 * */
	public void alterNotebook(NotebookVO notebook) throws Exception {
		
	}
	
	/*
	 * Delete a notebook from the actual repository
	 * */
	public void deleteNotebook(String name) throws Exception {
		
	}
	
	/*
	 * Get all notebook registered on the actual repository
	 * */
	public List<NotebookVO> getAllNotebook() throws Exception {
		
		
		List<NotebookVO> notebooks = DAOsFactory.getUniqueInstance().getNotebookDAO().getAll();
		
		return notebooks;
		
	}
	
	/*
	 * Get a notebook by his name
	 * */
	public NotebookVO getNotebookByName(String name) throws Exception {
		return null;
		
	}
	
	/*
	 * Get a notebook list filtered by the object's data received as a parameter
	 **/	
	public List<NotebookVO> getFilteredNotebookList(NotebookVO notebook) throws Exception {
		return null;
		
	}
	
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
