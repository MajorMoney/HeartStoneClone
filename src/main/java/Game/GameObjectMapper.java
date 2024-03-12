package Game;

import GameObjects.Cards.Card;
import java.awt.*;
import java.util.ArrayList;

public class GameObjectMapper {

  public ArrayList<Card> cards;
  private int screenHeight;
  private int screenWidth;

  public GameObjectMapper() {
    cards = new ArrayList<Card>();
  }

  public GameObjectMapper(int screenHeight, int screenWidth) {
    cards = new ArrayList<Card>();
    this.screenHeight = screenHeight;
    this.screenWidth = screenWidth;
  }

  public GameObjectMapper(GameObjectMapper objectMap) {
    cards = objectMap.cards;
    this.screenHeight = objectMap.screenHeight;
    this.screenWidth = objectMap.screenWidth;
  }

  public Card getObjectAt(int x, int y) {
    for (Card card : cards) {
      if (card.isWithinBounds(x, y)) return card;
    }
    return null;
  }

  public void updateHand(Card c) {
    cards.add(c);
    updateCardsPosition();
  }

  private void updateCardsPosition() {
    int offset = 0;
    if (cards.size() % 2 == 0) {
      offset += 40;
    }

    offset -= cards.size() / 2 * 80;
    for (int i = 0; i < cards.size(); i++) {
      cards
          .get(i)
          .getLocation()
          .setLocation(new Point(screenWidth / 2 + offset, screenHeight - 50));
      offset += 80;
    }
  }

  public void drawCards(Graphics2D g2) {
    cards.forEach((card -> card.draw(g2)));
  }
}
