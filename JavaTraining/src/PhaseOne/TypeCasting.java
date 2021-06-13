package PhaseOne;

public class TypeCasting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Implicit typecasting");
		
		char c = 'A';
		int ci = c;  //char to int
		long cil = ci; //int to long
		float cilf = ci; //int to float
		double cilfd = cilf; //float to double
		double cild = cil; //long to double
		float fl = cil; //long to float
		double cid = ci; //int to double
		short s = 1;
		int is = s; //short to int
		
		System.out.println("char to int: " + ci);
		System.out.println("int to long: " + cil);
		System.out.println("int to float: " + cilf);
		System.out.println("float to double: " +cilfd );
		System.out.println("long to double: " + cild);
		System.out.println("long to float: " + fl);
		System.out.println("int to double: " + cid);
		System.out.println("short to int: " + is);
		
		
		/* widening casting/
		 * byte - 8 bit,
		 *  short - 2 bytes-16 bits , 
		 * int - 4 bytes-32 bits, 
		 * long - 8 bytes - 64 bits (-2^63 to 2^63-1),
		 *  float - 4bytes - 32 bits, 
		 *  double - 8 bytes - 32 bits
		 *  boolean - 1 bit
		 *  char - 16 bit Unicode, 2 bytes
		 */
		// short, byte, boolean
		//byte ->char/short->int-->long-->float-->double

		System.out.println("Explicit typecasting");
		int i = (int) cild;  //double to int
		float fd = (float)cild; //double to float
		int fi = (int)fd; //float to int
		long flong = (long)fd; //float to long
		int il = (int)flong; //long to int
		short si = (short)i; // int to short
		short sc = (short)c; //char to short
		char scc = (char) s; //short to char
		
		System.out.println("double to int: " + i);
		System.out.println("double to float: " + fd);		
		System.out.println("float to int: " + fi);
		System.out.println("float to long: " + flong);
		System.out.println("long to int: " + il);
		System.out.println("int to short: " + si);
		System.out.println("char to short: " + sc);
		System.out.println("short to char: " + scc);
		
	}

}
