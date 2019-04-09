/*
 * Mobiquity INC
 * This is an Assignment Challenge
 * Written by Nikolaos Bellias
 *
 */
package com.mobiquity.packer.view;

import com.mobiquity.packer.model.TestCase;
import com.mobiquity.packer.model.Thing;
import com.mobiquity.packer.model.ThingCombination;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nikolaos
 */
public class PackageOptionView {

    /**
     *
     * This method creates all possible combinations from thing lists in each
     * case
     *
     * The following code is a slightly amended portion taken from
     * https://theproductiveprogrammer.blog/GeneratingCombinations.java.php
     *
     * @param objectList The objects to create their combinations
     * @return The list of combinations of the objects
     */
    private static List<ThingCombination> createCombinations(int caseItem,
            List<Thing> thingList) {
        List<ThingCombination> elementsCombinations = new ArrayList();
        int n = thingList.size();
        for (int num = 0; num < (1 << n); num++) {
            List<Thing> combination = new ArrayList();
            for (int i = 0; i < n; i++) {
                // (is the bit "on" in this number?)
                if ((num & (1 << i)) != 0) {
                    // then combinations included in the list
                    combination.add(thingList.get(i));
                }
            }
            String thingItems = "";
            Double totalWeight = 0D;
            Double totalCost = 0D;
            int cnt = 0;
            for (Thing thing : combination) {
                thingItems += thing.getIndex();
                if (cnt != (combination.size() - 1)) {
                    thingItems += ",";
                } else {
                    thingItems += "";
                }
                totalWeight += thing.getWeight();
                totalCost += thing.getCost();
                ++cnt;
            }
            ThingCombination thingCombination = new ThingCombination(caseItem,
                    thingItems,
                    totalWeight,
                    totalCost);
            elementsCombinations.add(thingCombination);
        }
        return elementsCombinations;
    }

    /**
     *
     * This method is used for finding thing combinations with max cost in the
     * list of thing combinations
     *
     * @param testCase The case for the list of things
     * @param listComb The relevant list of things
     * @return
     */
    private static ThingCombination findMaxCostCombinationList(TestCase testCase,
            List<ThingCombination> listComb) {
        Double maxTotalCost = 0d;
        ThingCombination thingCombinationWithMaxCost = null;
        for (ThingCombination thingCombination : listComb) {
            // Checking if total weight of combination of things
            // is less than or equal to test case weight
            if (thingCombination.getTotalWeight() <= testCase.getWeight()
                    && maxTotalCost <= thingCombination.getTotalCost()) {
                maxTotalCost = thingCombination.getTotalCost();
                thingCombinationWithMaxCost = thingCombination;
                // Checking if thing combinations exist
                // with same price (cost) then update thingCombinationWithMaxCost
                for (ThingCombination thingCombi : listComb) {
                    if (!thingCombi.equals(thingCombination)
                            && thingCombi
                                    .getTotalCost()
                                    .equals(thingCombination.getTotalCost())
                            && thingCombi
                                    .getTotalWeight()
                            < thingCombination.getTotalWeight()) {
                        thingCombinationWithMaxCost = thingCombination;
                    }
                }
            }
        }
        return thingCombinationWithMaxCost;
    }

    /**
     *
     * This method is used to to create printable packages from the list of
     * cases
     *
     * @param caseList The cases from file
     * @return The list of combinations according to the requirements
     */
    public static List<ThingCombination> createPackageCases(List<TestCase> caseList) {
        List<ThingCombination> myPackageCases = new ArrayList();
        for (TestCase testCase : caseList) {
            // Here create combinations
            List<ThingCombination> comb = createCombinations(
                    caseList.indexOf(testCase),
                    testCase.getListOfThings());
            // Here filter thing combinations with max cost
            if (findMaxCostCombinationList(testCase, comb) != null) {
                myPackageCases.add(findMaxCostCombinationList(testCase, comb));
            }
        }
        return myPackageCases;
    }
}
