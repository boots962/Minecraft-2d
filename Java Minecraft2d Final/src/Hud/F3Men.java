package Hud;

import java.awt.Color;
import java.awt.Graphics2D;

import engine.InputHandler;
import engine.Music;
import engine.Window;
import engine.dayNightChanger;
import steve.Steve;

public class F3Men {
    public static String direction = "Standing still";
    public static void renderF3(Graphics2D g, double fps, int x, int y, int chunkNum, String chunkID, String version){
        int mousex = ((InputHandler.mousex/50)-Window.xmoved/50), mousey = Math.abs(-(InputHandler.mousey/-50)-64);
        g.setColor(new Color(99, 107, 120));
        g.drawRect(0, 0, 150, 100);
        g.setColor(Color.white);
        g.drawString("Game version: " + version, 5, 10);
        g.drawString("X/" + x + "/Y/" + Math.abs(-(Steve.getStevey()/-50)-64), 5, 25);
        g.drawString("FPS/"+fps, 5, 40 );
        g.drawString("/N:" + chunkNum, 5, 55);
        g.drawString("BLOCK_TYPE_STANDING:"+Steve.getBlockType(), 5, 70);
        g.drawString(direction, 1200, 10);
        g.drawString("Mouse Block x:" + mousex + "; Mouse Block y:" + Math.abs(-(InputHandler.mousey/-50)-64), 1050, 25);
        g.drawString("Walking? " + InputHandler.iswalking, 1150, 40);
        g.drawString("Time: " + Math.round(dayNightChanger.time), 1150, 55);
        g.drawString("BLOCK_LOOKING_AT: "+ Steve.block_Looking, 1050, 70);
        g.drawString("Music?"+ Music.isPlaying(), 1150, 85);
        g.drawString("Song:--"+ Music.isPlaying(), 1050, 100);
    } 

} 
