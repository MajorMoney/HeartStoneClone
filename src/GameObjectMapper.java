import java.util.ArrayList;
import java.util.HashMap;

public class GameObjectMapper {

    public ArrayList<GameObject> gameObjects;

    public GameObjectMapper(){
        gameObjects = new ArrayList<>();
    }

    public GameObject getObjectAt(int x, int y){
        for (GameObject go:gameObjects) {
            if(go.isWithinBounds(x,y))
                return go;
        }
        return null;
    }


}
