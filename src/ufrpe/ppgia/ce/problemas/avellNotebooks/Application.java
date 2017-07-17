/**
 * 
 */
package ufrpe.ppgia.ce.problemas.avellNotebooks;

import ufrpe.ppgia.ce.problemas.avellNotebooks.control.ControlMigrator;
import ufrpe.ppgia.ce.problemas.avellNotebooks.model.DAOsFactory;
import ufrpe.ppgia.ce.problemas.avellNotebooks.view.AE_avellNotebooks;

/**
 * @author leonardo
 *
 */
public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ControlMigrator controlNotebooks = new ControlMigrator();
		
		try {
			
			new AE_avellNotebooks().executar();
			
//			controlNotebooks.migrateAllNotebooksToNewMongo();
//			controlNotebooks.migrateAllNotebooksToCSV();
//			controlNotebooks.migrateCromossomoOptions();
//			controlNotebooks.migrateAllModelsToNewMongo();
			
//			System.out.println(DAOsFactory.getUniqueInstance().getBatteryDAO().getAll().get(0).getTechnology());
//			System.out.println(DAOsFactory.getUniqueInstance().getChipsetDAO().getAll().get(0).getManufacturer());
//			System.out.println(DAOsFactory.getUniqueInstance().getColorDAO().getAll().get(0));
//			System.out.println(DAOsFactory.getUniqueInstance().getFirstSATA().getAll().get(0));
//			System.out.println(DAOsFactory.getUniqueInstance().getKeyboardDAO().getAll().get(0).getLayout());
//			System.out.println(DAOsFactory.getUniqueInstance().getNameModelDAO().getAll().get(0));
//			System.out.println(DAOsFactory.getUniqueInstance().getOperacionalSystemDAO().getAll().get(0).getDescription());
////			System.out.println(DAOsFactory.getUniqueInstance().getNotebookDAO().getAll().get(0));
//			System.out.println(DAOsFactory.getUniqueInstance().getNotebookModelDAO().getAll().get(0).getUrl());
//			System.out.println(DAOsFactory.getUniqueInstance().getProcessorDAO().getAll().get(0).getModel());
//			System.out.println(DAOsFactory.getUniqueInstance().getProductActionDAO().getAll().get(0));
//			System.out.println(DAOsFactory.getUniqueInstance().getRamMemoryDAO().getAll().get(0).getSize());
//			System.out.println(DAOsFactory.getUniqueInstance().getScreenDAO().getAll().get(0).getInches());
//			System.out.println(DAOsFactory.getUniqueInstance().getSecondSATADAO().getAll().get(0).getType());
//			System.out.println(DAOsFactory.getUniqueInstance().getStorageMemoryDAO().getAll().get(0).getSize());
//			System.out.println(DAOsFactory.getUniqueInstance().getVideoCardDAO().getAll().get(0).getModel());
//			System.out.println(DAOsFactory.getUniqueInstance().getWeightDAO().getAll().get(0));
//			System.out.println(DAOsFactory.getUniqueInstance().getWirelessCardDAO().getAll().get(0).getModel());
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}

}
