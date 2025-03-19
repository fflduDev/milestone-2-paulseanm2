package Milestone2;

import Milestone2.Models.Contact;
import Milestone2.Models.PhonebookEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class TestHarness {

	// Contact overrides hashcode && equals.  Observe collision here.
	
	private static Map<Contact, List<PhonebookEntry>> phonebook = new HashMap<>();
	private static List <Contact> contacts = new ArrayList<>();
	private static PhonebookHandlerImpl phonebookHander;


	public static void main(String[] args) throws InterruptedException {
		
		init();

		// initially print list of contacts	

		System.out.println("Contacts in the phonebook: \n");

		// //display non equality using your overriden equals method
		// //display equality using your overriden equals method

		TEST_Equals(contacts.get(0), contacts.get(1));
		TEST_Equals(contacts.get(2), contacts.get(2));
		
		// //display hashcode case that demonstrates collision
		// //display hashcode case that demonstrates non- collision

		TEST_hashcode(contacts.get(0), contacts.get(1));
		TEST_hashcode(contacts.get(2), contacts.get(2));

		// //Create the phonebook handler
		phonebookHander = new PhonebookHandlerImpl(phonebook);
		
		List<Contact> sortedContacts = TEST_Sort(phonebookHander);
		TEST_Display(sortedContacts);
		
		// // 2 cases:
		// // 1) a call to search finds the user and displays their entries 
		// //(2) a call to search does not find the user & displays some detail illustrating same
		
		TEST_Search(phonebookHander, sortedContacts, "Juan");

	}

	
	public static List<Contact> TEST_Sort(PhonebookHandlerImpl phonebookHandler) {
		
		List<Contact> sortedContacts = phonebookHander.sortByName();
		return sortedContacts;

	}

	
	public static void TEST_Search(PhonebookHandlerImpl phonebookHandler, List<Contact> sortedContacts, String name) {
		  
		System.out.printf("Searching for %s\n", name);
		List<PhonebookEntry> selectedEntries = phonebookHander.binarySearch(sortedContacts, name);
		
		for (PhonebookEntry entry : selectedEntries) {

			System.out.println("Entries for " + name + " " + entry.getType() + " " + entry.getPhoneNumber());
		
		}
		
	}
	
	public static void TEST_Display(List<Contact> sortedContacts) {
		
		System.out.println("Sorted Contacts in the phonebook: \n");

		phonebookHander.display(sortedContacts);

	}

	public static void TEST_Equals(Contact r1, Contact r2) {

		System.out.printf("Comparing %s with %s\n", r1.toString(), r2.toString());

		System.out.println(r1.equals(r2));

		System.out.println();

	}

	public static void TEST_hashcode(Contact r1, Contact r2) {

		System.out.printf("Hashing %s with %s\n", r1.toString(), r2.toString());

		if (r1.hashCode() == r2.hashCode()) {

			System.out.println("Hash matches - we're in the same bucket ( collision!): " + r1.hashCode());

		} else {

			System.out.println("NO hash match: " + r1.hashCode() + " / " + r2.hashCode());

		}

		System.out.println();

	}
	
	public static String generateRandomNumberString(int length) {

		Random random = new Random();
		String stringNumber = "";

		for (int i = 0; i < length; i++) {

			int digit = random.nextInt(10); 
			stringNumber += digit; 

		}
		
		return stringNumber;

	}
 
	/**
	 * 
	 * Build 5 contacts
	 * Add 1-3 phonebook entries per contact.   Some must have > 1.
	 * 'Put' into the phonebook map key-value pairs of the form contact, List<PhonebookEntries>
	 * 
	 * Feel free to update 
	 * 
	 * @throws InterruptedException
	*/
	
	public static void init() throws InterruptedException {

		System.out.println("Building Contacts ....");
		// TimeUnit.SECONDS.sleep(1);

		String[] commonNames = { "John", "Jane", "Steve", "Sean", "Paul", "Jan", "Stan", "Juan", "Mun", "Ran" };

		for (String name : commonNames) {

			contacts.add(new Contact(name));

		}

		System.out.println("Building Phonebook Entries ....");
		// TimeUnit.SECONDS.sleep(1);
		
		for (Contact contact : contacts) {

			contact.addPhonebookEntry(generateRandomNumberString(10), "Home");
			contact.addPhonebookEntry(generateRandomNumberString(10), "Cell");
			contact.addPhonebookEntry(generateRandomNumberString(10), "Work");

		}

		System.out.println("Adding Entries to the phonebook ....\n");
		// TimeUnit.SECONDS.sleep(1);

		for (Contact contact : contacts) {

			phonebook.put(contact, contact.getPhonebookEntries());

		}

	}

}