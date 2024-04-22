import java.util.Scanner;

/**
 * Класс, реализующий пользовательский интерфейс и меню для взаимодействия с приложением.
 */
public class Menu {

    private final Scanner scanner;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Метод для вывода меню и получения выбора пользователя.
     *
     * @return Выбранный пункт меню.
     */
    public int showMenuAndGetChoice() {
        System.out.println("Выберите действие:\n" +
                "1. Просмотр контактов\n" +
                "2. Добавление контакта\n" +
                "3. Редактирование контакта\n" +
                "4. Удаление контакта\n" +
                "5. Поиск контакта\n" +
                "6. Слияние контактов\n" +
                "7. Выход");
        return scanner.nextInt();
    }

    /**
     * Метод для получения данных контакта от пользователя.
     *
     * @return Контакт, созданный на основе введенных данных.
     */
    public Contact getContactData() {
        System.out.println("Введите данные контакта:\n" +
                "Фамилия Имя Отчество:\n" +
                "1. Номер телефона:\n" +
                "2. E-mail:\n" +
                "3. Дополнительная информация:");

        String fullName = scanner.next();
        String phoneNumber = scanner.next();
        String email = scanner.next();
        String additionalInfo = scanner.next();

        return new Contact(fullName, phoneNumber, email, additionalInfo);
    }

    /**
     * Метод для получения данных контакта для поиска от пользователя.
     *
     * @return Полное имя контакта для поиска.
     */
    public String getContactForSearch() {
        System.out.println("Введите полное имя контакта для поиска:");
        return scanner.next();
    }

    /**
     * Метод для получения данных контакта для редактирования от пользователя.
     *
     * @return Контакт, созданный на основе введенных данных.
     */
    public Contact getContactForEdit() {
        System.out.println("Введите данные контакта для редактирования:\n" +
                "1. Номер телефона:\n" +
                "2. E-mail:\n" +
                "3. Дополнительная информация:");

        String phoneNumber = scanner.next();
        String email = scanner.next();
        String additionalInfo = scanner.next();

        return new Contact("", phoneNumber, email, additionalInfo);
    }

    /**
     * Метод для вывода сообщения об успешном выполнении операции.
     */
    public void showSuccessMessage() {
        System.out.println("Операция выполнена успешно.");
    }

    /**
     * Метод для вывода сообщения об ошибке.
     *
     * @param message Сообщение об ошибке.
     */
    public void showErrorMessage(String message) {
        System.err.println("Ошибка: " + message);
    }
}