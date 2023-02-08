import java.io.*;

public class FilesHandler {
    String rutaEntrada;
    String rutaResultao;

    public FilesHandler(String rutaEntrada, String rutaResultao) {
        this.rutaEntrada = rutaEntrada;
        this.rutaResultao = rutaResultao;
    }
    public int contarRenglones() throws FileNotFoundException {
        File doc = new File(rutaEntrada);
        FileReader fR = new FileReader(doc);
        BufferedReader bR = new BufferedReader(fR);
        int renglones = (int) bR.lines().count();
        return renglones;
    }
    public int[][] leerArchivo(){
        try {
            File doc = new File(rutaEntrada);
            FileReader fR = new FileReader(doc);
            BufferedReader bR = new BufferedReader(fR);
            int lineas = contarRenglones();
            int totalRondas = Integer.parseInt(bR.readLine());
            if (lineas-1!=totalRondas){
                throw new RuntimeException("El numero de rondas no coincide");
            } else if (totalRondas>1000) {
                throw new RuntimeException("El numero de rondas no puede ser mayor a 1000");
            } else {
                int[][] tablero = new int[totalRondas][2];
                for (int ronda = 0; ronda < totalRondas; ronda++) {
                    String[] linea= bR.readLine().split(" ");
                    for (int jugador=0; jugador<tablero[ronda].length;jugador++){
                        if (!linea[jugador].matches("[0-9]*")){
                            throw new RuntimeException("Hay un caracter invalido en la linea: "+(ronda+1));
                        }
                        tablero[ronda][jugador]=Integer.parseInt(linea[jugador]);
                    }
                }
                return tablero;
            }
        } catch (FileNotFoundException e) {
            System.out.println("La ruta de entrada no fue encontrada");
        } catch (IOException e) {
            System.out.println("Ocurrio un error al intentar leer el archivo");
        }catch (RuntimeException runEx){
            System.out.println(runEx.getMessage());
        }
        return null;
    }

    public void crearArchivo(int ganador, int ventaja){
        try {
            File resultado = new File(rutaResultao);
            if (!resultado.exists()){
                resultado.createNewFile();
            } else {
                throw new RuntimeException("En la ruta ingresada ya existe un archivo con el mismo nombre");
            }
            FileWriter fw = new FileWriter(resultado);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(Integer.toString(ganador)+" "+Integer.toString(ventaja));
            bw.close();
        } catch (IOException e) {
            System.out.println("Ocurrio un error al intentar escribir sobre el archivo");
        }
    }
}
