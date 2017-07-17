package ufrpe.ppgia.ce.operadores.mutacao;

import java.util.Random;

import ufrpe.ppgia.ce.base.OperadorMutacao;
import ufrpe.ppgia.ce.base.solucao.SolucaoInteira;

public class MutacaoIncrementosLentos implements OperadorMutacao<SolucaoInteira> {
	private double pm = 0.1d;

	public double getPm() {
		return pm;
	}

	public void setPm(double pm) {
		this.pm = pm;
	}

	@Override
	public SolucaoInteira executarMutacao(SolucaoInteira pai) {
		SolucaoInteira mutacao = pai.clone();
		
		for(int i = 0; i < pai.getN(); i++) {
			
			if(Math.random() < pm) {
				int incremento = new Random().nextInt(2);
				
				if (incremento == 0)
					incremento = -1;
				
				int novoGene = pai.getValor(i) + incremento;
				
				if (novoGene < pai.getLimiteInferior(i))
					novoGene = pai.getLimiteInferior(i);
									
				else if (novoGene > pai.getLimiteSuperior(i))
					novoGene = pai.getLimiteSuperior(i);
					
				mutacao.setValor(i, novoGene);
				
			}
			
		}
		
		return mutacao;
	}

}
