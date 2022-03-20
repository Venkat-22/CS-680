
package edu.umb.cs680.hw02;

public class Singleton {
	public static Singleton instance_of_singleton=null;
	private Singleton() {}
	public static Singleton getInstance() {
		if(instance_of_singleton == null) {
			instance_of_singleton = new Singleton();
		}
		return instance_of_singleton;
	}
	public static void main(String args[]) {
		
	}

	}


