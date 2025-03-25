package Milestone2.Models;

/*
 * PhonebookEntry models a phone number and its type (work, home, mobile).
 * It is used in the Contact class to store multiple phone numbers for a single contact.
*/
public class PhonebookEntry {

    private String phoneNumber;
    private String type;

    public PhonebookEntry(String phoneNumber, String type) {

        this.phoneNumber = phoneNumber;
        this.type = type;

    }

    // accessors

    public String getPhoneNumber() {

        return phoneNumber;

    }

    public String getType() {

        return type;

    }
 
}
	