package gui.panels.componenti;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import functionCode.elementi.ElementoInCoda;

/**
 * Classe che permette la creazione del {@link JPanel} contenente il {@link JButton} per permettere l'esecuzione
 * degli {@link ElementoInCoda}
 * 
 * @author Nicola Improta
 *
 */

@SuppressWarnings("serial")
public class ButtonStart extends JPanel{

	/**
	 * {@link JButton} per permettere l'esecuzione degli {@link ElementoInCoda}
	 */
	
	protected final JButton start;
	
	/**
	 * Costruttore della classe
	 * 
	 * @param startCoda {@link ActionListener} per il {@link JButton} per l'esecuzione degli {@link ElementoInCoda}
	 */
	
	public ButtonStart(ActionListener startCoda) {
		
		start = new JButton();
		start.setPreferredSize(new Dimension(50,50));
		start.setIcon(new ImageIcon("img/iconStart.png"));
		start.setToolTipText("Esegui");
		start.setBorderPainted(true);
		start.addActionListener(startCoda);
		this.add(start);
	}
	
}
