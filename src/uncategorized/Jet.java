
package uncategorized;

public class Jet extends GameObject{
    private static final int SIZEY = 16;
    private static final int SIZEX = SIZEY *2 ;
    private static final float SPEED = 2f;

    
    public Jet( float x, float y) {
        this.x = x;
        this.y = y;
        this.sx = SIZEX;
        this.sy = SIZEY;
        this.life = 5;
        this.dmg = 1;
        

        
    }



    
    
    @Override
    public void update()
    {

        y -= SPEED;
    }
       
    
}
