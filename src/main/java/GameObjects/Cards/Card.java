package GameObjects.Cards;


import GameObjects.GameObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public abstract class Card extends GameObject {

    //TODO change to protected
    public enum CardClass {
        PALADIN,
        WARRIOR,HUNTER,MAGE,
        SHAMAN,DRUID,WARLOCK,PRIEST,
        ROGUE,DEMON_HUNTER,DEATH_KNIGHT,
        NEUTRAL

    }


    protected int manaCost;
    protected CardClass cardClass;

    public Card(int x, int y, int width, int height, CardProperties cp,int id) {
        location = new Point(x, y);
        this.width = width;
        this.height = height;

        try {
            img = ImageIO.read(this.getClass().getClassLoader().getResource("CardImages/"+ id +".png"));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        this.cardClass =  CardClass.valueOf(cp.getCardClass());
        this.manaCost = cp.getMana();
    }




    @Override
    public void draw(Graphics2D g2d  )  {

        // Scale the image to the desired dimensions
        //Image scaledImage =  img.getScaledInstance( width, height, Image.SCALE_SMOOTH);

        // Draw the scaled image onto the Graphics2D canvas
        g2d.drawImage(img,  location.x-width/2, location.y-height/2,width,height, null);
    }
}

