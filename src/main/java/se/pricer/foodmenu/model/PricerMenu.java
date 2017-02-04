package se.pricer.foodmenu.model;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;

/**
 * Created by peter on 2017-02-03.
 */
@JsonRootName(value = "breakfast_menu")
public class PricerMenu {
    public List<PricerFood> getFood() {
        return food;
    }

    public void setFood(List<PricerFood> food) {
        this.food = food;
    }

    private List<PricerFood> food;


}
