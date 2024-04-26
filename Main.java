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
        Scanner scanner = new Scanner(System.in, "cp866");
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
