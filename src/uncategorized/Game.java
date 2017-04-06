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
    private Shoot disparoEnemi;
    ListaDoble Lista = new ListaDoble();
    ColaEnemigos Cola = new ColaEnemigos();
    ListaDoble proyectiles =new ListaDoble();
    ListaDoble proyectilesEnemigos =new ListaDoble();
    Random randomx = new Random();
    Boss jefe1;
    boolean bandera = true;
    boolean disparos = true;
    Timer tim=new Timer();
	
	TimerTask task01=new TimerTask(){
            public void run(){
    		milis++;    		
                if (milis%200 == 1){
                        bandera = true; }
                
            } 
            
            
        };
        
    		
    public void start(){
    	tim.schedule(task01, 1000,1);
    	
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
        
        

        	this.recreate();
          
            
        	
        }
        
        //Cola.encolar(1);
        //Cola.encolar(2);
        //System.out.println(Cola.desencolar().getData());
        //System.out.println(Cola.desencolar().getData());
        
        
        //System.out.println(Lista.TakeFirst().getData().getClass().toString());
        
        

    public void recreate()
    {
        if ((Lista.getSize() < 4) && (milis % 10 == 1))
            {
                System.out.println(Lista.getSize());
                if (!Cola.isEmpty() )
                {
                    int x = Cola.desencolar().getData();
                    //System.out.println(x);
                    int randomx_pos =  randomx.nextInt(60)*10+100;             

                    if (x==0)
                    {
                        Jet jet1;
                        jet1 = new Jet(  randomx_pos  , Display.getHeight()); 
                        Lista.insertFirst(jet1);
                        //System.out.println("jet1 ins");
                    }
                    else if (x==1)
                    {
                        Kamikaze kami1;
                        kami1 = new Kamikaze (randomx_pos  , Display.getHeight(), player.getCenterX(), player.getY()); 
                        Lista.insertFirst(kami1);
                        //System.out.println("kami1 ins");
                    }
                    else if (x==2)
                    {
                        Bombardero bomb1;
                        bomb1 = new Bombardero (randomx_pos  , Display.getHeight()); 
                        Lista.insertFirst(bomb1);
                        //System.out.println("bomb1 ins");
                    }
                }

            }
    
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
        	
        	if( bandera )
                {
              
                    
                    proyectiles.insertFirst(disparo);
                    bandera = false;
                
                }
        }
       
        
        
    }
    
    public void update()
    {
        
        player.update();
        disparo = new Shoot(player.getX()+player.getSX()/2,player.getY()+player.getSY(),"heroe");
        Lista.Updateall();
        
        if (Lista!= null){
        	NodoDoble tempdis =  Lista.getHead();
        	if(milis%50==1){
        	while (tempdis != null){
        		disparoEnemi = new Shoot(tempdis.getData().getX()+tempdis.getData().getSX()/2+1,tempdis.getData().getY()-tempdis.getData().getSY(),"enemigo");
        		proyectilesEnemigos.insertFirst(disparoEnemi);
        		tempdis =tempdis.getNext();
        		
        	}
        	}
        }
  
        
        
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
        
        if( proyectilesEnemigos.getSize() != 0)
        {
        	proyectilesEnemigos.Updateall();
               NodoDoble tmp =  proyectilesEnemigos.getHead();
        	while (tmp != null)
                {
                    if (Physics.checkCollisions(tmp.getData(), player))
                    	proyectilesEnemigos.delete(tmp);
                    tmp = tmp.getNext();
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
        
        if( proyectilesEnemigos != null){
        	proyectilesEnemigos.Renderall();
           
        	  }
        
       /*
        for (GameObject go : objects)
            go.render();
        */
        
    }
    
    
}