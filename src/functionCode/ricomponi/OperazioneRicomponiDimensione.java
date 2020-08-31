package functionCode.ricomponi;

import java.io.*;

import functionCode.divisione.OperazioneDivisioneDimensione;

/**
 * Classe che permette di ricomporre un file specificando una delle parti generate 
 * mediante l'{@link OperazioneDivisioneDimensione}
 * 
 * @author Nicola Improta
 *
 */

public class OperazioneRicomponiDimensione extends OperazioneRicomponi{

	/**
	 * Metodo che permette di ricomporre un file che è stato diviso con l' {@link OperazioneDivisioneDimensione}
	 * 
	 * @param fileDaRicomporre File scelto dal utente e rappresentante una delle parti del file precedentemente diviso 
	 */
	
	@Override
	public void Esegui(File fileDaRicomporre) {
		// TODO Auto-generated method stub
		
		File[] partiDaRicomporre;
		
		FileOutputStream streamOutput;
		FileInputStream streamInput;
		
		File nomeFile = new File(fileDaRicomporre.getName().substring(0, fileDaRicomporre.getName().length()-10));
		
		
		int numeroByteLetti = 0;
		
		byte[] bytesFile;
		
		FilenameFilter filtroRicerca = new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				dir = new File(fileDaRicomporre.getAbsolutePath().replace(fileDaRicomporre.getName(), ""));
				return name.contains(nomeFile.getName().concat(".partDim"));
			}
		};
		
		partiDaRicomporre = new File(fileDaRicomporre.getAbsolutePath().replace(fileDaRicomporre.getName(), "")).listFiles(filtroRicerca);
		
		File risultato = new File(nomeFile.getName());
	
		try {
			streamOutput = new FileOutputStream(risultato, true);
			
			for(File el : partiDaRicomporre) {
				streamInput = new FileInputStream(el);
				bytesFile = new byte[(int) el.length()];
				numeroByteLetti = streamInput.read(bytesFile,0,(int)el.length());
				streamOutput.write(bytesFile);
				streamOutput.flush();
				streamInput.close();
				streamInput = null;
				bytesFile = null;
				el.delete();
			}
			
			streamOutput.close();
			streamOutput = null;
			
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
