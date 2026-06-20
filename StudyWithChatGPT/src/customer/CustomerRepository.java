package customer;

import java.util.List;

public interface CustomerRepository {

    void save(Customer customer);

    Customer findByEmail(String email);

    boolean existsByEmail(String email);

    void deleteByEmail(String email);

    List<Customer> findAll();

    int count();

}
