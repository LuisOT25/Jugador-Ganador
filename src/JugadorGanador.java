import java.io.*;
import java.util.Scanner;

public class JugadorGanador {
    public static void main(String[] args){
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Ingresa la ruta del archivo que contiene las instrucciones encriptadas:");
            String ruta = scan.nextLine();
            System.out.println("Ingresa la ruta donde se guardara archivo que contiene los Resultados:");
            String rutaResultado = scan.next();
            File doc = new File(ruta);
            scan = new Scanner(doc);
            File resultado = new File(rutaResultado + "\\ResultadoJugadorGanador.txt");
            resultado.createNewFile();
            FileWriter fw = new FileWriter(resultado);
            BufferedWriter bw = new BufferedWriter(fw);
            int rondas = Integer.parseInt(scan.nextLine());
            int ganador = 0, ventaja = 0, player1 = 0, player2 = 0;
            for (int ii = 0; ii < rondas; ii++) {
                String[] marcadores = scan.nextLine().split(" ");
                player1 = player1 + Integer.parseInt(marcadores[0]);
                player2 = player2 + Integer.parseInt(marcadores[1]);
                int resta = player1 - player2;
                if (Math.abs(resta) > ventaja) {
                    ventaja = Math.abs(resta);
                    if (player1 >= player2) {
                        ganador = 1;
                    } else {
                        ganador = 2;
                    }

                }
            }
            bw.write(Integer.toString(ganador));
            bw.write(" ");
            bw.write(Integer.toString(ventaja));
            bw.close();
        }catch (FileNotFoundException FnotFex){
            System.out.println("El archivo que quiere analizar no existe");
        } catch (IOException ex) {
            System.out.println("La ruta donde quiere guardar el archivo no existe o está mal");
        }
    }
}
