package res.textures;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Textures {
	public static File spriteSheet = new File("Java Minecraft2d Final\\src\\res\\textures\\blockSheet.png"),
	steveSprite = new File("Java Minecraft2d Final\\src\\res\\textures\\steveSheet.png"),
	sunSheet = new File("Java Minecraft2d Final\\src\\res\\textures\\sunSheet.png"),
	pigSheet = new File("Java Minecraft2d Final\\src\\res\\textures\\pig ss.png");  

	public static BufferedImage iron, stone, background, dirt, grass, steve, steveRight, steveLeft, worldBorder;
	public static BufferedImage iron_icon, stone_icon, dirt_icon, grass_icon;
	public static BufferedImage Broken1, Broken2, Broken3, Broken4,Broken5, SteveLeftwalk, sprites, steveSpriteSheet, sun, sunset, moon, sunSprites, steveHead, pigss, pigL, pigR, steveLegF;
		
	public static int Broken1_HEIGHT = 50, Broken1_WIDTH = 50, dirt_HEIGHT = 50, dirt_WIDTH = 50, grass_HEIGHT = 50, grass_WIDTH = 50, ironOre_HEIGHT = 50, ironORE_WIDTH = 50,
	stone_HEIGHT = 50, stone_WIDTH = 50, border_WIDTH = 50, border_HEIGHT = 50, IRON_HEIGHT = 50, IRON_WIDTH = 50, STEVE_WIDTH = 26, STEVE_HEIGHT = 100, STEVEWALK_WIDTH = 51, STEVEWALK_HEIGHT = 100,
	SUN_WIDTH = 51, SUN_HEIGHT = 51, SUNSET_WIDTH = 51, SUNSET_HEIGHT = 51, MOON_WIDTH = 51, MOON_HEIGHT = 51, head_height = 26, head_woidth = 26, icon_width = 35, icon_height = 35,
	pig_height = 50, pig_width = 75, leg_height = 38, leg_width = 25;

	public Textures() {
		try {
		
			steveSpriteSheet = ImageIO.read(steveSprite);
			sprites = ImageIO.read(spriteSheet);
			sunSprites = ImageIO.read(sunSheet);
			pigss = ImageIO.read(pigSheet);
			//blocks
			iron = sprites.getSubimage(400, 0, IRON_HEIGHT, IRON_WIDTH);
			Broken1 = sprites.getSubimage(0, 0, Broken1_HEIGHT, Broken1_WIDTH);
			Broken2 = sprites.getSubimage(50, 0, Broken1_HEIGHT, Broken1_WIDTH);
			Broken3 = sprites.getSubimage(100, 0, Broken1_HEIGHT, Broken1_WIDTH);
			Broken4 = sprites.getSubimage(150, 0, Broken1_HEIGHT, Broken1_WIDTH);
			Broken5 = sprites.getSubimage(200, 0, Broken1_HEIGHT, Broken1_WIDTH);
			dirt = sprites.getSubimage(250, 0, dirt_HEIGHT, dirt_WIDTH);
			grass = sprites.getSubimage(300, 0, grass_HEIGHT, grass_WIDTH);
			stone = sprites.getSubimage(350, 0, stone_HEIGHT, stone_WIDTH);

			//icons
			iron_icon = sprites.getSubimage(400, 0, icon_width, icon_height);
			stone_icon = sprites.getSubimage(350, 0, icon_width, icon_height);
			grass_icon = sprites.getSubimage(300, 0, icon_width, icon_height);
			dirt_icon = sprites.getSubimage(250, 0, icon_width, icon_height);
			//steve
			steveRight = steveSpriteSheet.getSubimage(0, 0, STEVEWALK_WIDTH, STEVEWALK_HEIGHT);
			steveLeft = steveSpriteSheet.getSubimage(51, 0, STEVEWALK_WIDTH, STEVEWALK_HEIGHT);
			steve = steveSpriteSheet.getSubimage(102, 26, STEVE_WIDTH, STEVE_HEIGHT-26 - leg_height);
			steveHead = steveSpriteSheet.getSubimage(102, 0, head_woidth, head_height);
			steveLegF = steveSpriteSheet.getSubimage(102, STEVE_HEIGHT-leg_height, leg_width, leg_height);


			//environment
			sun = sunSprites.getSubimage(0, 0, SUN_WIDTH, SUN_HEIGHT);
			sunset = sunSprites.getSubimage(102, 0, SUNSET_WIDTH, SUNSET_HEIGHT);
			moon = sunSprites.getSubimage(51, 0, MOON_WIDTH, MOON_HEIGHT);

			//entities
			pigL = pigss.getSubimage(0, 0, pig_width, pig_height);
			pigR = pigss.getSubimage(pig_width, 0, pig_width, pig_height);

			worldBorder = sprites.getSubimage(450, 0, border_HEIGHT, border_WIDTH);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
