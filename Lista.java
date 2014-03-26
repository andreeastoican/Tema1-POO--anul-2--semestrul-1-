
/**
 * 
 * Clasa ce defineste tipul lista
 * 
 *
 */


public class Lista {
	private String cuvant; 
	private int[] v;
	private Lista urm;
	
	Lista(String c, int[] v1, Lista u){
		cuvant = c;
		v = v1;
		urm = u;
	}
	
	/**
	 * 
	 * Functia <b>Cuvant</b>
	 * 
	 * @return
	 * cuvantul
	 */
	public String Cuvant(){
		return cuvant;
	}
	
	/**
	 * 
	 * Functia <b>Fisiere</b>
	 * 
	 * @return
	 * vectorul de fisiere
	 */
	public int[] Fisiere(){
		return v;
	}
	
	/**
	 * 
	 * Functia <b>Urm</b>
	 * 
	 * @return
	 * elementul urmator
	 */
	public Lista Urm(){
		return urm;
	}
	
	
}
