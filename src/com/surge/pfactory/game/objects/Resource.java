package com.surge.pfactory.game.objects;

public class Resource {
    
    public Item resourceYield;
    public int amount;
    public int maxAmount; //-1 for no limit

    //Note no time, intended for use in buildings.

    public Resource(Item item, int amount, int max) {
        this.resourceYield = item;
        this.amount = amount;
        this.maxAmount = max;
    }

}
