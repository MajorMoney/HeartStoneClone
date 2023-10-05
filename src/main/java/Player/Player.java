package Player;

import Game.GameObjectMapper;
import GameObjects.Cards.Card;
import GameObjects.Cards.CardPropertiesImporter;

import java.util.ArrayList;

public class Player {

    private Mana mana;
    private Deck deck;
    private Hand hand;
    private GameObjectMapper objectMapper;

    public Player(CardPropertiesImporter cpi, GameObjectMapper objectMapper){
        //Created Empty but with initial limits but no real limit
        this.objectMapper = objectMapper;
        deck = new Deck();
        hand = new Hand();
        mana = new Mana();

        deck.init(cpi);
    }


    public void init() {
        for (int i = 0; i < 3; i++) {
            Card c = deck.draw();
            hand.addCard(c);
        }
    }

    public void draw(){
        try{
            hand.addCard(deck.draw());
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("TODO Implement fatigue");
        }
    }

    public Mana getMana() {
        return mana;
    }

    public ArrayList<Card> getDeck() {
        return deck.getDeck();
    }

    public ArrayList<Card> getHand() {
        return hand.getHand();
    }
}
