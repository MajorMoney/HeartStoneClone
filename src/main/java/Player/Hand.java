package Player;

import GameObjects.Cards.Card;
import GameObjects.Cards.CardProperties;

import java.util.ArrayList;

public class Hand extends IncrementTurn {

    private ArrayList<Card> hand;

    public Hand(){
        this.hand = new ArrayList<Card>();
    }

    public void addCard(Card card){
        hand.add(card);
    }

    @Override
    public Card increment() {

        return null;
    }


    public ArrayList<Card> getHand() {
        return hand;
    }
}
