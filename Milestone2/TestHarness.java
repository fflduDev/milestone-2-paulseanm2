package Milestone2;

import Milestone2.Models.Contact;
import Milestone2.Models.PhonebookEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TestHarness {

	// Contact overrides hashcode && equals.  Observe collision here.
	
	private static Map<Contact, List<PhonebookEntry>> phonebook = new HashMap<>();
	private static List <Contact> contacts = new ArrayList<>();
	private static PhonebookHandlerImpl phonebookHander;


	public static void main(String[] args) throws InterruptedException {
		
		init();
		
		// //TODO: 2 cases:
		// //display non equality using your overriden equals method
		// //display equality using your overriden equals method

		// TEST_Equals(p1, p2);
		// TEST_Equals(p3, p3);
		
		// //TODO: 2 cases:
		// //display hashcode case that demonstrates collision
		// //display hashcode case that demonstrates non- collision

		// TEST_hashcode(p1, p3);
		// TEST_hashcode(p2, p3);

		// //Create the phonebook handler
		phonebookHander = new PhonebookHandlerImpl(phonebook);
		
		//TODO
		//call 
		List<Contact> sortedContacts = TEST_Sort(phonebookHander);
		TEST_Display(sortedContacts);
		
		// //TODO
		// // 2 cases:
		// // 1) a call to search finds the user and displays their entries 
		// //(2) a call to search does not find the user & displays some detail illustrating same
		// TEST_Search(phonebookHander, sortedContacts, "Juan");

	}

	// 
	public static List<Contact> TEST_Sort(PhonebookHandlerImpl phonebookHandler) {

		//TODO: call your phonebookHander & have it sort the contacts.  Return those.
		
		List<Contact> sortedContacts = phonebookHander.sortByName();
		return sortedContacts;

	}

	
	public static void TEST_Search(PhonebookHandlerImpl phonebookHandler, List<Contact> sortedContacts, String name) {
	
		//TODO: use the sorted contacts and a name to search for.  
	  
		System.out.println("\n -- Search results for " + name + " -- ");
		List<PhonebookEntry> selectedEntries = phonebookHander.binarySearch(sortedContacts, name);
		
		for (PhonebookEntry entry : selectedEntries) {

			System.out.println("Entries for " + name + " " + entry.getType() + " " + entry.getPhoneNumber());
		}
		
	}
	
	public static void TEST_Display(List<Contact> sortedContacts) {
		
		phonebookHander.display(sortedContacts);

	}

	public static void TEST_Equals(Contact r1, Contact r2) {

		System.out.println("Checking r1.equals(r2) for: \n" + r1.toString() + "\n" + r2.toString());
		System.out.println(r1.equals(r2));

		System.out.println();

	}

	public static void TEST_hashcode(Contact r1, Contact r2) {

		System.out.println("Checking r1.hashcode = r2.hashcode for: \n" + r1.toString() + "\n" + r2.toString());
		
		if (r1.hashCode() == r2.hashCode()) {

			System.out.println("Hash matches - we're in the same bucket ( collision!): " + r1.hashCode());

		} else {

			System.out.println("NO hash match: " + r1.hashCode() + " / " + r2.hashCode());

		}

		System.out.println();

	}
 
	/** TODO
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
		TimeUnit.SECONDS.sleep(1);

		contacts.add(new Contact("Jan"));
		contacts.add(new Contact("Stan"));
		contacts.add(new Contact("Juan"));
		contacts.add(new Contact("Mun"));
		contacts.add(new Contact("Ran"));
		contacts.add(new Contact("Steve"));
		contacts.add(new Contact("Sean"));
		contacts.add(new Contact("Paul"));
		contacts.add(new Contact("John"));
		contacts.add(new Contact("Jane"));

	

		System.out.println("Building Phonebook Entries ....");
		TimeUnit.SECONDS.sleep(1);

		Contact p1 = contacts.get(0);
		Contact p2 = contacts.get(1);
		Contact p3 = contacts.get(2);
		Contact p4 = contacts.get(3);
		Contact p5 = contacts.get(4);
		Contact p6 = contacts.get(5);
		Contact p7 = contacts.get(6);
		Contact p8 = contacts.get(7);
		Contact p9 = contacts.get(8);
		Contact p10 = contacts.get(9);
		

		p1.addPhonebookEntry("2034032233", "Home");
		p1.addPhonebookEntry("5532233322", "Cell");
		p1.addPhonebookEntry("1120092829", "Work");

		p2.addPhonebookEntry("1034032233", "Home");
		p2.addPhonebookEntry("2532233322", "Cell");
		p2.addPhonebookEntry("3120092829", "Work");

		p3.addPhonebookEntry("4034032233", "Home");
		p3.addPhonebookEntry("5532233322", "Cell");
		p3.addPhonebookEntry("6120092829", "Work");

		p4.addPhonebookEntry("6034032233", "Home");
		p4.addPhonebookEntry("3532233322", "Cell");
		p4.addPhonebookEntry("1120092829", "Work");

		p5.addPhonebookEntry("0034032233", "Home");
		p5.addPhonebookEntry("0532233322", "Cell");
		p5.addPhonebookEntry("0120092829", "Work");

        p6.addPhonebookEntry("8623699193", "Home");
        p6.addPhonebookEntry("9842709355", "Cell");
        p6.addPhonebookEntry("9487193688", "Work");

		p7.addPhonebookEntry("9328572984", "Home");
        p7.addPhonebookEntry("2387138932", "Cell");
        p7.addPhonebookEntry("1295084206", "Work");

        p8.addPhonebookEntry("8325672984", "Home");
        p8.addPhonebookEntry("2385792486", "Cell");
        p8.addPhonebookEntry("5398670213", "Work");
		
		p9.addPhonebookEntry("3198574690", "Home");
        p9.addPhonebookEntry("4039678093", "Cell");
        p9.addPhonebookEntry("2093486496", "Work");

		p10.addPhonebookEntry("4830692368", "Home");
        p10.addPhonebookEntry("1237859851", "Cell");
        p10.addPhonebookEntry("3304968215", "Work");


		System.out.println("Adding Entries to the phonebook ....\n");
		TimeUnit.SECONDS.sleep(1);

		for (Contact contact : contacts) {

			phonebook.put(contact, contact.getPhonebookEntries());

		}

	}

}