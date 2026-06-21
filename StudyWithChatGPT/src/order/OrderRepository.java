package order;

import java.util.List;

public interface OrderRepository {

    void save(Order order);

    Order findByOrderId(String orderId);

    boolean existsByOrderId(String orderId);

    void deleteByOrderId(String orderId);

    List<Order> findAll();

    int count();

    List<Order> findByCustomerEmail(String customerEmail);

    List<Order> findByPriceRange(int minPrice, int maxPrice);


}
