package property;

import java.util.Map;
import java.util.ArrayList;
import java.util.List;

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

    public List<Property> findByOwnerEmail(String ownerEmail) {
        List<Property> result = new ArrayList<>();

        for (Property property : propertyRepository.findAll().values()) {
            if (property.getOwnerEmail().equals(ownerEmail)) {
                result.add(property);
            }
        }
        return result;
    }

    public List<Property> findByPriceRange(int minPrice, int maxPrice) {
        List<Property> result = new ArrayList<>();

        for (Property property : propertyRepository.findAll().values()) {
            if (property.getPrice() >= minPrice && property.getPrice() <= maxPrice) {
                result.add(property);
            }
        }

        return result;
    }

    public List<Property> findByDescriptionKeyword(String keyword) {
        List<Property> result = new ArrayList<>();

        for (Property property : propertyRepository.findAll().values()) {
            if (property.getDescription().contains(keyword)) {
                result.add(property);
            }
        }
        return result;
    }



}
