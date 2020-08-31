package gui.panels.componenti;

import java.awt.Dimension;
import java.io.File;

import javax.swing.*;

/**
 * Classe che permette la creazione del {@link JPanel} contenente i componenti 
 * che permettono la selezione degi file da aggiungere alla coda
 * 
 * @author Nicola Improta
 *
 */

@SuppressWarnings("serial")
public class SelezionaFileDaAggiungereAllaCoda extends JPanel{

	/**
	 * {@link JButton} che permette di aprire il {@link JFileChooser} e selezionare i file 
	 */
	
	protected final JButton buttonScegli;
	
	/**
	 * {@link JTextField} che contiene il nome dei file selezionati
	 */
	
	protected final JTextField rigaFile;

	/**
	 * {@link JFileChooser} che permette di selezionare i file
	 */
	
	protected final JFileChooser finestraFile;
	
	/**
	 * Costruttore della classe
	 */
	
	public SelezionaFileDaAggiungereAllaCoda() {
		
		rigaFile = new JTextField();
		rigaFile.setPreferredSize(new Dimension(250,24));
		rigaFile.setEditable(false);
		rigaFile.setBorder(BorderFactory.createEtchedBorder());
		
		finestraFile = new JFileChooser();
		finestraFile.setMultiSelectionEnabled(true);
		finestraFile.setCurrentDirectory(new File("."));
		
		buttonScegli = new JButton(new ImageIcon("img/iconCartella.png"));
		buttonScegli.setPreferredSize(new Dimension(24,24));
		buttonScegli.setToolTipText("Seleziona file");
		buttonScegli.setBorderPainted(false);
		buttonScegli.addActionListener(e -> {
			if(finestraFile.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
				this.MostraFilesSelezionati();
				
			}
		});

		this.add(buttonScegli);
		
		this.add(rigaFile);
		
	}
	
	/**
	 * Metodo che permette di mostrare quali file sono stati selezionati nel {@link JFileChooser}
	 */
	
	protected void MostraFilesSelezionati() {
		
		StringBuilder testo = new StringBuilder();
		
		for(File file : finestraFile.getSelectedFiles()) {
			testo.append("\"");
			testo.append(file.getName());
			testo.append("\" ");
		}
		rigaFile.setText(testo.toString());
	}
	
	/**
	 * Metodo che permette di restituire i file che sono stati selezionati nel {@link JFileChooser}
	 */
	
	public File[] RestituisciFileSelezionati() {
		return finestraFile.getSelectedFiles();
	}

}
