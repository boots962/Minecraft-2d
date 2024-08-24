package engine;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import Hud.F3Men;
import steve.Steve;
import steve.soundFX;


public class InputHandler implements KeyListener, MouseListener, FocusListener, MouseMotionListener{
    public static int walkSpeed = 4, mousex, mousey, mouseClickedx, mouseClickedy, blocksMined = 0, jumpheight = 75;
    public static boolean F3 = false, iswalking = false, rightFlag = true, leftFlag = true, chunkBorders = false;;
    public static boolean keys[] = new boolean[68836];
    
    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mousex = e.getX();
        mousey=e.getY();
    }

    @Override
    public void focusGained(FocusEvent e) {
    }

    @Override
    public void focusLost(FocusEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int button = e.getButton();
        switch (button) {
            case MouseEvent.BUTTON1:
               
                mouseClickedx = e.getX();
                mouseClickedy = e.getY();
                break;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
          if(key > 0 && key < keys.length){
            keys[key] = true;
          }
        
        if(key==KeyEvent.VK_SPACE){
            Steve.jump();
            iswalking = true;
        }
        if(key==KeyEvent.VK_A){
            if(!leftFlag){}
            else{
            if(!soundFX.clipRunning()){
                soundFX.startFx();;
                soundFX.playClip();
            }
            Window.xmoved+= walkSpeed;
            F3Men.direction = "South";
            iswalking = true;
        }
        }
        if(key==KeyEvent.VK_D){
            if(!rightFlag){}
            else{
             if(!soundFX.clipRunning()){
                soundFX.startFx();;
            soundFX.playClip();
             }
            Window.xmoved-= walkSpeed;
            F3Men.direction = "North";
            iswalking = true;
            }
            }
            if(keys[KeyEvent.VK_SPACE] && keys[KeyEvent.VK_D]){
                Steve.jump();
                if(!rightFlag){}
            else{
             if(!soundFX.clipRunning()){
                soundFX.startFx();;
            soundFX.playClip();
             }
            Window.xmoved-= walkSpeed;
            F3Men.direction = "North";
            iswalking = true;
            }
            }
        if(keys[KeyEvent.VK_F3] && keys[KeyEvent.VK_H]){
             chunkBorders = !chunkBorders;
         }
        if(key == KeyEvent.VK_F3){
            F3 = !F3;
            
        }
    }

    
        
    @Override
    public void keyReleased(KeyEvent e) {
        for(int i = 0; i<keys.length; i++){
            keys[i] = false;
        }

    }
    
}
