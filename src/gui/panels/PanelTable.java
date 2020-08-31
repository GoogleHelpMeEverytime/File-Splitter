package gui.panels;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

import functionCode.elementi.ElementoInCoda;

import java.awt.*;
import java.util.ArrayList;

/**
 * Classe contenente la {@link JTable} che permette di mostrare tutti gli {@link ElementoInCoda}
 * 
 * @author Nicola Improta
 *
 */

@SuppressWarnings("serial")
public class PanelTable extends JPanel{

	/**
	 * Scrollbar per la {@link JTable}
	 */
	
	protected final JScrollPane scroll;
	
	/**
	 * {@link AbstractTableModel} per la {@link JTable}
	 */
	
	protected final ModelloTable modello;
	
	/**
	 * Definizione della {@link JTable}
	 */
	
	protected final JTable tabella;
	
	/**
	 * {@link ArrayList} contenente gli {@link ElementoInCoda} da mostrare nella tabella
	 */
	
	protected final ArrayList<ElementoInCoda> files;
	
	/**
	 * Metodo che permette la definizione di un {@link AbstractTableModel} per la {@link JTable}
	 */
	
	public class ModelloTable extends AbstractTableModel{

		/**
		 * Array contenente i nomi delle colonne della {@link JTable}
		 */
		
		String[] nomeColonna = {"Tipologia", "File", "Operazione"};

		/**
		 * Metodo che restituisce il numero delle righe della tabella
		 */
		
		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return files.size();
		}

		/**
		 * Metodo che restituisce il numero delle colonne della tabella
		 */
		
		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return nomeColonna.length;
		}

		/**
		 * Metodo che restituisce il valore delle celle della tabella
		 */
		
		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub

			ElementoInCoda file = files.get(rowIndex);
			
			switch(columnIndex) {
			case 0:
				return file.TipologiaOperazione();
			case 1:
				return file.NomeFileInCoda();
			case 2:
				return file.ModalitaOperazione();
			}
			return null;
		}
		
		/**
		 * Metodo che restituisce il nome di una colonna della tabella
		 */
		
		public String getColumnName(int colonna) {
			return nomeColonna[colonna];
		}
	
	}
	
	/**
	 * Costruttore della classe
	 * 
	 * @param files {@link ArrayList} contenente gli {@link ElementoInCoda} da mostrare nella tabella
	 */
	
	public PanelTable(ArrayList<ElementoInCoda> files) {
		
		super();
		
		this.files = files;
		
		this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		this.setBorder(BorderFactory.createEtchedBorder());
		
		modello = new ModelloTable();
		
		tabella = new JTable(modello);

		scroll = new JScrollPane(tabella);
				
		this.add(scroll, BorderLayout.CENTER);
		
	}
	
	/**
	 * Metodo che permette di effettuare un refresh sulla tabella
	 */
	
	public void AggiornaTabella() {
		modello.fireTableDataChanged();
		
	}
	
	/**
	 * Metodo che restituisce gli indici delle righe selezionate
	 */
	
	public int[] IndiceElemento() {
		return tabella.getSelectedRows();
	}
	
}
