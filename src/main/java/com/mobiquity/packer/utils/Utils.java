/*
 * Mobiquity INC
 * This is an Assignment Challenge
 * Written by Nikolaos Bellias
 *
 */
package com.mobiquity.packer.utils;

import com.mobiquity.packer.model.TestCase;
import com.mobiquity.packer.model.Thing;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nikolaos
 */
public class Utils {

    private static final Double packageMaxWeight = 100d;
    private static final Integer maxItems = 15;
    private static final Double itemMaxWeight = 100d;
    private static final Double itemMaxCost = 100d;

    /**
     *
     * This method is used to fetch data from sample data file and create a list
     * of test cases
     *
     * @param filePath
     * @return An object list of MyPacakges
     */
    public static List<TestCase> processPackageFile(String filePath) {
        List<TestCase> pkgList = new ArrayList();
        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(filePath),
                            StandardCharsets.UTF_8.name()));

            String line;

            // Read each line
            while ((line = br.readLine()) != null) {
                // process the line
                List<Thing> thingList = new ArrayList();
                TestCase pkg;
                int itemCounter = 0;

                // Separate left side of :
                Double packageWeight = Double.parseDouble(line.
                        split(":")[0]);

                // and right side of :
                String[] listOfThings = line.split(":")[1].
                        strip().
                        split(" ");

                // Creating Thing objects from string included in parenthesis
                for (String thingInParenthesis : listOfThings) {

                    String[] thingStr = thingInParenthesis.
                            replaceAll("[\\(\\)\\€]", "").split(",");
                    Thing thing = new Thing(Long.parseLong(thingStr[0]),
                            Double.parseDouble(thingStr[1]),
                            Double.parseDouble(thingStr[2]));
                    ++itemCounter;
                    // Check that item max weight and cost are less than
                    // or equal to 100, and items are less or equal to 15
                    if (thing.getWeight() <= itemMaxWeight
                            && thing.getCost() <= itemMaxCost
                            && itemCounter <= maxItems) {
                        thingList.add(thing);
                    }
                }
                // Creating TestCase objects
                pkg = new TestCase(packageWeight, thingList);
                // Check that package weight is less than or equal to 100
                if (pkg.getWeight() <= packageMaxWeight) {
                    pkgList.add(pkg);
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pkgList;
    }

}
