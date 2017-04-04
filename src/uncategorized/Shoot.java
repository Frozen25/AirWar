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
public class Shoot extends GameObject
{
    public static final int SIZEX = 5;
    public static final int SIZEY = 20;
    public static final float SPEED = 4f;
    
    public Shoot (float x , float y)
    {
        this.x = x;
        this.y = y;
        this.sx = SIZEX;
        this.sy = SIZEY;
    }
    
    
    
    
    
    
@Override
    public void update()
    {
        y += SPEED;
    }

    
}
