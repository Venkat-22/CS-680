package edu.umb.cs680.hw09;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw09.apfs.ApfsDirectory;
import edu.umb.cs680.hw09.apfs.ApfsFile;
import edu.umb.cs680.hw09.apfs.ApfsLink;

public class ApfsDirectoryTest {
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
	private static ApfsLink l1;
	private static ApfsLink l2;
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		root = new ApfsDirectory(null, "root", 0, LocalDateTime.now(), "author", "initialTime");
		apps = new ApfsDirectory(root, "apps", 0, LocalDateTime.now(), "author", "initialTime");
		bin = new ApfsDirectory(root, "bin", 0, LocalDateTime.now(), "author", "initialTime");
		home = new ApfsDirectory(root, "home", 0, LocalDateTime.now(), "author", "initialTime");
		pictures = new ApfsDirectory(home, "pictures", 0, LocalDateTime.now(), "author", "initialTime");
		x = new ApfsFile(apps, "x", 10, LocalDateTime.now(), "author", "initialTime");
		y = new ApfsFile(bin, "y", 20, LocalDateTime.now(), "author", "initialTime");
		a = new ApfsFile(pictures, "a", 30, LocalDateTime.now(), "author", "initialTime");
		b = new ApfsFile(pictures, "b", 40, LocalDateTime.now(), "author", "initialTime");
		c = new ApfsFile(home, "c", 50, LocalDateTime.now(), "author", "initialTime");
		l1 = new ApfsLink(home, "l1", 0, LocalDateTime.now(), "author", "initialTime", bin);
		l2 = new ApfsLink(pictures, "l2", 0, LocalDateTime.now(), "author", "initialTime", y);
		root.appendChild(apps);
		root.appendChild(bin);
		root.appendChild(home);
		apps.appendChild(x);
		apps.appendChild(y);
		home.appendChild(pictures);
		home.appendChild(c);
		home.appendChild(l1);
		pictures.appendChild(a);
		pictures.appendChild(b);
		pictures.appendChild(l2);
	}

	private String[] dirToStringArray(ApfsDirectory d) {
		String[] dirInfo = { String.valueOf(d.isDirectory()), d.getOwnerName(), String.valueOf(d.getTotalSize()),
							d.getLastModifiedTime(), String.valueOf(d.countChildren()) };
		return dirInfo;
	}

	@Test
	public void verifyDirectoryEqualityRoot() {
		String[] expected = { "true", "author", "150", "initialTime", "3" };
		ApfsDirectory actual = root;
		assertArrayEquals(expected, dirToStringArray(actual));
	}
	
	
	
	
	@Test
	public void verifyGetSubDirectoriesForHome() {
		assertSame(pictures, home.getSubDirectories().get(0));
	}
	
	@Test
	public void verifyGetFilesForHome() {
		assertSame(c, home.getFiles().get(0));
	}

	@Test
	public void verifyGetLinksForHome() {
		assertSame(l1, home.getLinks().get(0));
	}
	
	@Test
	public void isDirectoyTestCaseRoot() {
		assertTrue(root.isDirectory());
	}

	@Test
	public void appendChildrenTestCaseHome() {
		assertSame(home, c.getParent());
	}
	
	@Test
	public void countChildrenTestCaseRoot() {
		assertEquals(3, root.countChildren());;
	}

}