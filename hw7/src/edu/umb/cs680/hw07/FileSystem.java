package edu.umb.cs680.hw07;


import java.util.LinkedList;

public class FileSystem {
	static FileSystem instance=null;
	LinkedList<Directory> rootDir;
	private FileSystem() {
		rootDir=new LinkedList<>();
	}
	public static FileSystem getFileSystem() {
		if (instance == null) {
			instance = new FileSystem();
		}
		return instance;
	}
	public LinkedList<Directory> getRootDirs() {
		return rootDir;
	}
	public void appendRootDir(Directory root) {
		rootDir.add(root);
	}
}
