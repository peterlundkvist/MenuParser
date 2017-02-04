package se.mycompany;

import se.mycompany.foodmenu.model.MyMenu;

/**
 * Created by peter on 2017-02-03.
 */
public interface MenuParser {
    MyMenu parse(String fileContents);
}
