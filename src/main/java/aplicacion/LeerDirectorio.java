package aplicacion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Clase para leer Directorios.
 * @author Joel Perez Ramos
 */
public class LeerDirectorio {
	/**
	 * Atributo privado: Tipo File.
	 */
	private File folder_;

	/**
	 * Constructor.
	 * @param folder_
	 */
	public LeerDirectorio(File folder_) {
		super();
		this.folder_ = folder_;
	}
	
	/**
	 * Metodo que devuelve el directorio a leer
	 * @return
	 */
	public File getFolder_() {
		return folder_;
	}

	/**
	 * Metodo que cambia el directorio a leer.
	 * @param folder_
	 */
	public void setFolder_(File folder_) {
		this.folder_ = folder_;
	}

	/**
	 * Metodo que una vez listado el contenido del directorio
	 * muestra el contenido uno por uno.
	 * @param folder
	 */
	public void listFilesForFolder(final File folder) {
		for (final File fileEntry : folder.listFiles()) {
			System.out.println(fileEntry.getName());
			try {
				Scanner s = new Scanner(fileEntry);
				System.out.println(s.nextLine());
				s.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
