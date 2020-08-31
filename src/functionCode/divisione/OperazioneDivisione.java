package functionCode.divisione;

import java.io.File;

/**
 * Classe astratta che permette di definire il tipo OperazioneDivisione utilizzato
 * per rappresentare quale operazione di divisione l'utente ha scelto di effettuare
 * 
 * @author Nicola Improta
 *
 */

public abstract class OperazioneDivisione {

	/**
	 * Metodo che permette far partire la divisione del file scelto
	 * 
	 * @param fileDaDividere File che l'utente vuole dividere in una o più parti
	 * @param dim Dimensione di ogni parte oppure numero di parti scelte dal utente
	 */
	
	public abstract void Esegui(File fileDaDividere, int dim);
	
}
