import config.AppConfig;
import notification.EmailSender;
import notification.NotificationSender;
import notification.SmsSender;
import property.DuplicatePropertyException;
import property.Property;
import property.PropertyNotFoundException;
import property.PropertyService;
import user.User;
import user.UserRepository;
import user.UserService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();

        PropertyService propertyService = appConfig.propertyService();
        UserService emailUserService = appConfig.emailUserService();
        UserService smsUserService = appConfig.smsUserService();

        testProperty(propertyService);
        testNotification();
        testUser(emailUserService, smsUserService);
        testSingleton(appConfig);
    }

    private static void testProperty(PropertyService propertyService) {
        Property property1 = new Property("서울시 강남구", 50000, " 역세권 원룸", "kim@test.com");
        Property property2 = new Property("서울시 마포구", 70000, "투룸", "kim@test.com");
        Property property3 = new Property("서울시 서초구", 90000, "신축 오피스텔", "lee@test.com");

        propertyService.register(property1);
        propertyService.register(property2);
        propertyService.register(property3);

        Property foundProperty = propertyService.findByAddress("서울시 강남구");
        System.out.println("foundProperty.getDescription() = " + foundProperty.getDescription());

        propertyService.changePrice("서울시 강남구", 55000);
        System.out.println("변경된 가격 = "
            + propertyService.findByAddress("서울시 강남구").getPrice());

        System.out.println("전체 매물 수 : " + propertyService.countProperties());

        try {
            propertyService.register(new Property("서울시 강남구", 60000, "중 복 매 물", "lee@test.com"));
        } catch (DuplicatePropertyException e) {
            System.out.println("중복 매물 예외 발생: " + e.getMessage());
        }

        try {
            propertyService.findByAddress("없는 주소");
        } catch (PropertyNotFoundException e) {
            System.out.println("매물 없음 예외 발생:  " + e.getMessage());

        }
        for (Property property : propertyService.findAllProperties().values()) {
            System.out.println(property.getAddress() + " / " + property.getPrice());

        }

        Property foundProperty1 = propertyService.findByAddress("서울시 강남구");
        System.out.println("등록자 이메일 = " + foundProperty1.getOwnerEmail());


        System.out.println("kim@test.com 등록 매물");
        for (Property property : propertyService.findByOwnerEmail("kim@test.com")) {
            System.out.println(property.getAddress() + " / " + property.getPrice());
        }

        System.out.println("가격 범위 검색 결과");
        for (Property property : propertyService.findByPriceRange(60000, 100000)) {
            System.out.println(property.getAddress() + " / " + property.getPrice());

        }

        System.out.println("키워드 검색 결과");
        for (Property property : propertyService.findByDescriptionKeyword("원룸")) {
            System.out.println(property.getAddress() + " / " + property.getDescription());
        }

        propertyService.deleteByAddress("서울시 강남구");
        System.out.println(
            "삭제 후 전체 매물 수 = " + propertyService.countProperties());
    }

    private static void testNotification() {
        NotificationSender sender = new EmailSender();
        sender.send("회원가입을 환영함");

        sender = new SmsSender();
        sender.send("회원가입을 환영합니다.");
    }

    private static void testUser(UserService emailUserService, UserService smsUserService) {

        User emailUser = new User("email@test.com", "이메일 유저", 20);
        emailUserService.register(emailUser);

        User smsUser = new User("sms@test.com", "문자 유저", 32);
        smsUserService.register(smsUser);

    }

    private static void testSingleton(AppConfig appConfig){
        System.out.println(appConfig.emailUserService() == appConfig.emailUserService());
        System.out.println(appConfig.smsUserService() == appConfig.smsUserService());
        System.out.println(appConfig.propertyService() == appConfig.propertyService());
    }
}