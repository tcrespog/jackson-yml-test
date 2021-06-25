package jackson.yml.test;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class GenerateYmlTest {

    @Test
    void generateYmlWithY() {
        ObjectMapper defaultMapper = new ObjectMapper(new YAMLFactory());

        Map<String, Integer> map = new HashMap<>();
        map.put("x", 1);
        map.put("y", 2);
        map.put("z", 3);

        try {
            String expected = "---\nx: 1\ny: 2\nz: 3\n";
            String yml = defaultMapper.writeValueAsString(map);
            assertEquals(expected, yml);
        } catch (JsonProcessingException e) {
            fail(e);
        }
    }

}
