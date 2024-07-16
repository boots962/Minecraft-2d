package engine;

import java.awt.Color;
import java.awt.Graphics2D;

import res.textures.Textures;


public class dayNightChanger {

    public static double time = 0, totalTime = 0;
    private static double r = 180, g =180, b=255, div, roundedFrames;
    private static double x = Window.width/2, y = Window.height, yMove = 2*Math.pow(10, -div), oldY = 350;


    public static void renderSun(Graphics2D g2){ //day night changer
     

        yMove = 1.4*Math.pow(10, -div);
        if(time==0){
            y = 0;
        }
        if(time>0 && time <1000){ //daytime
            y+=(3*Math.pow(10, -div));
            g2.drawImage(Textures.sun, (int)x, (int)y, null);
        }
        if(time>1000&&time<2000){ //for the sunset
         
            r+=(0.375*Math.pow(10, -div));
            g-=(0.485*Math.pow(10, -div));
            b-=(1.03*Math.pow(10, -div));
            if(oldY<y-yMove){
               y = oldY;
            }else{
                y+=yMove;
            }
            
            g2.drawImage(Textures.sunset,(int) x, (int)y, null);
            oldY = y;
        }
        if(time== 2500){ //reset the moon to the ground
            y=0;
        }
        // System.out.println(y + " " + time + "r:" +r + "b:" + b + "g:" + g);
        if(time > 2000 && time < 3000){ //nighttime
            y+=(2*Math.pow(10, -div));

            g2.drawImage(Textures.moon,(int) x, (int)y, null);
            if(r>=0)r-=(2.50*Math.pow(10, -div));
            if(g>=0)g-=(0.8*Math.pow(10, -div));
            if(b>=0)b-=(0.4*Math.pow(10, -div));
        }
        if(time>3000&&time<3500){
            y+=(2*Math.pow(10, -div));
            g2.drawImage(Textures.moon,(int) x, (int)y, null);
            r=0;
            g=0;
            b=0;
        }
        if(time==3500){
            y = Window.height;
        }
        if(time>3500&&time<4500){
            
            if(r<=255)r+=(1.8*Math.pow(10, -div));
            if(g<=180)g+=(1.8*Math.pow(10, -div));
            if(b<=180)b+=(2.25*Math.pow(10, -div));
            y-=(2*Math.pow(10, -div));
            g2.drawImage(Textures.sunset,(int) x, (int)y, null);
        }
        if(time>4500&&time<5000){
            r = 180;
            g=180;
            b=255;
            y-=(2*Math.pow(10, -div));
            g2.drawImage(Textures.sun, (int)x, (int)y, null);
        }
    }

    public static Color sky_color(){
        roundedFrames = Math.round(Window.framesA);
        div = Math.log10(roundedFrames);
        if(div!=Double.NEGATIVE_INFINITY){
        time+=(5*Math.pow(10, -div));
         }else{
            time+=0;
         }
        if(time==5000){
            time = 0;
        }
        return new Color(0+(int)r, 0+(int)g, 0+(int)b);
    }
}