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
public class GOPlayer extends GameObject
{
    public static final int SIZEX = 16;
    public static final int SIZEY = SIZEX * 7;
    public static final float SPEED = 4f;
    
    
    public GOPlayer(float x, float y){
        this.x = x;
        this.y = y;
        this.sx = SIZEX;
        this.sy = SIZEY;
    
    
    }
    
    
    
    @Override
    public void update()
    {
    
    }
    
    public void move(float mag)
    {
        y += SPEED * mag;
    }
    
}
