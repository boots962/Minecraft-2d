package Terrain;

import engine.worldFile;

public class Perlin {

    public static double func(int x){
        return Math.sin(0.2*x + worldFile.seed) + Math.sin(Math.PI * x);
    }
}
