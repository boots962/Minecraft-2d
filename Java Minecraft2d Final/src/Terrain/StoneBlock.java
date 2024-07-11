package Terrain;

import java.awt.Color;
import java.awt.Graphics2D;

import engine.Window;
import engine.worldFile;
import res.textures.Textures;

public class StoneBlock {
     public static boolean mineable = true, flammable = false, solid = true;
    
    public static void placeBlock(Graphics2D g, int topCornerX){
        for(int i = 0; i<16; i++){
            for(int j = 0; j<13; j++){
            int mult =((int) Math.abs((((Perlin.func(i))*50)+49)/50 * 50))/10;
            int y=(mult*50)+ (50*j) + 300;
            g.setColor(Color.GREEN);
            int x = (i*50) + Window.xmoved + topCornerX;
            g.drawImage(Textures.stone, x, y, null);
           
            if(Window.renderedTimes ==0){
                worldFile.blockLocation(i*50, y, "STONE_BLOCK", mineable, solid, flammable);
            }
        }
        }
    }
}
