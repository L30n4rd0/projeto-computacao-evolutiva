/**
 * 
 */
package ufrpe.ppgia.ce.problemas.avellNotebooks.model.interfaces;

import java.util.List;

/**
 * @author leonardo
 *
 */
public interface DAOInterface <S> {
	
	public void insert(S s) throws Exception;
	public void alter(S s) throws Exception;
	public void delete(String data) throws Exception;
	public S getByStringData(String data) throws Exception;
	public List<S> getAll() throws Exception;

}
