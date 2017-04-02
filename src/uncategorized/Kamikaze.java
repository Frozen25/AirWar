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
public class Kamikaze extends GameObject {

    private static final int SIZEY = 16;
    private static final int SIZEX = SIZEY *2 ;
    private static final float SPEED = 1/200f;    
    private float calcx;
    private float calcy;
    
    
    public Kamikaze( float x, float y, float playerX , float playerY) {
        this.x = x;
        this.y = y;
        this.sx = SIZEX;
        this.sy = SIZEY;
        this.life = 5;
        this.dmg = 0;
        this.calcx = (playerX - this.getCenterX());
        this.calcy = (playerY - this.getCenterY());

        
    }
    
    @Override
    public void update()
    {
        x += (calcx *SPEED);
        y += (calcy *SPEED);
    }
    


    
}
