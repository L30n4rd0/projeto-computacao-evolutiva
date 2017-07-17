/**
 * 
 */
package ufrpe.ppgia.ce.problemas.avellNotebooks.model;

import ufrpe.ppgia.ce.problemas.avellNotebooks.model.daos.MongoBatteryDAO;
import ufrpe.ppgia.ce.problemas.avellNotebooks.model.daos.MongoChipsetDAO;
import ufrpe.ppgia.ce.problemas.avellNotebooks.model.daos.MongoColorDAO;
import ufrpe.ppgia.ce.problemas.avellNotebooks.model.daos.MongoFirstSATADAO;
import ufrpe.ppgia.ce.problemas.avellNotebooks.model.daos.MongoKeyboardDAO;
import ufrpe.ppgia.ce.problemas.avellNotebooks.model.daos.MongoNameModelDAO;
import ufrpe.ppgia.ce.problemas.avellNotebooks.model.daos.MongoNotebookDAO;
import ufrpe.ppgia.ce.problemas.avellNotebooks.model.daos.MongoNotebookModelDAO;
import ufrpe.ppgia.ce.problemas.avellNotebooks.model.daos.MongoOfficeDAO;
import ufrpe.ppgia.ce.problemas.avellNotebooks.model.daos.MongoOperationalSystemDAO;
import ufrpe.ppgia.ce.problemas.avellNotebooks.model.daos.MongoProcessadorDAO;
import ufrpe.ppgia.ce.problemas.avellNotebooks.model.daos.MongoProductActionDAO;
import ufrpe.ppgia.ce.problemas.avellNotebooks.model.daos.MongoRamMemoryDAO;
import ufrpe.ppgia.ce.problemas.avellNotebooks.model.daos.MongoScreenDAO;
import ufrpe.ppgia.ce.problemas.avellNotebooks.model.daos.MongoSecondSATADAO;
import ufrpe.ppgia.ce.problemas.avellNotebooks.model.daos.MongoSecondStorageMemoryDAO;
import ufrpe.ppgia.ce.problemas.avellNotebooks.model.daos.MongoStorageMemoryDAO;
import ufrpe.ppgia.ce.problemas.avellNotebooks.model.daos.MongoVideoCardDAO;
import ufrpe.ppgia.ce.problemas.avellNotebooks.model.daos.MongoWeightDAO;
import ufrpe.ppgia.ce.problemas.avellNotebooks.model.daos.MongoWirelessCardDAO;
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
public class MongoDAOsFactory extends DAOsFactory {

	/**
	 * 
	 */
	protected MongoDAOsFactory() {
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

	@Override
	public OperacionalSystemDAOInterface getOperacionalSystemDAO() {
		return new MongoOperationalSystemDAO();
	}

	@Override
	public OfficeDAOInterface getOfficeDAO() {
		return new MongoOfficeDAO();
	}

	@Override
	public SecondStorageMemoryDAOInterface getSecondStorageMemoryDAO() {
		return new MongoSecondStorageMemoryDAO();
	}

}
