package uncategorized;


public class Bombardero extends GameObject{
    

    private static final int SIZEY = 16;
    private static final int SIZEX = SIZEY *2 ;
    private static final float SPEED = 0.5f;


    
    public Bombardero( float x, float y) {
        this.x = x;
        this.y = y;
        this.sx = SIZEX;
        this.sy = SIZEY;
        this.life = 2;
        this.dmg = 2;
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
