/**
 * 
 */
package model;

import java.util.List;

import model.vo.NotebookVO;

/**
 * @author leonardo
 *
 */
public interface InterfaceRepository {
	/*
	 * Insert a new notebook to actual repository
	 * */
	public void insertNotebook(NotebookVO notebook) throws Exception;
	
	/*
	 * Update data of a notebook previously registered
	 * */
	public void alterNotebook(NotebookVO notebook) throws Exception;
	
	/*
	 * Delete a notebook from the actual repository
	 * */
	public void deleteNotebook(String name) throws Exception;
	
	/*
	 * Get all notebook registered on the actual repository
	 * */
	public List<NotebookVO> getAllNotebook() throws Exception;
	
	/*
	 * Get a notebook by his name
	 * */
	public NotebookVO getNotebookByName(String name) throws Exception;
	
	/*
	 * Get a notebook list filtered by the object's data received as a parameter
	 **/	
	public List<NotebookVO> getFilteredNotebookList(NotebookVO notebook) throws Exception;
	

}
