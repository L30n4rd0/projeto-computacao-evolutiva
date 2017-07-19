package ufrpe.ppgia.ce.operadores.mutacao;

import java.util.Random;

import ufrpe.ppgia.ce.base.OperadorMutacao;
import ufrpe.ppgia.ce.base.solucao.SolucaoReal;

public class MutacaoNaoUniforme implements OperadorMutacao<SolucaoReal> {

	private double pm = 0.1;
	
	@Override
	public SolucaoReal executarMutacao(SolucaoReal pai) {
		Random r = new Random();
		
		for (int i = 0; i < pai.getN(); i++){
			float aux = r.nextFloat();
			float gaussianAleatorio = (float) r.nextGaussian();
			
			if (aux < pm){
				double newGene = pai.getValor(i) + gaussianAleatorio;
				
				/**
				 * Controle do limite superior
				 */
				if (newGene > pai.getLimiteSuperior(i)) {
					newGene = pai.getLimiteSuperior(i);
				
				/**
				 * Controle do limite inferior
				 */
				} else if (newGene < pai.getLimiteInferior(i)) {
					newGene = pai.getLimiteInferior(i);
					
				}
				
				/**
				 * Setando o novo gene
				 */
				pai.setValor(i, newGene);
			} 
			
		}
		
		return pai;	
	}

	public double getPm() {
		return pm;
	}

	public void setPm(double pm) {
		this.pm = pm;
	}

}

