package PhaseOne;

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
	
}
