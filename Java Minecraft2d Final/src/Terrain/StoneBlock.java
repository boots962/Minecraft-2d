package Terrain;

import java.awt.Graphics2D;
import engine.Window;
import res.textures.Textures;

public class StoneBlock {
    public static boolean mineable = true, flammable = false, solid = true;
    
    public static void placeBlock(Graphics2D g, int startX) {
        int startBlock = startX / 50;
        int endBlock = startBlock + 16;

        for (int i = startBlock-(BlockLoader.chunkstoGen)*16; i < endBlock+ (BlockLoader.chunkstoGen*16); i++) {
            if((i*50)+Window.xmoved>=1200 || (i*50)+Window.xmoved<=0){
                continue;
            }
            for (int j = 0; j < 13; j++) {
                

                int mult = ((int) Math.abs((((Perlin.func(i)) * 50) + 49) / 50 * 50)) / 10;
                int y = (mult * 50) + (50 * j) + 300;
                int x = (i * 50) + Window.xmoved; //x variables
                
                

            //     int caveY = ((int) Math.abs((((Perlin.caveFunc(i)) * 50) + 49) / 50 * 50)) / 10;
            //    caveY=(caveY * 50) + (50 * j) + 300;; //cave generation

                if (x >= 0 && x <= 1200 && y<720) {
                    g.drawImage(Textures.stone, x, y, null);
                }
            }
        }
    }
}
