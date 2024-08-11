package Hud;

import java.awt.Color;
import java.awt.Graphics2D;

import engine.InputHandler;
import engine.Window;
import steve.Steve;

public class F3Men {
    public static String direction = "Standing still";
    public static void renderF3(Graphics2D g, double fps, int x, int y, int chunkNum, String chunkID, String version){
        g.setColor(new Color(99, 107, 120));
        g.drawRect(0, 0, 150, 100);
        g.setColor(Color.white);
        g.drawString("Game version: " + version, 5, 10);
        g.drawString("X/" + x + "/Y/" + y, 5, 25);
        g.drawString("FPS/"+fps, 5, 40 );
        g.drawString("CHUNKID:"+chunkID + "/N:" + chunkNum, 5, 55);
        g.drawString("BLOCK_TYPE_STANDING:"+Steve.blockType_Standing, 5, 70);
        g.drawString(direction, 1200, 10);
        g.drawString("Mouse Block x:" + ((InputHandler.mousex/50)-Window.xmoved/50) + "; Mouse Block y:" + ((InputHandler.mousey/50)+64), 1000, 25);
    } 
}
