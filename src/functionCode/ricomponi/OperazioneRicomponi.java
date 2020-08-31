package functionCode.ricomponi;

import java.io.*;

/**
 * Classe astratta che permette di definire il tipo OperazioneRicomponi utilizzato
 * per rappresentare quale operazione di ricomposizione l'utente ha scelto di effettuare
 * 
 * @author Nicola Improta
 *
 */

public abstract class OperazioneRicomponi {

	/**
	 * Metodo che permette di far partire l'operazione di ricomposizione del file scelto
	 * 
	 * @param fileDaRicomporre File rappresentante una parte del file che vuole ricomporre
	 */
	
	public abstract void Esegui(File fileDaRicomporre);
	
	
}
