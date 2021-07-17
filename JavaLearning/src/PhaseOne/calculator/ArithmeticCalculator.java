package PhaseOne.calculator;

public class ArithmeticCalculator {
	
	public float add(int firstValue, int secondValue) {
		float result = firstValue + secondValue;
		return result;
	}
	
	public float subtract(int firstValue, int secondValue) {
		float result = firstValue - secondValue;
		return result;
	}
	
	public float multiply(int firstValue, int secondValue) {
		float result = firstValue * secondValue;
		return result;
	}
	
	public float divide(int firstValue, int secondValue) {
		float result = (float)firstValue/(float)secondValue;
		return result;
	}
	
	public float remainderOf(int firstValue, int secondValue) {
		float result = firstValue % secondValue;
		return result;
	}
	
	public double findSquareRoot(int value) {
		double result = Math.sqrt(value);
		return result;
	}
	
	public float findPercentage(int part, int whole) {
		float percentage = part*100/whole;
		return percentage;
	}
}
