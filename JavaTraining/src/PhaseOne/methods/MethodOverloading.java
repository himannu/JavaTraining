package PhaseOne.methods;

public class MethodOverloading {

	public static void main(String[] args) {
		String lastName = "Smith";
		int id = 23;
		
		MethodOverloading methodCall = new MethodOverloading();
		methodCall.getUserName(lastName); //String
		methodCall.getUserName(id); //int
		
	}
	
	
	public void getUserName(String name) {
		System.out.println("getting user name by last name");
		
	}
	
	public void getUserName(int userId) {
		System.out.println("getting user name by user id");
	}
	
	
}
