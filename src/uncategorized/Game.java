package uncategorized;

import java.util.ArrayList;


/**
 *
 * @author Alexis
 */
public class Game {
    
    private ArrayList<GameObject> objects;
    
    public Game()
    {
        objects = new ArrayList<GameObject>();
    }
    
    public void getInput()
    {
    
    }
    public void update()
    {
        for (GameObject go : objects)
            go.update();
    }
    public void render()
    {
        for (GameObject go : objects)
            go.render();
    }
    
    
}
