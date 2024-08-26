package engine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import Hud.F3Men;
import Terrain.StoneBlock;
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

    public static void writeRandom(int chunknum, int x, int y, String dir, int size){
        try {
            FileWriter fw = new FileWriter(getVeinFile(), true);
            fw.append("\n");
            fw.append(chunknum + "%" + x + "%" + y + "%"+dir+"%"+size);
            
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    public static void isIron(){
        
        try {
            Scanner reader = new Scanner(getVeinFile());
            while(reader.hasNextLine()){
                
                String[]parts = reader.nextLine().split("%");
                if(parts.length>1) StoneBlock.ironLoc.put(Integer.parseInt(parts[1])-Window.xmoved, Integer.parseInt(parts[2]));
                
            }
            reader.close();
        } catch (FileNotFoundException e) {
        }
        
    }
    public static File getVeinFile(){
        return new File("Java Minecraft2d Final\\src\\Saves\\" + worldFolder + "\\veins.txt");
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
                    read.close();
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
                if(!parts[0].equals(String.valueOf(Steve.getSteveChunkNum(Steve.getStevex())))){continue;}
                if(parts[0].equals(String.valueOf(Steve.getSteveChunkNum(Steve.getStevex()))) && parts[1].equals(String.valueOf(worldFile.tempMoved))){
                    
                    prevx = Integer.toString(tempMoved);
                    if(tempMoved>=100 && prevy!="" && Integer.parseInt(prevy) - Integer.parseInt(parts[2])>= 100 ){
                        System.out.println(Integer.parseInt(prevy) + " " + Integer.parseInt(parts[2]));
                        if(F3Men.direction.equals("North")) InputHandler.rightFlag = false;
                        if(F3Men.direction.equals("South")) InputHandler.leftFlag = false;
                        parts[2] = prevy;
                        
                    }
                    if(F3Men.direction.equals("South")&&InputHandler.rightFlag == false ){
                        InputHandler.rightFlag = true;
                    }
                    if(F3Men.direction.equals("North")&&InputHandler.leftFlag == false ){
                        InputHandler.leftFlag = true;
                    }
                    prevy = parts[2];
                    read.close();
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
                    Steve.blockType_Standing = parts[3];
                    reader.close();
                    return parts[3];
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static int prevxx = 0, prevyy = 0;
    public static String getBlockTypeLookingAt(int x, int y){
        x*=50;
        

        String data = "";
       
        try {
            Scanner reader = new Scanner(getChunkFile());
            while(reader.hasNextLine()){
                
                data = reader.nextLine();
                String [] parts = data.split("%");
                System.out.println(parts.length);
                if(parts[1].equals(String.valueOf(x)) && parts[2].equals(String.valueOf(y))){
                    prevxx = x;
                    prevyy = y;
                    Steve.block_Looking = parts[3];
                    reader.close();
                    return parts[3];
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
        }

        return "MINECRAFT:AIR";
    }

}
