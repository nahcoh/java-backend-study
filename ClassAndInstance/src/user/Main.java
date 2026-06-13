package user;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        UserService userService = new UserService();

        User user1 = new User("kim@test.com", "김호찬", 31);
        User user2 = new User("lee@test.com", "이혜원", 33);

        userService.register(user1);
        userService.register(user2);

        User foundUser = userService.findByEmail("kim@test.com");
        System.out.println("foundUser.getName() = " + foundUser.getName());

        userService.deleteByEmail("lee@test.com");

        try {
            userService.findByEmail("lee@test.com");
        } catch (UserNotFoundException e) {
            System.out.println("예외 발생: " + e.getMessage());
         }

        try {
            userService.register(new User("kim@test.com", "중복 회원", 311));
        } catch (DuplicateEmailException e) {
            System.out.println("중복 예외 발생: " + e.getMessage());
        }

        userService.changeUserName("kim@test.com", "새로운 ss이름");
        User changedUser = userService.findByEmail("kim@test.com");
        System.out.println("changedUser.getName() = " + changedUser.getName());

        userService.changeUserAge("kim@test.com", 28);
        User ageChangeUser = userService.findByEmail("kim@test.com");
        System.out.println("ageChangeUser.getAge() = " + ageChangeUser.getAge());

        try {
            userService.changeUserAge("kim@test.com", -1);
        } catch (IllegalArgumentException e) {
            System.out.println("나이 변경 예외 발생: " + e.getMessage());
        }

        for (User user : userService.findAllUsers().values()) {
            System.out.println(user.getEmail() + " / " + user.getName());

        }

        System.out.println("전체 회원 수: " + userService.countUsers());

        try {
            userService.deleteByEmail("none@test.com");
        } catch (UserNotFoundException e) {
            System.out.println("삭제 예외 발생: " + e.getMessage());
        }
    }
}