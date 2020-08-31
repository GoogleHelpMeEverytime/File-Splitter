package gui.panels;

import gui.panels.componenti.*;
import gui.panels.opzioni.*;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.*;

import functionCode.elementi.ElementiInCodaRicomponiOperazioni;
import functionCode.elementi.ElementoInCoda;
import functionCode.ricomponi.OperazioneRicomponi;
import functionCode.ricomponi.OperazioneRicomponiDimensione;
import functionCode.ricomponi.OperazioneRicomponiDimensioneComprimi;
import functionCode.ricomponi.OperazioneRicomponiDimensioneDecripta;
import functionCode.ricomponi.OperazioneRicomponiNumeroParti;

/**
 * Classe contenente il {@link JPanel} e i componenti per dare la possibilità all'utente di 
 * scegliere il file da ricomporre e aggiungerlo alla coda
 * 
 * @author Nicola Improta
 *
 */

@SuppressWarnings("serial")
public class PanelRicomponi extends OpzioniDividiRicomponi{

	/**
	 * Insieme di componenti che permettono al utente di scegliere il file su cui 
	 * eseguire l' {@link OperazioneRicomponi}
	 * @see SelezionaFileDaAggiungereAllaCoda
	 */
	
	protected final SelezionaFileDaAggiungereAllaCoda seleziona;
	
	/**
	 * {@link JButton} che permette di aggiungere un file alla coda
	 * @see ButtonAggiungiAllaCoda
	 */
	
	protected final ButtonAggiungiAllaCoda aggiungi;
	
	/**
	 * Costruttore della classe
	 * 
	 * @param clickCrea {@link ActionListener} per il {@link JButton} che permette di aggiungere un file alla coda su cui si deve svolgere l'operazione di ricomposizione
	 */
	
	public PanelRicomponi(ActionListener clickCrea) {
		
		super();

		seleziona = new SelezionaFileDaAggiungereAllaCoda();
		this.add(seleziona);
		
		this.add(Box.createVerticalStrut(99));
		
		aggiungi = new ButtonAggiungiAllaCoda(clickCrea);
		aggiungi.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(aggiungi);
	
		this.add(Box.createVerticalStrut(1));
		
	}
	
	/**
	 * Metodo per aggiungere alla coda i file da ricomporre. Inoltre, tale metodo permette
	 * di riconoscere qual è  l' {@link OperazioneRicomponi} da eseguire effettuando un controllo
	 * sul nome del file scelto dal utente
	 * 
	 * @param files {@link ArrayList} contenente gli {@link ElementoInCoda} su cui effettuare l' {@link OperazioneRicomponi}
	 */
	
	public void AggiungiAllaCoda(ArrayList<ElementoInCoda> files) {
		if(seleziona.RestituisciFileSelezionati().length == 0) {
			JOptionPane.showMessageDialog(null, "Nessun file selezionato", "ATTENZIONE!!!", JOptionPane.ERROR_MESSAGE);
		}
		
		for(File file : seleziona.RestituisciFileSelezionati()) {
			
			OperazioneRicomponi op = null;
			
			
			if(file.getName().contains(".partDim")) {
				op = new OperazioneRicomponiDimensione();
			}
			
			else if(file.getName().contains(".part")) {
				op = new OperazioneRicomponiNumeroParti();
			}
			
			if(file.getName().contains(".crypt")) {
				op = new OperazioneRicomponiDimensioneDecripta();
			}
			
			if(file.getName().contains(".partZip")) {
				op = new OperazioneRicomponiDimensioneComprimi();
			}
			
			files.add(new ElementiInCodaRicomponiOperazioni(file, op));
		}
		
		
	}
	
}
