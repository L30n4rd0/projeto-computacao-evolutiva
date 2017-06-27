/**
 * 
 */
package ufrpe.ppgia.ce.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leonardo
 *
 */
public class StringConverter {
	
	public static double[] convertToNumbers(String inputString) {

		double[] numbersFound = null;
		
		String[] stringsArray = inputString.split(" ");
		
		List<String> tempList = new ArrayList<>();
		
		for (String string : stringsArray) {
			
			String tempString = string.replaceAll("[^0-9?!\\.]","");
			
			if (!tempString.equalsIgnoreCase("")) {
				tempList.add(tempString);
			}
			
		}
		
		numbersFound = new double[tempList.size()];
		
		for (int i = 0; i < numbersFound.length; i++) {
			
			numbersFound[i] = Double.parseDouble(tempList.get(i));
		}
		
		return numbersFound;
		
	}

}
