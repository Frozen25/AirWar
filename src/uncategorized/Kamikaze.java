/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uncategorized;

/**
 *
 * @author Alexis
 */
public class Kamikaze extends GameObject {

    public static final int SIZEY = 16;
    public static final int SIZEX = SIZEY *2 ;
    public static final float SPEED = 2f;
    private static final String tipo = "Kamikaze";
    private static int vida = 100;

    private float calcx;
    private float calcy;
    
    
    public Kamikaze( float x, float y, float jugadorx , float jugadory) {
        this.x = x;
        this.y = y;
        this.sx = SIZEX;
        this.sy = SIZEY;
        this.calcx = (jugadorx - this.getCenterX())/400;
        this.calcy = (jugadory - this.getCenterY())/400;
        
        

        
    }
    
    public String getTipo()
    {
        return tipo;
    }

    public int getVida()
    {
        return vida;
    }

    public void addVida(int mag)
    {
        vida += mag;
    }

    
    
    
    
    
    @Override
    public void update()
    {
        //float a = jugadorx - this.getX();
        x += (calcx *SPEED);
        //float b = jugadory - this.getY();
        y += (calcy *SPEED);
        
        
        //y -= SPEED;
    }
    
    public void moveY(float mag)
    {
        y -= SPEED;
    }
    public void moveX(float mag)
    {
        //float a = jugadorx - this.getX();
        //x += (a/1000 *SPEED);
        x += SPEED * mag;
    }

    


    
}
