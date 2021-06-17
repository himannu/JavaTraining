package PhaseOne.methods;

public class MethodByValue {
	public static void main(String[] args) {
		int value1 = 100;
		int value2 = 4529;
		
		MethodByValue methodCall = new MethodByValue();
		long result = methodCall.multiply(value1, value2); // passng by value
		System.out.println("multiplied 100*4529 =" + result);
	}
	
	public long multiply(int firstValue, int secondValue) {
		return firstValue*secondValue;
	}
}
