public class Contact {

    private final String fullName;
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
        return "Контакт:\n" +
        "    полное имя = " + fullName + '\n' +
        "    номер телефона = " + phoneNumber + '\n';
    }
}