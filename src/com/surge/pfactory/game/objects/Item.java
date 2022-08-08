package com.surge.pfactory.game.objects;

public class Item {
    
    public static final int RARITY_COMMON = 0;
    public static final int RARITY_UNCOMMON = 1;
    public static final int RARITY_RARE = 2;
    public static final int RARITY_SUPER_RARE = 3;
    public static final int RARITY_ULTRA_RARE = 4;

    public String name;
    public int stackSize;
    public int rarity;

    public Item(String name, int stackSize, int rarity) {
        this.name = name;
        this.stackSize = stackSize;
        this.rarity = rarity;
    }

}
