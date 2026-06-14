package property;

import java.util.HashMap;
import java.util.Map;

public class MemoryPropertyRepository implements PropertyRepository {

    private final Map<String, Property> properties = new HashMap<>();

    @Override
    public void save(Property property) {
        properties.put(property.getAddress(), property);
    }

    @Override
    public Property findByAddress(String address) {
        return properties.get(address);
    }

    @Override
    public boolean existsByAddress(String address) {
        return properties.containsKey(address);
    }

    @Override
    public void deleteByAddress(String address) {
        properties.remove(address);
    }

    @Override
    public Map<String, Property> findAll() {
        return properties;
    }

    @Override
    public int count() {
        return properties.size();
    }
}
