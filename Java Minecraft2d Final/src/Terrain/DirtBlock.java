package Terrain;

import java.awt.Graphics2D;
import engine.Window;
import engine.worldFile;
import res.textures.Textures;

public class DirtBlock {
    public static boolean mineable = true, flammable = false, solid = true;
    
    public static void placeBlock(Graphics2D g, int startX) {
        int startBlock = startX / 50;
        int endBlock = startBlock + 16;

        for (int i = startBlock-BlockLoader.chunkstoGen; i < endBlock + BlockLoader.chunkstoGen; i++) {
            for (int j = 0; j < 3; j++) {
                
                int mult = ((int) Math.abs((((Perlin.func(i)) * 50) + 49) / 50 * 50)) / 10;
                int y = (mult * 50) + 50 + (50 * j) + 100;
                int x = (i * 50) + Window.xmoved;
                int caveY = ((int) Math.abs((((Perlin.caveFunc(i)) * 50) + 49) / 50 * 50)) / 10;
               caveY=((caveY * 50) + 50 + (50 * j) + 100);
                if (x >= 0 && x <= 1200 && y!=caveY) {
                    g.drawImage(Textures.dirt, x, y, null);
                }
            }
        }
    }
}
