package Terrain;

import java.awt.Color;
import java.awt.Graphics2D;

import engine.Window;

public class BlockLoader {
    
    static int maxChunks = 4, topCornerX = 0, prevXmoved = 0, chunkstoGen = 0;
    public static void Loader(Graphics2D g){
         int chunksLoaded = 0,prev=0, newx=4;
         int StartX = ((3*16)*50);
 
         // Check if a new chunk needs to be added based on player movement
         if (Math.abs(Window.xmoved - prevXmoved) >= 800) {
             int movement = Math.abs(Window.xmoved - prevXmoved);
             int additionalChunks = movement / 800;
             chunkstoGen += additionalChunks;
             prevXmoved += additionalChunks * 800; // Update prevXmoved to account for all added chunks
         }
         while(prev<newx){
            GrassBlock.placeBlock(g, prev, chunksLoaded);
            DirtBlock.placeBlock(g, prev, chunksLoaded);
            StoneBlock.placeBlock(g, prev, chunksLoaded);
            GrassBlock.newChunks(g, StartX);
            DirtBlock.newChunks(g, StartX);
            StoneBlock.newChunks(g, StartX);
            prev++;
         }


        //if it is 800 it means a new chunk is needed
        //if a new chunk is needed we need to find the direction the chunk has to be
        //to find direction we need to know if starting xmoved is less than or greater than the previous time a chunk was needed
        //ex) if new chunk is needed when xmoved is -1600, and the previous time was -800, this means the player
        //is moving further into the negatives and a chunk is needed on the negative side,
        //in contrary if the previous time was -1600 but this time it is -800 this means a chunk is needed in the positive direction
        //if the chunk has already been loaded it needs to get the block locations and other information from the worldfile

        
        // g.setColor(Color.red); //for chunk outlines
        // g.drawRect(topCornerX*50 + Window.xmoved, 0, (topCornerX+16)*50 + Window.xmoved, 720);
        
        
        
    }
}
