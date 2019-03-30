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
import ufrpe.ppgia.ce.problemas.avellNotebooks.model.DAOsFactory;
import ufrpe.ppgia.ce.problemas.avellNotebooks.vo.Color;
import ufrpe.ppgia.ce.problemas.avellNotebooks.vo.DefaultNotebookModel;
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

	private NotebookVO notebookOld = null;
	
	// Constants
	private static final int CHROMOSOME_SIZE = 13;
	
	private List<String> namesModel;
//	private List<Double> weights;
	private List<Color> colors;
//	private List<Battery> batteries;
//	private List<ChipSet> chipLists;
//	private List<KeyBoard> keyBoards;
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
//		this.productActions = this.daosFactory.getProductActionDAO().getAll();
		this.colors = this.daosFactory.getColorDAO().getAll();
//		this.weights = this.daosFactory.getWeightDAO().getAll();
//		this.batteries = this.daosFactory.getBatteryDAO().getAll();
//		this.chipLists = this.daosFactory.getChipsetDAO().getAll();
//		this.keyBoards = this.daosFactory.getKeyboardDAO().getAll();
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
//		this.getOperadorCruzamento().setPr(0.9);
//		this.getOperadorMutacao().setPm(0.5);
		
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
//			individuo.setLimiteSuperior(1, this.productActions.size() - 1);
//			individuo.setLimiteSuperior(2, this.weights.size() - 1);
//			individuo.setLimiteSuperior(3, this.batteries.size() - 1);
//			individuo.setLimiteSuperior(4, this.chipLists.size() - 1);
//			individuo.setLimiteSuperior(5, this.keyBoards.size() - 1);
			individuo.setLimiteSuperior(1, this.colors.size() - 1);
			individuo.setLimiteSuperior(2, this.operatingSystem.size() - 1);
			individuo.setLimiteSuperior(3, this.offices.size() - 1);
			individuo.setLimiteSuperior(4, this.processors.size() -1);
			individuo.setLimiteSuperior(5, this.ramMemories.size() - 1);
			individuo.setLimiteSuperior(6, this.screens.size() - 1);
			individuo.setLimiteSuperior(7, this.storageMemories.size() - 1);
			individuo.setLimiteSuperior(8, this.secondStorageMemories.size() - 1);
			individuo.setLimiteSuperior(9, this.firstSATAs_eM2.size() - 1);
			individuo.setLimiteSuperior(10, this.secondSATAs_eM2.size() - 1);
			individuo.setLimiteSuperior(11, this.videoCards.size() - 1);
			individuo.setLimiteSuperior(12, this.wirelessCards.size() - 1);
			
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
		
		double melhorFitness = pop.get(0).getFitness();
		
		NotebookVO notebookAtual = getNotebookByCromossomo(pop.get(0));
		
		if (melhorFitness < getMenorFitness()) {
			setMenorFitness(melhorFitness);
			setMelhorNotebook(notebookAtual);
			
		} else if (melhorFitness > getMaiorFitness()) {
			setMaiorFitness(melhorFitness);
		}		
		
//		if (getIndiceAtualSomatorio() < getQtdIteracoes()) {
			double somatorioAtual = this.somatorioFitnessPorExecucao.get(getIndiceAtualSomatorio());
			this.somatorioFitnessPorExecucao.set(getIndiceAtualSomatorio(), somatorioAtual + melhorFitness);
			
//		}
		
//		System.out.println(" - Melhor fitness: " + melhorFitness);
		
