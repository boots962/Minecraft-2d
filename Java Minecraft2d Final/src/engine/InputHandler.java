package engine;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class InputHandler implements KeyListener, MouseListener, FocusListener, MouseMotionListener{
    public static int walkSpeed = 3;
    public static boolean F3 = false;
    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void focusGained(FocusEvent e) {
    }

    @Override
    public void focusLost(FocusEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
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
        switch(key){
            
            case KeyEvent.VK_A:
                Window.xmoved+= walkSpeed;
                break;
            case KeyEvent.VK_D:
                Window.xmoved-= walkSpeed;
                break;
            case KeyEvent.VK_F3:
                F3 = !F3;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
