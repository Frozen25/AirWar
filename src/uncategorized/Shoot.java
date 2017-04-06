package uncategorized;

public class Shoot extends GameObject
{
    public static final int SIZEX = 5;
    public static final int SIZEY = 20;
    public static final float SPEED = 4f;
    public String type;
    
    public Shoot (float x , float y, String type)
    {
        this.x = x;
        this.y = y;
        this.sx = SIZEX;
        this.sy = SIZEY;
        this.type=type;
    }
    
    
@Override
    public void update()
    {
	if(type.equalsIgnoreCase("Heroe")){
        y += SPEED;}
	if(type.equalsIgnoreCase("enemigo")){
        y -= SPEED;}
    }
    
}
