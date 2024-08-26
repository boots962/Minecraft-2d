package Terrain;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

import engine.InputHandler;
import engine.Window;
import engine.worldFile;
import steve.Steve;

public class BlockLoader {
    
    static int maxChunks = 3;
    static int chunkWidth = 16; // Width of each chunk in blocks
    static int chunkSize = chunkWidth * 50; // Width of each chunk in pixels
    static int topCornerX = 0;
    static int prevXmoved = 0;
    static int chunkstoGen = 1, tempMoved = 0;


    public static void Loader(Graphics2D g) {
        // Calculate startX based on chunkstoGen
        int startX = topCornerX * chunkSize;

        // Check if a new chunk needs to be added based on player movement
        if (Window.xmoved%400 == 0 && Window.xmoved!=0) {
            int movement = Math.abs(Window.xmoved);
            chunkstoGen += movement / 800;
            prevXmoved = -Window.xmoved; // Update prevXmoved
        }

        // Render the chunks
        for (int i = 0; i < maxChunks; i++) {
            int currentChunkX = startX + i * chunkSize;

            GrassBlock.placeBlock(g, currentChunkX);
            DirtBlock.placeBlock(g, currentChunkX);
            StoneBlock.placeBlock(g, currentChunkX);
            if(InputHandler.chunkBorders){
            g.setColor(Color.red);
            g.drawRect((currentChunkX)+ Window.xmoved, 0, 50*16, 720);
            }
        }

        // render chunk outlines for debugging
       
    }

    public static void addBlocks(int depth, String blockType, int ymod, String id){
        for (int u = Steve.getSteveChunkNum(Steve.getStevex())*16; u <= (Steve.getSteveChunkNum(Steve.getStevex())*16+16); u++){
                    int o = 0;
                    while(o < depth){
                    int mult1 = ((int) Math.abs((((Perlin.func(u)) * 50) + 49) / 50 * 50)) / 10;
                    // int y = (mult * 50) + (50 * j) + 300;
                    int y1 = (mult1 * 50) + 50 + (50 * u) + (100)+ymod;
                    int x1 = (u * 50);
                    if(x1 > 800 || x1==800&&u==Steve.getSteveChunkNum(Steve.getStevex())*16){
                        int temp = x1/800;
                        x1 -= (temp*800);
                    }
                    Chunk.chunkBlocks(x1, y1, blockType, id); //to save the blocks location and type of block
                    o++;
                    }
                }
    }
    private static Random veinNum = new Random();
    private static int numVeins = veinNum.nextInt(10);
    private static Random direction = new Random();
    private static Random y2 = new Random();
    public static Random size = new Random();

    public static void makeRandom(Random x1, int ChunkId) {
        int start = 0;

        while(start<numVeins){
        int Unx = x1.nextInt(chunkSize);
        int Uny = y2.nextInt(720 + 300) -300;
        int Direction = direction.nextInt(2);
        int size = direction.nextInt(4);
        
        int x = (Unx/50)*50;
        int y = (Uny/50)*50;

        String dir = "";

        if(Direction == 1){
            dir = "LEFT";
        }
        else{
            dir = "RIGHT";
        }

        worldFile.writeRandom(ChunkId, x, y, dir, size);
        start++;
    }
    }
}
