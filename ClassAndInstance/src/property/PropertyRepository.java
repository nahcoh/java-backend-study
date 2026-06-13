import java.util.HashMap;
import java.util.Map;

public class PropertyRepository {

    private final Map<String, Property> properties = new HashMap<>();

    public void save(Property property) {
        properties.put(property.getAddress(), property);
    }

    public Property findByAddress(String address) {
        return properties.get(address);

    }

    public boolean existsByAddress(String address) {
        return properties.containsKey(address);
    }

    public void deleteByAddress(String address) {
        properties.remove(address);
    }

    public Map<String, Property> findAll() {
        return properties;
    }

    public int count() {
        return properties.size();
    }
}
