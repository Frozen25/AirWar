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
    private GOBall ball;
    
    public GOPlayer(float x, float y, GOBall ball){
        this.x = x;
        this.y = y;
        this.sx = SIZEX;
        this.sy = SIZEY;
        this.ball = ball;
    
    }
    
    
    
    @Override
    public void update()
    {
        if (Physics.checkCollisions(this, ball))
            ball.reverseX();
    }
    
    public void move(float mag)
    {
        y += SPEED * mag;
    }
    
}
