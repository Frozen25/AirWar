/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uncategorized;

import java.awt.Rectangle;

/**
 *
 * @author Alexis
 */
public class Physics {
    public static boolean checkCollisions(GameObject go1, GameObject go2)
    {
        Rectangle r1 = new Rectangle((int)go1.getX(),(int)go1.getY(),(int)go1.getSX(),(int)go1.getSY());
        Rectangle r2 = new Rectangle((int)go2.getX(),(int)go2.getY(),(int)go2.getSX(),(int)go2.getSY());
        
        return r1.intersects(r2);
    }
    
    
    
  
    
    public static boolean checkwithListaDoble (GameObject go, ListaDoble lista )
    {
        NodoDoble current = lista.getHead();
        while (current != null)
        {
            if (checkCollisions( go,  current.getData()))
            {
                current.getData().addLife(-1 * go.getDmg());
                if (current.getData().getLife() <= 0)
                {
                    if (current.getData() instanceof Boss)
                    {
                        Main.changelevel();
                    }
                    lista.delete(current);
                    return true;
                }
                else
                    return true;
            }
            
            current = current.getNext();
        }
        return false;
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
