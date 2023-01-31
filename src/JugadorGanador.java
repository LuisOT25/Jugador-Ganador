import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class JugadorGanador {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingresa la ruta del archivo que contiene las instrucciones encriptadas:");
        String ruta = scan.nextLine();
        System.out.println("Ingresa la ruta donde se guardara archivo que contiene los Resultados:");
        String rutaResultado = scan.next();
        File doc = new File(ruta);
        scan = new Scanner(doc);
        int rondas = Integer.parseInt(scan.nextLine());
        int ganador=0,ventaja =0;
        for (int ii=0; ii<rondas;ii++){
            String[] marcadores = scan.nextLine().split(" ");
            System.out.println(marcadores[0]+" "+marcadores[1]);
            int resta = Math.abs(Math.abs(Integer.parseInt(marcadores[0]))-Math.abs(Integer.parseInt(marcadores[1])));
            if(resta>ventaja){
                ventaja=resta;
                if (Math.abs(Integer.parseInt(marcadores[0]))>=Math.abs(Integer.parseInt(marcadores[1]))){
                    ganador=1;
                }else{
                    ganador=2;
                }

            }
        }
        File resultado = new File(rutaResultado+"\\ResultadoJugadorGanador.txt");
        resultado.createNewFile();
        FileWriter fw = new FileWriter(resultado);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(Integer.toString(ganador));
        bw.write(" ");
        bw.write(Integer.toString(ventaja));
        bw.close();
    }
}
