/**
 * 
 */
package ufrpe.ppgia.ce.operadores.selecaoDeSobreviventes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import ufrpe.ppgia.ce.base.OperadorSelecao;
import ufrpe.ppgia.ce.base.solucao.SolucaoInteira;

/**
 * @author leonardo
 *
 */
public class SelecaoPorTorneioInteira implements OperadorSelecao<SolucaoInteira> {

	@Override
	public List<SolucaoInteira> selecionar(List<SolucaoInteira> solutionSet) {
		/*
		 * Número de indivíduos para cada torneio
		 */
		int tamanhoTorneio = 10;
		
		Set<Integer> setIndicesTorneio = new HashSet<>();
		
		/*
		 * popTotal
		 */
		List<SolucaoInteira> popTotal = new ArrayList<>();
		
		/*
		 * Adicionar pais para popTotal
		 */
		for (SolucaoInteira solucaoInteira : solutionSet) {
			popTotal.add(solucaoInteira);
		}
		
		/*
		 * Pais Selecionados por torneio
		 */
		List<SolucaoInteira> paisSelecionados = new ArrayList<>();
		
		Random random = new Random();
		
		/*
		 * Lista de indivíduos para o torneio
		 */
		List<SolucaoInteira> individuosTorneio = new ArrayList<>();
		
		/*
		 * Sorteia 10 índices de indivíduos para o torneio
		 */
		
		while (setIndicesTorneio.size() < tamanhoTorneio) {
			int rand = random.nextInt(popTotal.size());
			
			/*
			 * Insere o índice sorteado sem repetição de valor
			 */
			setIndicesTorneio.add(rand);
			
		}
		
		/*
		 * Insere os indivíduos sorteados ao array de torneio
		 */
		for (Integer indice : setIndicesTorneio)
			individuosTorneio.add(popTotal.get(indice));
		
		/*
		 * Organizar os individuos do torneio pelo valor do 
		 * fitness em ordem crescente
		 */
		individuosTorneio.sort(Comparator.comparingDouble(SolucaoInteira::getFitness));
		
		/*
		 * Define os pais ganhadores do torneio
		 */
		SolucaoInteira 
		pai1 = individuosTorneio.get(0), 
		pai2 = individuosTorneio.get(1);
		
		paisSelecionados.add(pai1);
		paisSelecionados.add(pai2);
			
		return paisSelecionados;
	}

}
