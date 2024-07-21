package Hud;

import java.awt.Color;
import java.awt.Graphics2D;

import steve.Steve;

public class F3Men {
    
    public static void renderF3(Graphics2D g, double fps, int x, int y, int chunkNum, String chunkID, String version){
        g.setColor(new Color(99, 107, 120));
        g.drawRect(0, 0, 150, 100);
        g.setColor(Color.white);
        g.drawString("Game version: " + version, 5, 10);
        g.drawString("X/" + x + "/Y/" + y, 5, 25);
        g.drawString("FPS/"+fps, 5, 40 );
        g.drawString("CHUNKID:"+chunkID + "/N:" + chunkNum, 5, 55);
        g.drawString("BLOCK_TYPE_STANDING:"+Steve.blockType_Standing, 5, 70);
    } 
}
