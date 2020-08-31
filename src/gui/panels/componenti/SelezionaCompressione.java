package gui.panels.componenti;

import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

import functionCode.divisione.OperazioneDivisioneDimensioneComprimi;

/**
 * Classe che permette la creazione del {@link JPanel} contenente la {@link JCheckBox} 
 * che permette di selezionare l' {@link OperazioneDivisioneDimensioneComprimi}
 * 
 * @author Nicola Improta
 *
 */

@SuppressWarnings("serial")
public class SelezionaCompressione extends JPanel{
	
	/**
	 * {@link JCheckBox} per permettere di selezionare l' {@link OperazioneDivisioneDimensioneComprimi}
	 */
	
	protected final JCheckBox compressione;
	
	/**
	 * Costruttore della classe
	 */
	
	public SelezionaCompressione() {
		
		super();
		
		compressione = new JCheckBox("COMPRIMI FILE");
		compressione.addActionListener(l -> ModalitaCompressaSelezionata());
		this.add(compressione);
		this.add(Box.createHorizontalStrut(169));
		
	}
	
	/**
	 * Metodo che restituisce se la {@link JCheckBox} è stata selezionata oppure no
	 * 
	 * @return false se non è stata selezionata oppure true se è stata selezionata
	 */
	
	public boolean ModalitaCompressaSelezionata() {
		
		if(compressione.isSelected()) {
			return true;
		}
		return false;
	}
}
