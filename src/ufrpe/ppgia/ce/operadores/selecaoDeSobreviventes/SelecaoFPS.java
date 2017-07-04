package ufrpe.ppgia.ce.operadores.selecaoDeSobreviventes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import ufrpe.ppgia.ce.base.OperadorSelecao;
import ufrpe.ppgia.ce.base.solucao.SolucaoInteira;

public class SelecaoFPS implements OperadorSelecao<SolucaoInteira>{
	@Override
	public List<SolucaoInteira> selecionar(List<SolucaoInteira> solutionSet) {
		solutionSet.sort(Comparator.comparingDouble(SolucaoInteira::getFitness));
		List<SolucaoInteira> pais = new ArrayList<>();
		
		double totalFitness = 0;
		Double[] fitnessNormalizado = new Double[solutionSet.size()];
		
		for(SolucaoInteira solucao : solutionSet) {
			totalFitness += solucao.getFitness();
		}
		
		for(int i = 0; i < solutionSet.size(); i++) {
			fitnessNormalizado[i] = solutionSet.get(i).getFitness() / totalFitness;
		}
		
		List<SolucaoInteira> roletaDePais = new ArrayList<>();
		for(int i = 0; i < solutionSet.size(); i++) {
			double fitnessParcial = fitnessNormalizado[0];
			while(fitnessParcial <= fitnessNormalizado[i]) {
				roletaDePais.add(solutionSet.get(i));
				fitnessParcial += fitnessParcial;
			}
		}
		
		// Escolhendo o primeiro pai
		int seletorDePai = new Random().nextInt(roletaDePais.size());
		pais.add(roletaDePais.get(seletorDePai));
		
		//Removendo todas as ocorrências do primeiro pai da roleta
		while(roletaDePais.contains(pais.get(0))) {
			roletaDePais.remove(pais.get(0));
		}
		
		// Escolhendo o segundo pai
		seletorDePai = new Random().nextInt(roletaDePais.size());
		pais.add(roletaDePais.get(seletorDePai));
		
		return pais;
	}
	
	public static void main(String[] args) {
		
		SolucaoInteira p1 = new SolucaoInteira(); 
		SolucaoInteira p2 = new SolucaoInteira(); 
		SolucaoInteira p3 = new SolucaoInteira(); 
		SolucaoInteira p4 = new SolucaoInteira();
		SolucaoInteira p5 = new SolucaoInteira(); 
		SolucaoInteira p6 = new SolucaoInteira(); 
		SolucaoInteira p7 = new SolucaoInteira(); 
		SolucaoInteira p8 = new SolucaoInteira();
		
		p1.setFitness(9);
		p2.setFitness(4);
		p3.setFitness(3);
		p4.setFitness(1);
		p5.setFitness(9);
		p6.setFitness(4);
		p7.setFitness(3);
		p8.setFitness(11);
		
		ArrayList<SolucaoInteira> teste = new ArrayList<SolucaoInteira>();
		
		teste.add(p1);
		teste.add(p2);
		teste.add(p3);
		teste.add(p4);
		teste.add(p5);
		teste.add(p6);
		teste.add(p7);
		teste.add(p8);
		
		SelecaoFPS sfps = new SelecaoFPS();
		
		List<SolucaoInteira> resp = sfps.selecionar(teste);
		System.out.println(resp.size());
		System.out.println(resp.get(0).getFitness());
		System.out.println(resp.get(1).getFitness());
	}	
}