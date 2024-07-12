package Terrain;

import java.awt.Graphics2D;
import engine.Window;
import engine.worldFile;
import res.textures.Textures;

public class GrassBlock {
    public static boolean mineable = true, flammable = false, solid = true;
    
    public static void placeBlock(Graphics2D g, int startX) {
        int startBlock = startX / 50;
        int endBlock = startBlock + 16;

        for (int i = startBlock; i < endBlock; i++) {
            int mult = ((int) Math.abs((((Perlin.func(i)) * 50) + 49) / 50 * 50)) / 10;
            int y = (mult * 50) + 100;
            int x = (i * 50) + Window.xmoved;

            if (x >= 0 && x <= 1200) {
                g.drawImage(Textures.grass, x, y, null);
                if (Window.renderedTimes == 0) {
                    worldFile.blockLocation(i * 50, y, "GRASS_BLOCK", mineable, solid, flammable);
                }
            }
        }
    }
}
