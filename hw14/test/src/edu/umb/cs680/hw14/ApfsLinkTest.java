package edu.umb.cs680.hw14;



import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ApfsLinkTest {
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
	
	private String[] linkToStringArray(ApfsLink l) {
		String[] linkInfo = { String.valueOf(l.isLink()), l.getOwnerName(), String.valueOf(l.getSize()),
						l.getLastModifiedTime(), l.getParent().getName(), l.getTarget().getName() };
		return linkInfo;
	}

	@Test
	public void verifyLinkM() {
		String[] expected = { "true", "author", "0", "defaultLastModifiedTime", "home", "bin" };
		ApfsLink actual = m;
		assertArrayEquals(expected, linkToStringArray(actual));
	}
	

	@Test
	public void isDirectoyTestingN() {
		assertFalse(n.isDirectory());
	}
	
	@Test
	public void isFileTestingWithN() {
		assertFalse(n.isFile());
	}
	
	@Test
	public void isLinkTestingWithN() {
		assertTrue(n.isLink());
	}

}
