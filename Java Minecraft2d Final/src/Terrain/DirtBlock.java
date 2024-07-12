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

        for (int i = startBlock; i < endBlock; i++) {
            for (int j = 0; j < 3; j++) {
                int mult = ((int) Math.abs((((Perlin.func(i)) * 50) + 49) / 50 * 50)) / 10;
                int y = (mult * 50) + 50 + (50 * j) + 100;
                int x = (i * 50) + Window.xmoved;

                if (x >= 0 && x <= 1200) {
                    g.drawImage(Textures.dirt, x, y, null);
                    if (Window.renderedTimes == 0) {
                        worldFile.blockLocation(i * 50, y, "DIRT_BLOCK", mineable, solid, flammable);
                    }
                }
            }
        }
    }
}
