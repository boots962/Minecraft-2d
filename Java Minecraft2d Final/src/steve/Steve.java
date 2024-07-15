package steve;

import Terrain.Chunk;
import Terrain.GrassBlock;
import engine.Window;
import engine.worldFile;

public class Steve {
    public static int Stevex = -Window.xmoved/50, steveChunknum = 0;


    public static void getStevex(){
    
    }
    public static void getStevey(){
        System.out.println(worldFile.getXy(Stevex, null));
    }
    public static void renderSteve(){
        getStevey();
    }
    public static int getSteveChunkNum(int x){
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
