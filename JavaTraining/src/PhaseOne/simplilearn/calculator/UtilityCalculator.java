package PhaseOne;

import java.util.Scanner;

public class UtilityCalculator {

	public static final int ADD = 1;
	public static final int SUBTRACT = 2;
	public static final int MULTIPLY = 3;
	public static final int DIVIDE = 4;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner myScanner = new Scanner(System.in);
		System.out.println("Enter the first number: ");
		int firstValue  = myScanner.nextInt();
		System.out.println("Enter the second number: ");
		int secondValue  = myScanner.nextInt();
		System.out.println("Enter 1 to Add: ");
		System.out.println("Enter 2 to Subtract: ");
		System.out.println("Enter 3 to Multiply: ");
		System.out.println("Enter 4 to Divide: ");
		int choice = myScanner.nextInt();
		
		float result = calculate(choice, firstValue, secondValue);
		System.out.println("Result is: " + result);		
	}
	
	private static float calculate(int choice, int firstValue, int secondValue) {
		ArithmeticCalculator calculator = new ArithmeticCalculator();
		float result = 0f;
		
		switch (choice)
		{
		case ADD:
			result = calculator.add(firstValue,secondValue);
			break;
		case SUBTRACT:
			result = calculator.subtract(firstValue,secondValue);
			break;
		case MULTIPLY:
			result = calculator.multiply(firstValue,secondValue);
			break;
		case DIVIDE :
			result = calculator.divide(firstValue,secondValue);
			break;
		default:
			System.out.print("Invalid Choice ! \n");
		}
		return result;	
	}

}
