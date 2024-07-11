package Terrain;

import java.awt.Color;
import java.awt.Graphics2D;

import engine.Window;
import engine.worldFile;
import res.textures.Textures;

public class DirtBlock {
     public static boolean mineable = true, flammable = false, solid = true;
    
    public static void placeBlock(Graphics2D g, int topCornerX, int chunksLoaded){
        for(int i = chunksLoaded; i<16*topCornerX; i++){
            for(int j = 0; j<3; j++){
            int mult =((int) Math.abs((((Perlin.func(i))*50)+49)/50 * 50))/10;
            int y=(mult*50) + 50+ (50*j) + 100;
            g.setColor(Color.GREEN);
            int x = (i*50) + Window.xmoved;
            g.drawImage(Textures.dirt, x, y, null);
            if(Window.renderedTimes ==0){
                worldFile.blockLocation(i*50, y, "DIRT_BLOCK", mineable, solid, flammable);
            }
        }
        }
    }
    static int timesLoaded =0;
    public static void newChunks(Graphics2D g, int startX){
        for(int i = 0; i<BlockLoader.chunkstoGen; i++){
        for(int j = 0; j<16; j++){
            for(int k = 0; k<3; k++){
                
                int mult =((int) Math.abs((((Perlin.func(j))*50)+49)/50 * 50))/10;
                int y=(mult*50) + 50+ (50*k) + 100;
                g.setColor(Color.GREEN);
                int x = (j*50) + startX + Window.xmoved;
                g.drawImage(Textures.dirt, x, y, null);
                if(timesLoaded ==0){
                    worldFile.blockLocation(j*50, y, "DIRT_BLOCK", mineable, solid, flammable);
                }
            }
        }
    }
    }
}
