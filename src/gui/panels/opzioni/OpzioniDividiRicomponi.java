package gui.panels.opzioni;

import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import gui.panels.PanelDividi;
import gui.panels.PanelRicomponi;

/**
 * Classe contenente alcune opzione per {@link PanelDividi} e {@link PanelRicomponi}
 * 
 * @author Nicola Improta
 *
 */

@SuppressWarnings("serial")
public abstract class OpzioniDividiRicomponi extends JPanel{

	/**
	 * Costruttore della classe che contiene le opzioni per {@link PanelDividi} e {@link PanelRicomponi}
	 */
	
	public OpzioniDividiRicomponi() {
		super();
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setBorder(BorderFactory.createEtchedBorder());
		this.setAlignmentX(Component.LEFT_ALIGNMENT);
		
	}
	
	
	
}
