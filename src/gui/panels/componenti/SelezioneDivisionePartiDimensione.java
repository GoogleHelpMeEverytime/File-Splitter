package gui.panels.componenti;

import java.awt.Dimension;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * Classe che permette la creazione del {@link JPanel} contenente i componenti 
 * che permettono di inserire la dimensione delle parti oppure il numero di parti in
 * cui dividere il file 
 * 
 * @author Nicola Improta
 *
 */

@SuppressWarnings("serial")
public class SelezioneDivisionePartiDimensione extends JPanel{

	/**
	 * {@link JCheckBox} che abilita alla scrittura sui {@link JTextField} per la dimensione e per il numero di parti
	 */
	
	protected final JCheckBox seleziona;
	
	/**
	 * {@link JSeparator} che separa i due {@link JTextField} presenti nel panel 
	 */
	
	protected final JSeparator separatore;
	
	/**
	 * {@link JTextField} per permettere di scrivere la dimensione di ogni parte oppure il numero di parti
	 */
	
	protected final JTextField parti, dimensione;
	
	/**
	 * {@link JLabel} contenti testo che indicano: quale {@link JTextField} è 
	 * dedicato alle parti e quale dedicato alla dimensione e bytes che specifica che 
	 * la dimensione delle parti è espressa in byte
	 */
	
	protected final JLabel testoParti, testoDimensione, bytes;
	
	/**
	 * Costruttore della classe
	 */
	
	public SelezioneDivisionePartiDimensione() {
		
		super();
		
		seleziona = new JCheckBox("DIVIDI");
		seleziona.addActionListener(l -> AbilitaScriviPartiDimensione());
		this.add(seleziona);	
		
		testoParti = new JLabel("Parti");
		this.add(testoParti);
		
		parti = new JTextField();
		parti.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				AbilitaScriviPartiDimensione();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				AbilitaScriviPartiDimensione();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				AbilitaScriviPartiDimensione();
			}
		} );
		parti.setPreferredSize(new Dimension(50,24));
		this.add(parti);
		
		separatore = new JSeparator();
		this.add(separatore);
		
		testoDimensione = new JLabel("Dimensione");
		this.add(testoDimensione);
		
		dimensione = new JTextField();
		dimensione.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				AbilitaScriviPartiDimensione();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				AbilitaScriviPartiDimensione();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				AbilitaScriviPartiDimensione();
			}
		});
		dimensione.setPreferredSize(new Dimension(50,24));
		this.add(dimensione);
		
		bytes = new JLabel("B");
		this.add(bytes);
		
		this.AbilitaScriviPartiDimensione();
		
	}
	
	/**
	 * Metodo che permette di abilitare la scrittura sui {@link JTextField} presenti
	 * nel panel
	 */
	
	public void AbilitaScriviPartiDimensione() {
		
		dimensione.setEnabled(seleziona.isEnabled());
		parti.setEnabled(seleziona.isEnabled());
		dimensione.setEditable(seleziona.isSelected() && parti.getText().equals(""));
	    parti.setEditable(seleziona.isSelected() && dimensione.getText().equals(""));
	    
	}

	/**
	 * Metodo che restituisce il valore inserito nel {@link JTextField} rappresentate il numero delle parti
	 */
	
	public int RestituisciNumeroParti() {
		
		if(!parti.getText().isEmpty() && !parti.getText().contentEquals("")) {
			return Integer.parseInt(parti.getText());
		}
		
		return 0;
	}
	
	/**
	 * Metodo che restituisce il valore inserito nel {@link JTextField} rappresentate la dimensione delle parti
	 */
	
	public int RestituisciDimensione() {
		
		
		if(!dimensione.getText().isEmpty() && !dimensione.getText().contentEquals("0")) {
			return Integer.parseInt(dimensione.getText());
		}
		return 0;
	}

}
