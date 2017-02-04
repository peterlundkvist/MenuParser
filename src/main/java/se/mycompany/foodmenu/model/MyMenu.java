package se.mycompany.foodmenu.model;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;

/**
 * Created by peter on 2017-02-03.
 */
@JsonRootName(value = "breakfast_menu")
public class MyMenu {
    public List<MyFood> getFood() {
        return food;
    }

    public void setFood(List<MyFood> food) {
        this.food = food;
    }

    private List<MyFood> food;


}
