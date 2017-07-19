/**
 * 
 */
package ufrpe.ppgia.ce.problemas.avellNotebooks;

import java.util.ArrayList;
import java.util.List;

import ufrpe.ppgia.ce.base.OperadorMutacao;
import ufrpe.ppgia.ce.base.OperadorRecombinacao;
import ufrpe.ppgia.ce.base.OperadorSelecao;
import ufrpe.ppgia.ce.base.solucao.SolucaoInteira;
import ufrpe.ppgia.ce.operadores.mutacao.MutacaoIncrementosLentos;
import ufrpe.ppgia.ce.operadores.mutacao.MutacaoInicializacaoAleatoria;
import ufrpe.ppgia.ce.operadores.recombinacao.RecombinacaoCrossoverNPontosInteira;
import ufrpe.ppgia.ce.operadores.recombinacao.RecombinacaoCrossoverUmPontoInteira;
import ufrpe.ppgia.ce.operadores.selecaoDeSobreviventes.SelecaoFPS;
import ufrpe.ppgia.ce.operadores.selecaoDeSobreviventes.SelecaoPorTorneioInteira;
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
		
//		ControlMigrator controlNotebooks = new ControlMigrator();
		
		List<Integer> 
		qtdsInteracoes = new ArrayList<>(), 
		tamanhosPopulacao = new ArrayList<>();
		
		List<Double> 
		probabilidadesCrossover = new ArrayList<>(),
		probabilidadesMutacao  = new ArrayList<>();
		
		List<OperadorSelecao<SolucaoInteira>> operadoresSelecaoPais = new ArrayList<>();
		List<OperadorRecombinacao<SolucaoInteira>> operadoresRecombinacao = new ArrayList<>();
		List<OperadorMutacao<SolucaoInteira>> operadoresMutacao = new ArrayList<>();
		
		qtdsInteracoes.add(1000);
		qtdsInteracoes.add(5000);
		qtdsInteracoes.add(10000);
		
		tamanhosPopulacao.add(50);
		tamanhosPopulacao.add(100);
		tamanhosPopulacao.add(200);
		
		probabilidadesCrossover.add(0.75);
		probabilidadesCrossover.add(0.85);
		probabilidadesCrossover.add(0.95);
		
		probabilidadesMutacao.add(0.03);
		probabilidadesMutacao.add(0.06);
		probabilidadesMutacao.add(0.1);
		
		operadoresSelecaoPais.add(new SelecaoFPS());
		operadoresSelecaoPais.add(new SelecaoPorTorneioInteira());
		
		operadoresRecombinacao.add(new RecombinacaoCrossoverUmPontoInteira());
		operadoresRecombinacao.add(new RecombinacaoCrossoverNPontosInteira());
		
		operadoresMutacao.add(new MutacaoIncrementosLentos());
		operadoresMutacao.add(new MutacaoInicializacaoAleatoria());
		
		try {
			
			AE_avellNotebooks ae_avellNotebooks = new AE_avellNotebooks();
			
			for (Integer qtdIteracoes : qtdsInteracoes) {
				
				for (OperadorSelecao<SolucaoInteira> operadorSelecao : operadoresSelecaoPais) {
					
					for (OperadorRecombinacao<SolucaoInteira> operadorRecombinacao : operadoresRecombinacao) {
						
						for (OperadorMutacao<SolucaoInteira> operadorMutacao : operadoresMutacao) {
							
							for (Integer tamanhoPopulacao : tamanhosPopulacao) {
								
								for (Double pc : probabilidadesCrossover) {
									
									for (Double pm : probabilidadesMutacao) {
										
										// Aqui a brincadeira inicia
										
									} // Fim for probabilidadesMutacao
									
								} // Fim for probabilidadesCrossover
								
							} // Fim for tamanhosPopulacao
							
						} // Fim for operadoresMutacao
						
					} // Fim for operadoresRecombinacao
					
				} // Fim for operadoresSelecaoPais
				
			} // Fim for iterações
			
			
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
//			System.out.println(DAOsFactory.getUniqueInstance().getNotebookDAO().getAll().get(0));
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
			e.printStackTrace();
		}
		
	}

}
