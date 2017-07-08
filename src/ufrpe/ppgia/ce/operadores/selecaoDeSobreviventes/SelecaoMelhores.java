package ufrpe.ppgia.ce.operadores.selecaoDeSobreviventes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import ufrpe.ppgia.ce.base.OperadorSelecao;
import ufrpe.ppgia.ce.base.solucao.SolucaoReal;


public class SelecaoMelhores implements OperadorSelecao<SolucaoReal>{
	
	ArrayList<SolucaoReal> pais = new ArrayList<SolucaoReal>();

	@Override
	public List<SolucaoReal> selecionar(List<SolucaoReal> solutionSet) {
		solutionSet.sort(Comparator.comparingDouble(SolucaoReal::getFitness));
		
		pais.add(solutionSet.get(0));
		pais.add(solutionSet.get(1));
		
		return pais;
	}
}
