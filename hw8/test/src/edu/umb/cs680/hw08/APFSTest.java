package edu.umb.cs680.hw08;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class APFSTest {


	@Test
	public void verifyFileSystemInstance() {
		APFS a1 = APFS.getApfs();
		APFS a2 = APFS.getApfs();
		assertSame(a1, a2);
	}
	
	@Test
	public void verifyRootDirectoryInitMethod() {
		APFS apfs = APFS.getApfs();
		FSElement expected = apfs.init("apfs", 15000);
		ApfsDirectory actual = apfs.getRootDir();
		assertSame(expected, actual);
	}



}
