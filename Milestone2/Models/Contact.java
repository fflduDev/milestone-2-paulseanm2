package Milestone2.Models;

import java.util.ArrayList;
import java.util.List;

/*
 * Contact models a person. They logically have multiple phone numbers (work, home, mobile), and 
 * those numbers are stored in a list of PhonebookEntry objects.
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
    public String toString() {

        String toDisplay = String.format("Contact: %s", this.name);

        for (PhonebookEntry entry : this.phonebookEntries) {

            toDisplay += String.format("\n\tPhone Number: %s, Type: %s", entry.getPhoneNumber(), entry.getType()); // each entry is indented 

        }

        toDisplay += "\n";

        return toDisplay;

    }

    @Override
    public int compareTo(Contact other) {

        return this.name.compareTo(other.getName());

    }

    @Override 
    public int hashCode() {

        return this.name.hashCode();

    }
    
    @Override
    public boolean equals(Object otherObj) {

        // checks name and entries list

        if (!(this instanceof Contact)) return false; // not same obj

        if (this == otherObj) return true; // same mem address
    
        Contact otherContact = (Contact) otherObj;

        return this.name == otherContact.name && this.phonebookEntries.equals(otherContact.phonebookEntries);
        
    }

}