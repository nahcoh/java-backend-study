package order;

import java.util.List;

public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void register(Order order) {
        if (orderRepository.existsByOrderId(order.getOrderId())) {
            throw new DuplicateOrderException();
        }
        orderRepository.save(order);

    }

    public Order findByOrderId(String orderId) {
        Order order = orderRepository.findByOrderId(orderId);
        if (order == null) {
            throw new OrderNotFoundException();
        }
        return order;
    }

    public void changeStatus(String orderId, OrderStatus orderStatus) {
        Order order = findByOrderId(orderId);
        order.changeStatus(orderStatus);
    }

    public void deleteByOrderId(String orderId) {
        if (!orderRepository.existsByOrderId(orderId)) {
            throw new OrderNotFoundException();
        }
        orderRepository.deleteByOrderId(orderId);
    }

    public List<Order> findAll() {

        return orderRepository.findAll();
    }

    public int count() {
        return orderRepository.count();
    }

    public List<Order> findByCustomerEmail(String customerEmail) {
        return orderRepository.findByCustomerEmail(customerEmail);
    }

    public List<Order> findByPriceRange(int minPrice, int maxPrice) {
        return orderRepository.findByPriceRange(minPrice, maxPrice);
    }
}
