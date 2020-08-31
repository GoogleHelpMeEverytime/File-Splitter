package gui.panels;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import functionCode.divisione.OperazioneDivisione;
import functionCode.elementi.ElementoInCoda;
import functionCode.ricomponi.OperazioneRicomponi;

/**
 * Classe contenente i {@link JPanel} {@link PanelDividi} e {@link PanelRicomponi}
 * uniti in un unico {@link JPanel}
 * 
 * @author Nicola Improta
 *
 */

@SuppressWarnings("serial")
public class PanelDividiRicomponi extends JPanel{

	/**
	 * Panel che contiene i componenti per effettuare le {@link OperazioneDivisione}
	 * 
	 * @see PanelDividi
	 */
	
	protected final PanelDividi dividi;
	
	/**
	 * Panel che contiene i componenti per effettuare le {@link OperazioneRicomponi} 
	 * 
	 * @see PanelRicomponi
	 */
	
	protected final PanelRicomponi ricomponi;
	
	/**
	 * Costruttore della classe
	 * 
	 * @param clickCreaDividi {@link ActionListener} per il {@link JButton} che permette di aggiungere un file alla coda su cui si deve svolgere l'operazione di divisione
	 * @param clickCreaRicomponi {@link ActionListener} per il {@link JButton} che permette di aggiungere un file alla coda su cui si deve svolgere l'operazione di ricomposizione
	 */
	
	public PanelDividiRicomponi(ActionListener clickCreaDividi, ActionListener clickCreaRicomponi) {
		
		super();
		
		dividi = new PanelDividi(clickCreaDividi);
		
		this.add(dividi);
		
		ricomponi = new PanelRicomponi(clickCreaRicomponi);
		
		this.add(ricomponi);
		
	}
	
	/**
	 * Metodo che permette di aggiungere un {@link ElementoInCoda} alla coda su cui bisogna effettuare l'operazione di divisione
	 */
	
	public void AggiungiAllaCodaDividi(ArrayList<ElementoInCoda> files) {
		dividi.AggiungiAllaCoda(files);
	}
	
	/**
	 * Metodo che permette di aggiungere un {@link ElementoInCoda} alla coda su cui bisogna effettuare l'operazione di ricomposizione
	 */
	
	public void AggiungiAllaCodaRicomponi(ArrayList<ElementoInCoda> files) {
		ricomponi.AggiungiAllaCoda(files);
	}
	
}
