package Aplicacio;

import EstructuresDades.*;
import Excepcions.*;
import java.util.Iterator;

public class Proves {
	
	/**
	 * Funció general que invoca totes les proves: <p>
	 * 	{@link #LinkedListString()} <p>
	 *  {@link #LinkedListInteger()} <p>
	 *  {@link #LinkedListDouble()} <p>
	 *  {@link #SkipListString()} <p>
	 *  {@link #SkipListInteger()} <p>
	 *  {@link #SkipListDouble()} <p>
	 */
	public static void Prova () {
		//LinkedListString();
		//LinkedListInteger();
		//LinkedListDouble();
		//SkipListString();
		SkipListInteger();
		//SkipListDouble();
	}
	
	/**
	 * Fa proves d'inserció i desplaçament de PDI, iteracions amb iterator i eliminació d'elements
	 *  en una LinkedList amb strings.
	 */
	public static void LinkedListString () {
		LinkedList<String> llista = new LinkedList<String>();
		System.out.println("\t\t---Prova d'insercions i desplaçament de PDI---");
		llista.printLinkedList();
		System.out.println("");
		try {
			llista.inserir("Primera");
			llista.printLinkedList();
			System.out.println("\nPDI actual: "+llista.actual());
		} catch (ErrorInsercio exc) {
			System.out.println("Hi ha hagut un problema en la inserció de l'element");
		} catch (ErrorPDI exc) {
			System.out.println(""+exc.getMessage());
		}
		try {
			llista.inserir("Segona");
			llista.printLinkedList();
			System.out.println("\nPDI actual: "+llista.actual());
		} catch (ErrorInsercio exc) {
			System.out.println("Hi ha hagut un problema en la inserció de l'element");
		} catch (ErrorPDI exc) {
			System.out.println(""+exc.getMessage());
		}
		try {
			System.out.println("Desplaçant PDI a l'inici");
			llista.Principi();
			System.out.println("PDI actual: "+llista.actual());
		} catch (ErrorPDI exc) {
			System.out.println(""+exc.getMessage());
		} catch (ErrorHeadTail exc) {
			System.out.println(""+exc.getMessage());
		}
		try {
			llista.inserir("Tercera");
			llista.printLinkedList();
			System.out.println("\nPDI actual: "+llista.actual());
		} catch (ErrorInsercio exc) {
			System.out.println("Hi ha hagut un problema en la inserció de l'element");
		} catch (ErrorPDI exc) {
			System.out.println(""+exc.getMessage());
		}
		try {
			System.out.println("Desplaçant PDI al final");
			llista.Final();
			System.out.println("PDI actual: "+llista.actual());
		} catch (ErrorPDI exc) {
			System.out.println(""+exc.getMessage());
		} catch (ErrorHeadTail exc) {
			System.out.println(""+exc.getMessage());
		}
		try {
			llista.inserir("Quarta");
			llista.printLinkedList();
			System.out.println("\nPDI actual: "+llista.actual());
		} catch (ErrorInsercio exc) {
			System.out.println("Hi ha hagut un problema en la inserció de l'element");
		} catch (ErrorPDI exc) {
			System.out.println(""+exc.getMessage());
		}
		try {
			System.out.println("Desplaçant PDI a l'esquerra");
			llista.Retrocedir();
			System.out.println("PDI actual: "+llista.actual());
		} catch (LimitPDI exc) {
			System.out.println(""+exc.getMessage());
		} catch (ErrorPDI exc) {
			System.out.println(""+exc.getMessage());
		}
		try {
			llista.inserir("Cinquena");
			llista.printLinkedList();
			System.out.println("\nPDI actual: "+llista.actual());
		} catch (ErrorInsercio exc) {
			System.out.println("Hi ha hagut un problema en la inserció de l'element");
		} catch (ErrorPDI exc) {
			System.out.println(""+exc.getMessage());
		}
		try {
			System.out.println("Desplaçant PDI a l'esquerra");
			llista.Retrocedir();
			System.out.println("PDI actual: "+llista.actual());
		} catch (LimitPDI exc) {
			System.out.println(""+exc.getMessage());
		} catch (ErrorPDI exc) {
			System.out.println(""+exc.getMessage());
		}
		try {
			llista.inserir("Sisena");
			llista.printLinkedList();
			System.out.println("\nPDI actual: "+llista.actual());
		} catch (ErrorInsercio exc) {
			System.out.println("Hi ha hagut un problema en la inserció de l'element");
		} catch (ErrorPDI exc) {
			System.out.println(""+exc.getMessage());
		}
		try {
			System.out.println("Desplaçant PDI a la dreta");
			llista.Avancar();
			System.out.println("PDI actual: "+llista.actual());
		} catch (LimitPDI exc) {
			System.out.println(""+exc.getMessage());
		}  catch (ErrorPDI exc) {
			System.out.println(""+exc.getMessage());
		}
		try {
			llista.inserir("Setena");
			llista.printLinkedList();
			System.out.println("\nPDI actual: "+llista.actual());
		} catch (ErrorInsercio exc) {
			System.out.println("Hi ha hagut un problema en la inserció de l'element");
		} catch (ErrorPDI exc) {
			System.out.println(""+exc.getMessage());
		}
		
		System.out.println("\n\t\t---Prova Iterator a partir del PDI actual---");
		Iterator<String> i=llista.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
		
		
		System.out.println("\n\t\t---Prova d'eliminació d'elements i desplaçament del PDI---");
		llista.printLinkedList();
		while (llista.longitud() > 0) {
			try {
				llista.esborrar();
				llista.printLinkedList();
			} catch (ElementNoTrobat exc) {
				System.out.println(""+exc.getMessage());
			}
		}
		
		try {
			System.out.println("\nPDI actual: "+llista.actual());
		}  catch (ErrorPDI exc) {
			System.out.println(""+exc.getMessage());
		}
		
		try {
			System.out.println("\nDesplaçant PDI a la dreta");
			llista.Avancar();
			System.out.println("PDI actual: "+llista.actual());
		} catch (LimitPDI exc) {
			System.out.println(""+exc.getMessage());
		}  catch (ErrorPDI exc) {
			System.out.println(""+exc.getMessage());
		}
		
		try {
			System.out.println("Desplaçant PDI a l'esquerra");
			llista.Retrocedir();
			System.out.println("PDI actual: "+llista.actual());
		} catch (LimitPDI exc) {
			System.out.println(""+exc.getMessage());
		}  catch (ErrorPDI exc) {
			System.out.println(""+exc.getMessage());
		}
		
		try {
			System.out.println("Desplaçant PDI al final");
			llista.Final();
			System.out.println("PDI actual: "+llista.actual());
		} catch (ErrorHeadTail exc) {
			System.out.println(""+exc.getMessage());
		}  catch (ErrorPDI exc) {
			System.out.println(""+exc.getMessage());
		}
		
		try {
			System.out.println("Desplaçant PDI a l'inici");
			llista.Principi();
			System.out.println("PDI actual: "+llista.actual());
		} catch (ErrorHeadTail exc) {
			System.out.println(""+exc.getMessage());
		}  catch (ErrorPDI exc) {
			System.out.println(""+exc.getMessage());
		}
		
		
	}
	
