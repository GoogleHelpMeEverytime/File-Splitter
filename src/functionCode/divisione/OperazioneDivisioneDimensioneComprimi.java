package functionCode.divisione;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Classe che permette di dividere un file in più parti specificando la dimensione di ogni parte
 * e comprimendo il contenuto di ogni parte
 * 
 * @author Nicola Improta
 *
 */

public class OperazioneDivisioneDimensioneComprimi extends OperazioneDivisione{

	/**
	 * Metodo che permette di comprimere il contenuto di ogni parte 
	 * 
	 * @param fileDaDividere File che l'utente vuole dividere in una o più parti
	 * @param dimensione Dimensione di ogni parte
	 */
	
	@Override
	public void Esegui(File fileDaDividere, int dimensione) {
		// TODO Auto-generated method stub

		FileInputStream streamInput = null;
		FileOutputStream streamOutput = null;
		ZipOutputStream zipStream = null;
		byte[] bytesParte;
		
		int letti;
		ZipEntry entry;
		File f = new File(".");


		//Divisione in più parti data la dimensione
		DividiFileDimensione(fileDaDividere, dimensione);

		File[] partiFile;
		FilenameFilter filtro = new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				dir = new File(".");
				return name.contains(fileDaDividere.getName().concat(".partZip"));
			}
		};

		partiFile = f.listFiles(filtro);


		for (File el : partiFile) {
			try {

				streamOutput = new FileOutputStream( "." + el.getName() + ".zip");
				zipStream = new ZipOutputStream(streamOutput);
				streamInput = new FileInputStream(el);
				entry = new ZipEntry(el.getName());
				zipStream.putNextEntry(entry);
				bytesParte = new byte[(int)el.length()];

				while((letti = streamInput.read(bytesParte)) >= 0){
					zipStream.write(bytesParte, 0, letti);
				}

				streamInput.close();
				zipStream.close();
				streamOutput.close();
				el.delete();
			}


			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}
		
	}
	
	/**
	 * Metodo che permette di dividere il file in più parti specificata la dimensione
	 * 
	 * @param fileDaDividere File che l'utente vuole dividere in una o più parti
	 * @param dimensione Dimensione di ogni parte
	 */
	
	public void DividiFileDimensione(File fileDaDividere, int dimensione) {
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

				nomeNuovoFile = fileDaDividere.getName() + ".partZip" + (new DecimalFormat("00").format(numeroParti - 1));
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
