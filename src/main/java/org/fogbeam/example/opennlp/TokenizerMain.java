
package org.fogbeam.example.opennlp;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import aplicacion.LeerDirectorio;
import aplicacion.LeerFichero;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;


public class TokenizerMain
{
	public static void main( String[] args ) throws Exception
	{
		
		LeerDirectorio LD = new LeerDirectorio();
		System.out.println(LD.getsize());
//		String sDirectorio = "Archtxt";
//		File f = new File(sDirectorio);
//		
//		if (f.exists()){
//			File[] ficheros = f.listFiles();
//			for(int i = 0; i < ficheros.length; i++){
//				System.out.println(ficheros[i].getName());
//			}
//		}
//		
//		else
//			System.out.println("Error");
		
		FileReader F = new FileReader("Archtxt/Texto01.txt");
		LeerFichero LF = new LeerFichero(F);
		
		
		
		// the provided model
		// InputStream modelIn = new FileInputStream( "models/en-token.bin" );
		
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
