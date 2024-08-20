package engine;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;



public class Music {
	public static Clip clip;
    private static File Hagg = new File("Java Minecraft2d Final\\src\\res\\Mus\\1-07. Haggstrom (2).wav");
	private static File aria = new File("Java Minecraft2d Final\\src\\res\\Mus\\2-10. Haunt Muskie.wav");
	private static File haunt = new File("Java Minecraft2d Final\\src\\res\\Mus\\2-13. Aria Math.wav");
	public static AudioInputStream AriaMath, Haggstrom, HauntMuskie;
    public static AudioInputStream [] musicFiles = new AudioInputStream[3];

	public static void getSong(){
		 
        Random rd = new Random();
        int index = rd.nextInt(musicFiles.length);
		 try {
		
			Haggstrom = AudioSystem.getAudioInputStream(Hagg);
			AriaMath = AudioSystem.getAudioInputStream(aria);
			HauntMuskie = AudioSystem.getAudioInputStream(haunt);
            musicFiles[0] = Haggstrom;
			musicFiles[1] = AriaMath;
			musicFiles[2] = HauntMuskie;
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
			clip.open(musicFiles[index]);
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	public static void play() {
		clip.start();
	}
	public static String songPlaying(){
		if(isPlaying()){
			return clip.toString();
		}
		return "";
	}
	public static void stop(){
		clip.stop();
	}

	public static boolean isPlaying(){
		return clip.isRunning();
	}
}