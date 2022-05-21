package edu.umb.cs680.hw07;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class DirectoryTest {
	private static Directory root;
	private static Directory apps;
	private static Directory bin;
	private static Directory home;
	private static Directory pictures;
	private static File x;
	private static File y;
	private static File a;
	private static File b;
	private static File c;
	private static Link m;
	private static Link n;
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		root = new Directory(null, "root", 0, LocalDateTime.now());
		apps = new Directory(root, "apps", 0, LocalDateTime.now());
		bin = new Directory(root, "bin", 0, LocalDateTime.now());
		home = new Directory(root, "home", 0, LocalDateTime.now());
		pictures = new Directory(home, "pictures", 0, LocalDateTime.now());
		x = new File(apps, "x", 10, LocalDateTime.now());
		y = new File(bin, "y", 20, LocalDateTime.now());
		a = new File(pictures, "a", 30, LocalDateTime.now());
		b = new File(pictures, "b", 40, LocalDateTime.now());
		c = new File(home, "c", 50, LocalDateTime.now());
		m = new Link(home, "m", 0, LocalDateTime.now(), bin);
		n = new Link(pictures, "n", 0, LocalDateTime.now(), y);
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

	private String[] dirToStringArray(Directory d) {
		String[] dirInfo = { String.valueOf(d.isDirectory()), d.getName(), String.valueOf(d.getTotalSize()),
				String.valueOf(d.getCreationTime()), String.valueOf(d.countChildren()) };
		return dirInfo;
	}

	
	
	@Test
	public void isDirectoyRoot() {
		assertTrue(root.isDirectory());
	}
	
	@Test
	public void isFileRoot() {
		assertFalse(root.isFile());
	}
	
	@Test
	public void isLinkRoot() {
		assertFalse(root.isLink());
	}
	
	@Test
	public void appendChildrenRoot() {
		assertSame(root, apps.getParent());
	}
	
	@Test
	public void appendChildrenHome() {
		assertSame(home, c.getParent());
	}
	
	@Test
	public void countChildrenRoot() {
		assertEquals(3, root.countChildren());;
	}
	
	@Test
	public void countChildrenHome() {
		assertSame(3, home.countChildren());
	}
	
	
	@Test
	public void getSubDirectoriesHome() {
		assertSame(pictures, home.getSubDirectories().get(0));
	}
	
	



}