/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uncategorized;

/**
 *
 * @author Daniel
 */
import java.net.*;
import java.io.*;

public class Conector {
    ServerSocket server;
    Socket socket;
    int puerto = 9000;
    
    // envia datos
    DataOutputStream salida;
    
    //resive datos
    BufferedReader entrada;
    public void iniciar()
    {
        try{
            server = new ServerSocket(puerto);
            socket = new Socket();
            socket = server.accept();
            while (true)
            {
            
            	entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            	String mensaje = entrada.readLine();
            	System.out.println(mensaje);
            	salida = new DataOutputStream(socket.getOutputStream());
            	salida.writeUTF("Adios");
            	}
           
        }catch(Exception e){};
}
}
