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
public class GOBall extends GameObject
{
    public static final int SIZE = 16;
    public static final float MAX_SPEEDX = 4f;
    public static final float MAX_SPEEDY = 8f;
    public final float velX;
    public final float velY;
    
    public GOBall(float x, float y)
    {
        this.x = x;
        this.y = y;
        this.sx = SIZE;
        this.sy = SIZE;
        
        velX = -MAX_SPEEDX;
        velY = 0;
    }
    
    
    
    @Override
    public void update()
    {
        x += velX;
        y += velY;
        
    }
}
