package GameObjects.Cards.Minions;

import GameObjects.Cards.CardInterfaces.ITradable;
import GameObjects.Cards.CardProperties;

public class TradableMinion extends Minion implements ITradable {

  public TradableMinion(int x, int y, int width, int height, CardProperties cp) {
    super(x, y, width, height, cp);
  }
}
