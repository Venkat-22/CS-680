package edu.umb.cs680.hw09;

import static org.junit.Assert.assertArrayEquals;

import java.time.LocalDateTime;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw09.apfs.ApfsDirectory;
import edu.umb.cs680.hw09.apfs.ApfsFile;
import edu.umb.cs680.hw09.apfs.ApfsLink;
import edu.umb.cs680.hw09.apfs.util.ApfsFileCrawlingVisitor;

public class ApfsFileCrawlingVisitorTest {
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

	@Test
	public void verifyFilesRoot() {
		ApfsFileCrawlingVisitor visitor = new ApfsFileCrawlingVisitor();
		root.accept(visitor);
		LinkedList<ApfsFile> actual = visitor.getFiles();
		LinkedList<ApfsFile> expected = new LinkedList<>();
		expected.add(x);
		expected.add(y);
		expected.add(a);
		expected.add(b);
		expected.add(c);
		assertArrayEquals(expected.toArray(), actual.toArray());
	}

}