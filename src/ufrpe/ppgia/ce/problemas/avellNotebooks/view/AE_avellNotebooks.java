/**
 * 
 */
package ufrpe.ppgia.ce.problemas.avellNotebooks.view;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ufrpe.ppgia.ce.base.Problema;
import ufrpe.ppgia.ce.base.solucao.SolucaoInteira;
import ufrpe.ppgia.ce.operadores.mutacao.MutacaoIncrementosLentos;
import ufrpe.ppgia.ce.operadores.recombinacao.CrossoverNPontosSolucaoInteira;
import ufrpe.ppgia.ce.operadores.recombinacao.CrossoverUmPontoSolucaoInteira;
import ufrpe.ppgia.ce.problemas.avellNotebooks.model.DAOsFactory;
import ufrpe.ppgia.ce.problemas.avellNotebooks.vo.Battery;
import ufrpe.ppgia.ce.problemas.avellNotebooks.vo.ChipSet;
import ufrpe.ppgia.ce.problemas.avellNotebooks.vo.Color;
import ufrpe.ppgia.ce.problemas.avellNotebooks.vo.DefaultNotebookModel;
import ufrpe.ppgia.ce.problemas.avellNotebooks.vo.KeyBoard;
import ufrpe.ppgia.ce.problemas.avellNotebooks.vo.NotebookVO;
import ufrpe.ppgia.ce.problemas.avellNotebooks.vo.Office;
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
	private static final int CHROMOSOME_SIZE = 18;
	
	private List<String> namesModel, productActions;
	private List<Double> weights;
	private List<Color> colors;
	private List<Battery> batteries;
	private List<ChipSet> chipLists;
	private List<KeyBoard> keyBoards;
	private List<OperationalSystem> operatingSystem;
	private List<Office> offices;
//	List<Price> defaultPrice, personalizedPrice;
	private List<Processor> processors;
	private List<RAMMemory> ramMemories;
	private List<Screen> screens;
	private List<StorageMemory> storageMemories, secondStorageMemories, firstSATAs_eM2, secondSATAs_eM2;
	private List<VideoCard> videoCards;
	private List<WirelessCard> wirelessCards;
	
	private Map<String, DefaultNotebookModel> modelsMap;
	
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
		this.offices = this.daosFactory.getOfficeDAO().getAll();
		this.processors = this.daosFactory.getProcessorDAO().getAll();
		this.ramMemories = this.daosFactory.getRamMemoryDAO().getAll();
		this.screens = this.daosFactory.getScreenDAO().getAll();
		this.storageMemories = this.daosFactory.getStorageMemoryDAO().getAll();
		this.secondStorageMemories = this.daosFactory.getSecondStorageMemoryDAO().getAll();
		this.firstSATAs_eM2 = this.daosFactory.getFirstSATA().getAll();
		this.secondSATAs_eM2 = this.daosFactory.getSecondSATADAO().getAll();
		this.videoCards = this.daosFactory.getVideoCardDAO().getAll();
		this.wirelessCards = this.daosFactory.getWirelessCardDAO().getAll();
		
		List<DefaultNotebookModel> modelsTemp = this.daosFactory.getNotebookModelDAO().getAll();
		
		this.modelsMap = new HashMap<>();
		
		for (DefaultNotebookModel notebookModel : modelsTemp)
			this.modelsMap.put(notebookModel.getNameModel(), notebookModel);
		
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
			individuo.setLimiteSuperior(6, this.colors.size() - 1);
			individuo.setLimiteSuperior(7, this.operatingSystem.size() - 1);
			individuo.setLimiteSuperior(8, this.offices.size() - 1);
			individuo.setLimiteSuperior(9, this.processors.size() -1);
			individuo.setLimiteSuperior(10, this.ramMemories.size() - 1);
			individuo.setLimiteSuperior(11, this.screens.size() - 1);
			individuo.setLimiteSuperior(12, this.storageMemories.size() - 1);
			individuo.setLimiteSuperior(13, this.secondStorageMemories.size() - 1);
			individuo.setLimiteSuperior(14, this.firstSATAs_eM2.size() - 1);
			individuo.setLimiteSuperior(15, this.secondSATAs_eM2.size() - 1);
			individuo.setLimiteSuperior(16, this.videoCards.size() - 1);
			individuo.setLimiteSuperior(17, this.wirelessCards.size() - 1);
			
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
		double fitness = 1000, peso = 10, penalidade = 2;
		
		DefaultNotebookModel notebookModel = this.modelsMap.get(this.namesModel.get( solucao.getValor(0) ));
		
		NotebookVO notebook = getNotebookByCromossomo(solucao);
		
		
