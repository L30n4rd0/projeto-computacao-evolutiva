/**
 * 
 */
package ufrpe.ppgia.ce.problemas.avellNotebooks.view;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ufrpe.ppgia.ce.base.Problema;
import ufrpe.ppgia.ce.base.solucao.SolucaoInteira;
import ufrpe.ppgia.ce.problemas.avellNotebooks.model.DAOsFactory;
import ufrpe.ppgia.ce.problemas.avellNotebooks.vo.Battery;
import ufrpe.ppgia.ce.problemas.avellNotebooks.vo.ChipSet;
import ufrpe.ppgia.ce.problemas.avellNotebooks.vo.KeyBoard;
import ufrpe.ppgia.ce.problemas.avellNotebooks.vo.OperationalSystem;
import ufrpe.ppgia.ce.problemas.avellNotebooks.vo.Processor;
import ufrpe.ppgia.ce.problemas.avellNotebooks.vo.RAMMemory;
import ufrpe.ppgia.ce.problemas.avellNotebooks.vo.Screen;
import ufrpe.ppgia.ce.problemas.avellNotebooks.vo.StorageMemory;
import ufrpe.ppgia.ce.problemas.avellNotebooks.vo.VideoCard;
import ufrpe.ppgia.ce.problemas.avellNotebooks.vo.WirelessCard;
import ufrpe.ppgia.ce.variantesAE.algoritmoGenetico.GAInteira;

/**
 * @author leonardo
 *
 */
public class AE_avellNotebooks extends GAInteira implements Problema<SolucaoInteira> {

	// Constants
	private static final int CHROMOSOME_SIZE = 15;
	
	private List<String> namesModel, productActions, colors;
	private List<Double> weights;
	private List<Battery> batteries;
	private List<ChipSet> chipLists;
	private List<KeyBoard> keyBoards;
	private List<OperationalSystem> operatingSystem;
//	List<Price> defaultPrice, personalizedPrice;
	private List<Processor> processors;
	private List<RAMMemory> ramMemories;
	private List<Screen> screens;
	private List<StorageMemory> storageMemories, firstSATAs_eM2, secondSATAs_eM2;
	private List<VideoCard> videoCards;
	private List<WirelessCard> wirelessCards;
	
	private DAOsFactory daosFactory;
	
	public AE_avellNotebooks() throws Exception {
		super();
		
		this.daosFactory = DAOsFactory.getUniqueInstance();
		
		this.namesModel = this.daosFactory.getNameModelDAO().getAll();
		this.productActions = this.daosFactory.getProductActionDAO().getAll();
		this.colors = this.daosFactory.getColorDAO().getAll();
		this.weights = this.daosFactory.getWeightDAO().getAll();
		this.batteries = this.daosFactory.getBatteryDAO().getAll();
		this.chipLists = this.daosFactory.getChipsetDAO().getAll();
		this.keyBoards = this.daosFactory.getKeyboardDAO().getAll();
		this.operatingSystem = this.daosFactory.getOperacionalSystemDAO().getAll();
		this.processors = this.daosFactory.getProcessorDAO().getAll();
		this.ramMemories = this.daosFactory.getRamMemoryDAO().getAll();
		this.screens = this.daosFactory.getScreenDAO().getAll();
		this.storageMemories = this.daosFactory.getStorageMemoryDAO().getAll();
		this.firstSATAs_eM2 = this.daosFactory.getFirstSATA().getAll();
		this.secondSATAs_eM2 = this.daosFactory.getSecondSATADAO().getAll();
		this.videoCards = this.daosFactory.getVideoCardDAO().getAll();
		this.wirelessCards = this.daosFactory.getWirelessCardDAO().getAll();
		
//		this.setTamanhoPop(200);
		
	}

	/* (non-Javadoc)
	 * @see ufrpe.ppgia.ce.variantesAE.algoritmoGenetico.GAInteira#inicializar()
	 */
	@Override
	public List<SolucaoInteira> inicializar() {
		List<SolucaoInteira> populacao = new ArrayList<>();
		
		for (int i = 0; i < this.getTamanhoPop(); i++){
			SolucaoInteira individuo = new SolucaoInteira(CHROMOSOME_SIZE);
			
			// Defining that each gene represent and your max values
			individuo.setLimiteSuperior(0, this.namesModel.size() - 1);
			individuo.setLimiteSuperior(1, this.productActions.size() - 1);
			individuo.setLimiteSuperior(2, this.weights.size() - 1);
			individuo.setLimiteSuperior(3, this.batteries.size() - 1);
			individuo.setLimiteSuperior(4, this.chipLists.size() - 1);
			individuo.setLimiteSuperior(5, this.keyBoards.size() - 1);
			individuo.setLimiteSuperior(6, this.operatingSystem.size() - 1);
			individuo.setLimiteSuperior(7, this.processors.size() - 1);
			individuo.setLimiteSuperior(8, this.ramMemories.size() - 1);
			individuo.setLimiteSuperior(9, this.screens.size() - 1);
			individuo.setLimiteSuperior(10, this.storageMemories.size() - 1);
			individuo.setLimiteSuperior(11, this.firstSATAs_eM2.size() - 1);
			individuo.setLimiteSuperior(12, this.secondSATAs_eM2.size() - 1);
			individuo.setLimiteSuperior(13, this.videoCards.size() - 1);
			individuo.setLimiteSuperior(14, this.wirelessCards.size() - 1);
			
			for(int j = 0; j < individuo.getN(); j++) {
				individuo.setLimiteInferior(j, 0);
				individuo.setValor(j, (int) (Math.random() * (individuo.getLimiteSuperior(j) - individuo.getLimiteInferior(j))) + individuo.getLimiteInferior(j));
				
			}
			
			populacao.add(individuo);
		}
		
		return populacao;
	}

	/* (non-Javadoc)
	 * @see ufrpe.ppgia.ce.variantesAE.algoritmoGenetico.GAInteira#parar(java.util.List)
	 */
	@Override
	public boolean parar(List<SolucaoInteira> pop) {
		pop.sort(Comparator.comparingDouble(SolucaoInteira::getFitness));
		
		System.out.println("Melhor fitness: " + pop.get(0).getFitness());
		
		return pop.get(0).getFitness() == 0.0;
	}

	@Override
	public void avaliar(SolucaoInteira solucao) {
		double fitness = 100;
		
		
		if (this.processors.get(solucao.getValor(7)).getModel().equals("7820HK"))
			fitness -= 25;
		
		if (this.ramMemories.get(solucao.getValor(8)).getSize() == 64)
			fitness -= 25;
		
		if (this.videoCards.get(solucao.getValor(12)).getModel().equals("GeForce GTX 1080"))
			fitness -= 25;
			
		if (this.productActions.get(solucao.getValor(1)).equals("SUPER DESCONTO"))
			fitness -= 25;
		
		solucao.setFitness(fitness);
	}

}