	/**
	 * Fa proves d'inserció i desplaçament de PDI, iteracions amb iterator i eliminació d'elements
	 *  en una LinkedList amb enters.
	 */
	public static void LinkedListInteger () {
		LinkedList<Integer> llista = new LinkedList<Integer>();
		System.out.println("\t\t---Prova d'insercions i desplaçament de PDI---");
		llista.printLinkedList();
		System.out.println("");
		try {
			llista.inserir(1);
			llista.printLinkedList();
			System.out.println("\nPDI actual: "+llista.actual());
		} catch (ErrorInsercio exc) {
			System.out.println("Hi ha hagut un problema en la inserció de l'element");
		} catch (ErrorPDI exc) {
			System.out.println(""+exc.getMessage());
		}
		try {
			llista.inserir(2);
			llista.printLinkedList();
			System.out.println("\nPDI actual: "+llista.actual());
		} catch (ErrorInsercio exc) {
			System.out.println("Hi ha hagut un problema en la inserció de l'element");
		} catch (ErrorPDI exc) {
			System.out.println(""+exc.getMessage());
		}
		try {
			System.out.println("Desplaçant PDI a l'inici");
			llista.Principi();
			System.out.println("PDI actual: "+llista.actual());
		} catch (ErrorPDI exc) {
			System.out.println(""+exc.getMessage());
		} catch (ErrorHeadTail exc) {
			System.out.println(""+exc.getMessage());
		}
		try {
			llista.inserir(3);
			llista.printLinkedList();
			System.out.println("\nPDI actual: "+llista.actual());
		} catch (ErrorInsercio exc) {
			System.out.println("Hi ha hagut un problema en la inserció de l'element");
		} catch (ErrorPDI exc) {
			System.out.println(""+exc.getMessage());
		}
		try {
			System.out.println("Desplaçant PDI al final");
			llista.Final();
			System.out.println("PDI actual: "+llista.actual());
		} catch (ErrorPDI exc) {
			System.out.println(""+exc.getMessage());
		} catch (ErrorHeadTail exc) {
			System.out.println(""+exc.getMessage());
		}
		try {
			llista.inserir(4);
			llista.printLinkedList();
			System.out.println("\nPDI actual: "+llista.actual());
		} catch (ErrorInsercio exc) {
			System.out.println("Hi ha hagut un problema en la inserció de l'element");
		} catch (ErrorPDI exc) {
			System.out.println(""+exc.getMessage());
		}
		try {
			System.out.println("Desplaçant PDI a l'esquerra");
			llista.Retrocedir();
			System.out.println("PDI actual: "+llista.actual());
		} catch (LimitPDI exc) {
			System.out.println(""+exc.getMessage());
		} catch (ErrorPDI exc) {
			System.out.println(""+exc.getMessage());
		}
		try {
			llista.inserir(5);
			llista.printLinkedList();
			System.out.println("\nPDI actual: "+llista.actual());
		} catch (ErrorInsercio exc) {
			System.out.println("Hi ha hagut un problema en la inserció de l'element");
		} catch (ErrorPDI exc) {
			System.out.println(""+exc.getMessage());
		}
		try {
			System.out.println("Desplaçant PDI a l'esquerra");
			llista.Retrocedir();
			System.out.println("PDI actual: "+llista.actual());
		} catch (LimitPDI exc) {
			System.out.println(""+exc.getMessage());
		} catch (ErrorPDI exc) {
			System.out.println(""+exc.getMessage());
		}
		try {
			llista.inserir(6);
			llista.printLinkedList();
			System.out.println("\nPDI actual: "+llista.actual());
		} catch (ErrorInsercio exc) {
			System.out.println("Hi ha hagut un problema en la inserció de l'element");
		} catch (ErrorPDI exc) {
			System.out.println(""+exc.getMessage());
		}
		try {
			System.out.println("Desplaçant PDI a la dreta");
			llista.Avancar();
			System.out.println("PDI actual: "+llista.actual());
		} catch (LimitPDI exc) {
			System.out.println(""+exc.getMessage());
		}  catch (ErrorPDI exc) {
			System.out.println(""+exc.getMessage());
		}
		try {
			llista.inserir(7);
			llista.printLinkedList();
			System.out.println("\nPDI actual: "+llista.actual());
		} catch (ErrorInsercio exc) {
			System.out.println("Hi ha hagut un problema en la inserció de l'element");
		} catch (ErrorPDI exc) {
			System.out.println(""+exc.getMessage());
		}
		
		System.out.println("\n\t\t---Prova Iterator a partir del PDI actual---");
		Iterator<Integer> i=llista.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
		
		
		System.out.println("\n\t\t---Prova d'eliminació d'elements i desplaçament del PDI---");
		llista.printLinkedList();
		while (llista.longitud() > 0) {
			try {
				llista.esborrar();
				llista.printLinkedList();
			} catch (ElementNoTrobat exc) {
				System.out.println(""+exc.getMessage());
			}
		}
		
		try {
			System.out.println("\nPDI actual: "+llista.actual());
		}  catch (ErrorPDI exc) {
			System.out.println(""+exc.getMessage());
		}
		
		try {
			System.out.println("\nDesplaçant PDI a la dreta");
			llista.Avancar();
			System.out.println("PDI actual: "+llista.actual());
		} catch (LimitPDI exc) {
			System.out.println(""+exc.getMessage());
		}  catch (ErrorPDI exc) {
			System.out.println(""+exc.getMessage());
		}
		
		try {
			System.out.println("Desplaçant PDI a l'esquerra");
			llista.Retrocedir();
			System.out.println("PDI actual: "+llista.actual());
		} catch (LimitPDI exc) {
			System.out.println(""+exc.getMessage());
		}  catch (ErrorPDI exc) {
			System.out.println(""+exc.getMessage());
		}
		
		try {
			System.out.println("Desplaçant PDI al final");
			llista.Final();
			System.out.println("PDI actual: "+llista.actual());
		} catch (ErrorHeadTail exc) {
			System.out.println(""+exc.getMessage());
		}  catch (ErrorPDI exc) {
			System.out.println(""+exc.getMessage());
		}
		
		try {
			System.out.println("Desplaçant PDI a l'inici");
			llista.Principi();
			System.out.println("PDI actual: "+llista.actual());
		} catch (ErrorHeadTail exc) {
			System.out.println(""+exc.getMessage());
		}  catch (ErrorPDI exc) {
			System.out.println(""+exc.getMessage());
		}
	}
	
