package customer;

import java.util.List;

public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void register(String email, String name, String phone) {
        if (customerRepository.existsByEmail(email)) {
            throw new DuplicateCustomerException();
        }
        Customer customer = new Customer(email, name, phone);

        customerRepository.save(customer);
    }

    public Customer findByEmail(String email) {
        Customer customer = customerRepository.findByEmail(email);

        if (customer == null) {
            throw new CustomerNotFoundException();
        }
        return customer;
    }

    public void changeName(String email, String newName) {
        Customer customer = findByEmail(email);
        customer.changeName(newName);
    }

    public void changePhone(String email, String newPhone) {
        Customer customer = findByEmail(email);
        customer.changePhone(newPhone);
    }

    public void deleteByEmail(String email) {
        if (!customerRepository.existsByEmail(email)) {
            throw new CustomerNotFoundException();
        }
        customerRepository.deleteByEmail(email);
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public int count() {
        return customerRepository.count();
    }
}
