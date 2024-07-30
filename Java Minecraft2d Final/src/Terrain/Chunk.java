package Terrain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import engine.Window;
import engine.worldFile;
import steve.Steve;

public class Chunk {
    public static int chunkSize = 16, numberOfChunksLoadedOnScreen = 0;

    public static String getChunkID(){ //generates and sets the chunkID for any new chunk added into the game
        File chunkFile = new File("Java Minecraft2d Final\\src\\Saves\\" + worldFile.worldFolder + "\\chunks.txt");
        String data = "";
        try {
            Scanner read = new Scanner(chunkFile);
            while(read.hasNextLine()){
                data = read.nextLine();
                if(data.contains(""+Steve.getSteveChunkNum(Steve.getStevex()+2)*16)){ //we are checking if the chunk has alr been loaded before writing the chunks info to file
                    return data;
                }
            }
            read.close();
        } catch (FileNotFoundException e) {
        }
        return null;
    }


}
