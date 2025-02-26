package Milestone2.Models;

/**
 *   model a PhonebookEntry 
 *   PhonebookEntry has a phoneNumber and type
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
	