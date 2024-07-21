package Terrain;

import java.util.Random;

import engine.worldFile;

public class Perlin {
    static Random rd = new Random();
    static int ran = rd.nextInt(1,5000);
        
    //class generates all randomized terrain and structure information using perlin noise
    //perlin noise is the same terrain generation strategy which notch used for minecraft
    //it is a non-periodical function as it is never the exact same 

    //math for terrain generation
    public static double func(int x){
        return Math.sin((1/Math.log10(worldFile.seed/ran))*x + worldFile.seed) + Math.sin(Math.PI * x);
    }
                            
    public static double caveFunc(int x){
        return Math.atan(x) + Math.sin(0.2*x);
    }
}
