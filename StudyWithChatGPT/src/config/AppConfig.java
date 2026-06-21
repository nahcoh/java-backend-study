package config;

import book.BookRepository;
import book.BookService;
import book.MemoryBookRepository;
import customer.CustomerRepository;
import customer.CustomerService;
import customer.MemoryCustomerRepository;
import notification.EmailSender;
import notification.SmsSender;
import order.MemoryOrderRepository;
import order.Order;
import order.OrderRepository;
import order.OrderService;
import property.MemoryPropertyRepository;
import property.Property;
import property.PropertyRepository;
import property.PropertyService;
import user.MemoryUserRepository;
import user.UserRepository;
import user.UserService;

public class AppConfig {

    private final UserRepository userRepository = new MemoryUserRepository();


    private final UserService emailUserService = new UserService(userRepository, new EmailSender());
    private final UserService smsUserService = new UserService(userRepository, new SmsSender());

    private final PropertyRepository propertyRepository = new MemoryPropertyRepository();
    private final PropertyService propertyService = new PropertyService(propertyRepository);

    private final BookRepository bookRepository = new MemoryBookRepository();
    private final BookService bookService = new BookService(bookRepository);

    private final CustomerRepository customerRepository = new MemoryCustomerRepository();
    private final CustomerService customerService = new CustomerService(customerRepository);

    private final OrderRepository orderRepository = new MemoryOrderRepository();
    private final OrderService orderService = new OrderService(orderRepository);


    public UserService emailUserService() {
        return emailUserService;

    }

    public UserService smsUserService() {
        return smsUserService;
    }

    public PropertyService propertyService() {
        return propertyService;
    }

    public BookService bookService() {
        return bookService;
    }

    public CustomerService customerService() {
        return customerService;
    }

    public OrderService orderService() {
        return orderService;
    }

}
