package functionCode.elementi;

import java.io.*;

import functionCode.divisione.OperazioneDivisione;

/**
 * Classe che permette di gestire gli {@link ElementoInCoda} su cui l'utente 
 * ha scelto di voler eseguire l' {@link OperazioneDivisione}
 * 
 * @author Nicola Improta
 *
 */

public class ElementiInCodaDividiOperazioni extends ElementoInCoda{

	/**
	 * Il file scelto dal utente sul quale si deve effettuare l'operazione di divisione in una o più parti
	 */
	
	private final File fileDaDividere;
	
	/**
	 * dividi Rappresenta la dimensione di ogni parte, scelta dal utente, oppure il numero di parti in cui dividere il file
	 * modalita Rappresenta la modalità di operazione che l'utente ha scelto di eseguire 
	 */
	
	private final int dividi, modalita;
	
	/**
	 * L' {@link OperazioneDivisione} scelta dal utente
	 */
	
	private final OperazioneDivisione op;
	
	/**
	 * Costruttore della classe
	 * 
	 * @param file Il file scelto dal utente sul quale si deve effettuare l'operazione di divisione
	 * @param op L' {@link OperazioneDivisione} scelta dal utente
	 * @param dividi La dimensione di ogni parte del file diviso oppure il numero di parti in cui l'utente vuole dividere il file
	 * @param modalita Intero che rappresenta quale modalità di operazione è stata scelta dal utente
	 */
	
	public ElementiInCodaDividiOperazioni(File file, OperazioneDivisione op, int dividi, int modalita) {
		super();
		this.fileDaDividere = file;
		this.dividi = dividi;
		this.op = op;
		this.modalita = modalita;
	}	
	
	/**
	 * Permette di restituire la stringa contenente la tipologia
	 * di operazione scelta dal utente
	 * 
	 * @see ElementoInCoda
	 * @return Stringa contenente l'operazione scelta dal utente, in questo caso "Divisione" 
	 */
	
	@Override
	public String TipologiaOperazione() {
		// TODO Auto-generated method stub
		return "Divisione";
	}

	/**
	 * Permette di restituire la stringa contenente il nome del file
	 * scelto dal utente
	 * 
	 * @see ElementoInCoda
	 * @return Stringa contente il nome del file scelto dal utente
	 */
	
	@Override
	public String NomeFileInCoda() {
		// TODO Auto-generated method stub
		return fileDaDividere.getName();
	}

	/**
	 * Permette di restituire la stringa contenente le informazioni
	 * sulla modalita dell'operazione scelta dal utente
	 * 
	 * @see ElementoInCoda
	 * @return Stringa contente la modalità di operazione di divisione scelta dal utente
	 */
	
	@Override
	public String ModalitaOperazione() {
		// TODO Auto-generated method stub
		
		switch (modalita) {
		
		case 1:
			return "Divisione in " + dividi + " parti";
			
		case 2:
			return "Divisione per dimensione " + "(" + dividi + "bytes)";
					
		case 3:
			return "Divisione per dimensione " + "(" + dividi + "bytes)" + "/Comprimi file";
		
		case 4:
			return "Divisione per dimensione " + "(" + dividi + "bytes)" + "/Contenuto criptato";
		
		}
		return null;
		
	}

	/**
	 * Permette di eseguire l'operazione scelta dal utente
	 * 
	 * @see ElementoInCoda
	 * @see OperazioneDivisione
	 */
	
	@Override
	public void Esegui() {
		// TODO Auto-generated method stub
		this.op.Esegui(fileDaDividere, dividi);
		
	}
	
}
