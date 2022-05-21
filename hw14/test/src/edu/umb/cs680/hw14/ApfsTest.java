package edu.umb.cs680.hw14;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class ApfsTest {

	@Test
	public void verifyFileSystemIdenticalInstance() {
		APFS a1 = APFS.getApfs();
		APFS a2 = APFS.getApfs();
		assertSame(a1, a2);
	}
	
	@Test
	public void initMethodAndGetRootDirTesting() {
		APFS apfs = APFS.getApfs();
		FSElement expected = apfs.init("apfs", 1000);
		ApfsDirectory actual = apfs.getRootDir();
		assertSame(expected, actual);
	}
}
