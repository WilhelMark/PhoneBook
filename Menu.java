import java.util.Map;
import java.util.Scanner;

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