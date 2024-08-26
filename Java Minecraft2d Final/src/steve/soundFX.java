package steve;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
public class soundFX {
    public static Clip clip;
    private static File Walking = new File("Java Minecraft2d Final\\src\\res\\SoundFx\\minecraft-footsteps.wav");
	public static AudioInputStream Walk;

    public static void startFx(){
        try {
		
			Walk = AudioSystem.getAudioInputStream(Walking);
           
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 try {
			clip = AudioSystem.getClip();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		try {
			clip.open(Walk);
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
    }

    public static void playClip(){
		
        clip.start();
    }

    public static void stopClip(){
        clip.stop();
    }
    public static boolean clipRunning(){
		
        return clip.isRunning();
    }
}
