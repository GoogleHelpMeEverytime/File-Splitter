package gui.panels;

import gui.panels.componenti.*;
import gui.panels.opzioni.*;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import functionCode.divisione.OperazioneDivisione;
import functionCode.divisione.OperazioneDivisioneDimensione;
import functionCode.divisione.OperazioneDivisioneDimensioneComprimi;
import functionCode.divisione.OperazioneDivisioneDimensioneCripta;
import functionCode.divisione.OperazioneDivisioneNumeroParti;
import functionCode.elementi.ElementiInCodaDividiOperazioni;
import functionCode.elementi.ElementoInCoda;
import functionCode.ricomponi.OperazioneRicomponi;


/**
 * Classe contenente il {@link JPanel} e i componenti per dare la possibilità all'utente di 
 * scegliere il file da dividere e aggiungerlo alla coda
 * 
 * @author Nicola Improta
 *
 */

@SuppressWarnings("serial")
public class PanelDividi extends OpzioniDividiRicomponi{

	/**
	 * Insieme di componenti che permettono al utente di scegliere il file su cui 
	 * eseguire l' {@link OperazioneDivisione}
	 * @see SelezionaFileDaAggiungereAllaCoda
	 */
	
	protected final SelezionaFileDaAggiungereAllaCoda seleziona;
	
	/**
	 * {@link JComboBox} che permette al utente di selezionare l' {@link OperazioneDivisioneDimensioneCripta}
	 */
	
	protected final SelezionaCriptaFileMood password;
	
	/**
	 * {@link JButton} che permette di aggiungere un file alla coda
	 * @see ButtonAggiungiAllaCoda
	 */
	
	protected final ButtonAggiungiAllaCoda aggiungi;
	
	/**
	 * {@link JComboBox} che permette al utente di selezionare l' {@link OperazioneDivisioneDimensioneComprimi}
	 */
	
	protected final SelezionaCompressione compressione;
	
	/**
	 * Insieme di componenti che permette al utente di inserire la dimensione 
	 * delle parti del file oppure il numero di parti in cui dividere il file
	 */
	
	protected final SelezioneDivisionePartiDimensione dividi;
	
	/**
	 * Costruttore della classe
	 * 
	 * @param clickCrea ActionListener per il {@link JButton} che permette di aggiungere un file alla coda su cui si deve svolgere l'operazione di divisione
	 */
	
	public PanelDividi(ActionListener clickCrea) {
		
		super();

		seleziona = new SelezionaFileDaAggiungereAllaCoda();
		this.add(seleziona);

		dividi = new SelezioneDivisionePartiDimensione();
		this.add(dividi);
		
		password = new SelezionaCriptaFileMood();
		this.add(password);
		
		compressione = new SelezionaCompressione();
		this.add(compressione);
				
		aggiungi = new ButtonAggiungiAllaCoda(clickCrea);
		aggiungi.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(aggiungi);

	}
	
	/**
	 * Metodo per aggiungere alla coda i file da dividere. Tale metodo per riconoscere
	 * quale {@link OperazioneDivisione} eseguire effettua un controllo sui componenti che 
	 * formano il panel.
	 * 
	 * @param files {@link ArrayList} contenente gli {@link ElementoInCoda} su cui effettuare l' {@link OperazioneRicomponi}
	 */
	public void AggiungiAllaCoda(ArrayList<ElementoInCoda> files) {
		if(seleziona.RestituisciFileSelezionati().length == 0) {
			JOptionPane.showMessageDialog(null, "Nessun file selezionato", "ATTENZIONE!!!", JOptionPane.ERROR_MESSAGE);
			}
		
		for(File file : seleziona.RestituisciFileSelezionati()) {
			
			OperazioneDivisione op = null;
			
			int divisione = 0;
			int modalita = 0;
			
			boolean comprimi = compressione.ModalitaCompressaSelezionata();
			boolean cripta = password.ModalitaCriptaFileSelezionata();
			
			if(dividi.RestituisciNumeroParti() != 0 && dividi.RestituisciDimensione() == 0) {
				op = new OperazioneDivisioneNumeroParti();
				divisione = dividi.RestituisciNumeroParti();
				modalita=1;
			}
			
			else if(dividi.RestituisciDimensione() != 0 && dividi.RestituisciNumeroParti() == 0) {
			    op = new OperazioneDivisioneDimensione();
			    divisione = dividi.RestituisciDimensione();
			    modalita=2;
			}
			
			if(comprimi && !(dividi.RestituisciDimensione() == 0)) {
				op = new OperazioneDivisioneDimensioneComprimi();
				modalita=3;
			}
		
			if(cripta && !(dividi.RestituisciDimensione() == 0)) {
				op = new OperazioneDivisioneDimensioneCripta();
				modalita=4;
			}
			
			files.add(new ElementiInCodaDividiOperazioni(file, op, divisione, modalita));
			
		}
		
		
	}
	

}
