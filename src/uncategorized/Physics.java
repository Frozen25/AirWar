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
    
    
    
  
    
    public static ListaDoble checkwithListaDoble (GameObject go, ListaDoble lista )
    {
        NodoDoble current = lista.getHead();
        while (current != null)
        {
            if (checkCollisions( go,  current.getData()))
            {
                if (lista.getSize() == 1)
                {
                    lista.setHead(null);
                    lista.setLast(null);
                    lista.reducir();
                }
                else if (current == lista.getHead() )
                {
                    lista.setHead(current.getNext());
                    current.getNext().setPrev();
                    lista.reducir();
                    
                }   
                else if (current == lista.getLast())   
                {
                    lista.setLast(current.getPrev());
                    current.getPrev().setNext();
                    lista.reducir();
                }
                else   
                {
                    current.getPrev().setNext(current.getNext());
                    current.getNext().setPrev(current.getPrev());
                    lista.reducir();
                }
            }
            
            current = current.getNext();
        }
        return lista;
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
