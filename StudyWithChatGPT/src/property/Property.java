package property;

public class Property {

    private final String address;
    private int price;
    private String description;
    private final String ownerEmail;


    public Property(String address, int price, String description, String ownerEmail) {
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("주소는 비어 있으면 안됨");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("0보다 커야함");
        }
        if (ownerEmail == null || ownerEmail.isBlank()) {
            throw new IllegalArgumentException("등록자 이메일은 필 수 ");
        }

        this.address = address;
        this.price = price;
        this.description = description;
        this.ownerEmail = ownerEmail;
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

    public String getOwnerEmail() {
        return ownerEmail;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Property property)) {
            return false;
        }
        return address.equals(property.address);
    }

    @Override
    public int hashCode() {
        return address.hashCode();
    }

}
