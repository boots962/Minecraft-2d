package Terrain;

import java.awt.Graphics2D;
import engine.Window;
import res.textures.Textures;
import steve.Steve;

public class DirtBlock {
    public static boolean mineable = true, flammable = false, solid = true;
    
    public static void placeBlock(Graphics2D g, int startX) {
        int startBlock = startX / 50;
        int endBlock = startBlock + 16;

        for (int i = startBlock-(BlockLoader.chunkstoGen*16); i < endBlock+ (BlockLoader.chunkstoGen*16); i++) {
            if((i*50)+Window.xmoved>=1200 || (i*50)+Window.xmoved<=0){
                continue;
            }
            for (int j = 0; j < 3; j++) {
                
                int mult = ((int) Math.abs((((Perlin.func(i)) * 50) + 49) / 50 * 50)) / 10;
                int y = (mult * 50) + 50 + (50 * j) + 100;
                int x = (i * 50) + Window.xmoved;
                    
             
            //     int caveY = ((int) Math.abs((((Perlin.caveFunc(i)) * 50) + 49) / 50 * 50)) / 10;
            //    caveY=((caveY * 50) + 50 + (50 * j) + 100);
                if (x >= 0 && x <= 1200 ) {
                    g.drawImage(Textures.dirt, x, y, null);
                }
            }
        }
        String chunkID = ""; //chunkID
        chunkID = "x-d"+ Steve.getSteveChunkNum(Steve.getStevex());

         if(!Chunk.chunkInfo(chunkID) && -Window.xmoved/50 !=1){ //checks if chunk has alr been accessed 
            BlockLoader.addBlocks(3, "MINECRAFT:DIRT_BLOCK", 0);
    }
    }
}
