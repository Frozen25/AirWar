package uncategorized;
import java.util.Random;

import org.lwjgl.opengl.Display;

public class Tester {
	private static Jet jet1;
	private static Kamikaze kami1;
	private static Bombardero bom1;
	private static Heroe player;
	
	public Tester(Heroe heroe){
		this.player =heroe;
	}
	
public static ColaEnemigos Generador(int totalEne){
	ColaEnemigos cola = new ColaEnemigos();
	Random r=new Random();
	for(int i=1;i==totalEne;i++){
		
		int num = r.nextInt(3);
		switch(num){
		case 1:
			jet1= new Jet( Display.getWidth()/2  , Display.getHeight());
			cola.insert(jet1);
			break;
		case 2:
			kami1 = new  Kamikaze(Display.getWidth()/2  , Display.getHeight(), player.getCenterX(), player.getY());
			break;
		case 3:
			bom1 =new Bombardero(Display.getWidth()/2  , Display.getHeight());
			break;
		}
	}
	return cola;
}
public static void main(String arg[]){
	Tester test =new Tester(player);
    test.Generador(9);
}
}
