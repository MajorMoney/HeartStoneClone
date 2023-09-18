package GUI;

import Game.GameState;
import Game.MouseHandler;
import PlayerActions.PlayerDraggableAction;
import GameObjects.Cards.Card;

import javax.swing.*;
import java.awt.*;


public class GamePanel extends JPanel implements Runnable{

    private int screenHeight;
    private int screenWidth;

    private MouseHandler mouse ;
    private Thread gameThread;
    private GameState gameState;

    public GamePanel(GameState gameState) {
        this.gameState=gameState;
        screenWidth=gameState.getScreenWidth();
        screenHeight=gameState.getScreenHeight();
        this.mouse =  new MouseHandler(this,gameState);
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setOpaque(false);
        this.setDoubleBuffered(true);
        this.addMouseListener(mouse);
        this.addMouseMotionListener(mouse);
        this.setFocusable(true);



    }



    public void startGameThread(){
        gameThread =new Thread(this);
        gameThread.start();
    }

    @Override
    public void run(){

        this.revalidate();
        while (gameThread != null){
            //update();
            repaint();
        }
    }

    public void handleAction(PlayerDraggableAction pa){
        gameState.handlePlayerAction(pa);
    }

    public void update(){

    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        gameState.getObjectMap().cards.forEach((card -> card.draw(g2)));

        gameState.getBoard().drawBoardCards(g2);

        g2.setColor(Color.ORANGE);
        g2.setStroke(new BasicStroke(2));
        g2.drawRect(275,200,this.screenWidth-575,this.screenHeight/2);
        for(int i=0;i<7;i++){
            g2.drawRect(gameState.getBoard().getLocation().x+(gameState.getBoard().getWidth()/7)*i,
                    gameState.getBoard().getLocation().y,gameState.getBoard().getWidth()/7,
                    gameState.getBoard().getHeight()/2);
        }
        for(int i=0;i<7;i++){
            g2.drawRect(gameState.getBoard().getLocation().x+(gameState.getBoard().getWidth()/7)*i,
                    gameState.getBoard().getLocation().y+gameState.getBoard().getHeight()/2,gameState.getBoard().getWidth()/7,
                    gameState.getBoard().getHeight()/2);
        }
        g2.drawRect(this.screenWidth/2-50,this.screenHeight-100,100,200);
    }


}
