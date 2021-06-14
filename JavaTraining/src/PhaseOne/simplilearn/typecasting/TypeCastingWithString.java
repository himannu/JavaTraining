package PhaseOne.simplilearn.typecasting;

import java.util.Scanner;

public class TypeCastingWithString {
	public static void main(String[] args) {
//		Scanner myScanner = new Scanner(System.in);
//		System.out.println("Input the string you need to convert to all the data types: ");
//		String inputString = myScanner.next();
		String inputString = "20";
		TypeCastingWithString utility = new TypeCastingWithString();
		utility.convertToDataTypes(inputString);

	}
	
	private void convertToDataTypes(String inputString) {
		short shortString = Short.parseShort(inputString); //convert String to short
		int intString = Integer.parseInt(inputString); //convert String to int
		long longString = Long.parseLong(inputString); //convert String to long
		float floatString = Float.parseFloat(inputString); //convert String to float
		double doubleString = Double.parseDouble(inputString); // convert to double
		char[] charString = inputString.toCharArray();
		byte byteString = Byte.parseByte(inputString); // String to byte
		
		System.out.println("converting String to short: " + shortString);
		System.out.println("converting String to int: " + intString);
		
		System.out.println("converting String to long: " + longString);
		System.out.println("converting String to float: " + floatString);
		System.out.println("converting String to double: " + doubleString);
		System.out.println("converting String to byte: " + byteString);
		System.out.println("converting String to char array: " + charString.toString());
		
		
		
		
;
		}
}
