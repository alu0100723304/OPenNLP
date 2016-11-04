package aplicacion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeerFichero {
	private FileReader fichero;
	private BufferedReader lector;
	
	public LeerFichero(FileReader fichero) {
		super();
		this.fichero = fichero;
		this.lector = new BufferedReader(fichero);
	}

	public FileReader getFichero() {
		return fichero;
	}

	public void setFichero(FileReader fichero) {
		this.fichero = fichero;
	}

	public BufferedReader getLector() {
		return lector;
	}

	public void setLector(BufferedReader lector) {
		this.lector = lector;
	}
	
	public String getContenido() {
		String contenido = "";
		String linea;
		
		try {
			while((linea = lector.readLine()) != null) 
				contenido += linea + "\n";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contenido;
	}
}
