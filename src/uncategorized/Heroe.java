package uncategorized;

import uncategorized.Comun;

public class Heroe extends Comun {

    public static final int SIZEY = 16;
    public static final int SIZEX = SIZEY * 5;
    public static final float SPEED = 4f;
    
    
    public Heroe(String nombre, int vida, int municion, float x, float y) {
            super(nombre, vida, municion);
        this.x = x;
        this.y = y;
        this.sx = SIZEX;
        this.sy = SIZEY;           
    }
    


    
    
    @Override
    public void update()
    {
        //if (Physics.checkCollisions(this, ball))
        //    ball.reverseX(getCenterY());
    }
    
    public void moveY(float mag)
    {
        y += SPEED * mag;
    }
    public void moveX(float mag)
    {
        x += SPEED * mag;
    }
    
}

        
        
        
        


