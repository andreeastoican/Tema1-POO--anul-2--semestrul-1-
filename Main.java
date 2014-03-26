import java.util.Scanner;


/**
 * 
 * Clasa Main
 * 
 * @author Andru
 *
 */
public class Main {
	private static Scanner reader;
	/**
	 * 
	 * Metoda main
	 * 
	 * @param args
	 * Argumentele primite de program
	 */
	
	public static void main(String[] args) {
		Dictionary d = new Dictionary(args[0]);
		
		
		reader = new Scanner(System.in);
		String s;
		int[] v;
		s = reader.nextLine();
		while(!s.equals("exit")){
			v = d.Procesare(s);
			operatiiVector.Afisare(v);
			s = reader.nextLine();
		}
	}
}
