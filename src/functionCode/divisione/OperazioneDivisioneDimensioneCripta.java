package functionCode.divisione;

import java.io.*;
import java.text.DecimalFormat;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

import java.security.*;

/**
 * Classe che permette di dividere un file in più parti specificando la dimensione di ogni parte
 * e criptando il contenuto di ogni parte
 * 
 * @author Nicola Improta
 *
 */

public class OperazioneDivisioneDimensioneCripta extends OperazioneDivisione{

	/**
	 * Metodo che permette di dividere il file in più parti specificata la dimensione
	 * e criptando il contenuto di ogni parte
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

		String password = "progetto";
		
		try {
			Key secret = new SecretKeySpec(password.getBytes(), "DES");
			Cipher chiper = Cipher.getInstance("DES");
			chiper.init(Cipher.ENCRYPT_MODE, secret);
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
				
				nomeNuovoFile = fileDaDividere.getName() + ".crypt" + (new DecimalFormat("00").format(numeroParti - 1));
				streamOutput = new FileOutputStream(new File("./esempi", nomeNuovoFile));
				
				byte[] byteCriptati = chiper.doFinal(bytesParte);
				
				
				streamOutput.write(byteCriptati);
				streamOutput.flush();
				streamOutput.close();
				
				bytesParte = null;
				streamOutput = null;
				byteCriptati = null;
			}
		
			streamInput.close();
			
			
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
		
	}

	

}
