import java.io.File;
import java.util.Scanner;

/**
 * 
 * Clasa ce defineste tipul dictionar
 * 
 * @author Andru
 *
 */
public class Dictionary {
	
	private Lista[] lst;
	
	/**
	 * 
	 * Constructor pentru dictionar. Primeste ca parametru numele fisierului text (dictionarului) si il citeste linie cu linie
	 * 
	 * @param inputFile
	 * Numele fisierului text
	 */
	public Dictionary(String inputFile) { 
		lst = new Lista[10000];
		
		try{
			File dictFile = new File(inputFile);
			Scanner reader = new Scanner(dictFile);
			String strLine, cuvant;
			
			while (reader.hasNextLine()) { // cat timp exista linie noua in fisier
				strLine = reader.nextLine(); // in strLine este retinuta linia curenta din dictionar
			
				// TO DO: aici veti procesa fiecare linie din dictionar
				// HINT: String tokenizer
				String[] s = strLine.split(" ");
				cuvant = s[0];
				int[] vector = new int[s.length-1];
				for(int i=1; i<s.length; i++) 
					vector[i-1] = Integer.parseInt(s[i]);
				Add(cuvant, vector);
			}
			reader.close();
		}catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}

	/**
	 * 
	 * Functia de Hash (calculeaza suma codurilor ASCII a caracterelor din cuvant)
	 * 
	 * @param 
	 * cuvant cuvantul pentru care vrem sa aflam pozitia de Hash
	 * @return
	 * numarul ce reprezinta Hash-ul
	 */
	public Integer Hash(String cuvant){
		int s = 0;
		for(int i=0; i<cuvant.length(); i++)
			s += cuvant.codePointAt(i);
		return s;
	}
	
	/**
	 * 
	 * Functie de Cautare a unui cuvant din dictionar 
	 * 
	 * @param 
	 * c cuvantul cautat
	 * @return
	 * vectorul de fisiere atasat cuvantului sau un vector de dimensiune 0 daca cuvantul nu exista
	 */
	public int[] Cauta(String c) {
		Lista l;
		int h = Hash(c);
		l = lst[h];
		if(l == null) return new int[0];
		while(!(c.equals(l.Cuvant()))){
			l = l.Urm();
			if(l == null)
				return new int[0];
		}
		return l.Fisiere();
	}
	
	/**
	 * 
	 * Functia de Adaugare a cuvantului si a fisierele atasate acestuia in Hash Table
	 * 
	 * @param 
	 * cuvant cuvantul ce va fi adaugat
	 * @param
	 * vector vectorul de fisiere atasat cuvantului
	 */
	public void Add(String cuvant, int[] vector){
		int h = Hash(cuvant);
		Lista elem = new Lista(cuvant, vector, lst[h]);
		lst[h] = elem;
	}
	
	/**
	 * 
	 * Functie recursiva de Procesare a expresiilor 
	 * 
	 * @param 
	 * exp expresia ce va fi procesata
	 * @return
	 * rezultatul cautarii expresiei
	 */
	public int[] Procesare(String exp){
		String t1, t2, op="";
		int ndesc, ninch, i;
		
		if(!(exp.contains("("))) // daca expresia nu contine paranteze caut cuvantul in Hash Table
			return Cauta(exp);
		
		exp=exp.substring(1, exp.length()-1); // scot parantezele din capete
		String[] s = exp.split(" ");
		if(exp.charAt(0) != '(') // daca primul termen nu contine paranteze
			t1 = s[0];
		else { // daca contine paranteze concatenez la t1 caracterele din expresie pana cand numarul de paranteze deschise este egal cu numarul de paranteze inchise
			t1 = "";
			ndesc = ninch = 0;
			i=0;
			char c;
			while(ndesc > ninch || ndesc == 0) {
				c=exp.charAt(i);
				t1+=c;
				if(c == '(')
					ndesc++;
				else
					if(c == ')')
						ninch++;
				i++;
			}
		}
		
		// verificarea operatorului ( operatorul incepe la pozitia t1.length()+1 )
		i = t1.length();
		if(exp.charAt(i+1) == 'o')
			op = "or";
		else
			op = "and";
		
		// pentru al doilea termen se procedeaza la fel ca si la primul termen
		i=t1.length()+op.length()+2;
		if(exp.charAt(i) != '(')
			t2 = s[s.length-1];
		else {
			ndesc = ninch = 0;
			char c;
			t2 = "";
			while(ndesc > ninch || ndesc == 0 ){
				c = exp.charAt(i);
				t2 += c;
				if(c == '(')
					ndesc++;
				else
					if(c == ')')
						ninch++;
				i++;
			}
		}
		
		if(op.equals("and"))
			return operatiiVector.and(Procesare(t1),Procesare(t2));
		return operatiiVector.or(Procesare(t1),Procesare(t2));
	}
	
	
}
