package uncategorized;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Servidor {
    public static void main(String[] args) {
        try {
            ServerSocket puerto = null;
            Socket canalComunicacion = null;
            InputStream bufferEntrada;
            DataInputStream datos;
            puerto = new ServerSocket(10831);
            canalComunicacion = puerto.accept();
            bufferEntrada = canalComunicacion.getInputStream();
            datos = new DataInputStream(bufferEntrada);
            String cadena = new String(datos.readUTF());
            while (cadena.length() > 0) {
                System.out.print(cadena);
                cadena = datos.readUTF();
            }
            datos.close();
            bufferEntrada.close();
            canalComunicacion.close();
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}