package se.mycompany;

import org.apache.commons.io.FileUtils;
import se.mycompany.foodmenu.model.MyFood;
import se.mycompany.foodmenu.model.MyMenu;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * Created by peter on 2017-02-03.
 */
public class Menu {

    enum SortOrder { asc, desc }
    private static SortOrder ordering;

    public static void main(String[] args) throws IOException {
        if(args == null || args.length != 2) {
            throw new IllegalArgumentException("Please specify these arguments: [json-file|xml-file] [asc|desc]");
        }

        ordering = SortOrder.valueOf(args[1]);

        new Menu().readFile(args[0], args[1]);
    }

    public void readFile(String fileName, String sortOrder) throws IOException {
        MenuParser parser = getSuitableParser(fileName);
        String fileContents = FileUtils.readFileToString(new File(fileName));
        MyMenu menu = parser.parse(fileContents);

        List<MyFood> foodList = menu.getFood();
        Collections.sort(foodList);
        if(ordering.equals(SortOrder.desc))
            Collections.reverse(foodList);

        for(MyFood pf : foodList) {
            System.out.println(pf);
        }
    }

    private  MenuParser getSuitableParser(String fileName) {
        if(fileName.indexOf(".json") > 0)
            return new JsonParser();
        else if(fileName.indexOf(".xml") > 0)
            return new XmlParser();
        else
            throw new IllegalArgumentException("Unknown file type: " + fileName);
    }

}

