public class EvaluadorResultados {
    Jugador j1;
    Jugador j2;
    int[] marcadorJ1;
    int[] marcadorJ2;
    public EvaluadorResultados(Jugador j1, Jugador j2) {
        this.j1 = j1;
        this.j2 = j2;
        this.marcadorJ1= j1.getMarcador();
        this.marcadorJ2= j2.getMarcador();
    }


    public int getGanador(){
        int ventaja=0, ganador=0;
        for (int indice=0; indice<marcadorJ1.length;indice++){
            int resta=Math.abs(marcadorJ1[indice] - marcadorJ2[indice]);
            if (resta>ventaja){
                ventaja=resta;
                if (marcadorJ1[indice] >= marcadorJ2[indice]){
                    ganador=1;
                }else {
                    ganador=2;
                }
            }
        }
        return ganador;
    }

    public int getVentaja(){
        int ventaja=0;
        for (int indice=0; indice<marcadorJ1.length;indice++){
            int resta=Math.abs(marcadorJ1[indice] - marcadorJ2[indice]);
            if (resta>ventaja){
                ventaja=resta;
            }
        }
        return ventaja;
    }

}