//		if (this.namesModel.get( solucao.getValor(0) ).equals("Titanium G1546 IRON V4")) {
//			fitness -= peso;
////			System.out.println("Diminuiu no nomeModelo");
//			
//		}
//		
//		if (this.productActions.get( solucao.getValor(1) ).equals("SUPER DESCONTO")) {
//			fitness -= peso;
////			System.out.println("Diminuiu no action");
//			
//		}
//		
//		if (this.weights.get( solucao.getValor(2) ) == 3.2) {
//			fitness -= peso;
////			System.out.println("Diminuiu no peso");
//			
//		}
//		
//		if (this.batteries.get( solucao.getValor(3) ).getCells() == 6) {
//			fitness -= peso;
////			System.out.println("Diminuiu na bateria");
//			
//		}
//		
//		if (this.chipLists.get( solucao.getValor(4) ).getModel().equals("Z170")) {
//			fitness -= peso;
////			System.out.println("Diminuiu no chipset");
//			
//		}
//		
//		if (this.keyBoards.get( solucao.getValor(5) ).isGamingKeys()) {
//			fitness -= peso;
////			System.out.println("Diminuiu no teclado");
//			
//		}
//		
//		if (this.colors.get( solucao.getValor(6) ).getName().equals("Laranja Fosco")) {
//			fitness -= peso;
////			System.out.println("Diminuiu no teclado");
//			
//		}
//		
//		if (this.operatingSystem.get( solucao.getValor(7) ).getDescription().equals("Sem Sistema Operacional")) {
//			fitness -= peso;
////			System.out.println("Diminuiu SO");
//			
//		}
//		
//		if (this.offices.get( solucao.getValor(8) ).getType().equals("Microsoft Office 2016 Home & Business (Word, Excel, PowerPoint, OneNote, Outlook)")) {
//			fitness -= peso;
////			System.out.println("Diminuiu SO");
//			
//		}
		
		// Processador
		if (notebook.getStorageMemory().getType().equals("7700K")) {
			fitness -= 5;
//			System.out.println("Diminuiu no processador");
			
		} else if (notebook.getStorageMemory().getType().equals("7700")) {
			fitness -= 4;
//			System.out.println("Diminuiu no processador");
			
		} else if (notebook.getStorageMemory().getType().equals("7820HK")) {
			fitness -= 3;
//			System.out.println("Diminuiu no processador");
			
		} else if (notebook.getStorageMemory().getType().equals("7700HQ")) {
			fitness -= 2;
//			System.out.println("Diminuiu no processador");
			
		} else if (notebook.getStorageMemory().getType().equals("7300HQ")) {
			fitness -= 1;
//			System.out.println("Diminuiu no processador");
			
		}
		
		// Memória RAM
		if (notebook.getRamMemory().getSize() == 64) {
			fitness -= 5;
//			System.out.println("Diminuiu na RAM");
			
		} else if (notebook.getRamMemory().getSize() == 32) {
			fitness -= 4;
//			System.out.println("Diminuiu na RAM");
			
		} else if (notebook.getRamMemory().getSize() == 24) {
			fitness -= 3;
//			System.out.println("Diminuiu na RAM");
			
		} else if (notebook.getRamMemory().getSize() == 16) {
			fitness -= 2;
//			System.out.println("Diminuiu na RAM");
			
		} else if (notebook.getRamMemory().getSize() == 8) {
			fitness -= 1;
//			System.out.println("Diminuiu na RAM");
			
		}
