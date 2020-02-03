package org.parisliu.WinRAR;

import java.io.File;
import java.io.IOException;

public class RAROptions { 
	private WinRAR rar;
	private File source = null;
	private File output = null;
	boolean recurses=true;
	boolean  deleteAfter = false;
	String comment = null;
	int m = 5;//compression ratio
	public RAROptions(WinRAR rar) {
		this.rar = rar;
	}

	public void run() throws IOException {
		Runtime.getRuntime().exec(rar.getRAR() + getOptions()); 
		System.out.print(rar.getRAR() + getOptions());
	}
	
	
	public boolean isDeleteAfter() {
		return deleteAfter;
	}

	public RAROptions setDeleteAfter(boolean deleteAfter) {
		this.deleteAfter = deleteAfter;
		return this;
	}

	public String getComment() {
		return comment;
	}

	public RAROptions setComment(String comment) {
		this.comment = comment;
		return this;
	}

	private String getOptions() {
		String options = " a";
		if(output!=null) {
			String name = output.getAbsolutePath();
			if(name.contains(" ")) {
				name = "\"" + name + "\"";
			}
			options+=" " + name;
		}
		else {
			return null;
		}
		if(recurses) {
			options += " -r";
		}
		if(deleteAfter) {
			options += " -df";
		}
		options += " -m" + m;
//		if(comment!=null) {
//			options+= " " + options;
//		}
		
		String name = source.getAbsolutePath();
		if(name.contains(" ")) {
			name = "\"" + name + "\"";
		}
		options+=" " + name;
		
		return options;
	}
	
	public File getSource() {
		return source;
	}



	public RAROptions setSource(File source) {
		this.source = source;
		return this;
	}



	public File getOutput() {
		return output;
	}



	public RAROptions setOutput(File output) {
		this.output = output;
		return this;
	}



	public RAROptions setRecursesSubfolders(boolean recurses) {
		this.recurses = recurses;
		return this;
	}

	public RAROptions setCompressionMethodStore() {
		m = 0;
		return this;
	}
	public RAROptions setCompressionMethodFastest() {
		m = 1;
		return this;
	}
	public RAROptions setCompressionMethodFast() {
		m = 2;
		return this;
	}
	public RAROptions setCompressionMethodNormal() {
		m = 3;
		return this;
	}
	public RAROptions setCompressionMethodGood() {
		m = 4;
		return this;
	}
	public RAROptions setCompressionMethodBest() {
		m = 5;
		return this;
	}
}
