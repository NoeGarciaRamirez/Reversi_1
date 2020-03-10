package reversii.reversi;

/**
 *
 * @author noe
 */
public class Logica {
    static int [][] cuadricula = new int[8][8];
    
    public Logica() {
        for(int c=0; c<8; c++) {
            for(int f=0; f<8; f++){
                cuadricula[c][f] = 0;
            }
        }
    }
    
    public void mostrarConsola() {
        for(int c=0; c<8; c++) {
            for(int f=0; f<8; f++){
                System.out.print(cuadricula[f][c] + "\t");
            }
            System.out.println();
        }
    }
    
    public void colocarFicha(int columna, int fila, int jugador){
            cuadricula [columna][fila] = jugador;
    }
    
    public int getNumFichasRaya(int fila, int columna){
        int jugador = cuadricula[columna][fila];
        int contadorFichasVueltas = 0;
        int i = 1;
        while (cuadricula[columna + i][fila] != jugador && cuadricula[columna - i][fila] != 0){
            contadorFichasVueltas ++ ;
            i++;
        }
        
        //
//        i = 1;
//        while (cuadricula[columna - i][fila] != jugador && cuadricula[columna - i][fila] != 0){
//            contadorFichasVueltas ++ ;
//            i++;
//        }
        //
        return contadorFichasVueltas;
    }
    
//    private void conseguirGiro(double escalaFichas){
//        if (escalaFichas >= -1){
//            escalaFichas --;
//        }
//    }
}