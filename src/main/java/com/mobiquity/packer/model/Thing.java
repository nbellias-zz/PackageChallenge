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
public class Thing {

    private Long index;
    private Double weight;
    private Double cost;

    public Thing() {
    }

    public Thing(Long index, Double weight, Double cost) {
        this.index = index;
        this.weight = weight;
        this.cost = cost;
    }

    public Long getIndex() {
        return index;
    }

    public void setIndex(Long index) {
        this.index = index;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Thing{"
                + "index="
                + index
                + ", weight="
                + weight
                + ", cost="
                + cost
                + '}';
    }

}
