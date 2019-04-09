/*
 * Mobiquity INC
 * This is an Assignment Challenge
 * Written by Nikolaos Bellias
 *
 */
package com.mobiquity.packer.model;

import java.util.List;

/**
 *
 * @author nikolaos
 */
public class TestCase {

    private Double weight;
    private List<Thing> listOfThings;

    public TestCase() {
    }

    public TestCase(Double weight, List<Thing> listOfThings) {
        this.weight = weight;
        this.listOfThings = listOfThings;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public List<Thing> getListOfThings() {
        return listOfThings;
    }

    public void setListOfThings(List<Thing> listOfThings) {
        this.listOfThings = listOfThings;
    }

    @Override
    public String toString() {
        return "MyPackage{"
                + "weight="
                + weight
                + ", listOfThings="
                + listOfThings
                + '}';
    }


}
