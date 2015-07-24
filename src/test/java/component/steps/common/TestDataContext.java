package component.steps.common;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;

/**
 * A simple testDataContext bag used to share testDataContext between step classes
 */
@Component
public class TestDataContext {

    private Map<String,Object> contextData = new HashMap<String, Object>();

    public void put(String key, Object value) {
        contextData.put(key,value);
    }

    public boolean containsKey(String key) {
        return contextData.containsKey(key);
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String key) {
        Object value = contextData.get(key);
        assertNotNull(key + " expected in testDataContext", value);
        return (T) value;
    }

    public Long getLong(String key) {
        Object value = contextData.get(key);
        assertNotNull(key + " expected in testDataContext", value);
        return (Long) value;
    }

    public String getString(String key) {
        Object value = contextData.get(key);
        assertNotNull(key + " expected in testDataContext", value);
        return (String) value;
    }

    public Integer getInt(String key){
        Object value = contextData.get(key);
        assertNotNull(key + " expected in testDataContext", value);
        return (Integer) value;
    }

    public void clear() {
        contextData.clear();
    }

}
