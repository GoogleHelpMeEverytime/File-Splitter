package gui;


import functionCode.elementi.ElementoInCoda;
import gui.panels.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import gui.panels.PanelButtonAzioni;
import gui.panels.PanelDividi;
import gui.panels.PanelDividiRicomponi;
import gui.panels.PanelTable;
import gui.panels.componenti.ButtonCancella;
import gui.panels.componenti.ButtonStart;

/**
 * Classe contenente il frame che permette di gestire le operazioni che l'utente vuole svolgere
 * @author Nicola Improta
 *
 */
@SuppressWarnings("serial")
public class FrameCompleto extends JFrame{

	/**
	 *Panel che contiene gli {@link ElementoInCoda} e messi in una tabella {@link PanelTable}
	 */
	protected final PanelTable tabella;
	
	/**
	 * Panel che contiene i sub-panel {@link PanelDividi} e {@link PanelRicomponi} rispettivamente per svolgere le operazioni di divisione e di ricomposizione di file 
	 */
	protected final PanelDividiRicomponi dividiRicomponi;
	
	/**
	 * Panel che contiene i bottoni {@link ButtonStart} e {@link ButtonCancella} rispettivamente per eseguire e cancellare gli {@link ElementoInCoda} presenti nell' {@link ArrayList}
	 */
	protected final PanelButtonAzioni azioni;
	
	/**
	 * {@link JProgressBar} che permette di conoscere lo stato di avanzamente degli {@link ElementoInCoda} presenti nel @link {@link ArrayList} e visibili nella tabella {@link PanelTable}
	 */
	protected final JProgressBar progress;
	
	/**
	 * La {@link ArrayList} che contiene tutti gli {@link ElementoInCoda} inseriti dal utente
	 */
	protected final ArrayList<ElementoInCoda> files;
	
	
	/**
	 * Costruttore della classe FrameCompleto 
	 * @param files L' {@link ArrayList} di {@link ElementoInCoda} che contiene i file sul quale svolgere operazioni
	 */
	public FrameCompleto(ArrayList<ElementoInCoda> files) {
		
		super();
		
		this.files = files;

		//titolo del programma
		this.setTitle("Progetto file splitter");
		
		//container in cui inserire tutto il necessario
		Container cont = getContentPane();
		
		cont.setLayout(new BoxLayout(cont, BoxLayout.PAGE_AXIS));
		
		tabella = new PanelTable(files);
		
		
		//aggiungo la tabella al container
		cont.add(tabella);
		
		ActionListener clickCreaDividi = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				progress.setValue(0);
				dividiRicomponi.AggiungiAllaCodaDividi(files);
				tabella.AggiornaTabella();
			}
		};
		
		
		ActionListener clickCreaRicomponi = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				progress.setValue(0);
				dividiRicomponi.AggiungiAllaCodaRicomponi(files);
				tabella.AggiornaTabella();
				
			}
		};

		dividiRicomponi = new PanelDividiRicomponi(clickCreaDividi, clickCreaRicomponi);
		
		cont.add(dividiRicomponi);
		
		
		progress = new JProgressBar(0, 100);
		
		progress.setValue(0); 
		progress.setVisible(true);
		progress.setStringPainted(true);
		 
		
		
		ActionListener startCoda = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
				for(int i = 0; i <= files.size() - 1; files.isEmpty()) {
					
					int j = 100/files.size()+1;
					
					files.get(i).Esegui();
					files.remove(i);
					
					progress.setValue(progress.getValue()+j);
					progress.setVisible(true);
					progress.setStringPainted(true);
					tabella.AggiornaTabella();
					
				}
			}
		};
		
		ActionListener cancellaDallaCoda = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				int[] indice = tabella.IndiceElemento();
				Arrays.sort(indice);
				
				for(int n = indice.length - 1; n>=0; n--) {
					files.remove(indice[n]);
				}
				tabella.AggiornaTabella();
			}
		};
		
		
		
		azioni = new PanelButtonAzioni(startCoda, cancellaDallaCoda);
		
		cont.add(azioni);
		
		cont.add(progress);
		//mi apre la finestra della dimensione necessaria
		this.pack();
		
	}
}
