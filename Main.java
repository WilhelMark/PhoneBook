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
        Map<String, Contact> phoneBook = new HashMap<>();
        Menu menu = new Menu(scanner, phoneBook);

        while (true) {
            int choice = menu.showMenu();

            switch (choice) {
                case 1:
                    menu.viewContacts();
                    break;
                case 2:
                    scanner.nextLine(); // очистка буфера
                    System.out.print("Введите полное имя: ");
                    String fullName = scanner.nextLine();
                    System.out.print("Введите номер телефона: ");
                    String phoneNumber = scanner.nextLine();
                    phoneBook.put(fullName, new Contact(fullName, phoneNumber));
                    break;
                case 3:
                    menu.editContact();
                    break;
                case 4:
                    menu.deleteContact();
                    break;
                case 5:
                    menu.searchContact();
                    break;
                case 6:
                    menu.mergeContacts();
                    break;
                case 7:
                    menu.getAllContacts();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }
}

class Menu {

    private Scanner scanner;
    private Map<String, Contact> phoneBook;

    public Menu(Scanner scanner, Map<String, Contact> phoneBook) {
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

    public void viewContacts() {
        for (Map.Entry<String, Contact> entry : phoneBook.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void addContact() {
        System.out.print("Введите полное имя: ");
        String fullName = scanner.next();
        System.out.print("Введите номер телефона: ");
        String phoneNumber = scanner.next();
        phoneBook.put(fullName, new Contact(fullName, phoneNumber));
    }

    public void editContact() {
        System.out.print("Введите полное имя контакта для редактирования: ");
        String fullName = scanner.next();
        if (phoneBook.containsKey(fullName)) {
            Contact contact = phoneBook.get(fullName);
            System.out.print("Введите новый номер телефона: ");
            String newPhoneNumber = scanner.next();
            contact.setPhoneNumber(newPhoneNumber);
        } else {
            System.out.println("Контакт не найден.");
        }
    }

    public void deleteContact() {
        System.out.print("Введите полное имя контакта, который необходимо удалить: ");
        String fullName = scanner.next();
        if (phoneBook.containsKey(fullName)) {
            phoneBook.remove(fullName);
        } else {
            System.out.println("Контакт не найден.");
        }
    }

    public void searchContact() {
        System.out.print("Введите номер телефона для поиска: ");
        String phoneNumber = scanner.next();
        for (Map.Entry<String, Contact> entry : phoneBook.entrySet()) {
            if (entry.getValue().getPhoneNumber().equals(phoneNumber)) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
                return;
            }
        }
        System.out.println("Контакт не найден.");
    }

    public void mergeContacts() {
        // Implementation of the mergeContacts method
    }

    public void getAllContacts() {
        // Implementation of the getAllContacts method
    }
}

class Contact {

    private String fullName;
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
        return "Contact{" +
                "fullName='" + fullName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}