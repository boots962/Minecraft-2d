package engine;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import Terrain.DirtBlock;
import Terrain.GrassBlock;
import Terrain.StoneBlock;
import res.textures.Textures;

public class Window extends Canvas implements Runnable {
    public static int height = 720, width = 1280, renderedTimes = 0, xmoved = 0;
    public static double worldVersion = 1.0;
    public static String title = "Java Minecraft2D", difficulty = "Easy";
    public static boolean running = true;
    public Thread game;
    public static double tickCount, frames, framesA;
    private BufferStrategy bs;
    private Graphics2D g;

    public Window(){
        new Textures();
        worldFile.createDir();
        InputHandler ih = new InputHandler();
        addKeyListener(ih);
        addMouseListener(ih);
        addFocusListener(ih);
        addMouseMotionListener(ih);
    }
    public static void main(String [] args){ //main method 
        titlepage.init();
    }

    public void run(){ //renders/deals with the fps when the game starts running
        requestFocus();
        double unproc = 0, secondsPer = 1/60.0;
		long prev = System.nanoTime();
		boolean ticked = false;
		running = true;
		while (running) {
			long curtime = System.nanoTime();
			long pasttime = curtime-prev;
			prev = curtime;
			unproc += pasttime/1000000000.0;
			while(unproc >secondsPer) {
				
				
				ticked = true;
				tickCount++;
				if(tickCount %60 == 0) {
                    
					unproc -= secondsPer;
					framesA = frames;
                    title = "Frames" + framesA;
					prev +=1000;
					frames = 0;
				}
			}
			if(ticked) {
				render();
				frames++;
			}
			render();
			frames++;
        }
    }

    public void start(){//starts game Thread 
        game = new Thread(this, "Minecraft");
        game.start();
    }

    private void render(){ //Main render method
        bs = this.getBufferStrategy();

		if(bs == null) {
			createBufferStrategy(2);
			return;
		}
		g = (Graphics2D) bs.getDrawGraphics();
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, width, height);
        
        GrassBlock.placeBlock(g);
        DirtBlock.placeBlock(g);
        StoneBlock.placeBlock(g);
        renderedTimes++;
        g.dispose();
        bs.show();
    }

    public static void create(){//creates window
        Window window = new Window();
        JFrame frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(3);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(window);
        frame.setVisible(true);
        window.start();
    } 

    


}
