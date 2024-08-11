package engine;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;


import javax.swing.JFrame;

import res.textures.Textures;


public class titlePage extends Canvas implements Runnable, MouseListener{
    private static Textures t;
    public static int Width = 800, Height = Width*9/16;
    public boolean running = false;
    private static JFrame frame;
    public static boolean cont = false;
    public static Rectangle create, load;

    public static void init(){
        t = new Textures();
        titlePage tp = new titlePage();
        frame = new JFrame("Minecraft2d");
        frame.setSize(Width, Height);
        frame.setDefaultCloseOperation(3);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.add(tp);
        frame.setVisible(true);
       
        tp.start();
    }
    public void start(){
        this.addMouseListener(this);
        Thread titlePage = new Thread(this, "title");
        titlePage.run();
    }
    
    public void run() {
        requestFocus();
        running = true;
        
        while(running){
            render();
        }
    }
   
    private void render(){

        BufferStrategy bs = this.getBufferStrategy();
      
        if(bs==null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics2D g = (Graphics2D)bs.getDrawGraphics();
       
        for(int i = 0; i<Width/50; i++){
            for(int j = 0; j<Height/50; j++){
                g.drawImage(t.dirt, i*50, j*50, null);
            }
        }
        
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.ITALIC, 25));
        g.drawString("MINECRAFT2D", 500, 100);
        
         create = new Rectangle(100, 90, 150, 50);
        g.setFont(new Font("Arial", Font.PLAIN, 25));
        g.drawString("Create world", 100, 100);

         load = new Rectangle(100, 200, 150, 50);
        g.setFont(new Font("Arial", Font.PLAIN, 25));
        g.drawString("Load world", 100, 200);

        bs.show();
        g.dispose();
    }
    @Override
    public void mouseClicked(MouseEvent e) {
    }
    @Override
    public void mousePressed(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();
        Rectangle mousePixel = new Rectangle(mouseX, mouseY, 1, 1);
        if(mousePixel.intersects(create)){
            frame.setVisible(false);

            Window.create();
        }
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
 
}
