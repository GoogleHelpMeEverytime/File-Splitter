package functionCode.divisione;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;

/**
 * Classe che permette di dividere un file in più parti specificando il numero di parti
 * 
 * @author Nicola Improta
 *
 */

public class OperazioneDivisioneNumeroParti extends OperazioneDivisione{

	/**
	 * Metodo che permette di dividere il file in più parti specificata il numero di parti
	 * 
	 * @param fileDaDividere File che l'utente vuole dividere in una o più parti
	 * @param numeroParti Numero di parti
	 */
	
	@Override
	public void Esegui(File fileDaDividere, int numeroParti) {
		// TODO Auto-generated method stub
		File file = fileDaDividere;
		FileInputStream streamInput;
		String nomeNuovoFile;
		FileOutputStream streamOutput;
		
		//dimensione di ogni parte
		int dimensioneParte = (int) file.length() / numeroParti + 1;
		
		
		byte[] bytesParte;
		
		@SuppressWarnings("unused")
		int leggi;
		
		try {
			streamInput = new FileInputStream(file);
			
			for(int i = 0; i < numeroParti; i++) {
				
				bytesParte = new byte[dimensioneParte];
				
				leggi = streamInput.read(bytesParte, 0, dimensioneParte);
				
				
				nomeNuovoFile = fileDaDividere.getName() + ".part" + (new DecimalFormat("00").format(i));
				streamOutput = new FileOutputStream(new File(".", nomeNuovoFile));
				streamOutput.write(bytesParte);
				streamOutput.flush();
				streamOutput.close();
				
				bytesParte = null;
				streamOutput = null;
			}
		streamInput.close();
			
		} 
		
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
