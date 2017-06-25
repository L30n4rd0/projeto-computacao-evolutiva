/**
 * 
 */
package view;

import control.ControlNotebooks;

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
			controlNotebooks.getAllNotebook();
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
