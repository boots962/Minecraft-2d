package steve;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import engine.InputHandler;
import res.textures.Textures;

public class legAnimation {
    private static double legAngle = 0; // Current angle of the leg
    private static boolean increasingAngle = true; // To track the direction of rotation
    private static final double maxAngle = Math.toRadians(45); // 45 degrees in radians
    private static final double rotationSpeed = 0.02; // Adjust this to control the speed of rotation

    public static void startAnimation(Graphics2D g, int steveX, int steveY) {
        if (InputHandler.iswalking) {
            // Adjust the angle for the leg rotation
            if (increasingAngle) {
                legAngle += rotationSpeed;
                if (legAngle >= maxAngle) {
                    increasingAngle = false;
                }
            } else {
                legAngle -= rotationSpeed;
                if (legAngle <= -maxAngle) {
                    increasingAngle = true;
                }
            }

            // Draw the main leg
            drawLeg(g, steveX, steveY, legAngle);

            // Draw the secondary leg with opposite rotation
            drawLeg(g, steveX, steveY, -legAngle);
        } else {
            // If not running, draw the static leg image without rotation
            g.drawImage(Textures.steveLegF, steveX + 75, steveY + (Textures.steve.getHeight() - Textures.steveLegF.getHeight()), null);
        }
    }

    private static void drawLeg(Graphics2D g, int steveX, int steveY, double angle) {
        // Apply rotation around the leg's top-left corner
        AffineTransform originalTransform = g.getTransform();
        g.rotate(angle, steveX + 75 + Textures.steveLegF.getWidth() / 2, steveY + (Textures.steve.getHeight() - Textures.steveLegF.getHeight()));

        // Draw the leg image with rotation
        g.drawImage(Textures.steveLegF, steveX + 75, steveY + (Textures.steve.getHeight() - Textures.steveLegF.getHeight()), null);

        // Reset the transform to avoid affecting other drawings
        g.setTransform(originalTransform);
    }
}
