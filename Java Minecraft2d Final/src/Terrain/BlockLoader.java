package Terrain;

import java.awt.Graphics2D;

import engine.Window;

public class BlockLoader {
    
    static int maxChunks = 4;
    static int chunkWidth = 16; // Width of each chunk in blocks
    static int chunkSize = chunkWidth * 50; // Width of each chunk in pixels
    static int topCornerX = 0;
    static int prevXmoved = 0;
    static int chunkstoGen = 0, tempMoved = 0;


    public static void Loader(Graphics2D g) {
        // Calculate startX based on chunkstoGen
        int startX = topCornerX * chunkSize;

        // Check if a new chunk needs to be added based on player movement
        if (Math.abs(Window.xmoved - prevXmoved) >= 800) {
            int movement = Math.abs(Window.xmoved - prevXmoved);
            chunkstoGen += movement / 800;
            prevXmoved = -Window.xmoved; // Update prevXmoved
        }

        // Render the chunks
        for (int i = 0; i < maxChunks; i++) {
            int currentChunkX = startX + i * chunkSize;

            GrassBlock.placeBlock(g, currentChunkX);
            DirtBlock.placeBlock(g, currentChunkX);
            StoneBlock.placeBlock(g, currentChunkX);
        }

        // Optionally, render chunk outlines for debugging
        // g.setColor(Color.red);
        // g.drawRect(topCornerX * 50 + Window.xmoved, 0, (topCornerX + 16) * 50 + Window.xmoved, 720);
    }
}
