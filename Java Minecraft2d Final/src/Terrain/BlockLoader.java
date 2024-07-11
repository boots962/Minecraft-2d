package Terrain;

import java.awt.Graphics2D;

import engine.Window;

public class BlockLoader {
    
    public BlockLoader(Graphics2D g){
        int topCornerX =0;
        if(Window.xmoved%800 == 0){ //getnerates new Chunk if Steve moves 800 pixels (one chunk)
            Chunk.numberOfChunksLoadedOnScreen--;
        }
        while(Chunk.numberOfChunksLoadedOnScreen <4){ //generates four chunks
        if(Chunk.numberOfChunksLoadedOnScreen>1){
        topCornerX = (Chunk.numberOfChunksLoadedOnScreen)*50;
        }

        GrassBlock.placeBlock(g, topCornerX);
        DirtBlock.placeBlock(g, topCornerX);
        StoneBlock.placeBlock(g, topCornerX);
        Chunk.numberOfChunksLoadedOnScreen++;
        }
    }
}
