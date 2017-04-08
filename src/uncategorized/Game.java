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
    
    public static Heroe player = new Heroe( "nombre", 3, Display.getWidth()*1/2,0);
    //private ColaEnemigos Cola;
    
   private int milis =0;

    private Shoot disparo;
    private Shoot disparoEnemi;
    ListaDoble Lista = new ListaDoble();
    ColaEnemigos Cola = new ColaEnemigos();
    ListaDoble proyectiles =new ListaDoble();
    ListaDoble proyectilesEnemigos =new ListaDoble();
    Random randomx = new Random();
    private int level;
    ListaDoble L_Torres;
    
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
    
    
    public Game(int numeronivel)
    {
        
    	level = numeronivel;
    	this.start();
        
        
        
        
      

        
        
        int numero_enemigos = 6;
        
        Random random = new Random();
        for (int i = 1; i <= numero_enemigos; i++) {
            int value =  random.nextInt(3);
            Cola.encolar(value);
        }
        Cola.encolar(3);
        
        /*
        int numero_torres = 7;
        for (int i = 1;i <= 7;i++)
        {
            int randomx_pos =  randomx.nextInt(60)*10+100; 
            int randomy_pos =  randomx.nextInt(500);
            System.out.println(randomx_pos);
            System.out.println(randomy_pos);
            System.out.println(i);
            if (i%4 == 3)
            {
                Torre t1;
                t1 = new Torre(randomx_pos ,randomy_pos,2);
                L_Torres.insertFirst(t1);
            }
            else
            {
                Torre t1;
                t1 = new Torre(randomx_pos ,randomy_pos,1);
                L_Torres.insertFirst(t1);
                
            }
            
        
        }*/
        

          
            
        //End of public Game	
        }
        

        

    public void recreate()
    {
        if ((Lista.getSize() < 4) && (milis % 10 == 1))
            {
                //System.out.println(Lista.getSize());
                if (!Cola.isEmpty() )
                {
                    int x = Cola.desencolar().getData();
                    //System.out.println(x);
                    int randomx_pos =  randomx.nextInt(600)+100;             

                    if (x==0)
                    {
                        Jet jet1;
                        jet1 = new Jet(  randomx_pos  , Display.getHeight()); 
                        Lista.insertFirst(jet1);
                        //System.out.println("jet1 ins");
                        //System.out.println( jet1 instanceof uncategorized.Jet );
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
                    else if (x==3)
                    {
                        Boss jefe1;
                        jefe1 = new Boss (); 
                        Lista.insertFirst(jefe1);
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
              
                    disparo = new Shoot(player.getX()+player.getSX()/2,player.getY()+player.getSY(),"heroe", player.getDmg());
                    proyectiles.insertFirst(disparo);
                    bandera = false;
                
                }
        }
       
        
        
    }
    
    public void update()
    {
        
        player.update();

        if (player.getLife() <= 0)
        {
            if (!(player.getheart() <= 0))
            {
                System.out.println("dead");
                player.addLife(50);
                player.addLife(-1);
            }
            else
            {
                System.out.println("defeat");
            }
        }
        
        if (Lista.getSize() != 0)
        {
            Lista.Updateall();
            /*
            NodoDoble current =  Lista.getHead();
        	while (current != null)
                {
                    if (Physics.checkwithListaDoble(player, Lista))
                        Lista.delete(current);
                    current = current.getNext();
                }
                */
        }
        
        if (Lista!= null){
        	NodoDoble tempdis =  Lista.getHead();
        	if(milis%50==1){
                    while (tempdis != null)
                    {

                        if (tempdis.getData() instanceof uncategorized.Jet )
                        {
                            disparoEnemi = new Shoot(tempdis.getData().getX()+tempdis.getData().getSX()/2+1,
                                                        tempdis.getData().getY()-tempdis.getData().getSY(),
                                                            "enemigo",tempdis.getData().getDmg());
                            proyectilesEnemigos.insertFirst(disparoEnemi);
                        }
                        else if (tempdis.getData() instanceof uncategorized.Bombardero )
                        {
                            disparoEnemi = new Shoot(tempdis.getData().getX()+tempdis.getData().getSX()/3+2,
                                                        tempdis.getData().getY()-tempdis.getData().getSY(),
                                                            "enemigo",tempdis.getData().getDmg());
                            proyectilesEnemigos.insertFirst(disparoEnemi);
                        }
                        else if (tempdis.getData() instanceof uncategorized.Boss )
                        {
                            disparoEnemi = new Shoot(tempdis.getData().getX()+tempdis.getData().getSX()+2,
                                                        tempdis.getData().getY()-tempdis.getData().getSY()/3,
                                                            "enemigo",tempdis.getData().getDmg());
                            proyectilesEnemigos.insertFirst(disparoEnemi);
                            
                            disparoEnemi = new Shoot(tempdis.getData().getX()+tempdis.getData().getSX()/10,
                                    tempdis.getData().getY()-tempdis.getData().getSY()/3,
                                        "enemigo",tempdis.getData().getDmg());
                            
                            proyectilesEnemigos.insertFirst(disparoEnemi);
                            disparoEnemi = new Shoot(tempdis.getData().getX()+tempdis.getData().getSX()/2,
                                    tempdis.getData().getY()-tempdis.getData().getSY()/3,
                                        "enemigo",tempdis.getData().getDmg());
                            
                            proyectilesEnemigos.insertFirst(disparoEnemi);
                        }
                        
                        tempdis =tempdis.getNext();


                    }
        	}
        }
  
        
        

        
        
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
                    {
                        player.addLife(-1*tmp.getData().getDmg());
                        proyectilesEnemigos.delete(tmp);
                    
                    }
                    tmp = tmp.getNext();
                }
                //System.out.println(xx);
                
            
        }
        
        
    }
    
    public void render()
    {


        player.render();

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