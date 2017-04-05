package uncategorized;

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
