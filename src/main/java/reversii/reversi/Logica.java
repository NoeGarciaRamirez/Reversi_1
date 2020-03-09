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
    
    private void conseguirGiro(double escalaFichas){
        if (escalaFichas >= -1){
            escalaFichas --;
        }
    }
}