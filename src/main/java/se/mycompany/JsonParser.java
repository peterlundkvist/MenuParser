package se.mycompany;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import se.mycompany.foodmenu.model.MyMenu;

import java.io.IOException;

/**
 * Created by peter on 2017-02-03.
 */
public class JsonParser implements MenuParser {
    public MyMenu parse(String contents) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
        try {
            return mapper.readValue(contents, MyMenu.class);
        } catch (IOException e) {
            throw new RuntimeException("Unable to read JSON file.", e);
        }
    }
}
