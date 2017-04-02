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
public class Boss extends GameObject {
    private static final int SIZEY = 100;
    private static final int SIZEX = SIZEY *3 ;
    private static final float SPEED = 2f;
    private int direccion = 1;

    
    public Boss( ) {
        this.x = Display.getWidth()/2 + SIZEX/2;
        this.y = Display.getHeight() - SIZEY;
        this.sx = SIZEX;
        this.sy = SIZEY;
        this.life = 5;
        this.dmg = 1;
        

        
    }



    
    
    @Override
    public void update()
    {
        if (direccion ==1)
        {
            if (x+sx/2 < Display.getWidth() - sx/2)
            {    
                x += SPEED*direccion;
            }
            else
                direccion *= -1;
        }
        if (direccion ==-1)
        {
            if (x > 0 )
            {    
                x += SPEED*direccion;
            }
            else
                direccion *= -1;
        
        
        }
             
    }
       
    
}
