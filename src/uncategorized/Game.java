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

     
    private Shoot disparo;
    
    ListaDoble Lista = new ListaDoble();
    ColaEnemigos Cola = new ColaEnemigos();
    ListaGenerica proyectiles =new ListaGenerica();
    Random randomx = new Random();
    Boss jefe1;
    
    public Game()
    {
        //objects = new ArrayList<GameObject>();
        
        
        player = new Heroe( "nombre", 3, Display.getWidth()*1/8  /2,0);
        
        jefe1 = new Boss();        
        
        
        
        int numero_enemigos = 0;
        
        Random random = new Random();
        for (int i = 1; i <= numero_enemigos; i++) {
            int value =  random.nextInt(3);
            Cola.encolar(value);
        }
        Cola.encolar(0);
        //jet1 = new Jet(  Display.getWidth()/2  , Display.getHeight()); 
        //Lista.insertFirst(jet1);
        //System.out.println(Lista.peek().getData().getClass());
        
        
        while ( !Cola.isEmpty()  )
        {
            int x = Cola.desencolar().getData();
            System.out.println(x);
            int randomx_pos =  randomx.nextInt(70)*10+100;             
            
            if (x==0)
            {
                Jet jet1;
                jet1 = new Jet(  randomx_pos  , Display.getHeight()); 
                Lista.insertFirst(jet1);
                System.out.println("jet1 ins");
            }
            if (x==1)
            {
                Kamikaze kami1;
                kami1 = new Kamikaze (randomx_pos  , Display.getHeight(), player.getCenterX(), player.getY()); 
                Lista.insertFirst(kami1);
                System.out.println("kami1 ins");
            }
            if (x==2)
            {
                Bombardero bomb1;
                bomb1 = new Bombardero (randomx_pos  , Display.getHeight()); 
                Lista.insertFirst(bomb1);
                System.out.println("bomb1 ins");
            }
            
            
        }
        //Cola.encolar(1);
        //Cola.encolar(2);
        //System.out.println(Cola.desencolar().getData());
        //System.out.println(Cola.desencolar().getData());
        
        
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
        if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)){
        	
        
        	disparo = new Shoot(player.getX()+player.getSX()/2,player.getY()+player.getSY());
        	proyectiles.Add(disparo);
        	}
        
        
    }
    public void update()
    {
        
        player.update();
        
        Lista.Updateall();
        
        if( proyectiles != null)
        {
        	proyectiles.updatelis();
        	//disparo.update();
            
            
        }
        /*if( proyectiles != null)
        {
        	proyectiles.update();
            
            
        }*/
        
    }
    
    public void render()
    {

                
        player.render();

        //Lista.peek().getData().render();
        //jet1.render();
        Lista.Renderall();
        if( proyectiles != null){
        	proyectiles.renderList();
            //disparo.render();
        	}
        
        /*if( proyectiles != null)
            proyectiles.renderList();
        /*
        for (GameObject go : objects)
            go.render();
        */
        
    }
    
    
}