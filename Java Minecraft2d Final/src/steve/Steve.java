package steve;

import java.awt.Graphics2D;

import Terrain.Chunk;
import Terrain.GrassBlock;
import engine.Window;
import engine.worldFile;
import res.textures.Textures;

public class Steve {
    public static int Stevex = -Window.xmoved/50, steveChunknum = 0, Stevey = 0;
    public static String blockType_Standing = "";

    public static int getStevey(){
        
        System.out.println(worldFile.getXy(Stevex, Chunk.getChunkID()));
        String [] info = worldFile.getXy(Stevex, Chunk.getChunkID()).split("//");
        Stevey = Integer.parseInt(info[0]);
        blockType_Standing = info[1];
        return Stevey;
    }
    public static void renderSteve(Graphics2D g){
        getStevey();
        // int actualY = getStevey()-Textures.steve.getHeight();
        // g.drawImage(Textures.steve, Stevex+50, actualY, null);
        // int steveHeady = actualY-Textures.steveHead.getHeight();
        // g.drawImage(Textures.steveHead, Stevex+50, steveHeady, null);
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
