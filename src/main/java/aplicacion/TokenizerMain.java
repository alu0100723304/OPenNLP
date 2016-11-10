
package aplicacion;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

/**
 * Cuerpo Principal.
 * @author Joel Pérez Ramos
 *
 */
public class TokenizerMain
{
	public static void main( String[] args ) throws Exception
	{
		
		// the provided model
		// InputStream modelIn = new FileInputStream( "models/en-token.bin" );
		
		FileReader F = new FileReader("Archtxt/Texto01.txt");
		LeerFichero LF = new LeerFichero(F);
		
		final File folder = new File("Archtxt");
		LeerDirectorio LD = new LeerDirectorio(folder);
		LD.listFilesForFolder(folder);
		
		// the model we trained
		InputStream modelIn = new FileInputStream( "models/en-token.model" );
		
		try
		{
			TokenizerModel model = new TokenizerModel( modelIn );
		
			Tokenizer tokenizer = new TokenizerME(model);
			
				/* note what happens with the "three depending on which model you use */
			String[] tokens = tokenizer.tokenize(LF.getContenido());
			
			for( String token : tokens )
			{
				System.out.println( token );
			}
			
		}
		catch( IOException e )
		{
			e.printStackTrace();
		}
		finally
		{
			if( modelIn != null )
			{
				try
				{
					modelIn.close();
				}
				catch( IOException e )
				{
				}
			}
		}
		System.out.println( "\n-----\ndone" );
	}
}