	/**
	 * Fa proves d'inserció i desplaçament de PDI, iteracions amb iterator i eliminació d'elements
	 *  en una LinkedList amb doubles.
	 */
	public static void LinkedListDouble () {
		LinkedList<Double> llista = new LinkedList<Double>();
		System.out.println("\t\t---Prova d'insercions i desplaçament de PDI---");
		llista.printLinkedList();
		System.out.println("");
		try {
			llista.inserir(1.1);
			llista.printLinkedList();
			System.out.println("\nPDI actual: "+llista.actual());
		} catch (ErrorInsercio exc) {
			System.out.println("Hi ha hagut un problema en la inserció de l'element");
		} catch (ErrorPDI exc) {
			System.out.println(""+exc.getMessage());
		}
		try {
			llista.inserir(2.2);
			llista.printLinkedList();
			System.out.println("\nPDI actual: "+llista.actual());
		} catch (ErrorInsercio exc) {
			System.out.println("Hi ha hagut un problema en la inserció de l'element");
		} catch (ErrorPDI exc) {
			System.out.println(""+exc.getMessage());
		}
		try {
			System.out.println("Desplaçant PDI a l'inici");
			llista.Principi();
			System.out.println("PDI actual: "+llista.actual());
		} catch (ErrorPDI exc) {
			System.out.println(""+exc.getMessage());
		} catch (ErrorHeadTail exc) {
			System.out.println(""+exc.getMessage());
		}
		try {
			llista.inserir(3.3);
			llista.printLinkedList();
			System.out.println("\nPDI actual: "+llista.actual());
		} catch (ErrorInsercio exc) {
			System.out.println("Hi ha hagut un problema en la inserció de l'element");
		} catch (ErrorPDI exc) {
			System.out.println(""+exc.getMessage());
		}
		try {
			System.out.println("Desplaçant PDI al final");
			llista.Final();
			System.out.println("PDI actual: "+llista.actual());
		} catch (ErrorPDI exc) {
			System.out.println(""+exc.getMessage());
		} catch (ErrorHeadTail exc) {
			System.out.println(""+exc.getMessage());
		}
		try {
			llista.inserir(4.4);
			llista.printLinkedList();
			System.out.println("\nPDI actual: "+llista.actual());
		} catch (ErrorInsercio exc) {
			System.out.println("Hi ha hagut un problema en la inserció de l'element");
		} catch (ErrorPDI exc) {
			System.out.println(""+exc.getMessage());
		}
		try {
			System.out.println("Desplaçant PDI a l'esquerra");
			llista.Retrocedir();
			System.out.println("PDI actual: "+llista.actual());
		} catch (LimitPDI exc) {
			System.out.println(""+exc.getMessage());
		} catch (ErrorPDI exc) {
			System.out.println(""+exc.getMessage());
		}
		try {
			llista.inserir(5.5);
			llista.printLinkedList();
			System.out.println("\nPDI actual: "+llista.actual());
		} catch (ErrorInsercio exc) {
			System.out.println("Hi ha hagut un problema en la inserció de l'element");
		} catch (ErrorPDI exc) {
			System.out.println(""+exc.getMessage());
		}
		try {
			System.out.println("Desplaçant PDI a l'esquerra");
			llista.Retrocedir();
			System.out.println("PDI actual: "+llista.actual());
		} catch (LimitPDI exc) {
			System.out.println(""+exc.getMessage());
		} catch (ErrorPDI exc) {
			System.out.println(""+exc.getMessage());
		}
		try {
			llista.inserir(6.6);
			llista.printLinkedList();
			System.out.println("\nPDI actual: "+llista.actual());
		} catch (ErrorInsercio exc) {
			System.out.println("Hi ha hagut un problema en la inserció de l'element");
		} catch (ErrorPDI exc) {
			System.out.println(""+exc.getMessage());
		}
		try {
			System.out.println("Desplaçant PDI a la dreta");
			llista.Avancar();
			System.out.println("PDI actual: "+llista.actual());
		} catch (LimitPDI exc) {
			System.out.println(""+exc.getMessage());
		}  catch (ErrorPDI exc) {
			System.out.println(""+exc.getMessage());
		}
		try {
			llista.inserir(7.7);
			llista.printLinkedList();
			System.out.println("\nPDI actual: "+llista.actual());
		} catch (ErrorInsercio exc) {
			System.out.println("Hi ha hagut un problema en la inserció de l'element");
		} catch (ErrorPDI exc) {
			System.out.println(""+exc.getMessage());
		}
		
		System.out.println("\n\t\t---Prova Iterator a partir del PDI actual---");
		Iterator<Double> i=llista.iterator();
		
		while (i.hasNext()) {
			System.out.println(i.next());
		}
		
		
		System.out.println("\n\t\t---Prova d'eliminació d'elements i desplaçament del PDI---");
		llista.printLinkedList();
		while (llista.longitud() > 0) {
			try {
				llista.esborrar();
				llista.printLinkedList();
			} catch (ElementNoTrobat exc) {
				System.out.println(""+exc.getMessage());
			}
		}
		
		try {
			System.out.println("\nPDI actual: "+llista.actual());
		}  catch (ErrorPDI exc) {
			System.out.println(""+exc.getMessage());
		}
		
		try {
			System.out.println("\nDesplaçant PDI a la dreta");
			llista.Avancar();
			System.out.println("PDI actual: "+llista.actual());
		} catch (LimitPDI exc) {
			System.out.println(""+exc.getMessage());
		}  catch (ErrorPDI exc) {
			System.out.println(""+exc.getMessage());
		}
		
		try {
			System.out.println("Desplaçant PDI a l'esquerra");
			llista.Retrocedir();
			System.out.println("PDI actual: "+llista.actual());
		} catch (LimitPDI exc) {
			System.out.println(""+exc.getMessage());
		}  catch (ErrorPDI exc) {
			System.out.println(""+exc.getMessage());
		}
		
		try {
			System.out.println("Desplaçant PDI al final");
			llista.Final();
			System.out.println("PDI actual: "+llista.actual());
		} catch (ErrorHeadTail exc) {
			System.out.println(""+exc.getMessage());
		}  catch (ErrorPDI exc) {
			System.out.println(""+exc.getMessage());
		}
		
		try {
			System.out.println("Desplaçant PDI a l'inici");
			llista.Principi();
			System.out.println("PDI actual: "+llista.actual());
		} catch (ErrorHeadTail exc) {
			System.out.println(""+exc.getMessage());
		}  catch (ErrorPDI exc) {
			System.out.println(""+exc.getMessage());
		}
	}

