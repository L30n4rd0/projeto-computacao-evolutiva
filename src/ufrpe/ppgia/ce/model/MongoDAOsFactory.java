/**
 * 
 */
package ufrpe.ppgia.ce.model;

import ufrpe.ppgia.ce.model.daos.MongoBatteryDAO;
import ufrpe.ppgia.ce.model.daos.MongoChipsetDAO;
import ufrpe.ppgia.ce.model.daos.MongoColorDAO;
import ufrpe.ppgia.ce.model.daos.MongoFirstSATADAO;
import ufrpe.ppgia.ce.model.daos.MongoKeyboardDAO;
import ufrpe.ppgia.ce.model.daos.MongoNameModelDAO;
import ufrpe.ppgia.ce.model.daos.MongoNotebookDAO;
import ufrpe.ppgia.ce.model.daos.MongoNotebookModelDAO;
import ufrpe.ppgia.ce.model.daos.MongoProcessadorDAO;
import ufrpe.ppgia.ce.model.daos.MongoProductActionDAO;
import ufrpe.ppgia.ce.model.daos.MongoRamMemoryDAO;
import ufrpe.ppgia.ce.model.daos.MongoScreenDAO;
import ufrpe.ppgia.ce.model.daos.MongoSecondSATADAO;
import ufrpe.ppgia.ce.model.daos.MongoStorageMemoryDAO;
import ufrpe.ppgia.ce.model.daos.MongoVideoCardDAO;
import ufrpe.ppgia.ce.model.daos.MongoWeightDAO;
import ufrpe.ppgia.ce.model.daos.MongoWirelessCardDAO;
import ufrpe.ppgia.ce.model.interfaces.BatteryDAOInterface;
import ufrpe.ppgia.ce.model.interfaces.ChipsetDAOInterface;
import ufrpe.ppgia.ce.model.interfaces.ColorDAOInterface;
import ufrpe.ppgia.ce.model.interfaces.FirstSATADAOInterface;
import ufrpe.ppgia.ce.model.interfaces.KeyboardDAOInterface;
import ufrpe.ppgia.ce.model.interfaces.NameModelDAOInterface;
import ufrpe.ppgia.ce.model.interfaces.NotebookDAOInterface;
import ufrpe.ppgia.ce.model.interfaces.NotebookModelDAOInterface;
import ufrpe.ppgia.ce.model.interfaces.ProcessorDAOInterface;
import ufrpe.ppgia.ce.model.interfaces.ProductActionDAOInterface;
import ufrpe.ppgia.ce.model.interfaces.RamMemoryDAOInterface;
import ufrpe.ppgia.ce.model.interfaces.ScreenDAOInterface;
import ufrpe.ppgia.ce.model.interfaces.SecondSATADAOInterface;
import ufrpe.ppgia.ce.model.interfaces.StorageMemoryDAOInterface;
import ufrpe.ppgia.ce.model.interfaces.VideoCardDAOInterface;
import ufrpe.ppgia.ce.model.interfaces.WeightDAOInterface;
import ufrpe.ppgia.ce.model.interfaces.WirelessCardDAOInterface;

/**
 * @author leonardo
 *
 */
public class MongoDAOsFactory extends DAOsFactory {

	/**
	 * 
	 */
	protected MongoDAOsFactory() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see ufrpe.ppgia.ce.model.DAOsFactory#getBatteryDAO()
	 */
	@Override
	public BatteryDAOInterface getBatteryDAO() {
		return new MongoBatteryDAO();
		
	}

	/* (non-Javadoc)
	 * @see ufrpe.ppgia.ce.model.DAOsFactory#getChipsetDAO()
	 */
	@Override
	public ChipsetDAOInterface getChipsetDAO() {
		return new MongoChipsetDAO();
	}

	/* (non-Javadoc)
	 * @see ufrpe.ppgia.ce.model.DAOsFactory#getColorDAO()
	 */
	@Override
	public ColorDAOInterface getColorDAO() {
		return new MongoColorDAO();
	}

	/* (non-Javadoc)
	 * @see ufrpe.ppgia.ce.model.DAOsFactory#getFirstSATA()
	 */
	@Override
	public FirstSATADAOInterface getFirstSATA() {
		return new MongoFirstSATADAO();
	}

	/* (non-Javadoc)
	 * @see ufrpe.ppgia.ce.model.DAOsFactory#getKeyboardDAO()
	 */
	@Override
	public KeyboardDAOInterface getKeyboardDAO() {
		return new MongoKeyboardDAO();
	}

	/* (non-Javadoc)
	 * @see ufrpe.ppgia.ce.model.DAOsFactory#getNameModelDAO()
	 */
	@Override
	public NameModelDAOInterface getNameModelDAO() {
		return new MongoNameModelDAO();
	}

	/* (non-Javadoc)
	 * @see ufrpe.ppgia.ce.model.DAOsFactory#getNotebookDAO()
	 */
	@Override
	public NotebookDAOInterface getNotebookDAO() {
		return new MongoNotebookDAO();
	}

	/* (non-Javadoc)
	 * @see ufrpe.ppgia.ce.model.DAOsFactory#getNotebookModelDAO()
	 */
	@Override
	public NotebookModelDAOInterface getNotebookModelDAO() {
		return new MongoNotebookModelDAO();
	}

	/* (non-Javadoc)
	 * @see ufrpe.ppgia.ce.model.DAOsFactory#getProcessorDAO()
	 */
	@Override
	public ProcessorDAOInterface getProcessorDAO() {
		return new MongoProcessadorDAO();
	}

	/* (non-Javadoc)
	 * @see ufrpe.ppgia.ce.model.DAOsFactory#getProductActionDAO()
	 */
	@Override
	public ProductActionDAOInterface getProductActionDAO() {
		return new MongoProductActionDAO();
	}

	/* (non-Javadoc)
	 * @see ufrpe.ppgia.ce.model.DAOsFactory#getRamMemoryDAO()
	 */
	@Override
	public RamMemoryDAOInterface getRamMemoryDAO() {
		return new MongoRamMemoryDAO();
	}

	/* (non-Javadoc)
	 * @see ufrpe.ppgia.ce.model.DAOsFactory#getScreenDAO()
	 */
	@Override
	public ScreenDAOInterface getScreenDAO() {
		return new MongoScreenDAO();
	}

	/* (non-Javadoc)
	 * @see ufrpe.ppgia.ce.model.DAOsFactory#getSecondSATADAO()
	 */
	@Override
	public SecondSATADAOInterface getSecondSATADAO() {
		return new MongoSecondSATADAO();
	}

	/* (non-Javadoc)
	 * @see ufrpe.ppgia.ce.model.DAOsFactory#getStorageMemoryDAO()
	 */
	@Override
	public StorageMemoryDAOInterface getStorageMemoryDAO() {
		return new MongoStorageMemoryDAO();
	}

	/* (non-Javadoc)
	 * @see ufrpe.ppgia.ce.model.DAOsFactory#getVideoCardDAO()
	 */
	@Override
	public VideoCardDAOInterface getVideoCardDAO() {
		return new MongoVideoCardDAO();
	}

	/* (non-Javadoc)
	 * @see ufrpe.ppgia.ce.model.DAOsFactory#getWeightDAO()
	 */
	@Override
	public WeightDAOInterface getWeightDAO() {
		return new MongoWeightDAO();
	}

	/* (non-Javadoc)
	 * @see ufrpe.ppgia.ce.model.DAOsFactory#getWirelessCardDAO()
	 */
	@Override
	public WirelessCardDAOInterface getWirelessCardDAO() {
		return new MongoWirelessCardDAO();
	}

}
