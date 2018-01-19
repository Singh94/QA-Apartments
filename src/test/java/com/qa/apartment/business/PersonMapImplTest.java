package com.qa.apartment.business;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.apartment.persistance.Person;
import com.qa.apartment.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class PersonMapImplTest {

	private String testJsonStringA;
	private String testJsonStringB;
	private Person aPerson;
	private Person bPerson;

	@InjectMocks
	private PersonMapImpl impl;

	@Mock
	private JSONUtil util;

	@Before
	public void setUp() {

		impl.setUtil(util);

		testJsonStringA = "{\"first_name\": \"James\",\"last_name\": \"Herbert\",\"email\": \"test@test.com\", \"phone_number\": \"01234567891\"}";
		testJsonStringB = "{\"first_name\": \"Jenkins\",\"last_name\": \"Harlot\",\"email\": \"test2@test.com\", \"phone_number\": \"01234567891\"}";

		aPerson = new Person("James", "Herbert", "test@test.com", "01234567891");
		bPerson = new Person("Jenkins", "Harlot", "test2@test.com", "01234567891");
	}

/*	@Test
	public void testCreatePersonFromString() {

		Mockito.when(util.getObjectForJSON(testJsonStringA, Person.class)).thenReturn(aPerson);

		String returnedString = impl.createPersonFromString(testJsonStringA);
		Assert.assertEquals("{\"message\": \"person sucessfully added\"}", returnedString);

		Mockito.verify(util).getObjectForJSON(testJsonStringA, Person.class);
	}*/

//	@Test
//	public void testCreatePersonFromPerson() {
//		String returnedString = impl.createPersonFromPerson(aPerson);
//		Assert.assertEquals("{\"message\": \"person sucessfully added\"}", returnedString);
//	}
//
//	@Test
//	public void testUpdatePersonFromString() {
//		Mockito.when(util.getObjectForJSON(testJsonStringA, Person.class)).thenReturn(aPerson);
//		Mockito.when(util.getObjectForJSON(testJsonStringB, Person.class)).thenReturn(bPerson);
//
//		String returnedString = impl.createPersonFromString(testJsonStringA);
//		Assert.assertEquals("{\"message\": \"person sucessfully added\"}", returnedString);
//
//		returnedString = impl.updatePersonFromString(1L, testJsonStringB);
//		Assert.assertEquals("{\"message\": \"person sucessfully updated\"}", returnedString);
//
//		returnedString = impl.updatePersonFromString(5L, testJsonStringB);
//		Assert.assertEquals("{\"message\": \"person not updated see log\"}", returnedString);
//
//	}
//
//	@Test
//	public void testUpdatePersonFromPerson() {
//		String returnedString = impl.createPersonFromPerson(aPerson);
//		Assert.assertEquals("{\"message\": \"person sucessfully added\"}", returnedString);
//
//		returnedString = impl.updatePersonFromPerson(1L, bPerson);
//		Assert.assertEquals("{\"message\": \"person sucessfully updated\"}", returnedString);
//
//		returnedString = impl.updatePersonFromPerson(5L, bPerson);
//		Assert.assertEquals("{\"message\": \"person not updated see log\"}", returnedString);
//
//	}
//
//	@Test
//	public void testDeletePerson() {
//		Mockito.when(util.getObjectForJSON(testJsonStringA, Person.class)).thenReturn(aPerson);
//
//		impl.createPersonFromString(testJsonStringA);
//
//		String returnedString = impl.deletePerson(1L);
//		Assert.assertEquals("{\"message\": \"person sucessfully deleted\"}", returnedString);
//
//		Assert.assertNull(impl.findPerson(1L));
//	}
//
//	// @Test
//	// public void testFindAllPersons() {
//	// Mockito.when(util.getObjectForJSON(testJsonStringA,
//	// Person.class)).thenReturn(aPerson);
//	// Mockito.when(util.getObjectForJSON(testJsonStringB,
//	// Person.class)).thenReturn(bPerson);
//	//
//	// impl.createPersonFromString(testJsonStringA);
//	// System.out.println(impl.findAllPersons());
//	// System.out.println(impl.getMap());
//	//
//	// } THERE IS A BUG WITH getJSONForObject which returns null
//
//	@Test
//	public void testFindPerson() {
//		Mockito.when(util.getObjectForJSON(testJsonStringA, Person.class)).thenReturn(aPerson);
//
//		Assert.assertNull(impl.findPerson(1L));
//
//		impl.createPersonFromString(testJsonStringA);
//
//		Assert.assertEquals(impl.findPerson(1L), aPerson);
//
//	}

}
