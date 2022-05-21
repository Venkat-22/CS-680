package edu.umb.cs680.hw07;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import edu.umb.cs680.hw07.FileSystem;


class FileSystemTest {

	@Test
	public void verifyFileSystemIdenticalInstance() {
		FileSystem f1 = FileSystem.getFileSystem();
		FileSystem f2 = FileSystem.getFileSystem();
		assertSame(f1, f2);
	}
	
}
