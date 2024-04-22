import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Главный класс приложения, содержащий метод main для запуска программы.
 * Взаимодействие с пользователем, вызов методов для работы с контактами.
 */
public class Main {

    public static void main(String[] args) {
        // Создание телефонной книги на основе HashMap
        PhoneBook phoneBook = new PhoneBook(new HashMap<>());

        // Объект для ввода данных пользователем
        Scanner scanner = new Scanner(System.in);

        // Главный цикл программы
        while (true) {
            // Вывод меню и получение выбора пользователя
            System.out.println("Выберите действие:\n" +
                    "1. Просмотр контактов\n" +
                    "2. Добавление контакта\n" +
                    "3. Редактирование контакта\n" +
                    "4. Удаление контакта\n" +
                    "5. Поиск контакта\n" +
                    "6. Слияние контактов\n" +
                    "7. Выход");
            int choice = scanner.nextInt();

            // Выполнение действия в зависимости от выбора пользователя
            switch (choice) {
                case 1:
                    phoneBook.viewContacts();
                    break;
                case 2:
                    phoneBook.addContact(scanner);
                    break;
                case 3:
                    phoneBook.editContact(scanner);
                    break;
                case 4:
                    phoneBook.deleteContact(scanner);
                    break;
                case 5:
                    phoneBook.searchContact(scanner);
                    break;
                case 6:
                    phoneBook.mergeContacts();
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }
}