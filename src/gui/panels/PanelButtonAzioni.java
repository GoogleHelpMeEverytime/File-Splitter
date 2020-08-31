package gui.panels;

import gui.panels.componenti.*;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import functionCode.elementi.ElementoInCoda;

/**
 * Classe contenente il {@link JPanel} e i componenti per dare la possibilità al utente
 * di far partire la coda oppure di cancellare uno o più {@link ElementoInCoda}
 * 
 * @author Nicola Improta
 *
 */

@SuppressWarnings("serial")
public class PanelButtonAzioni extends JPanel{

	/**
	 * {@link JButton} che permette di far partire la coda
	 * 
	 * @see ButtonStart
	 */
	
	protected final ButtonStart start;
	
	/**
	 * {@link JButton} che permette di cancellare uno o più {@link ElementoInCoda}
	 * 
	 * @see ButtonCancella
	 */
	
	protected final ButtonCancella cancella;
	
	/**
	 * Costruttore della classe
	 * 
	 * @param startCoda {@link ActionListener} per il {@link ButtonStart}
	 * @param deleteCoda {@link ActionListener} per il {@link ButtonCancella}
	 */
	
	public PanelButtonAzioni(ActionListener startCoda, ActionListener deleteCoda) {
		
		start = new ButtonStart(startCoda);
		this.add(start);
		
		cancella = new ButtonCancella(deleteCoda);
		this.add(cancella);
		
	}
	
	
}
