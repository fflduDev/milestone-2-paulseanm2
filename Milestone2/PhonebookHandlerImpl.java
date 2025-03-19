package Milestone2;

import Milestone2.Models.Contact;
import Milestone2.Models.PhonebookEntry;
import Utils.Sorting;

import java.util.*;

/**
 * PhonebookHandler - supports 
 * Phonebook operations
 * 
 * Use a map to build the Phonebook
 * key: Contact
 * value: List<phonebookEntries>
 */

public class PhonebookHandlerImpl implements PhonebookHandler {

    private Map<Contact, List<PhonebookEntry>> phonebook;
    
    public PhonebookHandlerImpl(Map<Contact, List<PhonebookEntry>> phonebook) {

        this.phonebook = phonebook;

    }

    @Override
    public void display(List<Contact> sortedContacts) {

        sortedContacts.forEach((contact) -> {

            System.out.println("Contact: " + contact.getName()); 

        });

    }
    
    @Override
    public List<Contact> sortByName() {

        Contact[] contactsArr = phonebook.keySet().toArray(new Contact[0]);

        Contact[] sorted = Sorting.quickSort(contactsArr, 0, contactsArr.length - 1);

        return Arrays.asList(sorted);

    }

    @Override
    public List<PhonebookEntry> binarySearch(List<Contact> sortedContacts, String name) {

        int low = 0;
        int high = sortedContacts.size() - 1;

        while (low <= high) {

            int mid = (low + high) / 2; // getting the middle index
            Contact midContact = sortedContacts.get(mid);

            if (midContact.getName().equals(name)) {

                return phonebook.get(midContact); // found

            } else if (midContact.getName().compareTo(name) < 0) {

                low = mid + 1; // moving to the right

            } else {

                high = mid - 1; // moving to the left

            }

        }

        return null; // Not found
        
    }

}
