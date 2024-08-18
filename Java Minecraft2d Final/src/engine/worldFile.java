package engine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import steve.Steve;

public class worldFile {
    public static String worldFolder = "";
    public static int seed;
    public static String prevx = "", prevy = "";
    
    
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
            FileWriter num = new FileWriter(numworld);
            int tempnum = Integer.parseInt(data);
            tempnum++;
            num.write(""+tempnum);
            
            Random se = new Random();
            seed = se.nextInt(1000000000); //generates seed

            infoWriter.append("Seed: " + seed);
            infoWriter.append("\n");
            infoWriter.append("Update: " + Window.worldVersion);
            infoWriter.append("\n");
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


    public static File getChunkFile(){
        return new File("Java Minecraft2d Final\\src\\Saves\\" + worldFolder + "\\chunks.txt");
    }
    public static int updownDistancemodifier = 100;
    public static int tempMoved = 0;
    public static String getXy(int x, String chunkID) {
        String data = "";
        try {
            Scanner read = new Scanner(getChunkFile());
            while (read.hasNextLine()) {
                
                tempMoved = (-Window.xmoved) - (Steve.getSteveChunkNum(Steve.getStevex()) * 800);
                tempMoved = ((tempMoved) / 50) * 50 + 100;
                if(Integer.toString(tempMoved).equals(prevx)){
                    return prevy;
                }
                if (tempMoved % 800 == 0 && tempMoved != 1) {
                    tempMoved = 0;
                }
                if(tempMoved > 800){
                    tempMoved = tempMoved-800;
                }
                data = read.nextLine();
                if(!data.contains("%")){
                    continue;
                }
                
                String [] parts = data.split("%");
                if(!parts[0].equals(String.valueOf(Steve.getSteveChunkNum((-Window.xmoved/50)+2)))){continue;}
                if(parts[0].equals(String.valueOf(Steve.getSteveChunkNum((-Window.xmoved/50)+2))) && parts[1].equals(String.valueOf(worldFile.tempMoved)) ){
                    
                    prevx = Integer.toString(tempMoved);
                    prevy = parts[2];
                    return parts[2];
                }
            }
            read.close();
        } catch (FileNotFoundException e) {
        
        }
        return "0"; // Return empty or error data if not found
    }
    private static int tempprevx = 0, tempprevy = 0;
    public static String getBlockType(int chunkNum, int x, int y){
        
        x = (x/50)*50;
        y = (y/50) *50;
        
        String data = "";
        if(tempprevx == x && tempprevy == y){
            return Steve.blockType_Standing;
        }
        try {
            Scanner reader = new Scanner(getChunkFile());
            while(reader.hasNextLine()){
                
                data = reader.nextLine();
                String [] parts = data.split("%");
                if(!parts[0].equals(String.valueOf(chunkNum))){continue;}
                if(parts[0].equals(String.valueOf(chunkNum)) && parts[1].equals(String.valueOf(tempMoved)) && parts[2].equals(String.valueOf(y))){
                    
                    tempprevx =x;
                    tempprevy = y;
                    return parts[3];
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }


}
