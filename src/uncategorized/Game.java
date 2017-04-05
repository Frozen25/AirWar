package uncategorized;



import java.util.Random;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;
import static uncategorized.Main.loadTexture;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Alexis
 */
public class Game {
    
    //private ArrayList<GameObject> objects;
    
    private Heroe player;
    //private ColaEnemigos Cola;
    
   private int milis =0;
     
    private Shoot disparo;
    
    ListaDoble Lista = new ListaDoble();
    ColaEnemigos Cola = new ColaEnemigos();
    ListaDoble proyectiles =new ListaDoble();
    Random randomx = new Random();
    Boss jefe1;
    boolean bandera = true;
    
    Timer tim=new Timer();
	
	TimerTask task01=new TimerTask(){
            public void run(){
    		milis++;
                if (milis%20 == 10)
                        bandera = true;        
            }    
        };
        
    		
    public void start(){
    	tim.scheduleAtFixedRate(task01, 1000,10);
    	
    }
    public boolean Divisible(){
    	return (milis %2 ==1);
    } 
    
    public Game()
    {
        //objects = new ArrayList<GameObject>();
    	
    	this.start();
        
        
        player = new Heroe( "nombre", 3, Display.getWidth()*1/8  /2,0);
        
        jefe1 = new Boss();        
        
        
        
        int numero_enemigos = 6;
        
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
            int randomx_pos =  randomx.nextInt(60)*10+100;             
            
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
        disparo = new Shoot(player.getX()+player.getSX()/2,player.getY()+player.getSY());
     
        if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)){ 
        	
        	if( bandera )
                {
                    //milis
                    
                    proyectiles.insertFirst(disparo);
                    bandera = false;
                
                }
        }
       
        
        
    }
    public void update()
    {
        
        player.update();
        
        Lista.Updateall();
        jefe1.update();
        if( proyectiles.getSize() != 0)
        {
        	proyectiles.Updateall();
                NodoDoble current =  proyectiles.getHead();
        	while (current != null)
                {
                    if (Physics.checkwithListaDoble(current.getData(), Lista))
                        proyectiles.delete(current);
                    current = current.getNext();
                }
                //System.out.println(xx);
                
            
        }       
    }
    
    public void render()
    {

                
        player.render();
        jefe1.render();
        //Lista.peek().getData().render();
        //jet1.render();
        Lista.Renderall();
        if( proyectiles != null){
        	proyectiles.Renderall();
           
        	  }
        
       /*
        for (GameObject go : objects)
            go.render();
        */
        
    }
    
    
}