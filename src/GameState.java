import java.awt.*;

public class GameState {

    private static volatile GameState instance;
    private GameObjectMapper objectMap;
    private int screenHeight;
    private int screenWidth;

    private GameState(){
        this.objectMap = new GameObjectMapper();
        setFullScreenHeightAndWidth();
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

    public int getScreenHeight() {
        return screenHeight;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public void startGame(){
        GameObject card = new Card(this.screenWidth/2,this.screenHeight,200,200,"test");
        objectMap.gameObjects.add(card);
    }

    public void handlePlayerAction(PlayerAction pa){
        if(pa.validate()){
            pa.resolve();
        }
    }

}

