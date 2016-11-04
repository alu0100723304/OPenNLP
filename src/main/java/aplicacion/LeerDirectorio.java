package aplicacion;

import java.io.File;

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
			if (fileEntry.isDirectory()) {
				listFilesForFolder(fileEntry);
			}
			else
				System.out.println(fileEntry.getName());
		}
	}
}
