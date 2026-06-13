package notification;

public class EmailSender implements NotificationSender {

    @Override
    public void send(String message) {
        System.out.println("이메일 발송 = " + message);

    }
}
