package notification;

public class SmsSender implements NotificationSender {

    @Override
    public void send(String message) {
        System.out.println("문자 발송 = " + message);

    }

}
