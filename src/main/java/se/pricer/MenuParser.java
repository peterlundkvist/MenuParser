package se.pricer;

import se.pricer.foodmenu.model.PricerMenu;

/**
 * Created by peter on 2017-02-03.
 */
public interface MenuParser {
    PricerMenu parse(String fileContents);
}
