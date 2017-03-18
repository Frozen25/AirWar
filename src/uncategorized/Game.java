package uncategorized;

import java.util.ArrayList;
import org.lwjgl.opengl.Display;


/**
 *
 * @author Alexis
 */
public class Game {
    
    private ArrayList<GameObject> objects;
    
    public Game()
    {
        objects = new ArrayList<GameObject>();
        
        GOBall ball = new GOBall(Display.getWidth()/2 - GOBall.SIZE/2 , Display.getHeight()/2 - GOBall.SIZE/2);
        
        objects.add(ball);
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
