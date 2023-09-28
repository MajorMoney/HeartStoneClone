package GameObjects;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public abstract class GameObject {

    protected Point location;
    protected int height;
    protected int width;
    protected BufferedImage img;


    public GameObject(int x, int y, int width, int height, String file) {
        location = new Point(x, y);
        this.width = width;
        this.height = height;
        try {
            img = ImageIO.read(this.getClass().getClassLoader().getResource("CardImages/"+ file +".png"));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public Point getLocation() {
        return location;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }


    public BufferedImage getImg() {
        return img;
    }


    public void draw(Graphics2D g2d) {

        // Scale the image to the desired dimensions
//        Image scaledImage = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);

        // Draw the scaled image onto the Graphics2D canvas
        g2d.drawImage(img, location.x, location.y, null);
    }

    public boolean isWithinBounds(int x, int y) {
        return x >= location.x - width / 2 && x <= location.x + width / 2 && y >= location.y - height / 2 && y <= location.y + height / 2;
    }

    @Override
    public String toString() {
        return "GameObjects.GameObject{" +
                "x=" + location.x +
                ", y=" + location.y +
                ", height=" + height +
                ", width=" + width +
                ", img=" + img +
                '}';
    }
}
