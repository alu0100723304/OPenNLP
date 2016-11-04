package aplicacion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeerDirectorio {
	private File folder_;

	public LeerDirectorio(File folder_) {
		super();
		this.folder_ = folder_;
	}

	public File getFolder_() {
		return folder_;
	}

	public void setFolder_(File folder_) {
		this.folder_ = folder_;
	}

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
