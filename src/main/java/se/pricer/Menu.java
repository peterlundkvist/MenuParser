package se.pricer;

import org.apache.commons.io.FileUtils;
import se.pricer.foodmenu.model.PricerMenu;

import java.io.File;
import java.io.IOException;

/**
 * Created by peter on 2017-02-03.
 */
public class Menu {
    public static void main(String[] args) throws IOException {
        if(args == null || args.length != 2) {
            throw new IllegalArgumentException("Please specify these arguments: [json-file|xml-file] [asc|desc]");
        }

        new Menu().readFile(args[0], args[1]);
    }

    public void readFile(String fileName, String sortOrder) throws IOException {
        MenuParser parser = getSuitableParser(fileName);
        String fileContents = FileUtils.readFileToString(new File(fileName));
        System.out.println("PricerFood menu:");
        PricerMenu menu = parser.parse(fileContents);


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

