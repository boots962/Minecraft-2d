package engine;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import Hud.F3Men;
import Terrain.BlockLoader;
import Terrain.Chunk;
import res.textures.Textures;
import steve.Steve;
import steve.soundFX;

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
        titlePage.init();
    }

    public void run(){ //renders/deals with the fps when the game starts running
        requestFocus();
        Music.getSong();
        soundFX.startFx();
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
				unproc -= secondsPer;
				ticked = true;
				tickCount++;
				if(tickCount %60 == 0) {
					
					framesA = frames;
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
   
    int ran = 5;
    private void render(){ //Main render method
        bs = this.getBufferStrategy();
        Random rd= new Random();
        int rand = rd.nextInt(10000);
        if(!Music.isPlaying() && rand == ran){
            Music.getSong();
            Music.play();
        }
		if(bs == null) {
			createBufferStrategy(2);
			return;
		}
		g = (Graphics2D) bs.getDrawGraphics();

        
		g.setColor(dayNightChanger.sky_color());
        g.fillRect(0, 0, width, height);
        dayNightChanger.renderSun(g);
		g.setColor(Color.GRAY);
        
        int x = Steve.getStevex();
        int y = Steve.getStevey();
        if(InputHandler.F3) F3Men.renderF3(g,framesA, x, y, Steve.getSteveChunkNum(Steve.getStevex()),Chunk.getChunkID(),"2.1.2Pre-Release (Vanilla)");

        BlockLoader.Loader(g);
        Steve.renderSteve(g);
        g.dispose();
        bs.show();
    }

    public static void create(){//creates window
        SwingUtilities.invokeLater(() -> {
        Window window = new Window();
        JFrame frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(3);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(window);
        frame.setVisible(true);
        window.start();
        });
    } 

    


}
