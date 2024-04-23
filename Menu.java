import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {

    private Scanner scanner;
    private Map<String, Contact> phoneBook;

    public Menu(Scanner scanner, Map<String, Contact> phoneBook) {
        this.scanner = scanner;
        this.phoneBook = phoneBook;
    }

    public void viewContacts() {
        for (Map.Entry<String, Contact> entry : phoneBook.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void addContact() {
        System.out.print("Введите полное имя: ");
        String fullName = scanner.nextLine();
        System.out.print("Введите номер телефона: ");
        String phoneNumber = scanner.nextLine();
        phoneBook.put(fullName, new Contact(fullName, phoneNumber));
    }

    public void editContact() {
        System.out.print("Введите полное имя контакта для редактирования: ");
        String fullName = scanner.nextLine();
        if (phoneBook.containsKey(fullName)) {
            Contact contact = phoneBook.get(fullName);
            System.out.print("Введите новый номер телефона: ");
            String newPhoneNumber = scanner.nextLine();
            contact.setPhoneNumber(newPhoneNumber);
        } else {
            System.out.println("Контакт не найден.");
        }
    }

    public void deleteContact() {
        System.out.print("Введите полное имя контакта, который необходимо удалить: ");
        String fullName = scanner.nextLine();
        if (phoneBook.containsKey(fullName)) {
            phoneBook.remove(fullName);
        } else {
            System.out.println("Контакт не найден.");
        }
    }

    public void searchContact() {
        System.out.print("Введите номер телефона для поиска: ");
        String phoneNumber = scanner.nextLine();
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
}