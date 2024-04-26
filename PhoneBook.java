import java.util.HashMap;
import java.util.Map;

class PhoneBook {
    private Map<String, Contact> contacts = new HashMap<>();

    public void printContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Список контактов пуст.");
            return;
        }
        for (Map.Entry<String, Contact> entry : contacts.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getFullName())) {
            System.out.println("Контакт с таким полным именем уже существует.");
            return;
        }
        contacts.put(contact.getFullName(), contact);
    }

    public Contact findContact(String fullName) {
        return contacts.get(fullName);
    }

    public void deleteContact(String fullName) {
        if (!contacts.containsKey(fullName)) {
            System.out.println("Контакт с таким полным именем не найден.");
            return;
        }
        contacts.remove(fullName);
    }

    public Map<String, Contact> getContacts() {
        return contacts;
    }

    public void mergeContacts(Contact firstContact, Contact secondContact) {
        if (firstContact == null || secondContact == null) {
            System.out.println("Один или оба контакта не найдены.");
            return;
        }
        firstContact.setPhoneNumber(firstContact.getPhoneNumber() + ", " + secondContact.getPhoneNumber());
        deleteContact(secondContact.getFullName());
    }
}
