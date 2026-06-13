public class Property {

    private final String address;
    private int price;
    private String description;

    public Property(String address, int price, String description) {
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("주소는 비어 있으면 안됨");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("0보다 커야함");
        }

        this.address = address;
        this.price = price;
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public int getPrice() {
        return price;
    }
    public String getDescription() {
        return description;
    }

    public void changePrice(int newPrice) {
        if (newPrice <= 0) {
            throw new IllegalArgumentException("0 보다 커야함");
        }
        this.price = newPrice;
    }

    public void changeDescription(String newDescription) {
        this.description = newDescription;

    }
}
