package com.surge.pfactory.game.objects;

import java.util.LinkedList;

public class TechTreeElement {
    
    public LinkedList<TechTreeElement> precursors;
    public LinkedList<TechTreeElement> unlocks;

    public String name, desc;
    public int cost;

    public TechTreeElement(String name, String desc, int rpCost) {
        this.name = name;
        this.desc = desc;
        this.cost = rpCost;
    }

    public void setPrecursors(TechTreeElement[] precursors) {

    }

}
