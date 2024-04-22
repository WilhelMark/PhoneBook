import java.util.HashMap;
import java.util.Map;

/**
 * Класс, отвечающий за управление контактами. Включает методы для добавления, удаления, редактирования, поиска и слияния контактов.
 */
public class PhoneBook {

    private final Map<String, Contact> contacts;

    public PhoneBook(Map<String, Contact> contacts) {
        this.contacts = contacts;
    }

    /**
     * Метод для добавления контакта в телефонную книгу.
     *
     * @param contact Контакт для добавления.
     */
    public void addContact(Contact contact) {
        String key = contact.getFullName();
        if (contacts.containsKey(key)) {
            Contact existingContact = contacts.get(key);
            existingContact.merge(contact);
        } else {
            contacts.put(key, contact);
        }
    }

    /**
     * Метод для удаления контакта из телефонной книги.
     *
     * @param contact Контакт для удаления.
     */
    public void deleteContact(Contact contact) {
        contacts.remove(contact.getFullName());
    }

    /**
     * Метод для редактирования данных контакта в телефонной книге.
     *
     * @param contact Контакт для редактирования.
     */
    public void editContact(Contact contact) {
        String key = contact.getFullName();
        if (contacts.containsKey(key)) {
            Contact existingContact = contacts.get(key);
            existingContact.edit(contact);
        }
    }

    /**
     * Метод для поиска контакта в телефонной книге.
     *
     * @param fullName Полное имя контакта для поиска.
     * @return Контакт, если он найден, иначе null.
     */
    public Contact searchContact(String fullName) {
        return contacts.get(fullName);
    }

    /**
     * Метод для слияния контактов с одинаковыми ФИО.
     */
    public void mergeContacts() {
        for (Map.Entry<String, Contact> entry : new HashMap<>(contacts).entrySet()) {
            String key = entry.getKey();
            Contact value = entry.getValue();
            for (Map.Entry<String, Contact> entry2 : contacts.entrySet()) {
                if (entry != entry2 && value.getFullName().equals(entry2.getValue().getFullName())) {
                    value.merge(entry2.getValue());
                    contacts.remove(entry2.getKey());
                }
            }
        }
    }

    /**
     * Метод для просмотра всех контактов в телефонной книге.
     */
    public void viewContacts() {
        // Сортировка контактов по убыванию числа телефонов
        contacts.values().stream()
                .sorted((o1, o2) -> Integer.compare(o2.getPhoneNumbers().size(), o1.getPhoneNumbers().size()))
                .forEach(System.out::println);
    }
}