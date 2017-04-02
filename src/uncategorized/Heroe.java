package uncategorized;

import org.lwjgl.opengl.Display;


public class Heroe extends GameObject {

    private static final int SIZEY = 16;
    private static final int SIZEX = SIZEY * 5;
    private static final float SPEED = 4f;
    
    
    public Heroe(String nombre,  int ammo, float x, float y) {
            
        this.x = x;
        this.y = y;
        this.sx = SIZEX;
        this.sy = SIZEY;
        this.life = 50;
        this.dmg = 5;
    }
    
    
    
    
    @Override
    public void update()
    {
        //if (Physics.checkCollisions(this, ball))
        //    ball.reverseX(getCenterY());
    }
    
    public void moveY(float mag)
    {
        if (mag > 0)
            if (y < ((Display.getHeight() )- this.sy * 1.2))
                y += SPEED * mag;
        if (mag <0)
            if (y>0)
                y += SPEED * mag;
    }
    public void moveX(float mag)
    {
        if (mag > 0)
        {
            if (x+sx < Display.getWidth())
            {
                x += SPEED * mag;
            }  
        }
        if (mag < 0)
        {
            if (x>0)
            {
                x += SPEED * mag;
            }
                
        }
                
    }
    
}

        
        
        
        


