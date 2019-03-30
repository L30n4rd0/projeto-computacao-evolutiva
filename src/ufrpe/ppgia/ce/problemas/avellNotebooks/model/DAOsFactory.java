/**
 * 
 */
package ufrpe.ppgia.ce.problemas.avellNotebooks.model;

import ufrpe.ppgia.ce.problemas.avellNotebooks.model.interfaces.BatteryDAOInterface;
import ufrpe.ppgia.ce.problemas.avellNotebooks.model.interfaces.ChipsetDAOInterface;
import ufrpe.ppgia.ce.problemas.avellNotebooks.model.interfaces.ColorDAOInterface;
import ufrpe.ppgia.ce.problemas.avellNotebooks.model.interfaces.FirstSATADAOInterface;
import ufrpe.ppgia.ce.problemas.avellNotebooks.model.interfaces.KeyboardDAOInterface;
import ufrpe.ppgia.ce.problemas.avellNotebooks.model.interfaces.NameModelDAOInterface;
import ufrpe.ppgia.ce.problemas.avellNotebooks.model.interfaces.NotebookDAOInterface;
import ufrpe.ppgia.ce.problemas.avellNotebooks.model.interfaces.NotebookModelDAOInterface;
import ufrpe.ppgia.ce.problemas.avellNotebooks.model.interfaces.OfficeDAOInterface;
import ufrpe.ppgia.ce.problemas.avellNotebooks.model.interfaces.OperacionalSystemDAOInterface;
import ufrpe.ppgia.ce.problemas.avellNotebooks.model.interfaces.ProcessorDAOInterface;
import ufrpe.ppgia.ce.problemas.avellNotebooks.model.interfaces.ProductActionDAOInterface;
import ufrpe.ppgia.ce.problemas.avellNotebooks.model.interfaces.RamMemoryDAOInterface;
import ufrpe.ppgia.ce.problemas.avellNotebooks.model.interfaces.ScreenDAOInterface;
import ufrpe.ppgia.ce.problemas.avellNotebooks.model.interfaces.SecondSATADAOInterface;
import ufrpe.ppgia.ce.problemas.avellNotebooks.model.interfaces.SecondStorageMemoryDAOInterface;
import ufrpe.ppgia.ce.problemas.avellNotebooks.model.interfaces.StorageMemoryDAOInterface;
import ufrpe.ppgia.ce.problemas.avellNotebooks.model.interfaces.VideoCardDAOInterface;
import ufrpe.ppgia.ce.problemas.avellNotebooks.model.interfaces.WeightDAOInterface;
import ufrpe.ppgia.ce.problemas.avellNotebooks.model.interfaces.WirelessCardDAOInterface;

/**
 * @author leonardo
 *
 */
public abstract class DAOsFactory {
	
	public static DAOsFactory daosFactory = null;
	private static boolean isMongoDB = true;

	/**
	 * 
	 */
	protected DAOsFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public synchronized static DAOsFactory getUniqueInstance() {
		if (daosFactory == null) {
			if (isMongoDB)
				daosFactory = new MongoDAOsFactory();
			
			else
				daosFactory = new CsvDAOsFactory();
			
		}
		
		return daosFactory;
		
	}

	public abstract BatteryDAOInterface getBatteryDAO();
	public abstract ChipsetDAOInterface getChipsetDAO();
	public abstract ColorDAOInterface getColorDAO();
	public abstract FirstSATADAOInterface getFirstSATA();
	public abstract KeyboardDAOInterface getKeyboardDAO();
	public abstract OperacionalSystemDAOInterface getOperacionalSystemDAO();
	public abstract OfficeDAOInterface getOfficeDAO();
	public abstract NameModelDAOInterface getNameModelDAO();
	public abstract NotebookDAOInterface getNotebookDAO();
	public abstract NotebookModelDAOInterface getNotebookModelDAO();
	public abstract ProcessorDAOInterface getProcessorDAO();
	public abstract ProductActionDAOInterface getProductActionDAO();
	public abstract RamMemoryDAOInterface getRamMemoryDAO();
	public abstract ScreenDAOInterface getScreenDAO();
	public abstract SecondSATADAOInterface getSecondSATADAO();
	public abstract SecondStorageMemoryDAOInterface getSecondStorageMemoryDAO();
	public abstract StorageMemoryDAOInterface getStorageMemoryDAO();
	public abstract VideoCardDAOInterface getVideoCardDAO();
	public abstract WeightDAOInterface getWeightDAO();
	public abstract WirelessCardDAOInterface getWirelessCardDAO();
	

}
