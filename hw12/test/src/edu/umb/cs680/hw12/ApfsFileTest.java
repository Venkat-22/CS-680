package edu.umb.cs680.hw12;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw12.ApfsDirectory;
import edu.umb.cs680.hw12.ApfsFile;
import edu.umb.cs680.hw12.ApfsLink;


public class ApfsFileTest {
	private static ApfsDirectory root;
	private static ApfsDirectory apps;
	private static ApfsDirectory bin;
	private static ApfsDirectory home;
	private static ApfsDirectory pictures;
	private static ApfsFile x;
	private static ApfsFile y;
	private static ApfsFile a;
	private static ApfsFile b;
	private static ApfsFile c;
	private static ApfsLink m;
	private static ApfsLink n;
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		root = new ApfsDirectory(null, "root", 0, LocalDateTime.now(), "author", "defaultLastModifiedTime");
		apps = new ApfsDirectory(root, "apps", 0, LocalDateTime.now(), "author", "defaultLastModifiedTime");
		bin = new ApfsDirectory(root, "bin", 0, LocalDateTime.now(), "author", "defaultLastModifiedTime");
		home = new ApfsDirectory(root, "home", 0, LocalDateTime.now(), "author", "defaultLastModifiedTime");
		pictures = new ApfsDirectory(home, "pictures", 0, LocalDateTime.now(), "author", "defaultLastModifiedTime");
		x = new ApfsFile(apps, "x", 5, LocalDateTime.now(), "author", "defaultLastModifiedTime");
		y = new ApfsFile(bin, "y", 15, LocalDateTime.now(), "author", "defaultLastModifiedTime");
		a = new ApfsFile(pictures, "a", 25, LocalDateTime.now(), "author", "defaultLastModifiedTime");
		b = new ApfsFile(pictures, "b", 35, LocalDateTime.now(), "author", "defaultLastModifiedTime");
		c = new ApfsFile(home, "c", 45, LocalDateTime.now(), "author", "defaultLastModifiedTime");
		m = new ApfsLink(home, "m", 0, LocalDateTime.now(), "author", "defaultLastModifiedTime", bin);
		n = new ApfsLink(pictures, "n", 0, LocalDateTime.now(), "author", "defaultLastModifiedTime", y);
		root.appendChild(apps);
		root.appendChild(bin);
		root.appendChild(home);
		apps.appendChild(x);
		apps.appendChild(y);
		home.appendChild(pictures);
		home.appendChild(c);
		home.appendChild(m);
		pictures.appendChild(a);
		pictures.appendChild(b);
		pictures.appendChild(n);
	}
	
	private String[] fileToStringArray(ApfsFile f) {
		String[] fileInfo = { String.valueOf(f.isFile()), f.getOwnerName(), String.valueOf(f.getSize()),
							f.getLastModifiedTime(), f.getParent().getName() };
		return fileInfo;
	}

	@Test
	public void verifyFileX() {
		String[] expected = { "true", "author", "5", "defaultLastModifiedTime", "apps" };
		ApfsFile actual = x;
		assertArrayEquals(expected, fileToStringArray(actual));
	}
	
	@Test
	public void verifyFileA() {
		String[] expected = { "true", "author", "25", "defaultLastModifiedTime", "pictures" };
		ApfsFile actual = a;
		assertArrayEquals(expected, fileToStringArray(actual));
	}

	@Test
	public void isDirectoyTestingWithA() {
		assertFalse(a.isDirectory());
	}
	
	@Test
	public void isFileTestingWithA() {
		assertTrue(a.isFile());
	}
	
	@Test
	public void isLinkTestingWithA() {
		assertFalse(a.isLink());
	}

}
