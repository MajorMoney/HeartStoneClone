package GameObjects.Cards;

import static Utils.ResourceUtils.getFileFromResources;

import GameObjects.Cards.Effects.Effect;
import GameObjects.GameObject;
import java.awt.*;
import java.io.IOException;
import javax.imageio.ImageIO;

public abstract class Card extends GameObject {

  protected int manaCost;
  protected String name, text;
  protected CardClass cardClass;
  protected Effect effect;

  public Card(int x, int y, int width, int height, CardProperties cp) {
    location = new Point(x, y);
    this.width = width;
    this.height = height;
    this.text = cp.getText();
    this.name = cp.getName();
    try {
      img = ImageIO.read(getFileFromResources("CardImages/" + name + ".png"));
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }

    this.cardClass = CardClass.valueOf(cp.getCardClass());
    this.manaCost = cp.getMana();
  }

  @Override
  public void draw(Graphics2D g2d) {

    // Scale the image to the desired dimensions
    // Image scaledImage =  img.getScaledInstance( width, height, Image.SCALE_SMOOTH);

    // Draw the scaled image onto the Graphics2D canvas
    g2d.drawImage(img, location.x - width / 2, location.y - height / 2, width, height, null);
  }

  protected enum CardClass {
    PALADIN,
    WARRIOR,
    HUNTER,
    MAGE,
    SHAMAN,
    DRUID,
    WARLOCK,
    PRIEST,
    ROGUE,
    DEMON_HUNTER,
    DEATH_KNIGHT,
    NEUTRAL
  }
}
