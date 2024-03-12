package GameObjects.Cards.Minions;

import GameObjects.Cards.Card;
import GameObjects.Cards.CardProperties;
import GameObjects.Cards.ISummonable;

public class Minion extends Card implements ISummonable {

  private int attack, health;

  public Minion(int x, int y, int width, int height, CardProperties cp) {
    super(x, y, width, height, cp);
    this.attack = cp.getAttack();
    this.health = cp.getHealth();
  }

  @Override
  public String toString() {
    return "Minion{"
        + "Card="
        + name
        + ", attack="
        + attack
        + ", health="
        + health
        + ", effect="
        + effect
        + '}';
  }
}
