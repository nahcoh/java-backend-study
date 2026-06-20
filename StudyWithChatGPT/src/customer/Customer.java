package customer;

public class Customer {

    private final String email;
    private String name;
    private String phone;

    public Customer(String email, String name, String phone) {
        noBlank(email, "email");
        noBlank(name, "이름");
        noBlank(phone, "전화번호");

        this.email = email;
        this.name = name;
        this.phone = phone;
    }

    public void changeName(String newName) {
        noBlank(newName, "변경할 이름");
        this.name = newName;
    }

    public void changePhone(String newPhone) {
        noBlank(newPhone, "새로운 번호");
        this.phone = newPhone;

    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    private void noBlank(String s, String fieldName) {
        if (s == null || s.isBlank()) {
            throw new IllegalArgumentException(fieldName + "는(은) 비면 안됨");
        }

    }

    @Override
    public String toString() {
        return "Customer{" +
            "email='" + email + '\'' +
            ", name='" + name + '\'' +
            ", phone='" + phone + '\'' +
            '}';
    }
}
