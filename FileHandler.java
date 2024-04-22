import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс для работы с файлами, отвечающий за сохранение и импорт данных контактов.
 */
public class FileHandler {

    /**
     * Метод для сохранения контактов в файл.
     *
     * @param contacts Карта контактов для сохранения.
     * @param filePath Путь к файлу для сохранения.
     */
    public void saveContactsToFile(Map<String, Contact> contacts, String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(contacts);
        } catch (IOException e) {
            System.err.println("Ошибка при сохранении контактов в файл: " + e.getMessage());
        }
    }

    /**
     * Метод для импорта контактов из файла.
     *
     * @param filePath Путь к файлу для импорта.
     * @return Карта контактов, импортированных из файла.
     */
    @SuppressWarnings("unchecked")
    public Map<String, Contact> importContactsFromFile(String filePath) {
        Map<String, Contact> contacts = new HashMap<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            contacts = (Map<String, Contact>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка при импорте контактов из файла: " + e.getMessage());
        }

        return contacts;
    }
}