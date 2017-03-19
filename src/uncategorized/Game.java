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
    private GOBall ball;
    private Enemigo enemigo1;
    
    public Game()
    {
        //objects = new ArrayList<GameObject>();
        
        ball = new GOBall(Display.getWidth()/2 - GOBall.SIZE/2 , Display.getHeight()/2 - GOBall.SIZE/2);
        jugador = new Heroe( "nombre ", 3, 100 , Display.getWidth()/2 - Heroe.SIZEX /2,0);
        enemigo1 = new Enemigo("", 1, 10, 1, Display.getWidth()/2 - Enemigo.SIZEX/2 , Display.getHeight() - Enemigo.SIZEY); 
        
        //objects.add(ball);
        //objects.add(jugador);
        
    }
    
    public void getInput()
    {
        if (Keyboard.isKeyDown(Keyboard.KEY_W) || (Keyboard.isKeyDown(Keyboard.KEY_UP)))
            jugador.moveY(1);
        if (Keyboard.isKeyDown(Keyboard.KEY_S) || (Keyboard.isKeyDown(Keyboard.KEY_DOWN)))
            jugador.moveY(-1);
        if (Keyboard.isKeyDown(Keyboard.KEY_A) || (Keyboard.isKeyDown(Keyboard.KEY_LEFT)))
            jugador.moveX(-1);
        if (Keyboard.isKeyDown(Keyboard.KEY_D) || (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)))
            jugador.moveX(1);
        
    }
    public void update()
    {
        ball.update();
        jugador.update();
        enemigo1.update();
        //for (GameObject go : objects)
        //    go.update();
    }
    public void render()
    {
        ball.render();
        jugador.render();
        enemigo1.render();
        /*
        for (GameObject go : objects)
            go.render();
        */
        
    }
    
    
}
