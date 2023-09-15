import javax.swing.*;
import java.awt.*;
import java.io.IOException;


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
        this.mouse =  new MouseHandler(this,gameState.getObjectMap());
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
            update();
            repaint();
        }
    }

    public void handleAction(PlayerAction pa){
        gameState.handlePlayerAction(pa);
    }

    public void update(){

    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;


        gameState.getObjectMap().gameObjects.forEach((gameObject -> {
            try {
                gameObject.draw(g2);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));
        g.drawString(mouse.getMsg(), mouse.getMouse_x(), mouse.getMouse_y());
        g2.setColor(Color.ORANGE);
        g2.setStroke(new BasicStroke(2));
        g2.drawRect(275,200,this.screenWidth-575,this.screenHeight/2);
        g2.drawRect(this.screenWidth/2-50,this.screenHeight-100,100,200);
    }


}
