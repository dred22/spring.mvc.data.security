package fr.treeptik.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import fr.treeptik.java.models.User;

public class ModelesTests {

	@Test
	public void testUser() {
		User user = new User();
		user.setUserName("test");
		user.setPassword("test");
		assertEquals(user.getUserName(), "test");
		assertEquals(user.getPassword(), "test");
		
	}

}
