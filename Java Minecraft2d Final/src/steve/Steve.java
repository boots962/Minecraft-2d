package steve;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import Terrain.Chunk;
import Terrain.GrassBlock;
import engine.InputHandler;
import engine.Window;
import engine.worldFile;
import res.textures.Textures;

import steve.MineBlock;

public class Steve {
    public static int steveChunknum = 0, Stevey = 0;
    public static String blockType_Standing = "";

    public static int getStevex(){
        return (-Window.xmoved/50) +2;
    }
    public static int getStevey(){
        String [] info = worldFile.getXy(getStevex(), Chunk.getChunkID()).split("//");
        Stevey = Integer.parseInt(info[0]);
        blockType_Standing = info[1];
        
        return Stevey;
    }
    
    public static void renderSteve(Graphics2D g){

        getStevey();
        int actualY = getStevey()-Textures.steve.getHeight();
        g.drawImage(Textures.steve, getStevex()+100, actualY, null);
        int overY = 0;
        int steveHeady = actualY-Textures.steveHead.getHeight();
        
        double theta = Math.atan2((InputHandler.mousey - steveHeady), (InputHandler.mousex - getStevex() + 100));
        AffineTransform originalTransform = g.getTransform();
        int headmoveback = 0;
        if(theta<-0.4){
            headmoveback=-10;
        }else{
            headmoveback=0;
        }
        int headCenterX = getStevex() + 100 + Textures.steveHead.getWidth() / 2;
        int headCenterY = steveHeady + Textures.steveHead.getHeight() / 2;
        g.rotate(theta, headCenterX, headCenterY); // Rotate around the center of the head
        g.drawImage(Textures.steveHead, getStevex() + 100+headmoveback , steveHeady, null);
        g.setTransform(originalTransform);
    
    }
    public static int getSteveChunkNum(int x){ //gets the chunk N
        if(x%16==0){
            steveChunknum = x/16;
            return steveChunknum;
        }
        int temp = 0;
        for(int i = x; i%16!=0; i--){
            temp++;
        }
        steveChunknum = (x-temp)/16;
        return steveChunknum;
    }
}
