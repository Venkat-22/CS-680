package edu.umb.cs680.hw04;
import java.io.IOException;
import java.nio.file.*;
import java.util.HashMap;


public class FIFOFileCache extends FileCache{
	private int size;
	
	public FIFOFileCache(int size) {
		this.size = size;
		cache = new HashMap<>();
	}

	protected boolean isCached(Path path) {
		if(cache.containsKey(path)) {
			return true;
		}else {
			return false;
		}
	}

	protected boolean isCacheFull() {
		int length=cache.size();
		if(length == size) {
			return true;
		}else {
			return false;
		}
	}

	protected void cacheFile(Path path) {
		try {
			String content = Files.readString(path);
			cache.put(path, content);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void replace(Path path) {
		try {
			String content = Files.readString(path);
			Path removeKey = cache.keySet().iterator().next();
			cache.remove(removeKey);
			cache.put(path, content);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}