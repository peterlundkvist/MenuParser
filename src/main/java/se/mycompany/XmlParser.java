package se.mycompany;

import se.mycompany.foodmenu.model.MyFood;
import se.mycompany.foodmenu.model.MyMenu;
import se.mycompany.foodmenu.model.jaxb.BreakfastMenu;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by peter on 2017-02-04.
 * The XML is first unmarshalled and then mapped to Pricer domain objects.
 */
public class XmlParser implements MenuParser {
    @Override
    public MyMenu parse(String fileContents) {
        try {
            JAXBContext jc = JAXBContext.newInstance("se.mycompany.foodmenu.model.jaxb");
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            BreakfastMenu jaxbMenu = (BreakfastMenu) unmarshaller.unmarshal(new StreamSource(new StringReader(fileContents)));
            return mapJaxbMenuToDoaminObject(jaxbMenu);
        } catch (JAXBException e) {
            throw new RuntimeException("Unable to read XML file.", e);
        }
    }

    private MyMenu mapJaxbMenuToDoaminObject(BreakfastMenu jaxbMenu) {

        Function<BreakfastMenu.Food, MyFood> mapFoodObject = new Function<BreakfastMenu.Food, MyFood>() {
            public MyFood apply(BreakfastMenu.Food t) {
                MyFood food = new MyFood();
                food.name = t.getName();
                food.description = t.getDescription();
                food.calories = t.getCalories();
                food.price = t.getPrice();
                return food;
            }
        };

        List<MyFood> foodList = jaxbMenu.getFood().stream()
                .map(mapFoodObject)
                .collect(Collectors.<MyFood> toList());

        MyMenu menu = new MyMenu();
        menu.setFood(foodList);
        return menu;
    }


}

