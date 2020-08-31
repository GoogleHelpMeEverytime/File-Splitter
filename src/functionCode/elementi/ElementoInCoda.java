package functionCode.elementi;

/**
 * Classe astratta che permette di definire il tipo ElementoInCoda utilizzato
 * per rappresentare i file sui quali dovranno essere effettuate le operazioni 
 * richieste dal utente. Inoltre, tale classe definisce delle operazioni(metodi) che si possono
 * richiamare su oggetti di tipo ElementoInCoda
 * 
 * @author Nicola Improta
 *
 */

public abstract class ElementoInCoda {
	
	/**
	 * Il metodo TipologiaOperazione permette di restituire la stringa contenente la tipologia
	 * di operazione scelta dal utente
	 * @return Stringa contenente l'operazione scelta dal utente
	 */
	
	public abstract String TipologiaOperazione();
	
	/**
	 * Il metodo NomeFileInCoda permette di restituire la stringa contenente il nome del file
	 * scelto dal utente
	 * @return Stringa contente il nome del file scelto dal utente
	 */
	
	public abstract String NomeFileInCoda();
	
	/**
	 * Il metodo ModalitaOperazione permette di restituire la stringa contenente le informazioni
	 * sulla modalita dell'operazione scelta dal utente
	 * @return Stringa contente la modalità di operazione di divisione scelta dal utente
	 */
	
	public abstract String ModalitaOperazione();

	/**
	 * Il metodo Esegui permette di eseguire l'operazione scelta dal utente
	 */
	
	public abstract void Esegui();

	
}
