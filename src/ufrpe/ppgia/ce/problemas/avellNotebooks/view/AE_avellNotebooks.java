/**
 * 
 */
package ufrpe.ppgia.ce.problemas.avellNotebooks.view;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import ufrpe.ppgia.ce.base.Problema;
import ufrpe.ppgia.ce.base.solucao.SolucaoInteira;
import ufrpe.ppgia.ce.operadores.mutacao.MutacaoIncrementosLentos;
import ufrpe.ppgia.ce.operadores.recombinacao.CrossoverNPontosSolucaoInteira;
import ufrpe.ppgia.ce.operadores.recombinacao.CrossoverUmPontoSolucaoInteira;
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
		((CrossoverNPontosSolucaoInteira) this.getOperadorCruzamento()).setPr(0.9);
//		((MutacaoIncrementosLentos) this.getOperadorMutacao()).setPm(0.5);
		
	}

	/* (non-Javadoc)
	 * @see ufrpe.ppgia.ce.variantesAE.algoritmoGenetico.GAInteira#inicializar()
	 */
	@Override
	public List<SolucaoInteira> inicializar() {
		List<SolucaoInteira> populacao = new ArrayList<>();
		
		// Imprimir placas de video
		for (VideoCard videoCard : this.videoCards) {
			System.out.println(videoCard.getModel() + "# - Sli: " + videoCard.isSli());
			
		}
		
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
			individuo.setLimiteSuperior(7, this.processors.size() -1);
			individuo.setLimiteSuperior(8, this.ramMemories.size() - 1);
			individuo.setLimiteSuperior(9, this.screens.size() - 1);
			individuo.setLimiteSuperior(10, this.storageMemories.size() - 1);
			individuo.setLimiteSuperior(11, this.firstSATAs_eM2.size() - 1);
			individuo.setLimiteSuperior(12, this.secondSATAs_eM2.size() - 1);
			individuo.setLimiteSuperior(13, this.videoCards.size() - 1);
			individuo.setLimiteSuperior(14, this.wirelessCards.size() - 1);
			
			for(int j = 0; j < individuo.getN(); j++) {
				individuo.setLimiteInferior(j, 0);
				individuo.setValor(
						j, 
						(int) Math.round(
								(Math.random() * (individuo.getLimiteSuperior(j) - individuo.getLimiteInferior(j))) + individuo.getLimiteInferior(j)
								)
						);
				
				
				
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
		
		System.out.println(" - Melhor fitness: " + pop.get(0).getFitness());
		
//		int cont = 1;
//		for (SolucaoInteira solucaoInteira : pop) {
//			System.out.println(cont + ": " + solucaoInteira.getFitness());
////			
//			cont++;
//		}
		
		return pop.get(0).getFitness() == 0.0;
	}

	@Override
	public void avaliar(SolucaoInteira solucao) {
		double fitness = 130, peso = 10;
		
		if (this.namesModel.get( solucao.getValor(0) ).equals("Titanium G1546 IRON V4")) {
			fitness -= peso;
//			System.out.println("Diminuiu no nomeModelo");
			
		}
		
		if (this.productActions.get( solucao.getValor(1) ).equals("SUPER DESCONTO")) {
			fitness -= peso;
//			System.out.println("Diminuiu no action");
			
		}
		
		if (this.weights.get( solucao.getValor(2) ) == 3.2) {
			fitness -= peso;
//			System.out.println("Diminuiu no peso");
			
		}
		
		if (this.batteries.get( solucao.getValor(3) ).getCells() == 6) {
			fitness -= peso;
//			System.out.println("Diminuiu na bateria");
			
		}
		
		if (this.chipLists.get( solucao.getValor(4) ).getModel().equals("Z170")) {
			fitness -= peso;
//			System.out.println("Diminuiu no chipset");
			
		}
		
		if (this.keyBoards.get( solucao.getValor(5) ).isGamingKeys()) {
			fitness -= peso;
//			System.out.println("Diminuiu no teclado");
			
		}
		
		if (this.operatingSystem.get( solucao.getValor(6) ).getDescription().equals("Sem Sistema Operacional")) {
			fitness -= peso;
//			System.out.println("Diminuiu SO");
			
		}
		
		if (this.processors.get( solucao.getValor(7) ).getModel().equals("7820HK")) {
			fitness -= peso;
//			System.out.println("Diminuiu no processador");
			
		}
		
		if (this.ramMemories.get( solucao.getValor(8) ).getSize() == 64) {
			fitness -= peso;
//			System.out.println("Diminuiu na RAM");
			
		}
		
		if (this.screens.get( solucao.getValor(9) ).getInches() == 17.3) {
			fitness -= peso;
//			System.out.println("Diminuiu na tela");
			
		}
		
		if (this.storageMemories.get( solucao.getValor(10) ).getSize() == 960) {
			fitness -= peso;
//			System.out.println("Diminuiu no armazenamento");
			
		}
		
//		if (this.firstSATAs_eM2.get( solucao.getValor(11) ).getSize() == 240) {
//			fitness -= peso;
////			System.out.println("Diminuiu no SATA 1");
//			
//		}
//		
//		if (this.secondSATAs_eM2.get( solucao.getValor(12) ).getSize() == 0) {
//			fitness -= peso;
////			System.out.println("Diminuiu no SATA 2");
//			
//		}
		
		if (this.videoCards.get( solucao.getValor(13) ).getModel().equals("GeForce GTX 1080")) {
			fitness -= peso;
//			System.out.println("Diminuiu na placa de video");
			
		}
		
		if (this.wirelessCards.get( solucao.getValor(14) ).getManufacturer().equals("Intel")) {
			fitness -= peso;
//			System.out.println("Diminuiu na wireless");
			
		}
		
		solucao.setFitness(fitness);
	}

}
