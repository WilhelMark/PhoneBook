import java.util.Scanner;

public class Menu {

    private Scanner scanner;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    public int showMenuAndGetChoice() {
        System.out.println("1. Показать все контакты");
        System.out.println("2. Добавить контакт");
        System.out.println("3. Редактировать контакт");
        System.out.println("4. Удалить контакт");
        System.out.println("5. Найти контакт");
        System.out.println("6. Объединить контакты");
        System.out.println("7. Сохранить контакты в файл");
        System.out.println("0. Выйти");
        System.out.print("Ваш выбор: ");
        int choice = scanner.nextInt();
        return choice;
    }

    public Contact getContactData() {
        System.out.print("Введите имя: ");
        String name = scanner.next();
        System.out.print("Введите телефон: ");
        String phone = scanner.next();
        System.out.print("Введите email: ");
        String email = scanner.next();
        System.out.print("Введите дополнительную информацию: ");
        String additionalInfo = scanner.next();
        Contact contact = new Contact(name, phone, email, additionalInfo);
        return contact;
    }

    public Contact getContactForEdit() {
        System.out.print("Введите имя контакта для редактирования: ");
        String name = scanner.next();
        System.out.print("Введите новый телефон: ");
        String phone = scanner.next();
        System.out.print("Введите новый email: ");
        String email = scanner.next();
        System.out.print("Введите новую дополнительную информацию: ");
        String additionalInfo = scanner.next();
        Contact contact = new Contact(name, phone, email, additionalInfo);
        return contact;
    }

    public Contact getContactForSearch() {
        System.out.print("Введите имя контакта для поиска: ");
        String name = scanner.next();
        return new Contact(name, "", "", "");
    }

    public void showSuccessMessage() {
        System.out.println("Контакт успешно сохранен.");
    }
}