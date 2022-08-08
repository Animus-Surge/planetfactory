package com.surge.pfactory.engine.util;

public class EMath {
    
    public static int clamp(int value, int max, int min) {
        return Math.max(min, Math.min(value, max));
    }

}
