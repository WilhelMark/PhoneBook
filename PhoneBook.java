import java.util.Map;

public class PhoneBook {

    private Map<String, Contact> contacts;

    public PhoneBook(Map<String, Contact> contacts) {
        this.contacts = contacts;
    }

    public void addContact(Contact contact) {
        contacts.put(contact.getFullName(), contact);
    }

    public void editContact(Contact contact) {
        contacts.put(contact.getFullName(), contact);
    }

    public void deleteContact(Contact contact) {
        contacts.remove(contact.getFullName());
    }

    public Contact searchContact(String name) {
        return contacts.get(name);
    }

    public void mergeContacts() {
        // TODO: implement merging contacts
    }

    public Map<String, Contact> getAllContacts() {
        return contacts;
    }

    public void viewContacts() {
        for (Map.Entry<String, Contact> entry : contacts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
