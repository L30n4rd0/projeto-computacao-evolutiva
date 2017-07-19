package ufrpe.ppgia.ce.operadores.selecaoDeSobreviventes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ufrpe.ppgia.ce.base.OperadorSelecao;
import ufrpe.ppgia.ce.base.solucao.SolucaoInteira;


public class SelecaoUniforme implements OperadorSelecao<SolucaoInteira> {
	
	Random r = new Random();
	List<SolucaoInteira> pais = new ArrayList<>();

	@Override
	public List<SolucaoInteira> selecionar(List<SolucaoInteira> solutionSet) {
		
		for (int i = 0; i<2; i++){
			
			int aux = r.nextInt(solutionSet.size());
			pais.add(solutionSet.get(aux));
			
		}
		return pais;
	}
}
