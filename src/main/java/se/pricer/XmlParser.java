package se.pricer;

import se.pricer.foodmenu.model.PricerFood;
import se.pricer.foodmenu.model.PricerMenu;
import se.pricer.foodmenu.model.jaxb.BreakfastMenu;

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
    public PricerMenu parse(String fileContents) {
        try {
            JAXBContext jc = JAXBContext.newInstance("se.pricer.foodmenu.model.jaxb");
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            BreakfastMenu jaxbMenu = (BreakfastMenu) unmarshaller.unmarshal(new StreamSource(new StringReader(fileContents)));
            return mapJaxbMenuToDoaminObject(jaxbMenu);
        } catch (JAXBException e) {
            throw new RuntimeException("Unable to read XML file.", e);
        }
    }

    private PricerMenu mapJaxbMenuToDoaminObject(BreakfastMenu jaxbMenu) {

        Function<BreakfastMenu.Food, PricerFood> mapFoodObject = new Function<BreakfastMenu.Food, PricerFood>() {
            public PricerFood apply(BreakfastMenu.Food t) {
                PricerFood food = new PricerFood();
                food.name = t.getName();
                food.description = t.getDescription();
                food.calories = t.getCalories();
                food.price = t.getPrice();
                return food;
            }
        };

        List<PricerFood> foodList = jaxbMenu.getFood().stream()
                .map(mapFoodObject)
                .collect(Collectors.<PricerFood> toList());

        PricerMenu menu = new PricerMenu();
        menu.setFood(foodList);
        return menu;
    }


}

