package Game;

import GameObjects.Board;
import GameObjects.Cards.Card;
import GameObjects.Cards.CardFactory;
import GameObjects.Cards.Minions.Minion;
import PlayerActions.PlayerDraggableAction;

import java.awt.*;

public class GameState {

    private static volatile GameState instance;
    private GameObjectMapper objectMap;
    private int screenHeight;
    private int screenWidth;
    private Board board;
    private int currentPlayer;

    private GameState(){
        setFullScreenHeightAndWidth();
        objectMap = new GameObjectMapper();
        board = new Board(275,200,screenWidth,screenHeight);
        currentPlayer =1;
        startGame();
        }

    public static GameState getInstance(){
        GameState result =instance;
        if (result==null) {
            synchronized (GameState.class){
                result = instance;
                if (result==null) {
                    instance = result = new GameState();
                }
            }
        }
        return result;
    }

    public void setFullScreenHeightAndWidth(){
        GraphicsDevice gd =  GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        gd.setFullScreenWindow(Main.Main.window);

        this.screenHeight=Main.Main.window.getHeight();
        this.screenWidth=Main.Main.window.getWidth();
    }

    public GameObjectMapper getObjectMap() {
        return objectMap;
    }

    public Board getBoard() {
        return board;

    }
    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void startGame(){
        CardFactory cardFactory = new CardFactory();

        cardFactory.getCardById(2);

        Card card1 = new Minion(screenWidth/2+300,screenHeight,200,200,"test",5, null);
        Card card2 = new Minion(screenWidth/2,screenHeight,200,200,"test",5, null);
        Card card3 = new Minion(screenWidth/2-300,screenHeight,200,200,"test",5, null);

        objectMap.cards.add(card1);
        objectMap.cards.add(card2);
        objectMap.cards.add(card3);
    }


    public void handlePlayerAction(PlayerDraggableAction pa){
        pa.resolve(pa.validate());
    }

    public void playCard(Card card,Point destination){
        board.addCard(card,destination, currentPlayer);
    }



}

