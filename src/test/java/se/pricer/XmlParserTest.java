package se.pricer;

import org.junit.Ignore;
import org.junit.Test;
import se.pricer.foodmenu.model.PricerMenu;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

/**
 * Created by peter on 2017-02-03.
 */
public class XmlParserTest {

    @Test
    public void parseXmlFile() throws URISyntaxException, IOException {
        String fileContents = new String(Files.readAllBytes(Paths.get(getClass().getResource("/menu.xml").toURI())));
        MenuParser menuParser = new XmlParser();
        PricerMenu breakfastMenu = menuParser.parse(fileContents);
        assertEquals(5, breakfastMenu.getFood().size());
    }
}
