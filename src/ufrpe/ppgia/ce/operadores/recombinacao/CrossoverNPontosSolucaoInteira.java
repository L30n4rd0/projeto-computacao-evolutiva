package ufrpe.ppgia.ce.operadores.recombinacao;

import java.util.Random;

import ufrpe.ppgia.ce.base.OperadorRecombinacao;
import ufrpe.ppgia.ce.base.solucao.SolucaoInteira;

public class CrossoverNPontosSolucaoInteira implements OperadorRecombinacao<SolucaoInteira> {

	private double pr = 1;
	
	@Override
	public SolucaoInteira[] recombinar(SolucaoInteira pai1, SolucaoInteira pai2) {
		
		if(Math.random() <= pr) {
			
			int pontoDeCrossover1 = new Random().nextInt(pai1.getN() - 2) + 1, 
				pontoDeCrossover2 = new Random().nextInt(pai1.getN() - 1) + 1;

			while (pontoDeCrossover2 <= pontoDeCrossover1)
				pontoDeCrossover2 = new Random().nextInt(pai1.getN() - 1) + 1;
			
			SolucaoInteira filho1 = pai1.clone();
			SolucaoInteira filho2 = pai1.clone();
			
			for(int i = pontoDeCrossover1; i < pontoDeCrossover2; i++) {
				filho1.setValor(i, pai2.getValor(i));
				filho2.setValor(i, pai1.getValor(i));
			}
			
			return new SolucaoInteira[]{filho1, filho2};
		}
		
		return new SolucaoInteira[]{pai1, pai2};
	}

	/**
	 * @param pr the pr to set
	 */
	public void setPr(double pr) {
		this.pr = pr;
	}

}
