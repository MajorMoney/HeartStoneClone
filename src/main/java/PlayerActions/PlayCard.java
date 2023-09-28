package PlayerActions;

import Game.GameState;
import GameObjects.Cards.Card;

import java.awt.*;
import java.util.LinkedList;

public class PlayCard extends PlayerDraggableAction {

    private Card card;
    private Point originalLocation;
    private Point destination;
    private GameState gs;

    public PlayCard(Card card, Point originalLocation, Point destination, GameState gs) {
        this.card = card;
        this.originalLocation = originalLocation;
        this.destination = destination;
        this.gs = gs;
    }

    //TODO create messager for invalid actions
    @Override
    public boolean validate() {
        if(gs.getBoard().isWithinBounds(destination.x,destination.y)){
            try {
                LinkedList<Card> boardCards = gs.getBoard().getPlayereCards(gs.getCurrentPlayer());
                if (boardCards.size()<7){
                    //If mana <=gs.available mana
                    return true;
                }
                else
                    System.out.println("Your GameObjects.Board is full!!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public void resolve(boolean valid) {
        if (valid){
            gs.playCard(card,destination);
        }
        else
            card.getLocation().setLocation(originalLocation);
    }
}
