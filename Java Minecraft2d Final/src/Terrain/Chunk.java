package Terrain;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

import engine.Window;
import engine.worldFile;
import steve.Steve;

public class Chunk {
    public static int chunkSize = 16, numberOfChunksLoadedOnScreen = 0;
    public static boolean chunkInfo(String chunkID){
        
        File chunkFile = new File("Java Minecraft2d Final\\src\\Saves\\" + worldFile.worldFolder + "\\chunks.txt");
        String data = "";
        try {
            Scanner read = new Scanner(chunkFile);
            while(read.hasNextLine()){
                data = read.nextLine();
                if(data.equals(chunkID)){ //we are checking if the chunk has alr been loaded before writing the chunks info to file
                    return true;
                }
                
            }
            read.close();
        } catch (FileNotFoundException e) {
        }
        
        try {
            FileWriter writer = new FileWriter(chunkFile, true);
            writer.append(chunkID); //assums the chunk has not been loaded so it will input the chunkID into the file
            writer.append("\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void chunkBlocks(int x, int y, String BLOCK_TYPE){
       
        File chunkFile = new File("Java Minecraft2d Final\\src\\Saves\\" + worldFile.worldFolder + "\\chunks.txt");
        
        try {
            FileWriter writer = new FileWriter(chunkFile, true);
            String id = "";
            if(BLOCK_TYPE.equals("MINECRAFT:DIRT_BLOCK")) id="d";

            writer.append(Steve.getSteveChunkNum(Steve.getStevex())+id+ "%" + x + "%" + y + "%" + BLOCK_TYPE); //assums the chunk has not been loaded so it will input the chunkID into the file
            writer.append("\n");
            writer.close();
        } catch (IOException e) {
           
        }
    
    }
    public static String getChunkID(){ //generates and sets the chunkID for any new chunk added into the game
        File chunkFile = new File("Java Minecraft2d Final\\src\\Saves\\" + worldFile.worldFolder + "\\chunks.txt");
        String data = "";
        try {
            Scanner read = new Scanner(chunkFile);
            while(read.hasNextLine()){
                data = read.nextLine(); 
                if(data.contains(""+Steve.getSteveChunkNum((-Window.xmoved/50)+2)*16)){ //we are checking if the chunk has alr been loaded before writing the chunks info to file
                    return data;
                }
            }
            read.close();
        } catch (FileNotFoundException e) {
        }
        return null;
    }


}
