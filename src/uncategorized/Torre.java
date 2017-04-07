/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uncategorized;

import org.lwjgl.opengl.Display;

/**
 *
 * @author Alexis
 */
public class Torre extends GameObject{
    
    

    private static final int SIZEY = 50;
    private static final int SIZEX = SIZEY /2 ;
    private static final float SPEED = 1/200f;
    private float calcy;
    
    public Torre( float posX , float posY, int tipo)  {
        this.x = posX;
        this.y = Display.getHeight();
        this.sx = SIZEX;
        this.sy = SIZEY;
        this.life = 5;
        this.calcy = (posY);
        if (tipo == 1)
        {
            this.dmg = 1;
        }
        else
        {
            this.dmg = 3;
        }

        
    }



    
    
    @Override
    public void update()
    {
        System.out.println(y );
        System.out.println(calcy);
        if (y >= calcy)
        {
            y -= (calcy *SPEED);
        }
    }
    
    
    
    
    
}
