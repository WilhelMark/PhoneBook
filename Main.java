import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook(new HashMap<>());
        Menu menu = new Menu(new Scanner(System.in));
        FileHandler fileHandler = new FileHandler();

        while (true) {
            int choice = menu.showMenuAndGetChoice();
            Contact contact = null;
            switch (choice) {
                case 1:
                    phoneBook.viewContacts();
                    break;
                case 2:
                    contact = menu.getContactData();
                    phoneBook.addContact(contact);
                    menu.showSuccessMessage();
                    break;
                case 3:
                    contact = menu.getContactForEdit();
                    phoneBook.editContact(contact);
                    menu.showSuccessMessage();
                    break;
                case 4:
                    contact = menu.getContactForSearch();
                    phoneBook.deleteContact(contact);
                    menu.showSuccessMessage();
                    break;
                case 5:
                    String contactForSearch = menu.getContactForSearch();
                    Contact searchedContact = phoneBook.searchContact(contactForSearch);
                    if (searchedContact != null) {
                        System.out.println(searchedContact);
                    } else {
                        System.out.println("Контакт не найден.");
                    }
                    break;
                case 6:
                    phoneBook.mergeContacts();
                    menu.showSuccessMessage();
                    break;
                case 7:
                    fileHandler.saveContactsToFile(phoneBook.getAllContacts(), "contacts.dat");
                    System.out.println("Контакты успешно сохранены в файл.");
                    return;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }
}
