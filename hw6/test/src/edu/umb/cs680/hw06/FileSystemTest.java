package edu.umb.cs680.hw06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FileSystemTest {


	@Test
	public void getFileSystemVerifyIdenticalInstance() {
		FileSystem f1 = FileSystem.getFileSystem();
		FileSystem f2 = FileSystem.getFileSystem();
		assertSame(f1, f2);
	}
	

}
