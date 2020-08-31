package main;
import gui.*;

import java.util.ArrayList;
import javax.swing.*;
import functionCode.elementi.ElementoInCoda;

/**
 * Classe contenente la funzione main per eseguire il programma
 * 
 * @author Nicola Improta
 */

public class Main {

	/**
	 * La {@link ArrayList} che contiene tutti gli {@link ElementoInCoda} scelti dal utente e sui quali si dovranno effettuare le operazioni selezionate
	 */
	
	protected static ArrayList<ElementoInCoda> files;
	
	/**
	 * Il metodo main del programma permette di aprire il {@link FrameCompleto} 
	 * dando così la possibiltà al utente di poter svolgere le operazioni che desidera e crea l' {@link ArrayList} che conterrà gli @link {@link ElementoInCoda}
	 *
	 * @param args Gli argomenti passati al programma dalla linea di comando 
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws UnsupportedLookAndFeelException
	 */
		
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		
		//Permette di impostare lo stile di Windows all'interfaccia grafica
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		
		files = new ArrayList<>();
		
		FrameCompleto cf = new FrameCompleto(files);
		
        cf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cf.setVisible(true);
	}

}
