package order;

public class Order {

    private final String orderId;
    private String customerEmail;
    private String productName;
    private int totalPrice;
    private OrderStatus orderStatus;

    public Order(String orderId, String customerEmail, String productName, int totalPrice) {
        noBlank(orderId, "주문 ID");
        noBlank(customerEmail, "고객 이메일");
        noBlank(productName, "상품명");
        if (totalPrice <= 0) {
            throw new IllegalArgumentException("가격은 0보다 커야 함");
        }
        this.orderId = orderId;
        this.customerEmail = customerEmail;
        this.productName = productName;
        this.totalPrice = totalPrice;
        this.orderStatus = OrderStatus.ORDERED;
    }

    public void changeStatus(OrderStatus orderStatus) {
        if (orderStatus == null) {
            throw new IllegalArgumentException("주문 상태는 null 불가");
        }
        this.orderStatus = orderStatus;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getProductName() {
        return productName;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    private void noBlank(String s, String fieldName) {
        if (s == null || s.isBlank()) {
            throw new IllegalArgumentException(fieldName + "은(는) 비면 안됨");
        }
    }

    @Override
    public String toString() {
        return "Order{" +
            "orderId='" + orderId + '\'' +
            ", customerEmail='" + customerEmail + '\'' +
            ", productName='" + productName + '\'' +
            ", totalPrice=" + totalPrice +
            ", orderStatus=" + orderStatus +
            '}';
    }
}
