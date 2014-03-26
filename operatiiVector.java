/**
 * 
 * Clasa ce contine metode de tip static, pentru operatii ale vectorilor
 * 
 *
 */

public class operatiiVector {
	
	/**
	 * 
	 * Functia <b>or</b> ( functie ce realizeaza reuniunea a doi vectori )
	 * 
	 * @param 
	 * a vector de elemente intregi
	 * @param 
	 * b vector de elemente intregi
	 * @return
	 * reuniunea celor doi vectori
	 */
	public static int[] or(int[] a, int[] b){
		int[] v = new int[a.length + b.length];
		int k=0, ok=0;
		for(int i=0; i<a.length; i++){
			v[k] = a[i];
			k++;
		}
		for(int i=0; i<b.length; i++){
			ok = 0;
			for(int j=0; j<a.length; j++){
				if(b[i]==v[j] ) { ok = 1; break; }
			}
				if(ok == 0){
					v[k] = b[i];
					k++;
				}
		}
		int[] vnew = new int[k];
		System.arraycopy(v, 0, vnew, 0, k);
		return vnew;
		}
	
	/**
	 * 
	 * Functia <b>and</b> ( functie ce realizeaza intersectia a doi vectori )
	 * 
	 * @param 
	 * a vector de elemente intregi
	 * @param 
	 * b vector de elemente intregi
	 * @return
	 * intersectia celor doi vectori
	 */
	public static int[] and(int[] a, int[] b){
		int[] v = new int[a.length + b.length];
		int k=0;
		for(int i=0; i<a.length; i++){
			for(int j=0; j<b.length; j++){
				if(a[i]==b[j]){
					v[k] = a[i];
					k++;
					break;
				}
			}
		}
		int[] vnew = new int[k];
		System.arraycopy(v, 0, vnew, 0, k);
		return vnew;
	}
	
	/**
	 * 
	 * Functie de Afisare a unui vector primit ca parametru
	 * 
	 * @param 
	 * v vector de intregi
	 */
	public static void Afisare(int[] v){
		if(v==null) return;
		for(int i=0; i<v.length; i++)
			System.out.print(v[i]+" ");
		System.out.println();
	}
	
}
