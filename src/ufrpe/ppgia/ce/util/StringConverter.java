/**
 * 
 */
package ufrpe.ppgia.ce.util;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author leonardo
 *
 */
public class StringConverter {
	
	public static double[] getDoubleNumbersByString(String inputString) {

		double[] numbersFound = null;
		
		// Separate by space
		String[] stringsArray = inputString.split(" ");
		
		// Temp list to storage string with numbers
		List<String> tempList = new ArrayList<>();
		
		for (String string : stringsArray) {
			
			// Filter double numbers of string and replace alpha characters by empty value
			// Using java regex
			String tempString = string.replaceAll("[^0-9?!\\.]","");
			
			// Add string with double number to list
			if (!tempString.equalsIgnoreCase("")) {
				tempList.add(tempString);
			}
			
		}
		
		// Create double array with size to according quantity of numbers found
		numbersFound = new double[tempList.size()];
		
		for (int i = 0; i < numbersFound.length; i++) {

			// Convert each string to double type
			numbersFound[i] = Double.parseDouble(tempList.get(i));
		}
		
		return numbersFound;
		
	}
	
	public static double formatDouble(double inputDouble) {
		NumberFormat format = NumberFormat.getInstance();
		format.setMaximumFractionDigits(2);
		format.setMinimumFractionDigits(2);
//		format.setMaximumIntegerDigits(2);
		format.setRoundingMode(RoundingMode.HALF_UP);
		return Double.valueOf(format.format(inputDouble));
		
	}
	
	public static double getPriceByString(String inputPrice) {
		String tempString = inputPrice;
		
		tempString = tempString.replace(",", "virgula");
		tempString = tempString.replace(".", "");
		tempString = tempString.replace("virgula", ".");
		
		return StringConverter.getDoubleNumbersByString(tempString)[0];
		
	}

}