//		
//		if (this.screens.get( solucao.getValor(11) ).getInches() == 17.3) {
//			fitness -= peso;
////			System.out.println("Diminuiu na tela");
//			
//		}
//		
//		if (this.storageMemories.get( solucao.getValor(12) ).getSize() == 960) {
//			fitness -= peso;
////			System.out.println("Diminuiu no armazenamento");
//			
//		}
//		
//		if (this.secondStorageMemories.get( solucao.getValor(13) ).getSize() == 960) {
//			fitness -= peso;
////			System.out.println("Diminuiu no armazenamento");
//			
//		}
//		
//		if (this.firstSATAs_eM2.get( solucao.getValor(14) ).getSize() == 240) {
//			fitness -= peso;
////			System.out.println("Diminuiu no SATA 1");
//			
//		}
//		
//		if (this.secondSATAs_eM2.get( solucao.getValor(15) ).getSize() == 0) {
//			fitness -= peso;
////			System.out.println("Diminuiu no SATA 2");
//			
//		}
//		
		
		// Placa de vídeo
		if (notebook.getVideoCard().getModel().equals("GeForce GTX 1080")) {
			
			if (notebook.getVideoCard().isSli()) {
				fitness -= 8;
				
			} else {
				fitness -= 7;
				
			}
			
//			System.out.println("Diminuiu na placa de video");
			
		} else if (notebook.getVideoCard().getModel().equals("GeForce GTX 1070")) {
			
			if (notebook.getVideoCard().isSli()) {
				fitness -= 6;
				
			} else {
				fitness -= 5;
				
			}
			
//			System.out.println("Diminuiu na placa de video");
			
		} else if (notebook.getVideoCard().getModel().equals("GeForce GTX 1060")) {
			fitness -= 4;
			
//			System.out.println("Diminuiu na placa de video");
			
		} else if (notebook.getVideoCard().getModel().equals("GeForce GTX 1050ti")) {
			fitness -= 3;
			
//			System.out.println("Diminuiu na placa de video");
			
		} else if (notebook.getVideoCard().getModel().equals("GeForce GTX 1050")) {
			fitness -= 2;
			
//			System.out.println("Diminuiu na placa de video");
			
		} else if (notebook.getVideoCard().getModel().equals("GeForce GTX 950m")) {
			fitness -= 1;
			
//			System.out.println("Diminuiu na placa de video");
			
		}
		
//		
//		if (this.wirelessCards.get( solucao.getValor(17) ).getManufacturer().equals("Intel")) {
//			fitness -= peso;
////			System.out.println("Diminuiu na wireless");
//			
//		}
		
		solucao.setFitness(fitness);
	}
	
	private NotebookVO getNotebookByCromossomo(SolucaoInteira solucao) {
		DefaultNotebookModel notebookModel = this.modelsMap.get(this.namesModel.get( solucao.getValor(0) ));
		
		NotebookVO notebook = new NotebookVO(
				notebookModel.getNameModel(), 
				this.productActions.get( solucao.getValor(1) ), 
				notebookModel.getUrl(), 
				notebookModel.getWidth(), 
				notebookModel.getHeight(), 
				notebookModel.getDepth(), 
				this.weights.get( solucao.getValor(2) ), 
				this.colors.get( solucao.getValor(6) ), 
				this.batteries.get( solucao.getValor(3) ), 
				this.chipLists.get( solucao.getValor(4) ), 
				this.keyBoards.get( solucao.getValor(5) ), 
				this.operatingSystem.get( solucao.getValor(7) ), 
				this.offices.get( solucao.getValor(8) ), 
				notebookModel.getDefaultPrice(), 
				this.processors.get( solucao.getValor(9) ), 
				this.ramMemories.get( solucao.getValor(10) ), 
				this.screens.get( solucao.getValor(11) ), 
				this.storageMemories.get( solucao.getValor(12) ), 
				this.secondStorageMemories.get( solucao.getValor(13) ), 
				this.firstSATAs_eM2.get( solucao.getValor(14) ), 
				this.secondSATAs_eM2.get( solucao.getValor(15) ), 
				this.videoCards.get( solucao.getValor(16) ), 
				this.wirelessCards.get( solucao.getValor(17) )
				);
		
		notebook.updatePrices();
		
//		System.out.println("Padrão: " + notebook.getDefaultPrice().toCsvFormat());
//		System.out.println("Person: " + notebook.getPersonalizedPrice().toCsvFormat());
		
		return notebook;
	}

}
