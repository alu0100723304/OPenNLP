package aplicacion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase para leer ficheros.
 * @author Joel Perez Ramos
 */
public class LeerFichero {
	/**
	 * Atributos privados para leer Ficheros.
	 */
	private FileReader fichero;
	private BufferedReader lector;
	
	/**
	 * Constructor.
	 * @param fichero
	 */
	public LeerFichero(FileReader fichero) {
		super();
		this.fichero = fichero;
		this.lector = new BufferedReader(fichero);
	}
	
	/**
	 * Metodo que devuelve el fichero a leer.
	 * @return
	 */
	public FileReader getFichero() {
		return fichero;
	}
	
	/**
	 * Metodo que cambia el fichero a leer.
	 * @param fichero
	 */
	public void setFichero(FileReader fichero) {
		this.fichero = fichero;
	}
	
	/**
	 * Metodo que devuelve un BufferedReader.
	 * @return
	 */
	public BufferedReader getLector() {
		return lector;
	}
	
	/**
	 * Metodo que cambia el BufferedReader.
	 * @param lector
	 */
	public void setLector(BufferedReader lector) {
		this.lector = lector;
	}
	
	/**
	 * Metodo que muestra el contenido del fichero.
	 * @return
	 */
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
