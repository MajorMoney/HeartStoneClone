package Game;

import GameObjects.Board;
import GameObjects.Cards.Card;
import GameObjects.Cards.CardPropertiesImporter;
import Player.*;
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
//        GraphicsDevice gd =  GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
//        gd.setFullScreenWindow(GameStart.window);

        this.screenHeight = GameStart.window.getHeight();
        this.screenWidth = GameStart.window.getWidth();
    }

    public void startGameLogic(){
        CardPropertiesImporter cpi = new CardPropertiesImporter(-1000,-1000,200,200);

        //TODO make actual deck importation
        Player player1 = new Player(cpi,objectMap);

        player1.init();

        for(Card c : player1.getHand()){
            System.out.println(c);
        }

        player1.draw();
        System.out.println("TODO add objectMapper / hand / board connectionx");


//
//        card1.setLocation(new Point(screenWidth/2+300,screenHeight));
//        card2.setLocation(new Point(screenWidth/2, screenHeight));
//        card3.setLocation(new Point(screenWidth/2-300, screenHeight));
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




    public void handlePlayerAction(PlayerDraggableAction pa){
        pa.resolve(pa.validate());
    }

    public void playCard(Card card,Point destination){
        board.addCard(card,destination, currentPlayer);
    }



}

