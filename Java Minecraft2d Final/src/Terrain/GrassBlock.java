package Terrain;

import java.awt.Color;
import java.awt.Graphics2D;

import engine.Window;
import engine.worldFile;
import res.textures.Textures;

public class GrassBlock {
    public static boolean mineable = true, flammable = false, solid = true;
    
    public static void placeBlock(Graphics2D g, int topCornerX, int chunksLoaded){
        for(int i = chunksLoaded; i<16*topCornerX; i++){
            int mult =((int) Math.abs((((Perlin.func(i))*50)+49)/50 * 50))/10;
            int y=(mult*50) +100;
            g.setColor(Color.GREEN);
            int x = (i*50) + Window.xmoved;
            if(x>=0 && x<=1200) g.drawImage(Textures.grass, x, y, null);
           
            if(Window.renderedTimes ==0){
                worldFile.blockLocation(i*50, y, "GRASS_BLOCK", mineable, solid, flammable);
            }
        }
    }
    static int timesLoaded =0;
    public static void newChunks(Graphics2D g, int startX){
        for(int i = 0; i<BlockLoader.chunkstoGen; i++){
        for(int j = 0; j<16; j++){
            int funcX =(startX/50)+j;
                
            int mult =((int) Math.abs((((Perlin.func(funcX))*50)+49)/50 * 50))/10;
                
                int y=(mult*50) +100;
                g.setColor(Color.GREEN);
                int x = (j*50) + startX + Window.xmoved;
                if(x>=0 && x<=1200) g.drawImage(Textures.grass, x, y, null);
                if(timesLoaded ==0){
                    worldFile.blockLocation(j*50, y, "GRASS_BLOCK", mineable, solid, flammable);
                }

            
        }
    }
    timesLoaded++;
    }

}
