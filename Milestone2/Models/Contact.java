package Milestone2.Models;

import java.util.ArrayList;
import java.util.List;

/**
 * model a Contact 
 * Contact has a name & list of phonebook entries
 * 
 * Support adding phonebookEntry to a contact
 * 
 * @Override hashCode and equals
 * 
 */

public class Contact implements Comparable<Contact> {

    private String name;
    private List<PhonebookEntry> phonebookEntries;

    public Contact(String name) {

        this.name = name;
        this.phonebookEntries = new ArrayList<>();

    }

    // accessors

    public String getName() {

        return name;

    }

    public List<PhonebookEntry> getPhonebookEntries() {
        
        return phonebookEntries;

    }

    // mutators

    public void addPhonebookEntry(String number, String type) {

        this.phonebookEntries.add(new PhonebookEntry(number, type));

    }

    // override hashCode and equals

    @Override
    public int compareTo(Contact other) {

        return this.name.compareTo(other.getName());

    }

    @Override 
    public int hashCode() {

        // making use of built-in hashcode functionality for String and List

        return this.name.hashCode() + this.phonebookEntries.hashCode();

    }
    
    @Override
    public boolean equals(Object otherObj) {

        // checks name and entries list

        if ((this instanceof Contact)) return false; // not same obj

        if (this == otherObj) return true; // same mem address
    
        Contact otherContact = (Contact) otherObj;

        return this.name == otherContact.name && this.phonebookEntries.equals(otherContact.phonebookEntries);
        
    }

}