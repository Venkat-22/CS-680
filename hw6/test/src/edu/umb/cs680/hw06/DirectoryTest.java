package edu.umb.cs680.hw06;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;


import java.time.LocalDateTime;
import java.util.LinkedList;


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
	static LocalDateTime localTime = LocalDateTime.now();
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		root = new Directory(null, "root", 0, localTime);
		apps = new Directory(root, "apps", 0, localTime);
		bin = new Directory(root, "bin", 0, localTime);
		home = new Directory(root, "home", 0,localTime);
		pictures = new Directory(home, "pictures", 0, localTime);
		x = new File(apps, "x", 10, localTime);
		y = new File(bin, "y", 20,localTime);
		a = new File(pictures, "a", 30, localTime);
		b = new File(pictures, "b", 40, localTime);
		c = new File(home, "c", 50, localTime);
		root.appendChild(apps);
		root.appendChild(bin);
		root.appendChild(home);
		apps.appendChild(x);
		apps.appendChild(y);
		home.appendChild(pictures);
		home.appendChild(c);
		pictures.appendChild(a);
		pictures.appendChild(b);
	}
	private String[] dirToStringArray(Directory d) {
		String[] dirInfo = { String.valueOf(d.isDirectory()), d.getName(), String.valueOf(d.getTotalSize()),
				String.valueOf(d.getCreationTime()), String.valueOf(d.countChildren()) };
		return dirInfo;
	}
	
	@Test
	public void verifyDirectoryEqualityRoot(){
		String[] expected = { "true", "root", "150", localTime.toString(), "3" };
		Directory actual = root;
		assertArrayEquals(expected, dirToStringArray(actual));
	}
	@Test
	public void verifyDirectoryEqualityHome (){ 
		String[] expected = { "true", "home", "120",  localTime.toString(), "2" };
		Directory actual = home;
		assertArrayEquals(expected, dirToStringArray(actual));
	}
	
	 @Test
	    public void verifyFiles() {
	        assertTrue(x.isFile());
	        assertTrue(y.isFile());
	        assertTrue(a.isFile());
	        assertTrue(b.isFile());
	        assertTrue(c.isFile());
	    }
	 @Test
	    public void verifyGetSubDirectories() {
	        assertEquals(apps, root.getSubDirectories().get(0));
	        assertEquals(bin, root.getSubDirectories().get(1));
	        assertEquals(home, root.getSubDirectories().get(2));
	        assertEquals(pictures, home.getSubDirectories().get(0));
	    }

	   
	  
	    @Test
		public void getTotalSizeRoot() {
			assertEquals(150, root.getTotalSize());
		}
	    @Test
		public void countChildrenRoot() {
			assertEquals(3, root.countChildren());;
		}
	    @Test
		public void appendChildrenRoot() {
			assertSame(root, apps.getParent());
		}
	    @Test
	    public void verifyGetChildreRoot() {
	        LinkedList<FSElement> expected = new LinkedList<>();
	        expected.add(apps);
	        expected.add(bin);
	        expected.add(home);
	        assertEquals(expected, root.getChildren());
	    }
}
	


