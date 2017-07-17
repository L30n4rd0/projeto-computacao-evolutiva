/**
 * 
 */
package ufrpe.ppgia.ce.variantesAE.algoritmoGenetico;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import ufrpe.ppgia.ce.base.AE;
import ufrpe.ppgia.ce.base.OperadorMutacao;
import ufrpe.ppgia.ce.base.OperadorRecombinacao;
import ufrpe.ppgia.ce.base.solucao.SolucaoInteira;
import ufrpe.ppgia.ce.operadores.mutacao.MutacaoIncrementosLentos;
import ufrpe.ppgia.ce.operadores.recombinacao.CrossoverNPontosSolucaoInteira;
import ufrpe.ppgia.ce.operadores.recombinacao.CrossoverUmPontoSolucaoInteira;
import ufrpe.ppgia.ce.operadores.selecaoDeSobreviventes.SelecaoPorElitismo;

/**
 * @author leonardo
 *
 */
public class GAInteira extends AE<SolucaoInteira> {

	/**
	 * Por padr�o a probalidade de muta��o � 0.1 
	 */
	private OperadorMutacao<SolucaoInteira> operadorMutacao;
	
	/**
	 * Por padr�o a probalidade de cruzamento � 1 
	 */
	private OperadorRecombinacao<SolucaoInteira> operadorCruzamento;
	
	/**
	 * Por padr�o o tamanho da popula��o � 100 
	 */
	private int tamanhoPop;
	
	/**
	 * 
	 */
	protected GAInteira() {
		super();
		
		this.operadorMutacao = new MutacaoIncrementosLentos();
		
		this.operadorCruzamento = new CrossoverNPontosSolucaoInteira();
		
		this.tamanhoPop = 100;
	}

	@Override
	public void executar() {
		List<SolucaoInteira> pop = inicializar();
		
		for (SolucaoInteira individuo : pop) {
			avaliar(individuo);
		}
		
		int iteracao = 0;
		System.out.print("Iteracao: " + iteracao);
		
		while (!parar(pop) && iteracao < 500000) {
			iteracao++;
			SolucaoInteira[] pais = selecionarPais(pop);
			SolucaoInteira[] descendentes = recombinar(pais);
			
//			for (int i = 0; i < pais.length; i++) {
//				System.out.println("Fitness pai: " + pais[i].getFitness());
//			}
			
			for(int i = 0; i < descendentes.length; i++) {
				descendentes[i] = executarMutacao(descendentes[i]);
				avaliar(descendentes[i]);
			}
			
			pop = selecionarSobreviventes(pop, descendentes);
			
			// Imprimir pop
//			for (SolucaoInteira solucaoInteira : pop) {
//			
//				for (int i = 0; i < solucaoInteira.getN(); i++) {
//					System.out.print(solucaoInteira.getValor(i) + " ");
//					
//				}
//				System.out.println("\n");
//			}
			
			System.out.print("Iteracao: " + iteracao);
		}
		
	}	
	
	@Override
	public List<SolucaoInteira> inicializar() {
		List<SolucaoInteira> populacao = new ArrayList<>();
		
		for (int i = 0; i < this.tamanhoPop; i++){
			SolucaoInteira individuo = new SolucaoInteira(10);
			
			for(int j = 0; j < individuo.getN(); j++) {
				individuo.setLimiteInferior(j, 0);
				individuo.setLimiteSuperior(j, 10);
				individuo.setValor(j, (int) (Math.random() * (individuo.getLimiteSuperior(j) - individuo.getLimiteInferior(j))) + individuo.getLimiteInferior(j));
				
			}
			
			populacao.add(individuo);
		}
		
		return populacao;
	}

	@Override
	public void avaliar(SolucaoInteira s) {
		
	}

	@Override
	public boolean parar(List<SolucaoInteira> pop) {
		return false;
	}

	@Override
	public SolucaoInteira[] selecionarPais(List<SolucaoInteira> pop) {
		SelecaoPorElitismo solucao = new SelecaoPorElitismo();
		
		SolucaoInteira[] popIntermediaria = new SolucaoInteira[pop.size()];
		
		for(int i = 0; i < pop.size(); i += 2) {
			List<SolucaoInteira> paisSelecionados =  solucao.selecionar(pop);
			
//			for (SolucaoInteira solucaoInteira : paisSelecionados) {
//				System.out.println("Fitness pai selecionado: " + solucaoInteira.getFitness());
//				
//			}
			
			popIntermediaria[i] = paisSelecionados.get(0);
			popIntermediaria[i + 1] = paisSelecionados.get(1);
			
		}
		
		return popIntermediaria;
	}

	@Override
	public List<SolucaoInteira> selecionarSobreviventes(List<SolucaoInteira> pop, SolucaoInteira[] descendentes) {
		pop.sort(Comparator.comparingDouble(SolucaoInteira::getFitness));
		
		// Elitismo
		SolucaoInteira melhorSolucao = pop.get(0);
		
		List<SolucaoInteira> sobreviventes = new ArrayList<>();
		
		sobreviventes.add(melhorSolucao);
		
		for(int i = 1; i < descendentes.length; i++) {
			sobreviventes.add(descendentes[i]);
			
		}
		
		return sobreviventes;
	}

	@Override
	public SolucaoInteira[] recombinar(SolucaoInteira[] pais) {
		
		//Embaralhando o array de pais
		List<SolucaoInteira> paisAux= new ArrayList<>(Arrays.asList(pais));
		
		long seed = System.nanoTime();
		Collections.shuffle(paisAux, new Random(seed));
		SolucaoInteira[] paisEmbaralhados = new SolucaoInteira[pais.length];
		paisEmbaralhados = paisAux.toArray(paisEmbaralhados);
		
		SolucaoInteira[] filhos = new SolucaoInteira[pais.length];
		
		for(int i = 0; i < paisEmbaralhados.length; i += 2) {
			SolucaoInteira[] filhosDaVez = operadorCruzamento.recombinar(paisEmbaralhados[i], paisEmbaralhados[i + 1]);
			filhos[i] = filhosDaVez[0];
			filhos[i + 1] = filhosDaVez[1];
		}
		
		return filhos;
	}

	@Override
	public SolucaoInteira executarMutacao(SolucaoInteira pai) {
		
		return operadorMutacao.executarMutacao(pai);
		
	}
	
	/**
	 * @return the tamanhoPop
	 */
	public int getTamanhoPop() {
		return tamanhoPop;
	}

	/**
	 * @param tamanhoPop the tamanhoPop to set
	 */
	public void setTamanhoPop(int tamanhoPop) {
		this.tamanhoPop = tamanhoPop;
	}

	/**
	 * @return the operadorMutacao
	 */
	public OperadorMutacao<SolucaoInteira> getOperadorMutacao() {
		return operadorMutacao;
	}

	/**
	 * @return the operadorCruzamento
	 */
	public OperadorRecombinacao<SolucaoInteira> getOperadorCruzamento() {
		return operadorCruzamento;
	}

}
