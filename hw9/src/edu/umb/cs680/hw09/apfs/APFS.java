package edu.umb.cs680.hw09.apfs;

import java.time.LocalDateTime;

import edu.umb.cs680.hw09.fs.FSElement;
import edu.umb.cs680.hw09.fs.FileSystem;

public class APFS extends FileSystem{
	private static APFS instance = null;

	private APFS(String name, int capacity) {
		this.name = name;
		this.capacity = capacity;
	}

	public static APFS getApfs() {
		if (instance == null) {
			instance = new APFS("APFS_Root", 1200);
		}
		return instance;
	}
	
	protected FSElement createDefaultRoot() {
		return new ApfsDirectory(null, "root", 300, LocalDateTime.now(), "aditya", "creationtime");
	}
	
	public ApfsDirectory getRootDir() {
		return (ApfsDirectory)this.getRootDirs().get(0);
	}

}