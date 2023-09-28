package GameObjects.Cards;


import GameObjects.GameObject;

import java.awt.*;
import java.lang.reflect.Parameter;
import java.security.InvalidParameterException;

public abstract class Card extends GameObject {

    //TODO change to protected
    public enum CardClass {
        PALADIN,
        WARRIOR,HUNTER,MAGE,
        SHAMAN,DRUID,WARLOCK,PRIEST,
        ROGUE,DEMON_HUNTER,DEATH_KNIGHT,
        NEUTRAL;

    }


    protected int manaCost;
    protected CardClass cardClass;

    public Card(int x, int y, int width, int height, String file, int manaCost,CardClass cardClass) {
        super(x, y, width, height,file);
        this.cardClass =  cardClass;
        this.manaCost = manaCost;
    }

    @Override
    public void draw(Graphics2D g2d  )  {

        // Scale the image to the desired dimensions
        //Image scaledImage =  img.getScaledInstance( width, height, Image.SCALE_SMOOTH);

        // Draw the scaled image onto the Graphics2D canvas
        g2d.drawImage(img,  location.x-width/2, location.y-height/2,width,height, null);
    }
}

