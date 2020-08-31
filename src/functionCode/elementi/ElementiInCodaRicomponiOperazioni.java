package functionCode.elementi;

import java.io.*;

import functionCode.ricomponi.OperazioneRicomponi;

/**
 * Classe che permette di gestire gli {@link ElementoInCoda} su cui l'utente 
 * ha scelto di voler eseguire l' {@link OperazioneRicomponi}
 * 
 * @author Nicola Improta
 *
 */

public class ElementiInCodaRicomponiOperazioni extends ElementoInCoda{

	/**
	 * Il file scelto dal utente sul quale si deve effettuare l'operazione di ricomposizione
	 */
	
	private final File fileRicomponi;
	
	/**
	 * L' {@link OperazioneRicomponi} scelta dal utente
	 */
	
	private final OperazioneRicomponi op;
	
	/**
	 * Costruttore della classe 
	 * 
	 * @param file Il file scelto dal utente sul quale si deve effettuare l'operazione di ricomposizione
	 * @param op L' {@link OperazioneRicomponi} scelta dal utente
	 */
	
	public ElementiInCodaRicomponiOperazioni(File file, OperazioneRicomponi op) {
		super();
		this.fileRicomponi = file;
		this.op = op;
	}

	/**
	 * Permette di restituire la stringa contenente la tipologia
	 * di operazione scelta dal utente
	 * 
	 * @see ElementoInCoda
	 * @return Stringa contenente l'operazione scelta dal utente, in questo caso "Ricomponi" 
	 */
	
	@Override
	public String TipologiaOperazione() {
		// TODO Auto-generated method stub
		return "Ricomponi";
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
		return fileRicomponi.toString();
	}

	/**
	 * Permette di restituire la stringa contenente le informazioni
	 * sulla modalita dell'operazione scelta dal utente
	 * 
	 * @see ElementoInCoda
	 * @return Stringa contente la modalità di operazione scelta dal utente, in questo caso "Ricomposizione del file" 
	 */
	
	@Override
	public String ModalitaOperazione() {
		// TODO Auto-generated method stub
		return "Ricomposizione del file";
	}

	/**
	 * Permette di eseguire l'operazione scelta dal utente
	 * 
	 * @see ElementoInCoda
	 * @see OperazioneRicomponi
	 */
	
	@Override
	public void Esegui() {
		// TODO Auto-generated method stub
		this.op.Esegui(fileRicomponi);
	}
	
}
