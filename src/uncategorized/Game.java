package uncategorized;

import java.util.ArrayList;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;


/**
 *
 * @author Alexis
 */
public class Game {
    
    //private ArrayList<GameObject> objects;
    
    private Heroe jugador;
    
    private Enemigo enemigo1;
    private Disparo disparo;
    
    public Game()
    {
        //objects = new ArrayList<GameObject>();
        
        
        jugador = new Heroe( "nombre ", 3, 100 , Display.getWidth()/2 - Heroe.SIZEX /2,0);
        
        enemigo1 = new Enemigo("", 1, 10, 1, Display.getWidth()/2 - Enemigo.SIZEX/2 , Display.getHeight() - Enemigo.SIZEY); 
        
        //objects.add(ball);
        //objects.add(jugador);
        
    }
    
    public void getInput()
    {
        /*
        if (Keyboard.isKeyDown(Keyboard.KEY_W) || (Keyboard.isKeyDown(Keyboard.KEY_UP)))
            jugador.moveY(1);
        if (Keyboard.isKeyDown(Keyboard.KEY_S) || (Keyboard.isKeyDown(Keyboard.KEY_DOWN)))
            jugador.moveY(-1);
        */
        if (Keyboard.isKeyDown(Keyboard.KEY_A) || (Keyboard.isKeyDown(Keyboard.KEY_LEFT)))
            jugador.moveX(-1);
        if (Keyboard.isKeyDown(Keyboard.KEY_D) || (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)))
            jugador.moveX(1);
        if (Keyboard.isKeyDown(Keyboard.KEY_SPACE))
            disparo = new Disparo(jugador.getX()+jugador.getSX()/2,jugador.getY()+jugador.getSY());
        
    }
    public void update()
    {
        
        jugador.update();
        enemigo1.update();
        if( disparo != null)
        {
            disparo.update();
            if (Physics.checkCollisions(enemigo1, disparo))
                
                System.out.println("colision");
        }
    }
    public void render()
    {
        
        jugador.render();
        enemigo1.render();
        if( disparo != null)
            disparo.render();
        /*
        for (GameObject go : objects)
            go.render();
        */
        
    }
    
    
}
