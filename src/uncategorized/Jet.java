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
public class Jet extends GameObject{
    private static final int SIZEY = 16;
    private static final int SIZEX = SIZEY *2 ;
    private static final float SPEED = 2f;
    private static final String type = "Jet";
    private static int life = 100;
    private static final int dmg = 10;
    
    public Jet( float x, float y) {
        this.x = x;
        this.y = y;
        this.sx = SIZEX;
        this.sy = SIZEY;
       
        

        
    }
    
    public String getType()
    {
        return type;
    }

    public int getLife()
    {
        return life;
    }

    public void addLife(int mag)
    {
        life += mag;
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
