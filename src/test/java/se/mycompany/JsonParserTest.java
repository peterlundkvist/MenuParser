package se.mycompany;

import org.junit.Test;
import se.mycompany.foodmenu.model.MyMenu;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by peter on 2017-02-03.
 */
public class JsonParserTest {

    @Test
    public void parseJsonFile() throws URISyntaxException, IOException {
        String fileContents = new String(Files.readAllBytes(Paths.get(getClass().getResource("/menu.json").toURI())));
        MenuParser menuParser = new JsonParser();
        MyMenu breakfastMenu = menuParser.parse(fileContents);
        assertEquals(5, breakfastMenu.getFood().size());
    }
}