//		int cont = 1;
//		for (SolucaoInteira solucaoInteira : pop) {
//			System.out.println(cont + ": " + solucaoInteira.getFitness());
////			
//			cont++;
//		}
		
		
//		System.out.println(notebookAtual == this.notebookOld);
//		
//		System.out.println(notebookAtual.toString() + "\n*********************");
//		
//		System.out.println("Penalizacao ******************");
//		getPenalidade(notebookAtual);
//		System.out.println("Fim ******************");
		
		this.notebookOld = notebookAtual;
		
		return melhorFitness < 3.0;
	}

	@Override
	public void avaliar(SolucaoInteira solucao) {
		double fitness,
//		notaColor = 0,
//		notaOperatingSystem = 0,
//		notaOffice = 0,
//		notaWirelessCard = 0,
//		notaScreen = 0,
		
		notaProcessor = 0,
		notaRamMemory = 0,
		notaStorageMemory = 0,
		notaSecondStorageMemory = 0,
		notaFirstSATA_eM = 0,
		notaSecondSATA_eM = 0,
		notaVideoCard = 0;
		
		NotebookVO notebook = getNotebookByCromossomo(solucao);
		
		// Processador
		if (notebook.getProcessor().getModel().equals("7700K")) {
			notaProcessor = 10;
			
		} else if (notebook.getProcessor().getModel().equals("7700")) {
			notaProcessor = 7.5;
			
		} else if (notebook.getProcessor().getModel().equals("7820HK")) {
			notaProcessor = 5;
			
		} else if (notebook.getProcessor().getModel().equals("7700HQ")) {
			notaProcessor = 2.5;
			
		} else if (notebook.getProcessor().getModel().equals("7300HQ")) {
			notaProcessor = 1;
			
		}
		
		// Memória RAM
		if (notebook.getRamMemory().getSize() == 64) {
			notaRamMemory = 10;
			
		} else if (notebook.getRamMemory().getSize() == 32 && notebook.getRamMemory().getFrequency() == 2400) {
			notaRamMemory = 9.5;
			
		} else if (notebook.getRamMemory().getSize() == 32 && notebook.getRamMemory().getFrequency() == 2133) {
			notaRamMemory = 8;
			
		} else if (notebook.getRamMemory().getSize() == 24) {
			notaRamMemory = 5;
			
		} else if (notebook.getRamMemory().getSize() == 16 && notebook.getRamMemory().getFrequency() == 2400) {
			notaRamMemory = 3;
			
		} else if (notebook.getRamMemory().getSize() == 16 && notebook.getRamMemory().getFrequency() == 2133) {
			notaRamMemory = 2.5;
			
		} else if (notebook.getRamMemory().getSize() == 8) {
			notaRamMemory = 1;
			
		}
		
		// Armazenamento primario
		if (notebook.getStorageMemory().getType().equals("SSD SATAe M.2")) {
			
			if (notebook.getStorageMemory().getSize() == 960) {
				notaStorageMemory = 10;
				
			} else if (notebook.getStorageMemory().getSize() == 480) {
				notaStorageMemory = 8.5;
				
			} else if (notebook.getStorageMemory().getSize() == 240) {
				notaStorageMemory = 7;
				
			}
			
		} else if (notebook.getStorageMemory().getType().equals("SSD SATA III")) {
			
			if (notebook.getStorageMemory().getSize() == 960) {
				notaStorageMemory = 6;
				
			} else if (notebook.getStorageMemory().getSize() == 480) {
				notaStorageMemory = 5;
				
			} else if (notebook.getStorageMemory().getSize() == 240) {
				notaStorageMemory = 3.5;
				
			}
 
		} else if (notebook.getStorageMemory().getType().equals("SSHD SSD")) {
			
			notaStorageMemory = 2;
 
		} else if (notebook.getStorageMemory().getType().equals("HD 5400 RPM")) {
			
			notaStorageMemory = 1;
 
		}
		
		// Armazenamento secundário
		if (notebook.getSecondStorageMemory().getSize() != 0) {
			
			if (notebook.getSecondStorageMemory().getType().equals("SSD SATA III")) {
				
				if (notebook.getSecondStorageMemory().getSize() == 960) {
					notaSecondStorageMemory = 6;
					
				} else if (notebook.getSecondStorageMemory().getSize() == 480) {
					notaSecondStorageMemory = 5;
					
				} else if (notebook.getSecondStorageMemory().getSize() == 240) {
					notaSecondStorageMemory = 3.5;
					
				}
	 
			} else if (notebook.getSecondStorageMemory().getType().equals("SSHD SSD")) {
				
				notaSecondStorageMemory = 2;
	 
			} else if (notebook.getSecondStorageMemory().getType().equals("HD 5400 RPM")) {
				
				notaSecondStorageMemory = 1;
	 
			}
			
		}
		
		// Primeiro SATAe
		if (notebook.getFirstSATA_eM2().getSize() != 0) {
			
			if (notebook.getFirstSATA_eM2().getType().equals("SSD SATAe M.2")) {
				
				if (notebook.getFirstSATA_eM2().getSize() == 960) {
					notaFirstSATA_eM = 10;
					
				} else if (notebook.getFirstSATA_eM2().getSize() == 480) {
					notaFirstSATA_eM = 8.5;
					
				} else if (notebook.getFirstSATA_eM2().getSize() == 240) {
					notaFirstSATA_eM = 7;
					
				}
	 
			}
		}
		
		// Segundo SATAe
		if (notebook.getSecondSATA_eM2().getSize() != 0) {
			
			if (notebook.getSecondSATA_eM2().getType().equals("SSD SATAe M.2")) {
				
				if (notebook.getSecondSATA_eM2().getSize() == 960) {
					notaSecondSATA_eM = 10;
					
				} else if (notebook.getSecondSATA_eM2().getSize() == 480) {
					notaSecondSATA_eM = 8.5;
					
				} else if (notebook.getSecondSATA_eM2().getSize() == 240) {
					notaSecondSATA_eM = 7;
					
				}
	 
			}
		}
		
		// Placa de vídeo
		if (notebook.getVideoCard().getModel().equals("GeForce GTX 1080")) {
			
			if (notebook.getVideoCard().isSli()) {
				notaVideoCard = 10;
				
			} else {
				notaVideoCard = 9;
				
			}
			
		} else if (notebook.getVideoCard().getModel().equals("GeForce GTX 1070")) {
			
			if (notebook.getVideoCard().isSli()) {
				notaVideoCard = 8;
				
			} else {
				notaVideoCard = 7;
				
			}
			
		} else if (notebook.getVideoCard().getModel().equals("GeForce GTX 1060")) {
			notaVideoCard = 6;
			
		} else if (notebook.getVideoCard().getModel().equals("GeForce GTX 1050ti")) {
			notaVideoCard = 5;
			
		} else if (notebook.getVideoCard().getModel().equals("GeForce GTX 1050")) {

			if (notebook.getVideoCard().getDedicatedMemory() == 4) {
				notaVideoCard = 4;
				
			} else {
				notaVideoCard = 3;
				
			}
			
		} else if (notebook.getVideoCard().getModel().equals("GeForce GTX 950m")) {
			notaVideoCard = 1;
			
		}
		
		double 
		desempenhoMedio = (notaProcessor + notaRamMemory + notaStorageMemory + notaSecondStorageMemory + notaFirstSATA_eM + notaSecondSATA_eM + notaVideoCard) / 7, 
		preco = notebook.getPersonalizedPrice().getInCash();
		
		fitness = Math.sqrt( Math.pow(10.0 - desempenhoMedio, 2) + Math.pow(0.0 - preco, 2));
		
		fitness += getPenalidade(notebook);
		
		solucao.setFitness(fitness);
	}
	
	private NotebookVO getNotebookByCromossomo(SolucaoInteira solucao) {
		DefaultNotebookModel notebookModel = this.modelsMap.get(this.namesModel.get( solucao.getValor(0) ));
		
		NotebookVO notebook = new NotebookVO(
				notebookModel.getNameModel(), // Ou -> this.namesModel.get( solucao.getValor(0)
				notebookModel.getActionProduct(), 
				notebookModel.getUrl(), 
				notebookModel.getWidth(), 
				notebookModel.getHeight(), 
				notebookModel.getDepth(), 
				notebookModel.getWeight(), 
				this.colors.get( solucao.getValor(1) ), 
				notebookModel.getBattery(), 
				notebookModel.getChipSet(), 
				notebookModel.getKeyBoard(), 
				this.operatingSystem.get( solucao.getValor(2) ), 
				this.offices.get( solucao.getValor(3) ), 
				notebookModel.getDefaultPrice(), 
				this.processors.get( solucao.getValor(4) ), 
				this.ramMemories.get( solucao.getValor(5) ), 
				this.screens.get( solucao.getValor(6) ), 
				this.storageMemories.get( solucao.getValor(7) ), 
				this.secondStorageMemories.get( solucao.getValor(8) ), 
				this.firstSATAs_eM2.get( solucao.getValor(9) ), 
				this.secondSATAs_eM2.get( solucao.getValor(10) ), 
				this.videoCards.get( solucao.getValor(11) ), 
				this.wirelessCards.get( solucao.getValor(12) )
				);
		
		notebook.updatePrices();
		
//		System.out.println("Padrão: " + notebook.getDefaultPrice().toCsvFormat());
//		System.out.println("Person: " + notebook.getPersonalizedPrice().toCsvFormat());
		
		return notebook;
	}
	
	private double getPenalidade(NotebookVO notebook) {
		double 
		peso = 0.08, 
		penalidade = 0;

		DefaultNotebookModel notebookModel = this.modelsMap.get( notebook.getNameModel() );
		
		// Penalizar cor
		if (!notebookModel.getColors().contains(notebook.getColor())) {
			penalidade += peso;
//			System.out.println("Penalizou a cor");
			
		}

		// Penalizar sistema operacional
		if (!notebookModel.getOperatingSystems().contains(notebook.getOperationalSystem())) {
			penalidade += peso;
//			System.out.println("Penalizou o SO");
		}

		// Penalizar office
		if (!notebookModel.getOffices().contains(notebook.getOffice())) {
			penalidade += peso;
//			System.out.println("Penalizou o office");
		}

		// Penalizar wireless
		if (!notebookModel.getWirelessCards().contains(notebook.getWirelessCard())) {
			penalidade += peso;
//			System.out.println("Penalizou a wireless");
		}
			
		// Penalizar tela
		if (!notebookModel.getScreens().contains(notebook.getScreen())) {
			penalidade += peso;
//			System.out.println("Penalizou a tela");
			
		}

		// Penalizar processador
		if (!notebookModel.getProcessors().contains(notebook.getProcessor())) {
			penalidade += peso;
//			System.out.println("Penalizou o processador");			
		}

		// Penalizar RAM
		if (!notebookModel.getRamMemories().contains(notebook.getRamMemory())) {
			penalidade += peso;
//			System.out.println("Penalizou a RAM");
		}
		
		// Penalizar armazenamento 1
		if (!notebookModel.getStorageMemories().contains(notebook.getStorageMemory())) {
			penalidade += peso;
//			System.out.println("Penalizou o armazenamento 1");
		}
		
		// Penalizar armazenamento 2
		if (!notebookModel.getSecondStorageMemories().contains(notebook.getSecondStorageMemory())) {
			penalidade += peso;
//			System.out.println("Penalizou o armazenamento 2");
		}

		// Penalizar primeiro SATAe
		if (!notebookModel.getFirstSATAS_eM2().contains(notebook.getFirstSATA_eM2())) {
			penalidade += peso;
//			System.out.println("Penalizou o SATAe 1");
		}

		// Penalizar segundo SATAe
		if (!notebookModel.getSecondSATAS_eM2().contains(notebook.getSecondSATA_eM2())) {
			penalidade += peso;
//			System.out.println("Penalizou o SATAe 2");
			
		}

		// Penalizar placa de vídeo
		if (!notebookModel.getVideoCards().contains(notebook.getVideoCard())) {
			penalidade += peso;
//			System.out.println("Penalizou a placa de video");
		}
		
		return penalidade;
	}

}
