package functionCode.ricomponi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import functionCode.divisione.OperazioneDivisioneDimensioneCripta;

/**
 * Classe che permette di ricomporre un file specificando una delle parti generate 
 * mediante l' {@link OperazioneDivisioneDimensioneCripta}
 * 
 * @author Nicola Improta
 *
 */

public class OperazioneRicomponiDimensioneDecripta extends OperazioneRicomponi{

	/**
	 * Metodo che permette di ricomporre un file che è stato diviso con l' {@link OperazioneDivisioneDimensioneCripta}
	 * 
	 * @param fileDaRicomporre File scelto dal utente e rappresentante una delle parti del file precedentemente diviso 
	 */
	
	@Override
	public void Esegui(File fileDaRicomporre) {
		// TODO Auto-generated method stub
		
		File[] partiDaRicomporre;
		
		FileOutputStream streamOutput;
		FileInputStream streamInput;
		
		File nomeFile = new File(fileDaRicomporre.getName().substring(0, fileDaRicomporre.getName().length()-8));
		
		@SuppressWarnings("unused")
		int numeroByteLetti = 0;
		
		byte[] bytesFile;
		
		String password = "progetto";
		Key secret = new SecretKeySpec(password.getBytes(), "DES");
		
		FilenameFilter filtroRicerca = new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				dir = new File(fileDaRicomporre.getAbsolutePath().replace(fileDaRicomporre.getName(), ""));
				return name.contains(nomeFile.getName().concat(".crypt"));
			}
		};
		
		partiDaRicomporre = new File(fileDaRicomporre.getAbsolutePath().replace(fileDaRicomporre.getName(), "")).listFiles(filtroRicerca);
		
		File risultato = new File(nomeFile.getName());
	
		try {
			streamOutput = new FileOutputStream(risultato, true);
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, secret);
			
			for(File el : partiDaRicomporre) {
				streamInput = new FileInputStream(el);
				bytesFile = new byte[(int) el.length()];
				numeroByteLetti = streamInput.read(bytesFile,0,(int)el.length());
				byte [] bytesDecript = cipher.doFinal(bytesFile);
				streamOutput.write(bytesDecript);
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
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
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
