/**
 * 
 */
package ufrpe.ppgia.ce.problemas.avellNotebooks;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
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
import ufrpe.ppgia.ce.operadores.selecaoDeSobreviventes.SelecaoUniformeInteira;
import ufrpe.ppgia.ce.problemas.avellNotebooks.view.AE_avellNotebooks;
import ufrpe.ppgia.ce.util.ConstantsValues;
import ufrpe.ppgia.ce.util.FileManager;

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
		todosFitnessMedio = new ArrayList<>(),
		probabilidadesRecombinacao = new ArrayList<>(),
		probabilidadesMutacao  = new ArrayList<>();
		
		List<OperadorSelecao<SolucaoInteira>> operadoresSelecaoPais = new ArrayList<>();
		List<OperadorRecombinacao<SolucaoInteira>> operadoresRecombinacao = new ArrayList<>();
		List<OperadorMutacao<SolucaoInteira>> operadoresMutacao = new ArrayList<>();
		
//		qtdsInteracoes.add(1000);
		qtdsInteracoes.add(5000);
		qtdsInteracoes.add(10000);
		
		tamanhosPopulacao.add(50);
		tamanhosPopulacao.add(100);
		tamanhosPopulacao.add(200);
		
		probabilidadesRecombinacao.add(0.75);
		probabilidadesRecombinacao.add(0.85);
		probabilidadesRecombinacao.add(0.95);
		
		probabilidadesMutacao.add(0.03);
		probabilidadesMutacao.add(0.06);
		probabilidadesMutacao.add(0.1);
		
		operadoresSelecaoPais.add(new SelecaoFPS());
		operadoresSelecaoPais.add(new SelecaoUniformeInteira());
		
		operadoresRecombinacao.add(new RecombinacaoCrossoverUmPontoInteira());
		operadoresRecombinacao.add(new RecombinacaoCrossoverNPontosInteira());
		
		operadoresMutacao.add(new MutacaoIncrementosLentos());
		operadoresMutacao.add(new MutacaoInicializacaoAleatoria());
		
		try {
			
			AE_avellNotebooks ae_avellNotebooks = new AE_avellNotebooks();
			
			ae_avellNotebooks.setQtdExecucoes(2);
			
			// Resetando arquivo de notebooks
			FileManager.writeFile(
					"Resultados" + File.separator + "Melhores notebooks por execucoes.txt",
					"*****************************************************************\n",
					false
					);
			
			// Criando cabecalho da planilha geral
			String cabecalhoPlanilhaGeral = 
					"Configuração" + ConstantsValues.CVS_SEPARATOR + 
					"Iterações/Gerações" + ConstantsValues.CVS_SEPARATOR + 
					"Seleção de pais" + ConstantsValues.CVS_SEPARATOR + 
					"Recombinação" + ConstantsValues.CVS_SEPARATOR + 
					"Mutação" + ConstantsValues.CVS_SEPARATOR + 
					"Tamanho população" + ConstantsValues.CVS_SEPARATOR + 
					"PR" + ConstantsValues.CVS_SEPARATOR + 
					"PM" + ConstantsValues.CVS_SEPARATOR + 
					"Menor Fitness" + ConstantsValues.CVS_SEPARATOR + 
					"Maior Fitness" + ConstantsValues.CVS_SEPARATOR +
					"Menor Fitness Medio" + ConstantsValues.CVS_SEPARATOR +
					"Maior Fitness Medio" + ConstantsValues.CVS_SEPARATOR + 
					"Tempo (ms) " + ae_avellNotebooks.getQtdExecucoes() + " execuções\n";
			
			FileManager.writeFile(
					"Resultados" + File.separator + "Planilha geral.csv", 
					cabecalhoPlanilhaGeral, 
					false
					);
			
			for (Integer qtdIteracoes : qtdsInteracoes) {
				
				for (OperadorSelecao<SolucaoInteira> operadorSelecao : operadoresSelecaoPais) {
					
					for (OperadorRecombinacao<SolucaoInteira> operadorRecombinacao : operadoresRecombinacao) {
						
						for (OperadorMutacao<SolucaoInteira> operadorMutacao : operadoresMutacao) {
							
							for (Integer tamanhoPopulacao : tamanhosPopulacao) {
								
								for (Double pr : probabilidadesRecombinacao) {
									
									for (Double pm : probabilidadesMutacao) {
										
										ae_avellNotebooks.setQtdIteracoes(qtdIteracoes);
										ae_avellNotebooks.setOperadorSelecaoPais(operadorSelecao);
										ae_avellNotebooks.setOperadorRecombinacao(operadorRecombinacao);
										ae_avellNotebooks.setOperadorMutacao(operadorMutacao);
										ae_avellNotebooks.setTamanhoPop(tamanhoPopulacao);
										ae_avellNotebooks.getOperadorRecombinacao().setPr(pr);
										ae_avellNotebooks.getOperadorMutacao().setPm(pm);
										
										ae_avellNotebooks.resetResultadosDaExecucao();
										
										long timeIn = System.nanoTime();
										
										System.out.println("Executando " + ae_avellNotebooks.getQtdExecucoes() + " vezes");
										
										for (int i = 0; i < ae_avellNotebooks.getQtdExecucoes(); i++) {
											System.out.println("Execucao: " + (i + 1));
											ae_avellNotebooks.executar();
											
										}
										
										double deltaTime = ( System.nanoTime() - timeIn ) / (1e6); // Convertendo de nanosegundo para milesegundo
										
										System.out.println("Execucoes finalizadas.\nTempo: " + deltaTime + "milisegundos.");
										
										System.out.println("Salvando dados!!");
										
										List<Double> somatoriosDeFitness = ae_avellNotebooks.getSomatorioFitnessPorExecucao();
										
										String tituloPlanilhaAtual = 
												"Dados de " + qtdIteracoes + " iteracoes_" + 
												operadorSelecao.getClass().getSimpleName() + 
												"_" + operadorRecombinacao.getClass().getSimpleName() + 
												"_com PR " + pr + 
												"_" + operadorMutacao.getClass().getSimpleName() + 
												"_com PM " + pm + 
												"_populacao " + tamanhoPopulacao + 
												".csv", 
												
												enderecoPlanilha = "Resultados" + File.separator + tituloPlanilhaAtual;
										
										double fitnessMedioAtual;
										
										// Criar cabeçalho do csv
										FileManager.writeFile(
												enderecoPlanilha, 
												"FitnessMedioPorGeracao" + ConstantsValues.CVS_SEPARATOR + ConstantsValues.CVS_SEPARATOR + 
												"MenorFitness" + ConstantsValues.CVS_SEPARATOR + 
												"MaiorFitness" + ConstantsValues.CVS_SEPARATOR +
												"Tempo de execucao (ms)\n", 
												false
												);
										
										boolean primeiraLinha = true;
										
										for (Double somatorio : somatoriosDeFitness) {
											
											fitnessMedioAtual = somatorio / ae_avellNotebooks.getQtdExecucoes();
											
											todosFitnessMedio.add(fitnessMedioAtual);
											
											if (primeiraLinha) {
												FileManager.writeFile(
														enderecoPlanilha, 
														fitnessMedioAtual + ConstantsValues.CVS_SEPARATOR + ConstantsValues.CVS_SEPARATOR + 
														ae_avellNotebooks.getMenorFitness() + ConstantsValues.CVS_SEPARATOR + 
														ae_avellNotebooks.getMaiorFitness()  + ConstantsValues.CVS_SEPARATOR +
														deltaTime + "\n", 
														true
														);
												primeiraLinha = false;
												
											} else {
												FileManager.writeFile(
														enderecoPlanilha, 
														fitnessMedioAtual + "\n", 
														true
														);
											}
											
											
										}
										
										todosFitnessMedio.sort(Comparator.comparingDouble(Double::doubleValue));
										
										String conteudoDaLinha = 
												tituloPlanilhaAtual + ConstantsValues.CVS_SEPARATOR + 
												qtdIteracoes + ConstantsValues.CVS_SEPARATOR + 
												operadorSelecao.getClass().getSimpleName() + ConstantsValues.CVS_SEPARATOR + 
												operadorRecombinacao.getClass().getSimpleName() + ConstantsValues.CVS_SEPARATOR + 
												operadorMutacao.getClass().getSimpleName() + ConstantsValues.CVS_SEPARATOR + 
												tamanhoPopulacao + ConstantsValues.CVS_SEPARATOR + 
												pr + ConstantsValues.CVS_SEPARATOR + 
												pm + ConstantsValues.CVS_SEPARATOR + 
												ae_avellNotebooks.getMenorFitness() + ConstantsValues.CVS_SEPARATOR + 
												ae_avellNotebooks.getMaiorFitness() + ConstantsValues.CVS_SEPARATOR +
												todosFitnessMedio.get(0) + ConstantsValues.CVS_SEPARATOR + 
												todosFitnessMedio.get(todosFitnessMedio.size() - 1) + ConstantsValues.CVS_SEPARATOR +  
												deltaTime + "\n";
										
										System.out.println("Salvar dados na planilha geral!");
										
										FileManager.writeFile(
												"Resultados" + File.separator + "Planilha geral.csv", 
												conteudoDaLinha, 
												true
												);										
										
										System.out.println("Salvando melhor notebook!");
										
										FileManager.writeFile(
												"Resultados" + File.separator + "Melhores notebooks por execucoes.txt",
												
												tituloPlanilhaAtual + "\n" + 
												"Fitness: " + ae_avellNotebooks.getMenorFitness() + "\n" + 
												ae_avellNotebooks.getMelhorNotebook().toString() + "\n" + 
												"*****************************************************************\n",
												
												true
												);
										
										todosFitnessMedio.clear();
										
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
