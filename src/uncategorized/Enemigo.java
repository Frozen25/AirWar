package uncategorized;

import uncategorized.Comun;

public class Enemigo extends GameObject {
	
	
        public static final int SIZEY = 16;
        public static final int SIZEX = SIZEY *2 ;
        public static final float SPEED = 2f;
        

	public Enemigo(int tipo, float x, float y) {
            this.x = x;
            this.y = y;
            this.sx = SIZEX;
            this.sy = SIZEY; 
            
        
/*
            this.tipo=tipo;
            if (this.tipo==1){
                    this.setNombre("jet");
            }if (this.tipo==2){
                    this.setNombre("bombardero");
            }if (this.tipo==3){
                    this.setNombre("torre metralla");
            }if (this.tipo==4){
                    this.setNombre("torre misil");
            }if (this.tipo==5){
                    this.setNombre("Kamikaze");
            }if (this.tipo==6){
                    this.setNombre("jefe");
            }
            */
            
            
        }
        
    @Override
    public void update()
    {
        
        y -= SPEED;
        
    }
    
    public void moveY(float mag)
    {
        y -= SPEED;
    }
    public void moveX(float mag)
    {
        x += SPEED * mag;
    }


}
