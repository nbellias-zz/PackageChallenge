/*
 * Mobiquity INC
 * This is an Assignment Challenge
 * Written by Nikolaos Bellias
 *
 */
package com.mobiquity.packer.model;

/**
 *
 * @author nikolaos
 */
public class ThingCombination {

    private Integer caseItem;
    private String itemIndexes;
    private Double totalWeight;
    private Double totalCost;

    public ThingCombination() {
    }

    public ThingCombination(Integer caseItem,
            String itemIndexes,
            Double totalWeight,
            Double totalCost) {
        this.caseItem = caseItem;
        this.itemIndexes = itemIndexes;
        this.totalWeight = totalWeight;
        this.totalCost = totalCost;
    }

    public Integer getCaseItem() {
        return caseItem;
    }

    public void setCaseItem(Integer caseItem) {
        this.caseItem = caseItem;
    }

    public String getItemIndexes() {
        return itemIndexes;
    }

    public void setItemIndexes(String itemIndexes) {
        this.itemIndexes = itemIndexes;
    }

    public Double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(Double totalWeight) {
        this.totalWeight = totalWeight;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return itemIndexes;
    }

}
