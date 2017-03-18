/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pong;
import static org.lwjgl.opengl.GL11.*;

/**
 *
 * @author Alexis
 */
public class Draw {
    
    
    static void rect(float x, float y, float width, float height)
    {
        glPushMatrix();
        {
            glTranslatef(x,y,0);
            glBegin(GL_QUADS);
            {
                glVertex2f(0,0);
                glVertex2f(0,height);
                glVertex2f(width,height);
                glVertex2f(width,0);       
            }

            glEnd();
        }
        glPopMatrix();
    }     
}
