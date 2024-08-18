package steve;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import Terrain.Chunk;
import engine.InputHandler;
import engine.Window;
import engine.worldFile;
import res.textures.Textures;


public class Steve {
    public static int steveChunknum = 0, deltay = 0;
    public static String blockType_Standing = getBlockType();
    private static boolean isJumping = false;
    private static int jumpStartY = 0;

    public static int getStevex(){
        return (-Window.xmoved/50) +2;
    }
    public static int getStevey(){
        return Integer.parseInt(worldFile.getXy(getStevex(), Chunk.getChunkID()));
    }
    public static void jump() {
        if (!isJumping && deltay == 0) { // Only jump if Steve is not already jumping
            isJumping = true;
            jumpStartY = getStevey(); // Record the Y position at the start of the jump
        }
    }
    public static void renderSteve(Graphics2D g){

        int actualY = getStevey()-Textures.steve.getHeight();

        if (isJumping) {
            actualY -= InputHandler.jumpheight - deltay;
            if (deltay < InputHandler.jumpheight) {
                deltay += 1; // Controls jump speed, adjust as necessary
            } else {
                isJumping = false;
                deltay = 0;
            }
        } else {
            if (deltay > 0) {
                actualY += deltay;
                deltay -= 2; // Controls fall speed, adjust as necessary
            }
        }
        g.drawImage(Textures.steve, getStevex()+75, actualY, null);
        int steveHeady = actualY-Textures.steveHead.getHeight();
        
        double theta = Math.atan2((InputHandler.mousey - steveHeady), (InputHandler.mousex - getStevex() + 100));
        AffineTransform originalTransform = g.getTransform();
        int headmoveback = 0;
        if(theta<-0.4){
            headmoveback=-10;
        }else{
            headmoveback=0;
        }
        int headCenterX = getStevex() + 75 + Textures.steveHead.getWidth() / 2;
        int headCenterY = steveHeady + Textures.steveHead.getHeight() / 2;
        g.rotate(theta, headCenterX, headCenterY); // Rotate around the center of the head
        g.drawImage(Textures.steveHead, getStevex() + 75+headmoveback , steveHeady, null);
        g.setTransform(originalTransform);
    
    }

    public static String getBlockType(){
        return worldFile.getBlockType(getSteveChunkNum(getStevex()), getStevex(), getStevey());
    }
    public static int getSteveChunkNum(int x){ //gets the chunk N
        if(x%16==0){
            steveChunknum = x/16;
            return steveChunknum;
        }
        int temp = 0;
        for(int i = x; i%16!=0; i--){
            temp++;
        }
        steveChunknum = (x-temp)/16;
        return steveChunknum;
    }
}
