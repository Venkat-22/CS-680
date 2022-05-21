package edu.umb.cs680.hw09;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw09.apfs.ApfsDirectory;
import edu.umb.cs680.hw09.apfs.ApfsFile;
import edu.umb.cs680.hw09.apfs.ApfsLink;

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
		m = new ApfsLink(home, "m", 0, LocalDateTime.now(), "author", "initialTime", bin);
		n = new ApfsLink(pictures, "n", 0, LocalDateTime.now(), "author", "initialTime", y);
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
	public void verifyLinkEqualsM() {
		String[] expected = { "true", "author", "0", "initialTime", "home", "bin" };
		ApfsLink actual = m;
		assertArrayEquals(expected, linkToStringArray(actual));
	}
	

	@Test
	public void verifyifNisDirectory() {
		assertFalse(n.isDirectory());
	}
	
	@Test
	public void verifyifNisFile() {
		assertFalse(n.isFile());
	}
	
	@Test
	public void verifyifNisLink() {
		assertTrue(n.isLink());
	}
	
	@Test //
	public void getTargetTestingWithM() {
		assertSame(bin, m.getTarget());
	}
	
	@Test //
	public void setTargetTestingWithM() {
		m.setTarget(apps);
		assertSame(apps, m.getTarget());
	}

}