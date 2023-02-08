import java.io.*;
import java.util.Scanner;

public class JugadorGanador {
    public static void main(String[] args){
            FilesHandler fileHandler = new FilesHandler(args[0],args[1] );
            fileHandler.leerArchivo();
    }
}
