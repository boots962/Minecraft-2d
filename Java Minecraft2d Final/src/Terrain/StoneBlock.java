package Terrain;

import java.awt.Graphics2D;
import java.util.Random;

import engine.Window;
import engine.worldFile;
import res.textures.Textures;
import steve.Steve;
import java.util.HashMap;

public class StoneBlock {
    public static boolean mineable = true, flammable = false, solid = true;
    private static Random rd = new Random(); //to set random so then iron_blocks will be able to randomly replace the stone blocks
    public static HashMap<Integer, Integer> ironLoc = new HashMap<>();
    public static HashMap<Integer, String> irondir = new HashMap<>();
    public static HashMap<Integer, Integer> ironVeinSize = new HashMap<>();
    public static void placeBlock(Graphics2D g, int startX) {
        Boolean firstRender = false;
        String chunkID = ""; //chunkID
        chunkID = "x-s"+ Steve.getSteveChunkNum(Steve.getStevex());

         if(!Chunk.chunkInfo(chunkID) && -Window.xmoved/50 !=1){ //checks if chunk has alr been accessed 
            firstRender = true;
            BlockLoader.makeRandom(rd,Steve.getSteveChunkNum(Steve.getStevex()));
            worldFile.isIron();
            BlockLoader.addBlocks(13, "MINECRAFT:STONE_BLOCK", 150, "s");
    }   


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
                // if(x >= 0 && x <= 1200 && y<720 && worldFile.isIron(Steve.getSteveChunkNum(Steve.getStevex()), x, y)){
                //     System.out.println("Showing iron");
                //     g.drawImage(Textures.iron, x, y, null);
                // }
                if(x >= 0 && x <= 1200 && y<720 && ironLoc.size()>1 && ironLoc.get(x-Window.xmoved)!=null){
                    if(ironLoc.get(x-Window.xmoved)==y){
                    g.drawImage(Textures.iron, x, y, null);
                    
                    continue;
                    }
                }
                if (x >= 0 && x <= 1200 && y<720) {

                    g.drawImage(Textures.stone, x, y, null);
                }
            }
        }

       
    }
    }
