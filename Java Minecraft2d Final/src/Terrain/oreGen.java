package Terrain;

public class oreGen {
    
    public static void ironVein(String dir, int size, int x, int y){
        if(size==1){
            return;
        }
        if(size==2&&dir.equals("North")){
            StoneBlock.ironLoc.put(x+50, y);
            return;
        }
        if(size==2&&dir.equals("South")){
            StoneBlock.ironLoc.put(x-50, y);
            return;
        }
        if(size==3&&dir.equals("North")){
            StoneBlock.ironLoc.put(x+50, y);
            StoneBlock.ironLoc.put(x+50, y+50);
            return;
        }
        if(size==3&&dir.equals("South")){
            StoneBlock.ironLoc.put(x-50, y);
            StoneBlock.ironLoc.put(x-50, y+50);
            return;
        }
        if(size==4&&dir.equals("North")){
            StoneBlock.ironLoc.put(x+50, y);
            StoneBlock.ironLoc.put(x+50, y+50);
            StoneBlock.ironLoc.put(x, y+50);
            return;
        }
        if(size==4&&dir.equals("South")){
            StoneBlock.ironLoc.put(x-50, y);
            StoneBlock.ironLoc.put(x-50, y+50);
            StoneBlock.ironLoc.put(x, y+50);
            return;
        }
    }
}
