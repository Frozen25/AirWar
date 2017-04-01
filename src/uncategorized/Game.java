package uncategorized;



import java.util.Random;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;
import static uncategorized.Main.loadTexture;


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
        
        
        player = new Heroe( "nombre", 3, Display.getWidth()*1/8  /2,0);
        
        jet1 = new Jet(  Display.getWidth()/2  , Display.getHeight()); 
        kami1 = new Kamikaze (Display.getWidth()/2  , Display.getHeight(), player.getCenterX(), player.getY()); 
        
        ColaEnemigos Cola = new ColaEnemigos();
        int numero_enemigos = 5;
        Random random = new Random();
        for (int i = 1; i <= numero_enemigos; i++) {
            int value =  random.nextInt(5);
            Cola.encolar(value);
        }
        
        while ( !Cola.isEmpty()  )
        {
            System.out.println(Cola.desencolar().getData());
        }
        //Cola.encolar(1);
        //Cola.encolar(2);
        //System.out.println(Cola.desencolar().getData());
        //System.out.println(Cola.desencolar().getData());
        ListaDoble Lista = new ListaDoble();
        Lista.insertFirst(jet1);
        //System.out.println(Lista.TakeFirst().getData().getClass().toString());
        
        



 
        
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