package gui.panels.componenti;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import functionCode.elementi.ElementoInCoda;

/**
 * Classe che permette la creazione del {@link JButton} per permettere di aggiungere
 * {@link ElementoInCoda} alla coda
 * 
 * @author Nicola Improta
 *
 */

@SuppressWarnings("serial")
public class ButtonAggiungiAllaCoda extends JPanel{

	/**
	 * {@link JButton} per permettere di aggiungere {@link ElementoInCoda} alla coda
	 */
	
	protected final JButton aggiungi;
	
	/**
	 * Costruttore della classe
	 * 
	 * @param click {@link ActionListener} per il {@link JButton} per l'aggiunta di {@link ElementoInCoda} alla coda
	 */
	
	public ButtonAggiungiAllaCoda(ActionListener click) {
		
		aggiungi = new JButton();
		aggiungi.addActionListener(click);
		aggiungi.setIcon(new ImageIcon("img/iconAggiungi.png"));
		aggiungi.setPreferredSize(new Dimension(30,30));
		aggiungi.setToolTipText("Aggiungi");
		aggiungi.setBorderPainted(false);
		this.add(aggiungi);
	}

}
