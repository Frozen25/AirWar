package uncategorized;



import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;


/**
 *
 * @author Alexis
 */
public class Game {
    
    //private ArrayList<GameObject> objects;
    
    private Heroe player;
    //private ColaEnemigos Cola;
    private Jet jet1;
    private Kamikaze kami1;
    private Shoot disparo;
    
    
    public Game()
    {
        //objects = new ArrayList<GameObject>();
        
        
        player = new Heroe( "nombre", 3, 100 , Display.getWidth()*1/8  /2,0);
        
        jet1 = new Jet(  Display.getWidth()/2  , Display.getHeight()); 
        kami1 = new Kamikaze (Display.getWidth()/2  , Display.getHeight(), player.getCenterX(), player.getY()); 
        
        ColaEnemigos Cola = new ColaEnemigos();
        Cola.insert(1);
        



 
        
    }
    
    public void getInput()
    {
        
        if (Keyboard.isKeyDown(Keyboard.KEY_W) || (Keyboard.isKeyDown(Keyboard.KEY_UP)))
            player.moveY(1);
        if (Keyboard.isKeyDown(Keyboard.KEY_S) || (Keyboard.isKeyDown(Keyboard.KEY_DOWN)))
            player.moveY(-1);
        
        if (Keyboard.isKeyDown(Keyboard.KEY_A) || (Keyboard.isKeyDown(Keyboard.KEY_LEFT)))
            player.moveX(-1);
        if (Keyboard.isKeyDown(Keyboard.KEY_D) || (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)))
            player.moveX(1);
        if (Keyboard.isKeyDown(Keyboard.KEY_SPACE))
            disparo = new Shoot(player.getX()+player.getSX()/2,player.getY()+player.getSY());
        
    }
    public void update()
    {
        
        player.update();
        jet1.update();
        kami1.update();
        if( disparo != null)
        {
            disparo.update();
            if (Physics.checkCollisions(jet1, disparo))
                
                System.out.println("colision");
        }
    }
    
    public void render()
    {
        
        player.render();
        jet1.render();
        kami1.render();
        if( disparo != null)
            disparo.render();
        /*
        for (GameObject go : objects)
            go.render();
        */
        
    }
    
    
}