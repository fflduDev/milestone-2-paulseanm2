package template;

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

class Contact {

    private String name;
    private List<PhonebookEntry> phonebookEntries;

    public Contact(String name) {

        this.name = name;

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

}
