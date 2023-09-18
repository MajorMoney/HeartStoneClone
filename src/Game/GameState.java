package Game;

import GameObjects.Board;
import GameObjects.Cards.Card;
import Main.Main;
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
        gd.setFullScreenWindow(Main.window);

        this.screenHeight=Main.window.getHeight();
        this.screenWidth=Main.window.getWidth();
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
        Card card1 = new Card(screenWidth/2+300,screenHeight,200,200,"test");
        Card card2 = new Card(screenWidth/2,screenHeight,200,200,"test");
        Card card3 = new Card(screenWidth/2-300,screenHeight,200,200,"test");

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

