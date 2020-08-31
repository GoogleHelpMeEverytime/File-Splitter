package functionCode.divisione;

import java.io.*;
import java.text.DecimalFormat;

/**
 * Classe che permette di dividere un file in più parti specificando la dimensione di ogni parte
 * 
 * @author Nicola Improta
 *
 */

public class OperazioneDivisioneDimensione extends OperazioneDivisione{

	/**
	 * Metodo che permette di dividere il file in più parti specificata la dimensione
	 * 
	 * @param fileDaDividere File che l'utente vuole dividere in una o più parti
	 * @param dimensione Dimensione di ogni parte
	 */
	
	@Override
	public void Esegui(File fileDaDividere, int dimensione) {
		// TODO Auto-generated method stub
		File file = fileDaDividere;
		FileInputStream streamInput ;
		String nomeNuovoFile;
		FileOutputStream streamOutput;
		
		int dimensioneFile = (int) file.length();
		int numeroParti = 0;
		int leggi;
		int dimensioneLetta = dimensione;
		
		
		byte[] bytesParte;
		
		
		try {
			streamInput = new FileInputStream(file);
		
			while(dimensioneFile > 0) {
				
				if(dimensioneFile <= dimensione) {
					dimensioneLetta = dimensioneFile;
				}
				
				bytesParte = new byte[dimensioneLetta];
				
				leggi = streamInput.read(bytesParte, 0, dimensioneLetta);
				
				dimensioneFile -= leggi;
				
				
				assert(leggi == bytesParte.length);
				
				numeroParti++;
				
				nomeNuovoFile = fileDaDividere.getName() + ".partDim" + (new DecimalFormat("00").format(numeroParti - 1));
				streamOutput = new FileOutputStream(new File("./esempi", nomeNuovoFile));
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
