package user;

public class User {

    private final String email;
    private String name;
    private int age;

    public User(String email, String name, int age){
        if (email == null || email.isBlank()){
            throw new IllegalArgumentException("이메일 입력 필 수");
        }
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("이름 입력 필 수");
        }
        if (age < 0) {
            throw new IllegalArgumentException("나이는 음 수 불 가");
        }

        this.email = email;
        this.name = name;
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    public void changeAge(int age) {
        if (!validationAge(age)) {
            throw new IllegalArgumentException("나이는 음 수 불 가");
        }
        this.age = age;

    }

    public void changeName(String name) {
        if (!validationName(name)) {
            throw new IllegalArgumentException("이름은 필 수 입 력");
        }
        this.name = name;
    }

    private boolean validationAge(int age) {
        return age >= 0;
    }

    private boolean validationName(String name) {
        return name != null && !name.isBlank();
    }
}
