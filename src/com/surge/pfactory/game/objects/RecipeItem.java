package com.surge.pfactory.game.objects;

public class RecipeItem {
    
    public Item[] inputs;
    public Item[] outputs;
    public Building[] compatibleBuildings;
    public double buildTime;

    public RecipeItem(Item[] inputs, Item[] outputs, Building[] compatibleBuildings, double buildTime) {
        this.inputs = inputs;
        this.outputs = outputs;
        this.compatibleBuildings = compatibleBuildings;
        this.buildTime = buildTime;
    }

}
