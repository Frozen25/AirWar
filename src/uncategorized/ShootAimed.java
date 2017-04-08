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
public class ShootAimed extends GameObject{
    

    private static final int SIZEX = 5;
    private static final int SIZEY = 20;
    private static final float SPEED = 1/200f;
    private float calcx;
    private float calcy;
    
    public ShootAimed (float x , float y, float playerX, float playerY, int dmg)
    {
        this.x = x;
        this.y = y;
        this.sx = SIZEX;
        this.sy = SIZEY;
        this.life = 1;
        this.dmg = dmg;
        this.calcx = (playerX - this.getCenterX());
        this.calcy = (playerY - this.getCenterY());
    }
    
    
@Override
    public void update()
    {
        
        x += (calcx *SPEED);
        y += (calcy *SPEED);
    }
    
@Override
    public void render()
    {
    
        Draw.rect(x, y, sx, sy, (float) ( -1*Math.toDegrees(Math.atan(calcy/calcx))));
    }

    
}