	/**
	 * Fa proves d'inserció i eliminació d'elements en una SkipList amb strings.
	 */
	public static void SkipListString () {
		SkipList<String> llista = new SkipList<String>();
		System.out.println("\t\t---Prova d'inserció d'elements---");
		llista.printSkipList();
		System.out.println("");
		try {
			llista.inserir("Primera");
			llista.printSkipList();
			System.out.println("");
		} catch (ErrorInsercio exc) {
			System.out.println("Hi ha hagut un problema en la inserció de l'element");
		}
		try {
			llista.inserir("Segona");
			llista.printSkipList();
			System.out.println("");
		} catch (ErrorInsercio exc) {
			System.out.println("Hi ha hagut un problema en la inserció de l'element");
		} 
		try {
			llista.inserir("Tercera");
			llista.printSkipList();
			System.out.println("");
		} catch (ErrorInsercio exc) {
			System.out.println("Hi ha hagut un problema en la inserció de l'element");
		}
		try {
			llista.inserir("Tercera");
			llista.printSkipList();
			System.out.println("");
		} catch (ErrorInsercio exc) {
			System.out.println("Hi ha hagut un problema en la inserció de l'element");
		}
		try {
			llista.inserir("Quarta");
			llista.printSkipList();
			System.out.println("");
		} catch (ErrorInsercio exc) {
			System.out.println("Hi ha hagut un problema en la inserció de l'element");
		}
		
		try {
			llista.inserir("Cinquena");
			llista.printSkipList();
			System.out.println("");
		} catch (ErrorInsercio exc) {
			System.out.println("Hi ha hagut un problema en la inserció de l'element");
		} 
		
		try {
			llista.inserir("Sisena");
			llista.printSkipList();
			System.out.println("");
		} catch (ErrorInsercio exc) {
			System.out.println("Hi ha hagut un problema en la inserció de l'element");
		}
		
		try {
			llista.inserir("Setena");
			llista.printSkipList();
			System.out.println("");
		} catch (ErrorInsercio exc) {
			System.out.println("Hi ha hagut un problema en la inserció de l'element");
		} 		
		
		System.out.println("Longitud: "+llista.longitud());
		
		System.out.println("\n\t\t---Prova d'eliminació d'elements---");
		llista.printSkipList();
		System.out.println("\nEliminant: Primera");
		try {
			llista.esborrar("Primera");
			llista.printSkipList();
		} catch (ElementNoTrobat exc) {
			System.out.println(""+exc.getMessage());
		}
		
		System.out.println("\nEliminant: Segona");
		try {
			llista.esborrar("Segona");
			llista.printSkipList();
		} catch (ElementNoTrobat exc) {
			System.out.println(""+exc.getMessage());
		}
		
		System.out.println("\nEliminant: Tercera");
		try {
			llista.esborrar("Tercera");
			llista.printSkipList();
		} catch (ElementNoTrobat exc) {
			System.out.println(""+exc.getMessage());
		}
		
		System.out.println("\nEliminant: Tercera");
		try {
			llista.esborrar("Tercera");
			llista.printSkipList();
		} catch (ElementNoTrobat exc) {
			System.out.println(""+exc.getMessage());
		}
		
		System.out.println("\nEliminant: Quarta");
		try {
			llista.esborrar("Quarta");
			llista.printSkipList();
		} catch (ElementNoTrobat exc) {
			System.out.println(""+exc.getMessage());
		}
		
		System.out.println("\nEliminant: Cinquena");
		try {
			llista.esborrar("Cinquena");
			llista.printSkipList();
		} catch (ElementNoTrobat exc) {
			System.out.println(""+exc.getMessage());
		}
		
		System.out.println("\nEliminant: Sisena");
		try {
			llista.esborrar("Sisena");
			llista.printSkipList();
		} catch (ElementNoTrobat exc) {
			System.out.println(""+exc.getMessage());
		}
		
		System.out.println("\nEliminant: Setena");
		try {
			llista.esborrar("Setena");
			llista.printSkipList();
		} catch (ElementNoTrobat exc) {
			System.out.println(""+exc.getMessage());
		}
	}
	
