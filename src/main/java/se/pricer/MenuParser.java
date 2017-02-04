package se.pricer;

import se.pricer.foodmenu.model.BreakfastMenu;

/**
 * Created by peter on 2017-02-03.
 */
public interface MenuParser {
    BreakfastMenu parse(String fileContents);
}
