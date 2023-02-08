public class Jugador {
    int numJugador;
    int[][] tablero;


    public Jugador(int numJugador, int[][] tablero) {
        this.numJugador = numJugador;
        this.tablero = tablero;
    }

    public int[] getMarcador(){
        try{
            int[] marcadorAcumulado = new int[tablero.length];
            for (int indice = 0; indice < marcadorAcumulado.length; indice++) {
                marcadorAcumulado[indice] = tablero[indice][numJugador];
            }
            for (int indice = 1; indice < marcadorAcumulado.length; indice++) {
                marcadorAcumulado[indice] = marcadorAcumulado[indice] + marcadorAcumulado[indice - 1];
            }

            return marcadorAcumulado;
        }catch (NullPointerException ex){
            System.out.println("Hay un valor incorrecto");
        }
        return null;
    }

}
