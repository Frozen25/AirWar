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
public class Bombardero extends GameObject{
    

    private static final int SIZEY = 16;
    private static final int SIZEX = SIZEY *2 ;
    private static final float SPEED = 0.5f;
    private static final int dmg = 30;

    
    public Bombardero( float x, float y) {
        this.x = x;
        this.y = y;
        this.sx = SIZEX;
        this.sy = SIZEY;
        this.life = 100;
       
        
 
    }

    public int getDmg()
    {
        return dmg;
    }
    
    @Override
    public void update()
    {

        y -= SPEED;
    }
       
    
}
