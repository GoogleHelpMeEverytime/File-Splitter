package gui.panels.componenti;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import functionCode.elementi.ElementoInCoda;

/**
 * Classe che permette la creazione del {@link JPanel} contenente il {@link JButton} per permettere la cancellazione
 * di {@link ElementoInCoda}
 * 
 * @author Nicola Improta
 *
 */

@SuppressWarnings("serial")
public class ButtonCancella extends JPanel{
	
	/**
	 * {@link JButton} per permettere la cancellazione di {@link ElementoInCoda}
	 */
	
	protected final JButton cancella;
	
	/**
	 * Costruttore della classe
	 * 
	 * @param deleteCoda {@link ActionListener} per il {@link JButton} per la cancellazione di {@link ElementoInCoda}
	 */
	
	public ButtonCancella(ActionListener deleteCoda){
		
		cancella = new JButton();
		cancella.setPreferredSize(new Dimension(50,50));
		cancella.setIcon(new ImageIcon("img/iconCestino.png"));
		cancella.setToolTipText("Cancella dalla coda");
		cancella.setBorderPainted(true);
		cancella.addActionListener(deleteCoda);
		this.add(cancella);
	}
}
