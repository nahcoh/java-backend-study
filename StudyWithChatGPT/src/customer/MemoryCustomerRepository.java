package customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryCustomerRepository implements CustomerRepository {

    private final Map<String, Customer> map = new HashMap<>();

    @Override
    public void save(Customer customer) {
        map.put(customer.getEmail(), customer);
    }

    @Override
    public Customer findByEmail(String email) {
        return map.get(email);
    }

    @Override
    public boolean existsByEmail(String email) {
        return map.containsKey(email);
    }

    @Override
    public void deleteByEmail(String email) {
        map.remove(email);
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public int count() {
        return map.size();
    }

}
