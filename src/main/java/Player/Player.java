package Player;

import Game.GameObjectMapper;
import GameObjects.Cards.Card;
import GameObjects.Cards.CardProperties;
import GameObjects.Cards.CardPropertiesImporter;
import java.util.ArrayList;
import java.util.List;

public class Player {

    private int HAND_SIZE;
    private Mana mana;
    private ArrayList<Card> deck;
    private ArrayList<Card> hand;
    private GameObjectMapper objectMapper;

    public Player(CardPropertiesImporter cpi, GameObjectMapper objectMapper){
        //Created Empty but with initial limits but no real limit
        this.objectMapper = objectMapper;
        deck = new ArrayList<Card>(30);
        this.hand = new ArrayList<Card>();
        mana = new Mana();

        initDeck(cpi);
//        initHand();
    }

    public void initDeck(CardPropertiesImporter cf){
        List<CardProperties> cardPropertiesList = new ArrayList<CardProperties>(cf.propertiesHasMap.values());
        for(CardProperties cp : cardPropertiesList){
            System.out.println(cp.toString());
            deck.add(cf.createCard(cp));
        }
    }



    public void initHand() {
        for (int i = 0; i < 3; i++) {
            draw();
        }
    }

    public void draw(){
        try{
            Card c =  deck.remove(0);
            if(hand.size()<10){
                addToHand(c);
            }
            else{
                System.out.println("TODO Discard Card");
            }
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("TODO Implement fatigue");
        }
    }

    public void addToHand(Card c){
        hand.add(c);
        objectMapper.updateHand(c);
    }

    public  void newTurn(){
        draw();
    }



    public Mana getMana() {
        return mana;
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }
}
