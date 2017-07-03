/**
 * 
 */
package ufrpe.ppgia.ce.view;

import ufrpe.ppgia.ce.control.ControlNotebooks;

/**
 * @author leonardo
 *
 */
public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ControlNotebooks controlNotebooks = new ControlNotebooks();
		
		try {
//			List<NotebookVO> nnn = controlNotebooks.getAllNotebook();
//			
//			System.out.println(nnn.get(0).toCsvFormat());
//			System.out.println(nnn.get(1).toCsvFormat());
			
//			controlNotebooks.migrateDB_ToNewMongoDB();
//			controlNotebooks.migrateDB_ToCSV();
			controlNotebooks.migrateCromossomoOptions();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}

}
