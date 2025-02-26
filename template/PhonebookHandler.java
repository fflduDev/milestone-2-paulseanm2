package template;

import java.util.*;

/**
 * PhonebookHandler - supports 
 * Phonebook operations
 * 
 * Use a map to build the Phonebook
 * key: Contact
 * value: List<phonebookEntries>
 */

public class PhonebookHandler implements iPhonebookHander {

    private Map<Contact, List<PhonebookEntry>> phonebook;
    
    public PhonebookHandler(Map<Contact, List<PhonebookEntry>> phonebook) {

        this.phonebook = phonebook;

    }

    @Override
    public void display(List<Contact> sortedContacts) {

        sortedContacts.forEach((contact) -> {

            System.out.println("Contact: " + contact.getName()); // TODO: make better

        });

    }
    
    
    @Override
    public List<Contact> sortByName() {

        return null; // TODO: implement sort

    }

    @Override
    public List<PhonebookEntry> binarySearch(List<Contact> sortedContacts, String name) {

        return null; // TODO: implement binary search

    }

}
