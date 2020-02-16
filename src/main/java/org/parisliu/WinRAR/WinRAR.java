package org.parisliu.WinRAR;

import java.io.File;

public class WinRAR {
	File folder;
	public WinRAR(File folder) {
		this.folder = folder;
	}
	
	public RAROptions compress(File file) {
		RAROptions output = new RAROptions(this);
		output.setOutput(file);
		output.setSource(file);
		return output;
	}
	
	public boolean hasRAR() {
		return new File(folder.getAbsolutePath() + File.separator + "Rar.exe").exists();
	}
	
	public String getRAR() {
		String output = folder.getAbsolutePath() + File.separator;
		if(output.contains(" ")) {
			return "\"" + output + "Rar.exe\"";
		}
		else {
			return output + "Rar.exe";
		}
	}
	
	
}
