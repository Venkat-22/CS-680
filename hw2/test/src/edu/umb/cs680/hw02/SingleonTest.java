package edu.umb.cs680.hw02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SingleonTest {

	@Test
	public void getInstanceReturnNonNullValue() {
		assertNotNull(Singleton.getInstance());
	}
	
	@Test
	public void checkIdenticalInstance() {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		assertSame(s1, s2);
	}


}
