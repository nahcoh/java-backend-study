import java.text.MessageFormat;

public class MessageFormatEx2 {
    public static void main(String[] args) {
        String tableName = "CUST_INFO";
        String msg = "INSERT INTO " + tableName +
                " VALUES (''{0}'', ''{1}'', {2}, ''{3}'');";    //''{0}''는 '변수값'으로 출력

        Object[][] arguments = {
                {"이자바", "02-123-1234", "20", "08-21"},
                {"김프로", "12-123-1234", "30", "03-21"}
        };

        for (int i = 0; i < arguments.length; i++) {
            String result = MessageFormat.format(msg, arguments[i]);
            System.out.println(result);

        }
    }
}
