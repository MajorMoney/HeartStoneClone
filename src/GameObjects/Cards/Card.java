package GameObjects.Cards;

import GameObjects.GameObject;

import java.awt.*;

public class Card extends GameObject {


    public Card(int x, int y, int width, int height, String file) {
        super(x, y, width, height,file);
    }


    public void draw(Graphics2D g2d  )  {

        // Scale the image to the desired dimensions
        //Image scaledImage =  img.getScaledInstance( width, height, Image.SCALE_SMOOTH);

        // Draw the scaled image onto the Graphics2D canvas
        g2d.drawImage(img,  location.x-width/2, location.y-height/2,width,height, null);
    }
}

