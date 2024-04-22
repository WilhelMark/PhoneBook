import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Класс, представляющий контакт. Содержит поля для ФИО, номера телефонов, e-mail и дополнительной информации.
 */
public class Contact {

    private final String fullName;
    private final List<String> phoneNumbers;
    private final String email;
    private final String additionalInfo;

    public Contact(String fullName, String phoneNumber, String email, String additionalInfo) {
        this.fullName = fullName;
        this.phoneNumbers = new ArrayList<>();
        this.phoneNumbers.add(phoneNumber);
        this.email = email;
        this.additionalInfo = additionalInfo;
    }

    /**
     * Метод для добавления номера телефона в контакт.
     *
     * @param phoneNumber Номер телефона для добавления.
     */
    public void addPhoneNumber(String phoneNumber) {
        phoneNumbers.add(phoneNumber);
    }

    /**
     * Метод для редактирования данных контакта.
     *
     * @param contact Контакт для редактирования.
     */
    public void edit(Contact contact) {
        if (contact.getPhoneNumbers().size() > 0) {
            phoneNumbers.clear();
            phoneNumbers.addAll(contact.getPhoneNumbers());
        }
        if (contact.getEmail() != null) {
            email = contact.getEmail();
        }
        if (contact.getAdditionalInfo() != null) {
            additionalInfo = contact.getAdditionalInfo();
        }
    }

    /**
     * Метод для слияния данных контактов.
     *
     * @param contact Контакт для слияния.
     */
    public void merge(Contact contact) {
        if (contact.getPhoneNumbers().size() > 0) {
            phoneNumbers.addAll(contact.getPhoneNumbers());
        }
        if (contact.getEmail() != null) {
            email = contact.getEmail();
        }
        if (contact.getAdditionalInfo() != null) {
            additionalInfo = contact.getAdditionalInfo();
        }
    }

    /**
     * Метод для получения полного имени контакта.
     *
     * @return Полное имя контакта.
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Метод для получения номеров телефонов контакта.
     *
     * @return Список номеров телефонов контакта.
     */
    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    /**
     * Метод для получения e-mail контакта.
     *
     * @return E-mail контакта.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Метод для получения дополнительной информации контакта.
     *
     * @return Дополнительная информация контакта.
     */
    public String getAdditionalInfo() {
        return additionalInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(fullName, contact.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "fullName='" + fullName + '\'' +
                ", phoneNumbers=" + phoneNumbers +
                ", email='" + email + '\'' +
                ", additionalInfo='" + additionalInfo + '\'' +
                '}';
    }
}