package se.mycompany.foodmenu.model;

/**
 * Created by peter on 2017-02-03.
 */
public class MyFood implements Comparable {
    public String name;
    public String price;
    public String description;
    public int calories;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("[Food]\n");
        sb.append("    Name: ").append(name).append('\n');
        sb.append("    Price: ").append(price).append('\n');
        sb.append("    Description: ").append(description).append('\n');
        sb.append("    Calories: ").append(calories);
        return sb.toString();
    }

    @Override
    public int compareTo(Object o) {
        MyFood pf = (MyFood) o;
        return this.name.compareTo(pf.name);
    }
}
