package Terrain;

import java.awt.Color;
import java.awt.Graphics2D;

import engine.Window;
import engine.worldFile;
import res.textures.Textures;

public class GrassBlock {
    public static boolean mineable = true, flammable = false, solid = true;
    
    public static void placeBlock(Graphics2D g){
        for(int i = 0; i<16; i++){
            int mult =((int) Math.abs((((Perlin.func(i))*50)+49)/50 * 50))/10;
            int y=(mult*50) +100;
            g.setColor(Color.GREEN);
            int x = (i*50) + Window.xmoved;
            g.drawImage(Textures.grass, x, y, null);
           
            if(Window.renderedTimes ==0){
                worldFile.blockLocation(i*50, y, "GRASS_BLOCK", mineable, solid, flammable);
            }
        }
    }

}
