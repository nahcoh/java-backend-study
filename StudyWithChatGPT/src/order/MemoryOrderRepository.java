package order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryOrderRepository implements OrderRepository {

    private final Map<String, Order> map = new HashMap<>();


    @Override
    public void save(Order order) {
        map.put(order.getOrderId(), order);
    }

    @Override
    public Order findByOrderId(String orderId) {
        return map.get(orderId);
    }

    @Override
    public boolean existsByOrderId(String orderId) {
        return map.containsKey(orderId);
    }

    @Override
    public void deleteByOrderId(String orderId) {
        map.remove(orderId);
    }

    @Override
    public List<Order> findAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public int count() {
        return map.size();
    }

    @Override
    public List<Order> findByCustomerEmail(String customerEmail) {
        List<Order> result = new ArrayList<>();

        for (Order order : map.values()) {
            if (order.getCustomerEmail().equals(customerEmail)) {
                result.add(order);
            }
        }

        return result;
    }

    @Override
    public List<Order> findByPriceRange(int minPrice, int maxPrice) {
        List<Order> result = new ArrayList<>();

        for (Order order : map.values()) {
            int price = order.getTotalPrice();

            if (minPrice <= price && price <= maxPrice) {
                result.add(order);
            }
        }

        return result;

    }
}
