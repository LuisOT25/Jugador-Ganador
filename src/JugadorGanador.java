public class JugadorGanador {
    public static void main(String[] args){
        try {
            if (args.length != 2) {
                if (args.length>2){
                    throw new Exception("El programa no puede recibir mas de dos argumentos");
                }
                throw new Exception("El programa debe recibir dos argumentos: una ruta de entrada y una de salida");
            }
            FilesHandler fileHandler = new FilesHandler(args[0], args[1]);
            int[][] tablero = fileHandler.leerArchivo();
            if (tablero != null) {
                Jugador jugador1 = new Jugador(0, tablero);
                Jugador jugador2 = new Jugador(1, tablero);
                EvaluadorResultados evaluadorResultadosResultados = new EvaluadorResultados(jugador1, jugador2);
                fileHandler.crearArchivo(evaluadorResultadosResultados.getGanador(), evaluadorResultadosResultados.getVentaja());
            }

        }catch (Exception ex1){
            System.out.println(ex1.getMessage());
        }
    }
}
