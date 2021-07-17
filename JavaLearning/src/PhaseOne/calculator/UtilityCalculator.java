package PhaseOne.calculator;

import java.util.Scanner;

 class UtilityCalculator {

	public static final int ADD = 1;
	public static final int SUBTRACT = 2;
	public static final int MULTIPLY = 3;
	public static final int DIVIDE = 4;
	public static final int SQUAREROOT = 5;
	public static final int PERCENTAGE = 6;
	ArithmeticCalculator calculator = new ArithmeticCalculator();

	
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
		System.out.println("Enter 5 to Squareroot of first number: ");
		System.out.println("Enter 6 to find what is the percentage of firstNumber against the whole/secondNumber: ");
		int choice = myScanner.nextInt();
		
		UtilityCalculator utility = new UtilityCalculator();
		float result = utility.calculate(choice, firstValue, secondValue);
		System.out.println("Result is: " + result);		
	}
	
	private float calculate(int choice, int firstValue, int secondValue) {
		float result = 0f;
		
		switch (choice)
		{
		case ADD:
			result = this.calculator.add(firstValue,secondValue);
			break;
		case SUBTRACT:
			result = this.calculator.subtract(firstValue,secondValue);
			break;
		case MULTIPLY:
			result = this.calculator.multiply(firstValue,secondValue);
			break;
		case DIVIDE :
			result = this.calculator.divide(firstValue,secondValue);
			break;
		case SQUAREROOT:
			result = (float) (this.calculator.findSquareRoot(firstValue));
			break;
		case PERCENTAGE:
			result = this.calculator.findPercentage(firstValue,secondValue);
			break;
		default:
			System.out.print("Invalid Choice ! \n");
		}
		return result;	
	}

}
