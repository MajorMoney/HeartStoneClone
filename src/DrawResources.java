import java.awt.*;
import java.awt.image.BufferedImage;

public class DrawResources {

    public static void drawCard(Graphics2D g2d,int x, int y,int width, int height,BufferedImage bufferedImage) {

        // Scale the image to the desired dimensions
            Image scaledImage = bufferedImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);

            // Draw the scaled image onto the Graphics2D canvas
            g2d.drawImage(scaledImage, x-width/2, y-height/2, null);
    }

    public static void drawBoard(Graphics g,int width, int height,BufferedImage background)  {
        g.drawImage(background,0,0,width,height,null);
    }
}
