package Milestone2;

import Milestone2.Models.Contact;
import Milestone2.Models.PhonebookEntry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TestHarness {

	// Declarations
	
	private static Map<Contact, List<PhonebookEntry>> phonebook = new HashMap<>();
	private static List<Contact> contacts = new ArrayList<>();
	
	private static PhonebookHandlerImpl phonebookHander;

	// Util Methods

	public static void seperator() {

		System.out.println("--------------------------------------------------\n");

	}

	// "Tester"

	public static void main(String[] args) throws InterruptedException {

		// Building Contacts

		init();

		seperator();

		// Printing Built Contacts	

		System.out.println("Contacts in the phonebook: \n");

		for (Contact contact : contacts) {

			System.out.println(contact.toString()); // toString() is overridden in Contact class

		}

		seperator();

		// Equality Test

		TEST_Equals(contacts.get(0), contacts.get(1));
		TEST_Equals(contacts.get(2), contacts.get(2));

		seperator();

		// HashCode Test

		TEST_hashcode(contacts.get(0), contacts.get(1));
		TEST_hashcode(contacts.get(2), contacts.get(2));

		seperator();

		// Sort Test

		phonebookHander = new PhonebookHandlerImpl(phonebook);

		List<Contact> sortedContacts = TEST_Sort(phonebookHander);
		TEST_Display(sortedContacts);

		seperator();

		// Search Test

		TEST_Search(phonebookHander, sortedContacts, "Juan");

	}
	
	// Test Helper Methods
	
	public static List<Contact> TEST_Sort(PhonebookHandlerImpl phonebookHandler) {
		
		List<Contact> sortedContacts = phonebookHander.sortByName();
		return sortedContacts;

	}
	
	public static void TEST_Search(PhonebookHandlerImpl phonebookHandler, List<Contact> sortedContacts, String name) {
		  
		System.out.printf("Searching phone book for %s\n", name);
		List<PhonebookEntry> selectedEntries = phonebookHander.binarySearch(sortedContacts, name);
		
		for (PhonebookEntry entry : selectedEntries) {

			// indented just for formatting

			System.out.println("\tEntry for " + name + ": " + entry.getType() + " " + entry.getPhoneNumber());
		
		}
		
	}
	
	public static void TEST_Display(List<Contact> sortedContacts) {
		
		System.out.println("Sorted Contacts in the phonebook: \n");

		phonebookHander.display(sortedContacts);

		System.out.println();

	}

	public static void TEST_Equals(Contact r1, Contact r2) {

		System.out.printf("Comparing %s with %s\n", r1.toString(), r2.toString());

		System.out.printf("Result: %b\n\n", r1.equals(r2));

	}

	public static void TEST_hashcode(Contact r1, Contact r2) {

		System.out.printf("Hashing %s with %s\n", r1.toString(), r2.toString());

		if (r1.hashCode() == r2.hashCode()) {

			System.out.println("Hash matches - collision: " + r1.hashCode());

		} else {

			System.out.println("NO hash match: " + r1.hashCode() + " / " + r2.hashCode());

		}

		System.out.println();

	}

	/*
	 * Util method for generating fake phone numbers.
	 * Natrually, we didn't want to write out n phone numbers for n fake contacts, so this helps us procedurally generate them using just list of common names 
	*/
	public static String generateRandomNumberString(int length) {

		// funny way of doing it but it ensures length is always 10 digits long

		Random random = new Random();
		String stringNumber = "";

		for (int i = 0; i < length; i++) {

			int digit = random.nextInt(10); 
			stringNumber += digit; 

		}
		
		return stringNumber;

	}
 
	/**
	 * Builds the phonebook with fake contacts and phone numbers.
	 * @throws InterruptedException
	*/
	public static void init() throws InterruptedException {

		System.out.println("Building Contacts ....");
		TimeUnit.SECONDS.sleep(1);
		
		// len(commonNames) contacts will be created. (see the phone number generator function comments)

		String[] commonNames = { "John", "Jane", "Steve", "Sean", "Paul", "Jan", "Stan", "Juan", "Mun", "Ran" };

		for (String name : commonNames) {

			contacts.add(new Contact(name));

		}

		System.out.println("Building Phonebook Entries ....");
		TimeUnit.SECONDS.sleep(1);
		
		for (Contact contact : contacts) {

			// adds 3 random phone numbers to each contact

			contact.addPhonebookEntry(generateRandomNumberString(10), "Home");
			contact.addPhonebookEntry(generateRandomNumberString(10), "Cell");
			contact.addPhonebookEntry(generateRandomNumberString(10), "Work");

		}

		System.out.println("Adding Entries to the phonebook ....\n");
		TimeUnit.SECONDS.sleep(1);

		// puts the contact and associated phonebook entries into a map

		for (Contact contact : contacts) {

			phonebook.put(contact, contact.getPhonebookEntries());

		}

	}

}