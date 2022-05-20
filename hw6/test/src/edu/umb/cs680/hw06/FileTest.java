package edu.umb.cs680.hw06;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FileTest {
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
	private String[] fileToStringArray(File f) {
		String[] fileInfo = { String.valueOf(f.isDirectory()), f.getName(), f.getParent().getName(), String.valueOf(f.getSize()),
				String.valueOf(f.getCreationTime()) };
		return fileInfo;
	}
	

    @Test
    public void verifyFileA() {
        String[] expected = {"false", "a", "pictures", "30", localTime.toString()};
        String[] actual = fileToStringArray(a);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyFileB() {
        String[] expected = {"false", "b", "pictures", "40", localTime.toString()};
        String[] actual = fileToStringArray(b);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyFileC() {
        String[] expected = {"false", "c", "home", "50", localTime.toString()};
        String[] actual = fileToStringArray(c);
        assertArrayEquals(expected, actual);
    }


}
