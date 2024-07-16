package Terrain;

import java.util.Random;

import engine.worldFile;

public class Perlin {
    static Random rd = new Random();
    static int ran = rd.nextInt(1,5000);
        
    //math for terrain generation
    public static double func(int x){
        
        return Math.sin((1/Math.log10(worldFile.seed/ran))*x + worldFile.seed) + Math.sin(Math.PI * x);
    }
                            
    public static double caveFunc(int x){
        return Math.atan(x) + Math.sin(0.2*x);
    }
}
