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
public abstract class GameObject {
    
    protected float x;
    protected float y;
    protected float sx;
    protected float sy;
    abstract void update();
    public void render()
    {
        Draw.rect(x,y,sx,sy);
    }
    
    public float getX ()
    {
        return x;
    }
    
    public float getY()
    {
        return y;
    }
    
    public float getSX()
    {
        return sx;
    }
    
    public float getSY()
    {
        return sy;
    }
    
    public float getCenterY()
    {
        return y + sy/2;
     
    }
    
}
