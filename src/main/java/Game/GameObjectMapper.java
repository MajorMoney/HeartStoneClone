package Game;


import GameObjects.Cards.Card;

import java.util.ArrayList;

public class GameObjectMapper {

    public ArrayList<Card> cards;

    public GameObjectMapper(){
        cards = new ArrayList<Card>();
    }

    public Card getObjectAt(int x, int y){
        for (Card card: cards) {
            if(card.isWithinBounds(x,y))
                return card;
        }
        return null;
    }


}
