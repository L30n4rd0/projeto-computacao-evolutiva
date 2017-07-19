/**
 * 
 */
package ufrpe.ppgia.ce.operadores.selecaoDeSobreviventes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ufrpe.ppgia.ce.base.OperadorSelecao;
import ufrpe.ppgia.ce.base.solucao.SolucaoInteira;

/**
 * @author leonardo
 *
 */
public class SelecaoPorTorneioInteira implements OperadorSelecao<SolucaoInteira> {

	@Override
	public List<SolucaoInteira> selecionar(List<SolucaoInteira> solutionSet) {
		
		List<SolucaoInteira> paisSelecionados = new ArrayList<>();
		
		// FALTA IMPLEMENTAR ***************
		paisSelecionados.add(solutionSet.get( new Random().nextInt(solutionSet.size()) ));
		paisSelecionados.add(solutionSet.get( new Random().nextInt(solutionSet.size()) ));
		
		return paisSelecionados;
	}

}
