import java.util.Map;

public class PropertyService {

    private final PropertyRepository propertyRepository = new PropertyRepository();


    public void register(Property property) {
        if (propertyRepository.existsByAddress(property.getAddress())) {
            throw new DuplicatePropertyException("이미 등록된 매물입니다.");
        }

        propertyRepository.save(property);
    }

    public Property findByAddress(String address) {
        Property property = propertyRepository.findByAddress(address);

        if (property == null) {
            throw new PropertyNotFoundException("매물을 찾을 수 없음");
        }

        return property;
    }

    public void deleteByAddress(String address) {
        if (!propertyRepository.existsByAddress(address)) {
            throw new PropertyNotFoundException("매물을 찾을 수 없음");
        }

        propertyRepository.deleteByAddress(address);
    }

    public void changePrice(String address, int newPrice) {

        Property property = findByAddress(address);
        property.changePrice(newPrice);
    }

    public int countProperties() {
        return propertyRepository.count();
    }

    public Map<String, Property> findAllProperties() {
        return propertyRepository.findAll();
    }

}