	/**
	 * Fa proves d'inserció i eliminació d'elements en una SkipList amb enters.
	 */
	public static void SkipListInteger () {
		SkipList<Integer> llista = new SkipList<Integer>();
		System.out.println("\t\t---Prova d'inserció d'elements---");
		llista.printSkipList();
		System.out.println("");
		try {
			llista.inserir(1);
			llista.printSkipList();
			System.out.println("");
		} catch (ErrorInsercio exc) {
			System.out.println("Hi ha hagut un problema en la inserció de l'element");
		}
		try {
			llista.inserir(2);
			llista.printSkipList();
			System.out.println("");
		} catch (ErrorInsercio exc) {
			System.out.println("Hi ha hagut un problema en la inserció de l'element");
		} 
		try {
			llista.inserir(3);
			llista.printSkipList();
			System.out.println("");
		} catch (ErrorInsercio exc) {
			System.out.println("Hi ha hagut un problema en la inserció de l'element");
		}
		try {
			llista.inserir(3);
			llista.printSkipList();
			System.out.println("");
		} catch (ErrorInsercio exc) {
			System.out.println("Hi ha hagut un problema en la inserció de l'element");
		}
		try {
			llista.inserir(4);
			llista.printSkipList();
			System.out.println("");
		} catch (ErrorInsercio exc) {
			System.out.println("Hi ha hagut un problema en la inserció de l'element");
		}
		
		try {
			llista.inserir(5);
			llista.printSkipList();
			System.out.println("");
		} catch (ErrorInsercio exc) {
			System.out.println("Hi ha hagut un problema en la inserció de l'element");
		} 
		
		try {
			llista.inserir(6);
			llista.printSkipList();
			System.out.println("");
		} catch (ErrorInsercio exc) {
			System.out.println("Hi ha hagut un problema en la inserció de l'element");
		}
		
		try {
			llista.inserir(7);
			llista.printSkipList();
			System.out.println("");
		} catch (ErrorInsercio exc) {
			System.out.println("Hi ha hagut un problema en la inserció de l'element");
		}
		
		System.out.println("Longitud: "+llista.longitud());
		
		System.out.println("\n\t\t---Prova d'eliminació d'elements---");
		llista.printSkipList();
		System.out.println("\nEliminant: 1");
		try {
			llista.esborrar(1);
			llista.printSkipList();
		} catch (ElementNoTrobat exc) {
			System.out.println(""+exc.getMessage());
		}
		
		System.out.println("\nEliminant: 2");
		try {
			llista.esborrar(2);
			llista.printSkipList();
		} catch (ElementNoTrobat exc) {
			System.out.println(""+exc.getMessage());
		}
		
		System.out.println("\nEliminant: 3");
		try {
			llista.esborrar(3);
			llista.printSkipList();
		} catch (ElementNoTrobat exc) {
			System.out.println(""+exc.getMessage());
		}
		
		System.out.println("\nEliminant: 3");
		try {
			llista.esborrar(3);
			llista.printSkipList();
		} catch (ElementNoTrobat exc) {
			System.out.println(""+exc.getMessage());
		}
		
		System.out.println("\nEliminant: 4");
		try {
			llista.esborrar(4);
			llista.printSkipList();
		} catch (ElementNoTrobat exc) {
			System.out.println(""+exc.getMessage());
		}
		
		System.out.println("\nEliminant: 5");
		try {
			llista.esborrar(5);
			llista.printSkipList();
		} catch (ElementNoTrobat exc) {
			System.out.println(""+exc.getMessage());
		}
		
		System.out.println("\nEliminant: 6");
		try {
			llista.esborrar(6);
			llista.printSkipList();
		} catch (ElementNoTrobat exc) {
			System.out.println(""+exc.getMessage());
		}
		
		System.out.println("\nEliminant: 7");
		try {
			llista.esborrar(7);
			llista.printSkipList();
		} catch (ElementNoTrobat exc) {
			System.out.println(""+exc.getMessage());
		}
	}
	
