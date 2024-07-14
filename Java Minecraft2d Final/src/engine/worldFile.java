package engine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class worldFile {
    private static String worldFolder = "";
    public static int seed;

    public static void createDir(){ //creates the directory and the info file 
        String data = "";
        File numworld = new File("Java Minecraft2d Final\\src\\num2y");
        try{
            Scanner read = new Scanner(numworld);
            while(read.hasNextLine()){
                data = read.nextLine();
            }
            worldFolder = "New World" + data;
            File saves = new File("Java Minecraft2d Final\\src\\Saves\\" + worldFolder);
            saves.mkdir();
            
            File info = new File("Java Minecraft2d Final\\src\\Saves\\" + worldFolder + "\\Info.txt");
            FileWriter infoWriter = new FileWriter(info, true);
            FileWriter num = new FileWriter(numworld, true);
            num.append("1");
            
            Random se = new Random();
            seed = se.nextInt(1000000000); //generates seed

            infoWriter.append("Seed: " + seed);
            infoWriter.append("Update: " + Window.worldVersion);
            infoWriter.append("Difficulty: " + Window.difficulty);

            num.close();
            infoWriter.close();
            read.close();

        }catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static boolean chunkInfo(String chunkID){
        File chunkFile = new File("Java Minecraft2d Final\\src\\Saves\\" + worldFolder + "\\chunks.txt");
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

}
