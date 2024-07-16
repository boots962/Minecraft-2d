package Terrain;

import java.awt.Graphics2D;
import engine.Window;
import engine.worldFile;
import res.textures.Textures;
import steve.Steve;

public class GrassBlock {
    public static boolean mineable = true, flammable = false, solid = true;

    public static void placeBlock(Graphics2D g, int startX) {
        int startBlock = startX / 50;
        int endBlock = startBlock + 16;
        
        for (int i = startBlock-(BlockLoader.chunkstoGen*16); i < endBlock+ (BlockLoader.chunkstoGen*16); i++) {
            if((i*50)+Window.xmoved>=1200 || (i*50)+Window.xmoved<=0){
                continue;
            }
            int mult = ((int) Math.abs((((Perlin.func(i)) * 50) + 49) / 50 * 50)) / 10;
            int y = (mult * 50) + 100;
            int x = (i * 50) + Window.xmoved;

            String chunkID = ""; //chunkID
            if((Window.xmoved/50)%16==0){ //if first loop
                chunkID = "x-"+Window.xmoved/50;
            }
            if(!worldFile.chunkInfo(chunkID)){ //checks if chunk has alr been accessed 
                
                for (int j = Steve.getSteveChunkNum(-Window.xmoved/50)*16; j < (Steve.getSteveChunkNum(-Window.xmoved/50)*16+16); j++){
                    
                    int mult1 = ((int) Math.abs((((Perlin.func(j)) * 50) + 50) / 50 * 50)) / 10;
                    int y1 = (mult1 * 50) + 100;
                    int x1 = (j * 50) + Window.xmoved;
                   
                    worldFile.chunkBlocks(x1+Steve.getSteveChunkNum(-Window.xmoved/50), y1, "MINECRAFT:GRASS_BLOCK"); //to save the blocks location and type of block
                }

            }
            // int caveY = ((int) Math.abs((((Perlin.caveFunc(i)) * 50) + 49) / 50 * 50)) / 10;
            //    caveY=(caveY * 50) + 100;;
            if (x >= 0 && x <= 1200 ) {
                g.drawImage(Textures.grass, x, y, null);
            }
        }
    }
}
