package functionCode.ricomponi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;


import functionCode.divisione.OperazioneDivisioneDimensioneComprimi;

/**
 * Classe che permette di ricomporre un file specificando una delle parti generate 
 * mediante l' {@link OperazioneDivisioneDimensioneComprimi}
 * 
 * @author Nicola Improta
 *
 */

public class OperazioneRicomponiDimensioneComprimi extends OperazioneRicomponi{

	/**
	 * Metodo che permette di leggere i file con estensione Zip e richiama i metodi per
	 * estrarre i file presenti negli archivi Zip
	 * 
	 * @param fileDaRicomporre File scelto dal utente e rappresentante una delle parti del file precedentemente diviso 
	 */
	
	@Override
	public void Esegui(File fileDaRicomporre) {
		// TODO Auto-generated method stub
	
		File[] partiDaRicomporre;
		byte[] bytesLetti = null;
		
		File nomeFileZip = new File(fileDaRicomporre.getName().substring(0, fileDaRicomporre.getName().length()-6));
		
		File path_file = fileDaRicomporre;
		
		ZipInputStream zipStreamInput = null;
		ZipEntry entry;
		
		FilenameFilter filtro = new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				dir = new File(fileDaRicomporre.getAbsolutePath().replace(fileDaRicomporre.getName(), ""));
				return name.contains(nomeFileZip.getName());
			}
		};

		
		try {
			
			partiDaRicomporre = new File(fileDaRicomporre.getAbsolutePath().replace(fileDaRicomporre.getName(), "")).listFiles(filtro);
			
			for(File el : partiDaRicomporre) {
			
				zipStreamInput = new ZipInputStream(new FileInputStream(el));
				
				entry = zipStreamInput.getNextEntry();
				
				File path = new File(el.getAbsolutePath().replace(el.getName(), ""));
				
				bytesLetti = new byte[(int)el.length()];
				
				while(entry != null) {
					
					File filenuovo = newFile(path, entry);
					
					FileOutputStream streamOut = new FileOutputStream(filenuovo);
					
					int letti;
					
					while((letti = zipStreamInput.read(bytesLetti)) > 0) {
						streamOut.write(bytesLetti, 0, letti);
					}
					streamOut.close();
					entry = zipStreamInput.getNextEntry();
				}
				zipStreamInput.closeEntry();
				zipStreamInput.close();
				el.delete();
			} 
		
		}
			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		File nomeParte = new File(nomeFileZip.getName());
		filtro = new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				dir = new File(path_file.getAbsolutePath().replace(path_file.getName(), ""));
				return name.contains(nomeParte.getName());
			}
		};
		
		partiDaRicomporre = new File(path_file.getAbsolutePath().replace(path_file.getName(), "")).listFiles(filtro);
		
		RicomponiUnzipFiles(partiDaRicomporre);
		
	}
	
	/**
	 * Metodo che permette di restituire i file estratti
	 * 
	 * @param destinazione Directory di destinazione
	 * @param zipEntry File letto dallo {@link ZipInputStream}
	 * @return destFile File che conterrà i bytes del file originale
	 * @throws IOException 
	 */
	
	public static File newFile(File destinazione, ZipEntry zipEntry) throws IOException {
        File destFile = new File(destinazione, zipEntry.getName());
        
        String destDirPath = destinazione.getAbsolutePath();
        String destFilePath = destFile.getAbsolutePath();
        
        if (!destFilePath.startsWith(destDirPath + File.separator)) {
            throw new IOException("Il file non è presente nella cartella: " + zipEntry.getName());
        }
        
        return destFile;
    }
	
	/**
	 * Metodo che permette di ricomporre i file rappresentanti le parti del file
	 * diviso precedentemente estratti dagli archivi Zip
	 * 
	 * @param partidaRicomporre Array di file contenente i file rappresentanti le parti del file da ricomporre
	 */
	
	public void RicomponiUnzipFiles(File[] partidaRicomporre) {
		
		
		FileOutputStream streamOutput;
		FileInputStream streamInput;
		
		File risultato = new File(partidaRicomporre[0].getName().substring(0, partidaRicomporre[0].getName().length()-10));
		
		byte[] bytesFile;
		
		
		try {
			streamOutput = new FileOutputStream(risultato, true);
			
			for(File el : partidaRicomporre) {
				
				streamInput = new FileInputStream(el);
				bytesFile = new byte[(int) el.length()];
				@SuppressWarnings("unused")
				int letti = streamInput.read(bytesFile, 0, (int)el.length());
				streamOutput.write(bytesFile);
				streamOutput.flush();
				streamInput.close();
				streamInput = null;
				bytesFile = null;
				el.delete();
				
			}
			
			streamOutput.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}