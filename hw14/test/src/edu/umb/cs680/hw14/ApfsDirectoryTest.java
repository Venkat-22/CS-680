package edu.umb.cs680.hw14;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


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

	private String[] dirToStringArray(ApfsDirectory d) {
		String[] dirInfo = { String.valueOf(d.isDirectory()), d.getOwnerName(), String.valueOf(d.getTotalSize()),
							d.getLastModifiedTime(), String.valueOf(d.countChildren()) };
		return dirInfo;
	}

	@Test
	public void verifyDirectoryEqualityRoot() {
		String[] expected = { "true", "author", "125", "defaultLastModifiedTime", "3" };
		ApfsDirectory actual = root;
		assertArrayEquals(expected, dirToStringArray(actual));
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
	public void countChildrenRoot() {
		assertEquals(3, root.countChildren());;
	}
	
	
	
	@Test
	public void verifyGetChildrenOfHome() {
		ApfsFSElement[] expected = new ApfsFSElement[3];
		expected[0] = c;
		expected[1] = m;
		expected[2] = pictures;
		ApfsFSElement[] actual = new ApfsFSElement[3];
		LinkedList<ApfsFSElement> children = home.getChildren();
		actual[0] = children.get(0);
		actual[1] = children.get(1);
		actual[2] = children.get(2);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void verifyGetChildrenOfHomeBasedReverseAlphabetical() {
		ApfsFSElement[] expected = new ApfsFSElement[3];
		expected[0] = pictures;
		expected[1] = m;
		expected[2] = c;
		ApfsFSElement[] actual = new ApfsFSElement[3];
		LinkedList<ApfsFSElement> children = home.getChildren(Comparator.comparing(e -> e.getName(), Comparator.reverseOrder()));
		actual[0] = children.get(0);
		actual[1] = children.get(1);
		actual[2] = children.get(2);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void verifyGetChildrenOfHomeBasedElementKind() {
		ApfsFSElement[] expected = new ApfsFSElement[3];
		expected[0] = pictures;
		expected[1] = c;
		expected[2] = m;
		ApfsFSElement[] actual = new ApfsFSElement[3];
		LinkedList<ApfsFSElement> children = home.getChildren(Comparator.comparing(e -> e.elementKindToInt()));
		actual[0] = children.get(0);
		actual[1] = children.get(1);
		actual[2] = children.get(2);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void verifyGetSubDirectoriesOfRoot() {
		ApfsDirectory[] expected = new ApfsDirectory[3];
		expected[0] = apps;
		expected[1] = bin;
		expected[2] = home;
		ApfsDirectory[] actual = new ApfsDirectory[3];
		LinkedList<ApfsDirectory> subDirectories = root.getSubDirectories();
		actual[0] = subDirectories.get(0);
		actual[1] = subDirectories.get(1);
		actual[2] = subDirectories.get(2);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void verifyGetSubDirectoriesOfRootBasedReverseAlphabetical() {
		ApfsDirectory[] expected = new ApfsDirectory[3];
		expected[0] = home;
		expected[1] = bin;
		expected[2] = apps;
		ApfsDirectory[] actual = new ApfsDirectory[3];
		LinkedList<ApfsDirectory> subDirectories = root.getSubDirectories(Comparator.comparing(e -> e.getName(), Comparator.reverseOrder()));
		actual[0] = subDirectories.get(0);
		actual[1] = subDirectories.get(1);
		actual[2] = subDirectories.get(2);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void verifyGetSubDirectoriesOfRootBasedElementKind() {
		ApfsDirectory[] expected = new ApfsDirectory[3];
		expected[0] = apps;
		expected[1] = bin;
		expected[2] = home;
		ApfsDirectory[] actual = new ApfsDirectory[3];
		LinkedList<ApfsDirectory> subDirectories = root.getSubDirectories(Comparator.comparing(e -> e.elementKindToInt()));
		actual[0] = subDirectories.get(0);
		actual[1] = subDirectories.get(1);
		actual[2] = subDirectories.get(2);
		assertArrayEquals(expected, actual);
	}
	
	
	@Test
	public void verifyGetFilesOfPictures() {
		ApfsFile[] expected = new ApfsFile[2];
		expected[0] = a;
		expected[1] = b;
		ApfsFile[] actual = new ApfsFile[2];
		LinkedList<ApfsFile> files = pictures.getFiles();
		actual[0] = files.get(0);
		actual[1] = files.get(1);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void verifyGetFilesOfPicturesBasedReverseAlphabetical() {
		ApfsFile[] expected = new ApfsFile[2];
		expected[0] = b;
		expected[1] = a;
		ApfsFile[] actual = new ApfsFile[2];
		LinkedList<ApfsFile> files = pictures.getFiles(Comparator.comparing(e -> e.getName(), Comparator.reverseOrder()));
		actual[0] = files.get(0);
		actual[1] = files.get(1);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void verifyGetFilesOfPicturesBasedElementKind() {
		ApfsFile[] expected = new ApfsFile[2];
		expected[0] = a;
		expected[1] = b;
		ApfsFile[] actual = new ApfsFile[2];
		LinkedList<ApfsFile> files = pictures.getFiles(Comparator.comparing(e -> e.elementKindToInt()));
		actual[0] = files.get(0);
		actual[1] = files.get(1);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void verifyGetLinksTestingHome() {
		assertSame(m, home.getLinks().get(0));
	}
	
	@Test
	public void verifyGetTotalSizeTestingRoot() {
		assertEquals(125, root.getTotalSize());
	}
	

}
