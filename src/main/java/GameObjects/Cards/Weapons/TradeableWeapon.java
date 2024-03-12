package GameObjects.Cards.Weapons;

import GameObjects.Cards.CardInterfaces.ITradable;
import GameObjects.Cards.CardProperties;

public class TradeableWeapon extends Weapon implements ITradable {

  public TradeableWeapon(int x, int y, int width, int height, CardProperties cp) {
    super(x, y, width, height, cp);
  }
}
