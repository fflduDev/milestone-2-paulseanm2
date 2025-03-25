package Milestone2;

import java.util.List;

import Milestone2.Models.Contact;
import Milestone2.Models.PhonebookEntry;

public interface PhonebookHandler {
	
	public List<Contact> sortByName();

	public List<PhonebookEntry> binarySearch(List<Contact> sortedContacts, String name);

	public void display(List<Contact> sortedContacts);

}