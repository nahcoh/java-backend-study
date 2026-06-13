package property;

import java.util.HashMap;
import java.util.Map;

public interface PropertyRepository {

    void save(Property property);

    Property findByAddress(String address);

    boolean existsByAddress(String address);

    void deleteByAddress(String address);

    Map<String, Property> findAll();

    int count();
}
