package Player;

import GameObjects.Cards.Card;
import GameObjects.Cards.CardProperties;
import GameObjects.Cards.CardPropertiesImporter;
import java.util.ArrayList;
import java.util.List;

public class Deck {

    private ArrayList<Card> deck;

    public Deck(){
        this.deck = new ArrayList<Card>(30);
    }

    public void init(CardPropertiesImporter cf){
        List<CardProperties> cardPropertiesList = new ArrayList<CardProperties>(cf.propertiesHasMap.values());
        for(CardProperties cp : cardPropertiesList){
            System.out.println(cp.toString());
            deck.add(cf.createCard(cp));
        }
    }


    public Card draw(){
        return deck.remove(0);
    }

    public ArrayList<Card> getDeck(){
        return deck;
    }



}



