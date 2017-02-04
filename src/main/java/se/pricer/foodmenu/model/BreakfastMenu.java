package se.pricer.foodmenu.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;

/**
 * Created by peter on 2017-02-03.
 */
@JsonRootName(value = "breakfast_menu")
public class BreakfastMenu {
    public List<Food> getFood() {
        return food;
    }

    public void setFood(List<Food> food) {
        this.food = food;
    }

    private List<Food> food;


}
