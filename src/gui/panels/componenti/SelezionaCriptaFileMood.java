package gui.panels.componenti;

import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import functionCode.divisione.OperazioneDivisioneDimensioneCripta;

/**
 * Classe che permette la creazione del {@link JPanel} contenente la {@link JCheckBox} 
 * che permette di selezionare l' {@link OperazioneDivisioneDimensioneCripta}
 * 
 * @author Nicola Improta
 *
 */

@SuppressWarnings("serial")
public class SelezionaCriptaFileMood extends JPanel{

	/**
	 * {@link JCheckBox} per permettere di selezionare l' {@link OperazioneDivisioneDimensioneCripta}
	 */
	
	protected final JCheckBox seleziona;
	
	/**
	 * {@link JLabel} che contiene il testo della password usata per criptare
	 * il file
	 */
	
	protected final JLabel password;
	
	/**
	 * {@link JSeparator} che separa il {@link JLabel} e la {@link JCheckBox} presenti nel panel
	 */
	
	protected final JSeparator separatore;
	
	/**
	 * Costruttore della classe
	 */
	
	public SelezionaCriptaFileMood() {
		
		super();
		
		seleziona = new JCheckBox("CRIPTA CONTENUTO");
		seleziona.addActionListener(l -> ModalitaCriptaFileSelezionata());
		this.add(seleziona);
		
		this.add(Box.createHorizontalStrut(25));
		
		separatore = new JSeparator(JSeparator.VERTICAL);
		this.add(separatore);
		
		password = new JLabel("PASSWORD: progetto");
		this.add(password);
		
	}
	
	/**
	 * Metodo che restituisce se la {@link JCheckBox} è stata selezionata oppure no
	 * 
	 * @return false se non è stata selezionata oppure true se è stata selezionata
	 */
	
	public boolean ModalitaCriptaFileSelezionata() {
		
		if(seleziona.isSelected()) {
			return true;
		}
		
		return false;
	}
	
	
	
}
