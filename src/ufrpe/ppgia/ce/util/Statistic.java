/**
 * 
 */
package ufrpe.ppgia.ce.util;

import java.util.List;

/**
 * @author leonardo
 *
 */
public class Statistic {
	/***
	Obtem o
	desvio padrão
	de uma
	Lista de
	numeros passados
	
	@param temposDetodosFluxos
	 * @return
	 */
	public static double desvioPadrao(List<Double> objetos) {
		if (objetos.size() == 1) {
			return 0.0;
		} else {
			double mediaAritimetica = mediaAritimetica(objetos);
			double somatorio = 0l;
			for (int i = 0; i < objetos.size(); i++) {
				double result = objetos.get(i) - mediaAritimetica;
				somatorio = somatorio + result * result;
			}
			return Math.sqrt(((double) 1 /( objetos.size()-1))
					* somatorio);
		}
	}

	/**
	 * Obtem o a media aritmetica de um array de Elementos
	 * 
	 * @param temposDetodosFluxos
	 * @return
	 */
	public static double mediaAritimetica(List<Double> objetos) {
		double somatorio = 0l;
		for (Double d : objetos) {
			somatorio += d;
		}
		return somatorio / objetos.size();
	}

}
