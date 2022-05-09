package Aplicacio;
import java.io.*;
import EstructuresDades.*;
import Excepcions.*;
public class Analisi {
	
	/**
	 * Funció general que invoca les dues proves d'anàlisi: <p>
	 * 	{@link #AnalisiCostLinkedList()} <p>
	 *  {@link #AnalisiCostSkipList()} <p>
	 */
	public static void AnalisiCost() {
		//AnalisiCostLinkedList();
		AnalisiCostSkipList();
	}
	
	/**
	 * Funció d'anàlisi de la LinkedList. Genera una llista de la mida indicada al llindar i hi insereix
	 *  valors entre 0 i la meitat del llindar. Més tard fa tantes cerques com elements hi ha a la llista.
	 * Un bucle principal fa l'execució de l'anàlisi pels llindars desitjats, i en calcula per cadascun la
	 *  mitjana i la desviació.
	 * El resultat dels accessos per cada consulta serà guardat a un fitxer de text.
	 */
	public static void AnalisiCostLinkedList() {
		FileWriter fitxer = null;
		PrintWriter pw = null;
		try {
			fitxer = new FileWriter("C:/Users/joelc/OneDrive/Universitat/Tercer any/2Q/ED/resultatLinked.txt");
			pw = new PrintWriter(fitxer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		pw.println("Elements\tMitjana\t\tDesviació");
		
		LinkedList<Integer> llista1 = new LinkedList<Integer>();
		double[] historial;
		int i, valor, llindar;
		int elements=0;
		double total = 0;
		double mitjana, varianca, desviacio;
		
		for (llindar=1000;llindar<=50000;llindar+=1000) {
			historial = new double[llindar];
			elements=0;
			total=0;
			mitjana=0.0;
			varianca=0.0;
			desviacio=0.0;
			
			for (i=0;i<llindar;i++) {
				valor = (int) (Math.random() * (llindar/2));
				try {
					llista1.inserir(valor);
				} catch (ErrorInsercio exc) {
					System.out.println(""+exc.getMessage());
				}
			}
			
			for (i=0;i<llindar;i++) {
				valor = (int) (Math.random() * (llindar/2));
				try {
					elements=llista1.buscar(valor);
				} catch (ElementNoTrobat exc) {
					System.out.println(""+exc.getMessage());
					elements=llindar;
				}
				System.out.println("Cerca: "+i+", "+elements+" elements");
				total += elements;
				historial[i] = elements;
			}
			mitjana = total / llindar;
			
			for(i = 0 ; i < llindar; i++){
			   double rang;
			   rang = Math.pow(historial[i] - mitjana, 2f);
			   varianca = varianca + rang;
			}
			
			varianca = varianca / (double)llindar;
			desviacio = Math.sqrt(varianca);
			mitjana = Math.round(mitjana*100.0)/100.0;
			desviacio = Math.round(desviacio*100.0)/100.0;
			
			pw.println(""+llindar+"\t\t"+mitjana+"\t\t"+desviacio);
			llista1 = new LinkedList<Integer>();
		}
		
		try {
			if (null != fitxer)
				fitxer.close();
         } catch (Exception e2) {
            e2.printStackTrace();
         }	
		
	} 
	
	/**
	 * Funció d'anàlisi de la SkipList. Genera una llista de la mida indicada al llindar i hi insereix
	 *  valors entre 0 i la meitat del llindar. Més tard fa tantes cerques com elements hi ha a la llista.
	 * Un bucle principal fa l'execució de l'anàlisi pels llindars desitjats, i en calcula per cadascun la
	 *  mitjana i la desviació.
	 * El resultat dels accessos per cada consulta serà guardat a un fitxer de text.
	 */
	public static void AnalisiCostSkipList() {
		FileWriter fitxer = null;
		PrintWriter pw = null;
		
		try {
			fitxer = new FileWriter("C:/Users/joelc/OneDrive/Universitat/Tercer any/2Q/ED/resultatSkip.txt");
			pw = new PrintWriter(fitxer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		pw.println("Elements\tMitjana\t\tDesviació");
		
		SkipList<Integer> llista1 = new SkipList<Integer>();
		double[] historial;		
		int i, valor, llindar;
		int elements=0;
		double total = 0;
		double mitjana, varianca, desviacio;
		
		for (llindar=1000;llindar<=50000;llindar+=1000) {
			historial = new double[llindar];
			elements=0;
			total=0;
			mitjana=0.0;
			varianca=0.0;
			desviacio=0.0;
			
			for (i=0;i<llindar;i++) {
				valor = (int) (Math.random() * (llindar/2));
				try {
					llista1.inserir(valor);
				} catch (ErrorInsercio exc) {
					System.out.println(""+exc.getMessage());
				}
			}
			
			for (i=0;i<llindar;i++) {
				valor = (int) (Math.random() * (llindar/2));
				try {
					elements=llista1.buscar(valor);
				} catch (ElementNoTrobat exc) {
					System.out.println(""+exc.getMessage());
					elements=llista1.getAccessos();
				}
				System.out.println("Cerca: "+(i+1)+", valor: "+valor+", key: "+llista1.resultat.getSeguent().getDades()+", elements: "+elements+"");
				total += elements;
				historial[i] = elements;
			}
			mitjana = total / llindar;
			
			for(i = 0 ; i < llindar; i++){
			   double rang;
			   rang = Math.pow(historial[i] - mitjana, 2f);
			   varianca = varianca + rang;
			}
			
			varianca = varianca / (double)llindar;
			desviacio = Math.sqrt(varianca);
			mitjana = Math.round(mitjana*100.0)/100.0;
			desviacio = Math.round(desviacio*100.0)/100.0;
			
			pw.println(""+llindar+"\t\t"+mitjana+"\t\t"+desviacio);
			llista1 = new SkipList<Integer>();
		}

		try {
			if (null != fitxer)
				fitxer.close();
         } catch (Exception e2) {
            e2.printStackTrace();
         }	
	}
	
}