	/**
	 * Fa proves d'inserció i eliminació d'elements en una SkipList amb doubles.
	 */
	public static void SkipListDouble() {
		SkipList<Double> llista = new SkipList<Double>();
		System.out.println("\t\t---Prova d'inserció d'elements---");
		llista.printSkipList();
		System.out.println("");
		try {
			llista.inserir(1.1);
			llista.printSkipList();
			System.out.println("");
		} catch (ErrorInsercio exc) {
			System.out.println("Hi ha hagut un problema en la inserció de l'element");
		}
		try {
			llista.inserir(2.2);
			llista.printSkipList();
			System.out.println("");
		} catch (ErrorInsercio exc) {
			System.out.println("Hi ha hagut un problema en la inserció de l'element");
		} 
		try {
			llista.inserir(3.3);
			llista.printSkipList();
			System.out.println("");
		} catch (ErrorInsercio exc) {
			System.out.println("Hi ha hagut un problema en la inserció de l'element");
		}
		try {
			llista.inserir(3.3);
			llista.printSkipList();
			System.out.println("");
		} catch (ErrorInsercio exc) {
			System.out.println("Hi ha hagut un problema en la inserció de l'element");
		}
		try {
			llista.inserir(4.4);
			llista.printSkipList();
			System.out.println("");
		} catch (ErrorInsercio exc) {
			System.out.println("Hi ha hagut un problema en la inserció de l'element");
		}
		
		try {
			llista.inserir(5.5);
			llista.printSkipList();
			System.out.println("");
		} catch (ErrorInsercio exc) {
			System.out.println("Hi ha hagut un problema en la inserció de l'element");
		} 
		
		try {
			llista.inserir(6.6);
			llista.printSkipList();
			System.out.println("");
		} catch (ErrorInsercio exc) {
			System.out.println("Hi ha hagut un problema en la inserció de l'element");
		}
		
		try {
			llista.inserir(7.7);
			llista.printSkipList();
			System.out.println("");
		} catch (ErrorInsercio exc) {
			System.out.println("Hi ha hagut un problema en la inserció de l'element");
		}
		
		System.out.println("Longitud: "+llista.longitud());
		
		System.out.println("\n\t\t---Prova d'eliminació d'elements---");
		llista.printSkipList();
		System.out.println("\nEliminant: 1.1");
		try {
			llista.esborrar(1.1);
			llista.printSkipList();
		} catch (ElementNoTrobat exc) {
			System.out.println(""+exc.getMessage());
		}
		
		System.out.println("\nEliminant: 2.2");
		try {
			llista.esborrar(2.2);
			llista.printSkipList();
		} catch (ElementNoTrobat exc) {
			System.out.println(""+exc.getMessage());
		}
		
		System.out.println("\nEliminant: 3.3");
		try {
			llista.esborrar(3.3);
			llista.printSkipList();
		} catch (ElementNoTrobat exc) {
			System.out.println(""+exc.getMessage());
		}
		
		System.out.println("\nEliminant: 3.3");
		try {
			llista.esborrar(3.3);
			llista.printSkipList();
		} catch (ElementNoTrobat exc) {
			System.out.println(""+exc.getMessage());
		}
		
		System.out.println("\nEliminant: 4.4");
		try {
			llista.esborrar(4.4);
			llista.printSkipList();
		} catch (ElementNoTrobat exc) {
			System.out.println(""+exc.getMessage());
		}
		
		System.out.println("\nEliminant: 5.5");
		try {
			llista.esborrar(5.5);
			llista.printSkipList();
		} catch (ElementNoTrobat exc) {
			System.out.println(""+exc.getMessage());
		}
		
		System.out.println("\nEliminant: 6.6");
		try {
			llista.esborrar(6.6);
			llista.printSkipList();
		} catch (ElementNoTrobat exc) {
			System.out.println(""+exc.getMessage());
		}
		
		System.out.println("\nEliminant: 7.7");
		try {
			llista.esborrar(7.7);
			llista.printSkipList();
		} catch (ElementNoTrobat exc) {
			System.out.println(""+exc.getMessage());
		}
	}
	
	
}
