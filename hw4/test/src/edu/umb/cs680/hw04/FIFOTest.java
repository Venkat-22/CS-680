package edu.umb.cs680.hw04;

import java.io.IOException;
import java.nio.file.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;



public class FIFOTest {
	private static FIFOFileCache cache;
	private static Path B,C;
	
	@BeforeAll
	static void addFiles() throws Exception {
		cache = new FIFOFileCache(2);
		
		B = Paths.get("files/fileB.txt");
		C = Paths.get("files/fileC.txt");
	}

	@Test
	public void retrieveFileB() throws IOException {
		assertEquals(Files.readString(B), cache.fetch(B));
	}
	
	@Test
	public void retrieveFileC() throws IOException {
		
		assertEquals(Files.readString(C), cache.fetch(C));
	}
	
	

}
