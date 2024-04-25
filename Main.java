import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try {
            System.setOut(new PrintStream(System.out, true, "cp866"));
        } catch (UnsupportedEncodingException e) {
            System.err.println("Unsupported encoding: cp866");
        }
        Scanner scanner = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();
        Menu menu = new Menu(scanner, phoneBook);

        while (true) {
            int choice = menu.showMenu();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    phoneBook.printContacts();
                    break;
                case 2:
                    scanner.nextLine(); // очистка буфера
                    System.out.print("Введите полное имя: ");
                    String fullName = scanner.nextLine();
                    System.out.print("Введите номер телефона: ");
                    String phoneNumber = scanner.nextLine();
                    phoneBook.addContact(new Contact(fullName, phoneNumber));
                    break;
                case 3:
                    System.out.print("Введите полное имя контакта для редактирования: ");
                    String editName = scanner.nextLine();
                    Contact editedContact = phoneBook.findContact(editName);
                    if (editedContact != null) {
                        System.out.print("Введите новый номер телефона: ");
                        String newPhoneNumber = scanner.nextLine();
                        editedContact.setPhoneNumber(newPhoneNumber);
                    } else {
                        System.out.println("Контакт не найден.");
                    }
                    break;
                case 4:
                    System.out.print("Введите полное имя контакта для удаления: ");
                    String deleteName = scanner.nextLine();
                    phoneBook.deleteContact(deleteName);
                    break;
                case 5:
                    System.out.print("Введите имя контакта для поиска: ");
                    String searchName = scanner.nextLine();
                    Contact searchedContact = phoneBook.findContact(searchName);
                    if (searchedContact != null) {
                        System.out.println(searchedContact);
                    } else {
                        System.out.println("Контакт не найден.");
                    }
                    break;
                case 6:
                    System.out.print("Введите полное имя первого контакта для слияния: ");
                    String firstContactName = scanner.nextLine();
                    Contact firstContact = phoneBook.findContact(firstContactName);
                    System.out.print("Введите полное имя второго контакта для слияния: ");
                    String secondContactName = scanner.nextLine();
                    Contact secondContact = phoneBook.findContact(secondContactName);
                    if (firstContact != null && secondContact != null) {
                        phoneBook.mergeContacts(firstContact, secondContact);
                    } else {
                        System.out.println("Один или оба контакта не найдены.");
                    }
                    break;
                case 7:
                    Map<String, Contact> contacts = phoneBook.getContacts();
                    for (Map.Entry<String, Contact> entry : contacts.entrySet()) {
                        System.out.println(entry.getValue());
                    }
                    break;
                case 0:
                    System.out.println("До свидания!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }
}

class Menu {

    private final Scanner scanner;
    private final PhoneBook phoneBook;
    private String fullName;

    public Menu(Scanner scanner, PhoneBook phoneBook) {
        this.scanner = scanner;
        this.phoneBook = phoneBook;
    }

    public int showMenu() {
        System.out.println("1. Просмотр контактов");
        System.out.println("2. Добавить контакт");
        System.out.println("3. Редактировать контакт");
        System.out.println("4. Удалить контакт");
        System.out.println("5. Поиск контакта");
        System.out.println("6. Объединить контакты");
        System.out.println("7. Получить все контакты");
        System.out.println("0. Выход");
        System.out.print("Введите свой выбор: ");
        return scanner.nextInt();
    }

    public void printContacts() {
        phoneBook.printContacts();
    }

    public void addContact() {
        scanner.nextLine(); // очистка буфера
        System.out.print("Введите полное имя: ");
        String fullName = scanner.next();
        System.out.print("Введите номер телефона: ");
        String phoneNumber = scanner.next();
        phoneBook.addContact(new Contact(fullName, phoneNumber));
    }

    public void editContact() {
        System.out.print("Введите полное имя контакта для редактирования: ");
        String fullName = scanner.nextLine();
        Contact editedContact = phoneBook.findContact(fullName);
        if (editedContact != null) {
            System.out.print("Введите новый номер телефона: ");
            String newPhoneNumber = scanner.nextLine();
            editedContact.setPhoneNumber(newPhoneNumber);
        } else {
            System.out.println("Контакт не найден.");
        }
    }

    public void deleteContact() {
        System.out.print("Введите полное имя контакта, который необходимо удалить: ");
        String fullName = scanner.nextLine();
        phoneBook.deleteContact(fullName);
    }

    public void searchContact() {
        System.out.print("Введите номер телефона для поиска: ");
        Contact searchedContact = phoneBook.findContact(fullName);
        if (searchedContact != null) {
            System.out.println(searchedContact);
        } else {
            System.out.println("Контакт не найден.");
        }
    }

    public void mergeContacts() {
        System.out.print("Введите полное имя первого контакта для слияния: ");
        String firstFullName = scanner.nextLine();
        Contact firstContact = phoneBook.findContact(firstFullName);
        System.out.print("Введите полное имя второго контакта для слияния: ");
        String secondFullName = scanner.nextLine();
        Contact secondContact = phoneBook.findContact(secondFullName);
        if (firstContact != null && secondContact != null) {
            phoneBook.mergeContacts(firstContact, secondContact);
        } else {
            System.out.println("Один или оба контакта не найдены.");
        }
    }

    public void getAllContacts() {
        Map<String, Contact> contacts = phoneBook.getContacts();
        for (Map.Entry<String, Contact> entry : contacts.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}

class Contact {

    private final String fullName;
    private String phoneNumber;

    public Contact(String fullName, String phoneNumber) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Контакт:\n" +
        "    полное имя = " + fullName + '\n' +
        "    номер телефона = " + phoneNumber + '\n';
    }
}

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