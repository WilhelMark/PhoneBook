import java.util.ArrayList;
import java.util.List;

public class Contact {

    private String fullName;
    private List<String> phoneNumbers;
    private String email;
    private String additionalInfo;

    public Contact(String fullName, String phoneNumber, String email, String additionalInfo) {
        this.fullName = fullName;
        this.phoneNumbers = new ArrayList<>();
        this.phoneNumbers.add(phoneNumber);
        this.email = email;
        this.additionalInfo = additionalInfo;
    }

    public Contact(String fullName, List<String> phoneNumbers, String email, String additionalInfo) {
        this.fullName = fullName;
        this.phoneNumbers = phoneNumbers;
        this.email = email;
        this.additionalInfo = additionalInfo;
    }

    public String getFullName() {
        return fullName;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public String getEmail() {
        return email;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void addPhoneNumber(String phoneNumber) {
        phoneNumbers.add(phoneNumber);
    }

    public void edit(Contact contact) {
        if (contact.getFullName() != null) {
            fullName = contact.getFullName();
        }
        if (contact.getPhoneNumbers() != null) {
            phoneNumbers = contact.getPhoneNumbers();
        }
        if (contact.getEmail() != null) {
            email = contact.getEmail();
        }
        if (contact.getAdditionalInfo() != null) {
            additionalInfo = contact.getAdditionalInfo();
        }
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