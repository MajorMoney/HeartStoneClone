package GameObjects.Cards.Spells;

import GameObjects.Cards.CardInterfaces.IForgeable;
import GameObjects.Cards.CardProperties;

public class ForgeableSpell extends Spell implements IForgeable {

  public ForgeableSpell(int x, int y, int width, int height, CardProperties cp, int id) {
    super(x, y, width, height, cp);
  }
}
